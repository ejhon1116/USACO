import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class BovineGenomics {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new FileReader("USACO/src/.in/cownomics.in"));
        int cows = scan.nextInt();
        int length = scan.nextInt();
        scan.nextLine();

        ArrayList<HashSet<Character>> spottyGene = new ArrayList<HashSet<Character>>();
        for(int o = 0; o < cows; o++) {
            String genome = scan.nextLine();
            for(int i = 0; i < length; i++) {
                HashSet<Character> temp = new HashSet<>();
                if(spottyGene.size() > i) temp = spottyGene.get(i);
                temp.add(genome.charAt(i));
                if(o!=0) spottyGene.set(i, temp);
                else spottyGene.add(i, temp);
            }
        }

        ArrayList<HashSet<Character>> plainGene = new ArrayList<HashSet<Character>>();
        for(int o = 0; o < cows; o++) {
            String genome = scan.nextLine();
            for(int i = 0; i < length; i++) {
                HashSet<Character> temp = new HashSet<>();
                if(plainGene.size() > i) temp = plainGene.get(i);
                temp.add(genome.charAt(i));
                if(o!=0) plainGene.set(i, temp);
                else plainGene.add(i, temp);
            }
        }

        System.out.println(spottyGene + "\n" + plainGene);
        for(int i = 0; i < length; i++) {
            boolean trapdoor = true;
            for(char e : spottyGene.get(i)) {
                if(plainGene.get(i).contains(e)) {
                    trapdoor = false;
                }
            }
            if(trapdoor) System.out.println(spottyGene.get(i) + " " + i);
        }
    }
}
