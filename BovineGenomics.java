import java.util.*;
import java.io.*;

public class BovineGenomics {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("cownomics.in"));
        FileWriter fw = new FileWriter("cownomics.out");
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cowNum = Integer.parseInt(st.nextToken());
        int geneLength = Integer.parseInt(st.nextToken());
        String[] cows = new String[cowNum * 2];

        // Puts all the cow genomes in one array
        for (int i = 0; i < cowNum * 2; i++) {
            cows[i] = br.readLine();
        }

        String[] spottyGene = new String[geneLength];
        String[] plainGene = new String[geneLength];

        // Splits the genomes and puts the spotty/plain ones in their respective arrays
        for (int i = 0; i < geneLength; i++) {
            String spotty = "";
            String plain = "";
            for (int n = 0; n < cowNum; n++) {
                spotty += cows[n].charAt(i);
                plain += cows[n + cowNum].charAt(i);
            }
            spottyGene[i] = spotty;
            plainGene[i] = plain;
        }

        System.out.println(Arrays.toString(cows));
        System.out.println(Arrays.toString(spottyGene));
        System.out.println(Arrays.toString(plainGene));

        int count = 0;
        for (int i = 0; i < geneLength; i++) {
            boolean contains = false;
            for (int n = 0; n < cowNum; n++) {
                if (spottyGene[i].contains(plainGene[i].charAt(n) + "")) {
                    contains = true;
                }
            }
            if (!contains) {
                count++;
            }
        }
        fw.write(count + "");
        fw.flush();
        fw.close();
    }
}