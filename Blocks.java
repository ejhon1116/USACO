import java.io.*;
import java.util.*;

public class Blocks {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new FileReader("blocks.in"));
        int n = scan.nextInt();
        int[] alphabet = new int[26];
        scan.nextLine();

        for(int i = 0; i < n; i++) {
            int[] tempAlphaA = new int[26];
            int[] tempAlphaB = new int[26];
            String[] words = scan.nextLine().split(" ");
            for(int o = 0; o < words[0].length(); o++) {
                tempAlphaA[words[0].charAt(o)-97]++;
            }
            for(int o = 0; o < words[1].length(); o++) {
                tempAlphaB[words[1].charAt(o)-97]++;
            }

            for(int o = 0; o < 26; o++) {
                if(tempAlphaA[o] >= tempAlphaB[o]) alphabet[o]+=tempAlphaA[o];
                else alphabet[o]+=tempAlphaB[o];
            }
        }

        PrintWriter pw = new PrintWriter("blocks.out");
        for(int count : alphabet) {
            pw.println(count);
        }

        pw.flush();
        pw.close();
    }
}
