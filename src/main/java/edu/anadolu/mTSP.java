
package edu.anadolu;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

public class mTSP {
    int NumDepots;
    int NumSalesmen;
    String InitialCity;
    Map<String, LinkedList<LinkedList<String>>> solution = new HashMap();
    LinkedList<String> tempNetworkList = new LinkedList();
    LinkedList<String> NetworkList = new LinkedList();
    LinkedList<String> keys = new LinkedList();

    public mTSP(int numDepots, int numSalesmen, String initialcity) {
        this.NumDepots = numDepots;
        this.NumSalesmen = numSalesmen;
        this.InitialCity = initialcity;
    }

    public void nearestNeighborSolution() {
        Collections.addAll(this.tempNetworkList, TurkishNetwork.cities);
        Collections.addAll(this.NetworkList, TurkishNetwork.cities);
        int mindistance = 1000000;
        String parametricCity = null;
        Iterator var3 = this.NetworkList.iterator();

        int numOfCitiesforRoute;
        int j;
        int k;
        while(var3.hasNext()) {
            String s = (String)var3.next();
            numOfCitiesforRoute = 0;
            int[] var6 = TurkishNetwork.distance[this.NetworkList.indexOf(s)];
            j = var6.length;

            for(k = 0; k < j; ++k) {
                int i = var6[k];
                numOfCitiesforRoute += i;
            }

            if (numOfCitiesforRoute < mindistance) {
                mindistance = numOfCitiesforRoute;
                parametricCity = s;
            }
        }

        if (!this.InitialCity.equals("")) {
            parametricCity = this.InitialCity;
        }

        String nearestCity = parametricCity;
        LinkedList<String> generalRoute = new LinkedList();
        this.tempNetworkList.remove(parametricCity);

        int i;
        while(this.tempNetworkList.size() > 0) {
            numOfCitiesforRoute = this.NetworkList.indexOf(nearestCity);
            i = 100000;

            for(j = 0; j < 81; ++j) {
                if (j != numOfCitiesforRoute && TurkishNetwork.distance[numOfCitiesforRoute][j] < i && this.tempNetworkList.contains(this.NetworkList.get(j))) {
                    i = TurkishNetwork.distance[numOfCitiesforRoute][j];
                    nearestCity = (String)this.NetworkList.get(j);
                }
            }

            generalRoute.add(nearestCity);
            this.tempNetworkList.remove(nearestCity);
        }

        generalRoute.addFirst(parametricCity);
        numOfCitiesforRoute = (81 - this.NumDepots) / (this.NumSalesmen * this.NumDepots);

        for(i = 0; i <= generalRoute.size(); ++i) {
            if (i % (2 * numOfCitiesforRoute + 1) == 0 && this.keys.size() < this.NumDepots) {
                this.keys.add((String)generalRoute.get(i));
                LinkedList<LinkedList<String>> temp = new LinkedList();
                this.solution.put((String)generalRoute.get(i), temp);

                for(k = 0; k < this.NumSalesmen; ++k) {
                    LinkedList<String> temp2 = new LinkedList();
                    ((LinkedList)this.solution.get(generalRoute.get(i))).add(temp2);
                }
            }
        }

        LinkedList var10000 = this.keys;
        Objects.requireNonNull(generalRoute);
        var10000.forEach(generalRoute::remove);
        i = 0;
        j = 0;

        for(k = 0; i < generalRoute.size(); ++i) {
            if (i % numOfCitiesforRoute == 0 && i >= numOfCitiesforRoute) {
                if (i < this.NumDepots * this.NumSalesmen * numOfCitiesforRoute) {
                    ++k;
                }

                if (i % (numOfCitiesforRoute * this.NumSalesmen) == 0 && i >= numOfCitiesforRoute * this.NumSalesmen) {
                    k = 0;
                    if (i < this.NumDepots * this.NumSalesmen * numOfCitiesforRoute) {
                        ++j;
                    } else {
                        k = this.NumSalesmen - 1;
                    }
                }
            }

            ((LinkedList)((LinkedList)this.solution.get(this.keys.get(j))).get(k)).add((String)generalRoute.get(i));
        }

    }

    public void randomSolution() {
        Random rand = new Random();
        Collections.addAll(this.tempNetworkList, TurkishNetwork.cities);
        Collections.addAll(this.NetworkList, TurkishNetwork.cities);
        Collections.shuffle(this.tempNetworkList);

        for(int i = 0; i < this.NumDepots; ++i) {
            LinkedList<LinkedList<String>> temp = new LinkedList();
            String tempKey = (String)this.tempNetworkList.removeFirst();
            this.keys.add(tempKey);
            this.solution.put(tempKey, temp);
        }

        this.keys.forEach((k) -> {
            for(int i = 0; i < this.NumSalesmen; ++i) {
                LinkedList<String> temp = new LinkedList();
                temp.add((String)this.tempNetworkList.removeFirst());
                ((LinkedList)this.solution.get(k)).add(temp);
            }

        });
        this.tempNetworkList.forEach((s) -> {
            ((LinkedList)((LinkedList)this.solution.get(this.keys.get(rand.nextInt(this.NumDepots)))).get(rand.nextInt(this.NumSalesmen))).add(s);
        });
    }

    public int cost() {
        int cost = 0;

        for(int k = 0; k < this.keys.size(); ++k) {
            LinkedList<LinkedList<String>> linkOfLink = (LinkedList)this.solution.get(this.keys.get(k));

            for(int i = 0; i < linkOfLink.size(); ++i) {
                cost += TurkishNetwork.distance[this.NetworkList.indexOf(((LinkedList)linkOfLink.get(i)).get(0))][this.NetworkList.indexOf(this.keys.get(k))];
                cost += TurkishNetwork.distance[this.NetworkList.indexOf(((LinkedList)linkOfLink.get(i)).getLast())][this.NetworkList.indexOf(this.keys.get(k))];

                for(int j = 0; j < ((LinkedList)linkOfLink.get(i)).size() - 1; ++j) {
                    cost += TurkishNetwork.distance[this.NetworkList.indexOf(((LinkedList)linkOfLink.get(i)).get(j))][this.NetworkList.indexOf(((LinkedList)linkOfLink.get(i)).get(j + 1))];
                }
            }
        }

        return cost;
    }

    public void swapNodesInRoute() {
        Random rand = new Random();
        int randKey = rand.nextInt(this.keys.size());
        int count = 0;

        int randRoute;
        do {
            randRoute = rand.nextInt(((LinkedList)this.solution.get(this.keys.get(randKey))).size());
            ++count;
            if (count > 5) {
                randKey = rand.nextInt(this.keys.size());
                count = 0;
            }
        } while(((LinkedList)((LinkedList)this.solution.get(this.keys.get(randKey))).get(randRoute)).size() < 2);

        int randNode1 = rand.nextInt(((LinkedList)((LinkedList)this.solution.get(this.keys.get(randKey))).get(randRoute)).size());

        int randNode2;
        do {
            randNode2 = rand.nextInt(((LinkedList)((LinkedList)this.solution.get(this.keys.get(randKey))).get(randRoute)).size());
        } while(randNode2 == randNode1);

        String s1 = (String)((LinkedList)((LinkedList)this.solution.get(this.keys.get(randKey))).get(randRoute)).get(randNode1);
        String s2 = (String)((LinkedList)((LinkedList)this.solution.get(this.keys.get(randKey))).get(randRoute)).get(randNode2);
        ((LinkedList)((LinkedList)this.solution.get(this.keys.get(randKey))).get(randRoute)).set(randNode1, s2);
        ((LinkedList)((LinkedList)this.solution.get(this.keys.get(randKey))).get(randRoute)).set(randNode2, s1);
    }

    public void swapHubWithNodeInRoute() {
        Random rand = new Random();
        int randKey = rand.nextInt(this.keys.size());

        int randKey2;
        do {
            randKey2 = rand.nextInt(this.keys.size());
        } while(randKey == randKey2);

        LinkedList<LinkedList<String>> randDepot1 = (LinkedList)this.solution.get(this.keys.get(randKey));
        LinkedList<LinkedList<String>> randDepot2 = (LinkedList)this.solution.get(this.keys.get(randKey2));
        this.solution.remove(this.keys.get(randKey));
        this.solution.remove(this.keys.get(randKey2));
        this.solution.put((String)this.keys.get(randKey), randDepot2);
        this.solution.put((String)this.keys.get(randKey2), randDepot1);
    }

    public void swapNodesBetweenHubs() {
        Random rand = new Random();
        int randKey = rand.nextInt(this.keys.size());
        int count = 0;

        int randRoute;
        do {
            randRoute = rand.nextInt(((LinkedList)this.solution.get(this.keys.get(randKey))).size());
            ++count;
            if (count > 5) {
                randKey = rand.nextInt(this.keys.size());
                count = 0;
            }
        } while(((LinkedList)((LinkedList)this.solution.get(this.keys.get(randKey))).get(randRoute)).size() < 2);

        count = 0;

        int randRoute2;
        do {
            randRoute2 = rand.nextInt(((LinkedList)this.solution.get(this.keys.get(randKey))).size());
            ++count;
            if (count > 5) {
                randKey = rand.nextInt(this.keys.size());
                count = 0;
            }
        } while(((LinkedList)((LinkedList)this.solution.get(this.keys.get(randKey))).get(randRoute2)).size() < 2 || randRoute == randRoute2);

        int randNode1 = rand.nextInt(((LinkedList)((LinkedList)this.solution.get(this.keys.get(randKey))).get(randRoute)).size());

        int randNode2;
        do {
            randNode2 = rand.nextInt(((LinkedList)((LinkedList)this.solution.get(this.keys.get(randKey))).get(randRoute2)).size());
        } while(randNode2 == randNode1);

        String node1 = (String)((LinkedList)((LinkedList)this.solution.get(this.keys.get(randKey))).get(randRoute)).get(randNode1);
        String node2 = (String)((LinkedList)((LinkedList)this.solution.get(this.keys.get(randKey))).get(randRoute2)).get(randNode2);
        ((LinkedList)((LinkedList)this.solution.get(this.keys.get(randKey))).get(randRoute)).set(randNode1, node2);
        ((LinkedList)((LinkedList)this.solution.get(this.keys.get(randKey))).get(randRoute2)).set(randNode2, node1);
    }

    public void insertNodeInRoute() {
        Random rand = new Random();
        int randKey = rand.nextInt(this.keys.size());
        int count = 0;

        int randRoute;
        do {
            randRoute = rand.nextInt(((LinkedList)this.solution.get(this.keys.get(randKey))).size());
            ++count;
            if (count > 5) {
                randKey = rand.nextInt(this.keys.size());
                count = 0;
            }
        } while(((LinkedList)((LinkedList)this.solution.get(this.keys.get(randKey))).get(randRoute)).size() < 2);

        int randNode1 = rand.nextInt(((LinkedList)((LinkedList)this.solution.get(this.keys.get(randKey))).get(randRoute)).size());

        int randNode2;
        do {
            randNode2 = rand.nextInt(((LinkedList)((LinkedList)this.solution.get(this.keys.get(randKey))).get(randRoute)).size());
        } while(randNode2 == randNode1);

        String node2 = (String)((LinkedList)((LinkedList)this.solution.get(this.keys.get(randKey))).get(randRoute)).get(randNode2);
        if (randNode1 == ((LinkedList)((LinkedList)this.solution.get(this.keys.get(randKey))).get(randRoute)).size() - 1) {
            ((LinkedList)((LinkedList)this.solution.get(this.keys.get(randKey))).get(randRoute)).remove(randNode2);
            ((LinkedList)((LinkedList)this.solution.get(this.keys.get(randKey))).get(randRoute)).add(node2);
        } else {
            ((LinkedList)((LinkedList)this.solution.get(this.keys.get(randKey))).get(randRoute)).remove(randNode2);
            ((LinkedList)((LinkedList)this.solution.get(this.keys.get(randKey))).get(randRoute)).add(randNode1, node2);
        }

    }

    public void swapHubsWithNodes() {
        Random rand = new Random();
        int randKey = rand.nextInt(this.keys.size());
        LinkedList<LinkedList<String>> linkOfLink = (LinkedList)this.solution.remove(this.keys.get(randKey));
        String depot = (String)this.keys.remove(randKey);
        int randRoute = rand.nextInt(this.NumSalesmen);
        int randNode = rand.nextInt(((LinkedList)linkOfLink.get(randRoute)).size());
        String node = (String)((LinkedList)linkOfLink.get(randRoute)).remove(randNode);
        ((LinkedList)linkOfLink.get(randRoute)).add(depot);
        this.keys.add(node);
        this.solution.put(node, linkOfLink);
    }

    public void swapNodesBetweenRoutes() {
        Random rand = new Random();
        int randKey = rand.nextInt(this.keys.size());

        int randKey2;
        do {
            randKey2 = rand.nextInt(this.keys.size());
        } while(randKey == randKey2);

        int randRoute = rand.nextInt(this.NumSalesmen);
        int randRoute2 = rand.nextInt(this.NumSalesmen);
        int randNode = rand.nextInt(((LinkedList)((LinkedList)this.solution.get(this.keys.get(randKey))).get(randRoute)).size());
        int randNode2 = rand.nextInt(((LinkedList)((LinkedList)this.solution.get(this.keys.get(randKey2))).get(randRoute2)).size());
        String node = (String)((LinkedList)((LinkedList)this.solution.get(this.keys.get(randKey))).get(randRoute)).get(randNode);
        String node2 = (String)((LinkedList)((LinkedList)this.solution.get(this.keys.get(randKey2))).get(randRoute2)).get(randNode2);
        ((LinkedList)((LinkedList)this.solution.get(this.keys.get(randKey))).get(randRoute)).add(randNode, node2);
        ((LinkedList)((LinkedList)this.solution.get(this.keys.get(randKey2))).get(randRoute2)).add(randNode2, node);
        ((LinkedList)((LinkedList)this.solution.get(this.keys.get(randKey))).get(randRoute)).remove(randNode + 1);
        ((LinkedList)((LinkedList)this.solution.get(this.keys.get(randKey2))).get(randRoute2)).remove(randNode2 + 1);
    }

    public void insertNodeBetweenRoute() {
        Random rand = new Random();
        int randKey = rand.nextInt(this.keys.size());

        int randKey2;
        do {
            randKey2 = rand.nextInt(this.keys.size());
        } while(randKey == randKey2);

        int count = 0;

        int randRoute;
        do {
            randRoute = rand.nextInt(((LinkedList)this.solution.get(this.keys.get(randKey))).size());
            ++count;
            if (count > 5) {
                randKey = rand.nextInt(this.keys.size());
            }
        } while(((LinkedList)((LinkedList)this.solution.get(this.keys.get(randKey))).get(randRoute)).size() < 3);

        count = 0;

        int randRoute2;
        do {
            randRoute2 = rand.nextInt(((LinkedList)this.solution.get(this.keys.get(randKey2))).size());
            ++count;
            if (count > 5) {
                randKey2 = rand.nextInt(this.keys.size());
            }
        } while((double)((LinkedList)((LinkedList)this.solution.get(this.keys.get(randKey2))).get(randRoute2)).size() > (double)(81 / (this.NumSalesmen * this.NumDepots)) * 1.5D);

        int randNode = rand.nextInt(((LinkedList)((LinkedList)this.solution.get(this.keys.get(randKey))).get(randRoute)).size());
        int randNode2 = rand.nextInt(((LinkedList)((LinkedList)this.solution.get(this.keys.get(randKey2))).get(randRoute2)).size());
        String node = (String)((LinkedList)((LinkedList)this.solution.get(this.keys.get(randKey))).get(randRoute)).remove(randNode);
        ((LinkedList)((LinkedList)this.solution.get(this.keys.get(randKey2))).get(randRoute2)).add(randNode2, node);
    }

    public void print() {
        for(int i = 0; i < this.keys.size(); ++i) {
            System.out.println("Depot" + (i + 1) + ":" + (String)this.keys.get(i));

            for(int j = 0; j < ((LinkedList)this.solution.get(this.keys.get(i))).size(); ++j) {
                System.out.print("   Route" + (j + 1) + ": ");

                for(int k = 0; k < ((LinkedList)((LinkedList)this.solution.get(this.keys.get(i))).get(j)).size(); ++k) {
                    if (k != ((LinkedList)((LinkedList)this.solution.get(this.keys.get(i))).get(j)).size() - 1) {
                        System.out.print((String)((LinkedList)((LinkedList)this.solution.get(this.keys.get(i))).get(j)).get(k) + ", ");
                    } else {
                        System.out.println((String)((LinkedList)((LinkedList)this.solution.get(this.keys.get(i))).get(j)).get(k));
                    }
                }
            }
        }

    }

    void converJSon(int a, int b) throws Exception {
        String jsonString = "{\"solution\": [";
        jsonString = jsonString + "";

        for(int i = 0; i < this.keys.size(); ++i) {
            jsonString = jsonString + "{";
            jsonString = jsonString + "\"depot\": \"" + this.NetworkList.indexOf(this.keys.get(i)) + "\", \"routes\": [";

            for(int j = 0; j < ((LinkedList)this.solution.get(this.keys.get(i))).size(); ++j) {
                jsonString = jsonString + "\"";

                for(int k = 0; k < ((LinkedList)((LinkedList)this.solution.get(this.keys.get(i))).get(j)).size(); ++k) {
                    jsonString = jsonString + "" + this.NetworkList.indexOf(((LinkedList)((LinkedList)this.solution.get(this.keys.get(i))).get(j)).get(k));
                    if (k != ((LinkedList)((LinkedList)this.solution.get(this.keys.get(i))).get(j)).size() - 1) {
                        jsonString = jsonString + " ";
                    }
                }

                jsonString = jsonString + "\"";
                if (j != ((LinkedList)this.solution.get(this.keys.get(i))).size() - 1) {
                    jsonString = jsonString + ",";
                }
            }

            jsonString = jsonString + "]}";
            if (i != this.keys.size() - 1) {
                jsonString = jsonString + ",";
            }
        }

        jsonString = jsonString + "]}";
        LinkedList<String> jsonList = new LinkedList();
        jsonList.add(jsonString);
        Files.write(Paths.get("solution_d" + this.NumDepots + "s" + this.NumSalesmen + ".json"), jsonList);
    }
}
