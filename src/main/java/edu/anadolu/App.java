package edu.anadolu;

import com.google.gson.Gson;
import com.lexicalscope.jewel.cli.ArgumentValidationException;
import com.lexicalscope.jewel.cli.CliFactory;
import java.util.Random;

public class App {
    public App() {
    }

    public static void main(String[] args) throws Exception {
        Params params;
        try {
            params = (Params)CliFactory.parseArguments(Params.class, args);
        } catch (ArgumentValidationException var11) {
            System.out.println(var11.getMessage());
            return;
        }

        Random rand = new Random();
        mTSP tsp = new mTSP(params.getNumDepots(), params.getNumSalesmen(), params.getInitialCity());
        tsp.nearestNeighborSolution();
        boolean isMTSP = params.getNumDepots() >= 2 && params.getNumSalesmen() >= 2;

        int i;
        for(i = 0; i < 100000; ++i) {
            int cost = tsp.cost();
            Gson gson = new Gson();
            String jsonString = gson.toJson(tsp);
            int op;
            if (isMTSP) {
                op = rand.nextInt(7);
            } else {
                int[] mtsOp = new int[]{0, 2, 3};
                op = mtsOp[rand.nextInt(3)];
            }

            switch(op) {
                case 0:
                    tsp.swapNodesInRoute();
                    break;
                case 1:
                    tsp.swapHubWithNodeInRoute();
                    break;
                case 2:
                    tsp.swapNodesBetweenHubs();
                    break;
                case 3:
                    tsp.insertNodeInRoute();
                    break;
                case 4:
                    tsp.swapHubsWithNodes();
                    break;
                case 5:
                    tsp.swapNodesBetweenRoutes();
                    break;
                case 6:
                    tsp.insertNodeBetweenRoute();
            }

            if (tsp.cost() >= cost) {
                tsp = (mTSP)gson.fromJson(jsonString, mTSP.class);
            } else {
                System.out.println(tsp.cost() + " " + i);
            }
        }

        i = tsp.cost();
        tsp.print();
        System.out.println("**Total cost is " + i);
        tsp.converJSon(params.getNumDepots(), params.getNumSalesmen());
    }
}