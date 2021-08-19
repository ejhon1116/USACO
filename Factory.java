//Problem Link: http://www.usaco.org/index.php?page=viewproblem2&cpid=940

import java.util.*;
import java.io.*;

public class Factory {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new FileReader("factory.in"));
        int n = scan.nextInt();

        TreeMap<Integer, Integer> paths = new TreeMap<>();
        for (int i = 0; i < n - 1; i++) paths.put(scan.nextInt(), scan.nextInt());

        //If a node leads to multiple different nodes then there is no node in which they all converge
        if (paths.size() < n - 1) {
            FileWriter fw = new FileWriter("factory.out");
            fw.write(-1 + "");
            fw.flush();
            fw.close();
        } else {
            //The amount of paths leading to a certain node
            TreeMap<Integer, Integer> leadingTo = new TreeMap<>();

            for (int value : paths.values()) {
                if (!leadingTo.containsKey(value)) leadingTo.put(value, 1);
                else leadingTo.put(value, leadingTo.get(value) + 1);
            }

            for(int key : leadingTo.keySet()) {
                if(pathSum(paths, leadingTo, key) == n-1) {
                    System.out.println(key);
                    FileWriter fw = new FileWriter("factory.out");
                    fw.write(key + "");
                    fw.flush();
                    fw.close();
                    break;
                }
            }
        }
    }

    public static int pathSum(TreeMap<Integer, Integer> paths, TreeMap<Integer, Integer> leadingTo, int currNode) {
        //If no paths lead to the current node, then return 0 paths
        if(!paths.containsValue(currNode)) {
            return 0;
        }
        //If a path leads to the current node we are looking at then...
        int tot = 0;
        for (int key : paths.keySet()) {
            if (currNode == paths.get(key)) {
                tot += pathSum(paths, leadingTo, key);
            }
        }
        return leadingTo.get(currNode) + tot;
    }
}
