package edu.anadolu;


import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static edu.anadolu.TurkishNetwork.cities;

public class mTSP {
    int NumDepots;
    int NumSalesmen;

    Map<String, LinkedList<LinkedList<String>>> solution = new HashMap<>();
    LinkedList<String> tempNetworkList = new LinkedList<>();
    LinkedList<String> NetworkList = new LinkedList<>();
    LinkedList<String> keys = new LinkedList<>();

    public mTSP(int numDepots, int numSalesmen) {
        NumDepots = numDepots;
        NumSalesmen = numSalesmen;
    }

    public void randomSolution() {
        Random rand = new Random();

        Collections.addAll(tempNetworkList, cities);
        Collections.addAll(NetworkList, cities);
        Collections.shuffle(tempNetworkList);

        for (int i = 0; i < NumDepots; i++) {
            LinkedList<LinkedList<String>> temp = new LinkedList<>();
            String tempKey = tempNetworkList.removeFirst();
            keys.add(tempKey);
            solution.put(tempKey, temp);
        }
        keys.forEach(k -> {
            for (int i = 0; i < NumSalesmen; i++) {
                LinkedList<String> temp = new LinkedList<>();
                temp.add(tempNetworkList.removeFirst());
                solution.get(k).add(temp);
            }
        });

        tempNetworkList.forEach(s -> {
            solution.get(keys.get(rand.nextInt(NumDepots))).get(rand.nextInt(NumSalesmen)).add(s);
        });
    }

    public int cost() {
        int cost = 0;
        for (int k = 0; k < keys.size(); k++) {
            LinkedList<LinkedList<String>> linkOfLink = solution.get(keys.get(k));
            for (int i = 0; i < linkOfLink.size(); i++) {
                cost += TurkishNetwork.distance[NetworkList.indexOf(linkOfLink.get(i).get(0))][NetworkList.indexOf(keys.get(k))];
                cost += TurkishNetwork.distance[NetworkList.indexOf(linkOfLink.get(i).getLast())][NetworkList.indexOf(keys.get(k))];
                for (int j = 0; j < linkOfLink.get(i).size() - 1; j++) {
                    cost += TurkishNetwork.distance[NetworkList.indexOf(linkOfLink.get(i).get(j))][NetworkList.indexOf(linkOfLink.get(i).get(j + 1))];
                }
            }
        }
        return cost;
    }

    public void swapNodesInRoute() {
        Random rand = new Random();
        int randKey = rand.nextInt(keys.size());
        int randRoute;
        int count = 0;
        do {
            randRoute = rand.nextInt(solution.get(keys.get(randKey)).size());
            count++;
            if (count>5){
                randKey = rand.nextInt(keys.size());
                count=0;
            }
        } while (solution.get(keys.get(randKey)).get(randRoute).size() < 2);

        int randNode1 = rand.nextInt(solution.get(keys.get(randKey)).get(randRoute).size());
        int randNode2;
        do {
            randNode2 = rand.nextInt(solution.get(keys.get(randKey)).get(randRoute).size());
        } while (randNode2 == randNode1);

        String s1 = solution.get(keys.get(randKey)).get(randRoute).get(randNode1);
        String s2 = solution.get(keys.get(randKey)).get(randRoute).get(randNode2);

        solution.get(keys.get(randKey)).get(randRoute).set(randNode1, s2);
        solution.get(keys.get(randKey)).get(randRoute).set(randNode2, s1);
    }

    public void swapHubWithNodeInRoute() {
        Random rand = new Random();
        int randKey = rand.nextInt(keys.size());
        int randKey2;
        do {
            randKey2 = rand.nextInt(keys.size());
        } while (randKey == randKey2);

        LinkedList<LinkedList<String>> randDepot1 = solution.get(keys.get(randKey));
        LinkedList<LinkedList<String>> randDepot2 = solution.get(keys.get(randKey2));

        solution.remove(keys.get(randKey));
        solution.remove(keys.get(randKey2));

        solution.put(keys.get(randKey), randDepot2);
        solution.put(keys.get(randKey2), randDepot1);
    }

    public void swapNodesBetweenHubs() {
        Random rand = new Random();
        int randKey = rand.nextInt(keys.size());
        int randRoute;
        int count =0;
        do {
            randRoute = rand.nextInt(solution.get(keys.get(randKey)).size());
            count++;
            if (count>5){
                randKey = rand.nextInt(keys.size());
                count=0;
            }
        } while (solution.get(keys.get(randKey)).get(randRoute).size() < 2);

        int randRoute2;
        count=0;
        do {
            randRoute2 = rand.nextInt(solution.get(keys.get(randKey)).size());
            count++;
            if (count>5){
                randKey = rand.nextInt(keys.size());
                count=0;
            }
        } while (solution.get(keys.get(randKey)).get(randRoute2).size() < 2 || randRoute == randRoute2);

        int randNode1 = rand.nextInt(solution.get(keys.get(randKey)).get(randRoute).size());
        int randNode2;
        do {
            randNode2 = rand.nextInt(solution.get(keys.get(randKey)).get(randRoute2).size());
        } while (randNode2 == randNode1);

        String node1 = solution.get(keys.get(randKey)).get(randRoute).get(randNode1);
        String node2 = solution.get(keys.get(randKey)).get(randRoute2).get(randNode2);

        solution.get(keys.get(randKey)).get(randRoute).set(randNode1, node2);
        solution.get(keys.get(randKey)).get(randRoute2).set(randNode2, node1);
    }

    public void insertNodeInRoute() {
        Random rand = new Random();
        int randKey = rand.nextInt(keys.size());
        int randRoute;
        int count =0;
        do {
            randRoute = rand.nextInt(solution.get(keys.get(randKey)).size());
            count++;
            if (count>5){
                randKey = rand.nextInt(keys.size());
                count=0;
            }
        } while (solution.get(keys.get(randKey)).get(randRoute).size() < 2);

        int randNode1 = rand.nextInt(solution.get(keys.get(randKey)).get(randRoute).size());
        int randNode2;

        do {
            randNode2 = rand.nextInt(solution.get(keys.get(randKey)).get(randRoute).size());
        } while (randNode2 == randNode1);

        String node2 = solution.get(keys.get(randKey)).get(randRoute).get(randNode2);

        if (randNode1 == solution.get(keys.get(randKey)).get(randRoute).size() - 1) {
            solution.get(keys.get(randKey)).get(randRoute).remove(randNode2);
            solution.get(keys.get(randKey)).get(randRoute).add(node2);
        } else {
            solution.get(keys.get(randKey)).get(randRoute).remove(randNode2);
            solution.get(keys.get(randKey)).get(randRoute).add(randNode1, node2);
        }

    }

    public void swapHubsWithNodes() {
        Random rand = new Random();
        int randKey = rand.nextInt(keys.size());
        LinkedList<LinkedList<String>> linkOfLink = solution.remove(keys.get(randKey));
        String depot = keys.remove(randKey);

        int randRoute = rand.nextInt(NumSalesmen);
        int randNode = rand.nextInt(linkOfLink.get(randRoute).size());

        String node = linkOfLink.get(randRoute).remove(randNode);
        linkOfLink.get(randRoute).add(depot);
        keys.add(node);
        solution.put(node, linkOfLink);
    }

    public void swapNodesBetweenRouters() {
        Random rand = new Random();
        int randKey = rand.nextInt(keys.size());
        int randKey2;
        do {
            randKey2 = rand.nextInt(keys.size());
        } while (randKey == randKey2);

        int randRoute = rand.nextInt(NumSalesmen);
        int randRoute2 = rand.nextInt(NumSalesmen);

        int randNode = rand.nextInt(solution.get(keys.get(randKey)).get(randRoute).size());
        int randNode2 = rand.nextInt(solution.get(keys.get(randKey2)).get(randRoute2).size());

        String node = solution.get(keys.get(randKey)).get(randRoute).get(randNode);
        String node2 = solution.get(keys.get(randKey2)).get(randRoute2).get(randNode2);


        solution.get(keys.get(randKey)).get(randRoute).add(randNode, node2);
        solution.get(keys.get(randKey2)).get(randRoute2).add(randNode2, node);

        solution.get(keys.get(randKey)).get(randRoute).remove(randNode+1);
        solution.get(keys.get(randKey2)).get(randRoute2).remove(randNode2+1);
    }


    public void insertNodeBetweenRoute(){
        Random rand = new Random();
        int randKey = rand.nextInt(keys.size());
        int randKey2;

        do {
            randKey2 = rand.nextInt(keys.size());
        }while (randKey == randKey2);

        int count = 0;

        int randRoute;
        do {
            randRoute = rand.nextInt(solution.get(keys.get(randKey)).size());
            count++;
            if (count>5){
                randKey = rand.nextInt(keys.size());
            }
        }while (solution.get(keys.get(randKey)).get(randRoute).size() < 3);

        count =0;
        int randRoute2;
        do {
            randRoute2 = rand.nextInt(solution.get(keys.get(randKey2)).size());
            count++;
            if (count>5){
                randKey2 = rand.nextInt(keys.size());
            }
        }while (solution.get(keys.get(randKey2)).get(randRoute2).size() > (81/(NumSalesmen*NumDepots))*1.5);

        int randNode = rand.nextInt(solution.get(keys.get(randKey)).get(randRoute).size());
        int randNode2 = rand.nextInt(solution.get(keys.get(randKey2)).get(randRoute2).size());

        String node = solution.get(keys.get(randKey)).get(randRoute).remove(randNode);
        solution.get(keys.get(randKey2)).get(randRoute2).add(randNode2, node);




    }

    public void print() {
//        System.out.println(keys);
//        keys.forEach(k->{
//            LinkedList<LinkedList<String>> linkedList = solution.get(k);
//            linkedList.forEach(System.out::println);
//        });
//
//        System.out.println("-------------------------------");

        for (int i = 0; i < keys.size(); i++) {
            System.out.println("Depot" + (i + 1) + ":" + keys.get(i));
            for (int j = 0; j < solution.get(keys.get(i)).size(); j++) {
                System.out.print("   Route" + (j + 1) + ": ");
                for (int k = 0; k < solution.get(keys.get(i)).get(j).size(); k++) {
                    if (k != solution.get(keys.get(i)).get(j).size() - 1)
                        System.out.print(solution.get(keys.get(i)).get(j).get(k) + ", ");
                    else
                        System.out.println(solution.get(keys.get(i)).get(j).get(k));
                }
            }
        }
    }

    void converJSon(int a, int b) throws Exception{
        String jsonString = "{\"solution\": [";
        jsonString+="";

        for (int i =0 ; i<keys.size(); i++){
            jsonString+="{";
            jsonString+="\"depot\": \""+NetworkList.indexOf(keys.get(i))+"\", \"routes\": [";
            for (int j =0 ; j<solution.get(keys.get(i)).size();j++){
                jsonString+="\"";
                for (int k = 0 ; k< solution.get(keys.get(i)).get(j).size(); k++){
                    jsonString+=""+NetworkList.indexOf(solution.get(keys.get(i)).get(j).get(k));
                    if (k!=solution.get(keys.get(i)).get(j).size()-1){
                        jsonString+=" ";
                    }
                }
                jsonString+="\"";
                if (j != solution.get(keys.get(i)).size()-1)
                    jsonString+=",";
            }
            jsonString+="]}";
            if (i != keys.size()-1){
                jsonString+= ",";
            }
        }

        jsonString+="]}";
        LinkedList<String> jsonList = new LinkedList<>();
        jsonList.add(jsonString);
        Files.write(Paths.get("solution_d"+NumDepots+"s"+NumSalesmen+".json"), jsonList);
    }
}
