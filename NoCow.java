import java.io.*;
import java.util.*;

public class NoCow {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new FileReader("src/.in/nocow.in"));

        int n = scan.nextInt();
        int k = scan.nextInt();
        scan.nextLine();

        ArrayList<TreeSet<String>> adjectives = new ArrayList<TreeSet<String>>();

        for(int i = 0; i < n; i++) {
            adjectives.add(new TreeSet<String>());
        }

        while(scan.hasNextLine()) {
            String[] sentence = scan.nextLine().split(" ");
            for(int i = 0; i < n; i++) {
                adjectives.get(i).add(sentence[i+4]);
            }
        }

        int poss = 1;
        for(int i = 0; i < adjectives.size(); i++) {
            poss = poss * adjectives.get(i).size();
        }
        poss = poss;

        int[] path = new int[3];
        for(int i = 0; i < adjectives.size(); i++) {
            for(int o = 0; o < adjectives.get(i).size(); o++) {
                if(poss * (o + 1) / adjectives.get(i).size() <= k-2) {
                    path[i] = o;
                    poss = poss * (o + 1) / adjectives.get(i).size();
                }
            }
        }


        for(TreeSet<String> e : adjectives) {
            System.out.println(e);
        }
        System.out.println(Arrays.toString(path));
    }
}
