import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class Cowntagion {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int farms = scan.nextInt();
        int[] farmArr = new int[farms];
        ArrayList<ArrayList<Integer>> roads =  new ArrayList<>();
        int events = 0;

        //TreeMap contains all core roads(key: road #, value: occurences)
        TreeMap<Integer, Integer> core = new TreeMap<>();

        //The infected count at each farm
        TreeMap<Integer, Integer> infected = new TreeMap<>();

        //The first farm always has the first infected cow
        infected.put(1, 1);

        for(int i = 0; i < farms-1; i++) {
            int start = scan.nextInt();
            int end = scan.nextInt();

            if(!core.containsKey(start)) {
                core.put(start, 2);
            } else {
                core.put(start, core.get(start)+1);
            }

            ArrayList<Integer> temp = new ArrayList<>(2);
            temp.add(start);
            temp.add(end);

            roads.add(temp);

            infected.put(i + 2, 0);
        }

        //Find the farm farthest from farm 1
        int maxDist = 0;
//Find distance to all the core roads then find how many doubles it takes to get above min then just add all the farms they reach out to

        ArrayList<ArrayList<Integer>> distances = new ArrayList<>();
        for(ArrayList<Integer> road : roads) {
            int distance = 0;
            if (road.get(0) == 1) {
                distance++;
                ArrayList<Integer> temp = new ArrayList<>(2);
                temp.add(road.get(1));
                temp.add(distance);
                distances.add(temp);
            } else {
                for (int i = 0; i < distances.size(); i++) {
                    ArrayList<Integer> roadDist = distances.get(i);
                    //If the road is a part of the road we're looking at, add its distance
                    if (roadDist.get(0) == road.get(0)) {
                        distance += roadDist.get(1) + 1;
                        ArrayList<Integer> temp = new ArrayList<>(2);
                        temp.add(road.get(1));
                        temp.add(distance);
                        distances.add(temp);
                        break;
                    }
                }
            }
            if (distance > maxDist) maxDist = distance;
        }

        for(int farmNum : core.keySet()) {

            //While the infected cows at the farm are less than the amount needed to spread
            while(infected.get(farmNum) < core.get(farmNum)) {
                events++;
                for(int i = 0; i < infected.size(); i++) {
                    infected.put(i+1, infected.get(i+1)*2);
                }
            }

            for(int i = 0; i < roads.size(); i++) {

                //If a there is a road from one of the core farms, move a cow from the core farm along the road
                if(roads.get(i).get(0) == farmNum) {
                    infected.put(roads.get(i).get(0), roads.get(i).get(0)-1);
                    infected.put(roads.get(i).get(1), roads.get(i).get(1)+1);
                    events++;
                }
            }
        }

        System.out.println(events);
    }

    public static TreeMap<Integer, Integer> doubleEvent(TreeMap<Integer, Integer> input) {
        for(int i = 0; i < input.size(); i++) {
            input.put(i+1, input.get(i+1)*2);
        }
        return input;
    }

    public static TreeMap<Integer, Integer> moveEvent(TreeMap<Integer, Integer> input, int start, int end) {
        input.put(start, input.get(start)-1);
        input.put(end, input.get(end)+1);
        return input;
    }
}
