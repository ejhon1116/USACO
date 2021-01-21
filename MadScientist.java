import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class MadScientist {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new FileReader("breedflip.in"));
        int geneLength = scan.nextInt();
        scan.nextLine();
        String[] cowA = scan.nextLine().split("");
        String[] cowB = scan.nextLine().split("");

        int flipCount = 0;
        for(int i = 0; i < geneLength; i++) {
            if(!same(cowA, cowB, i)) {
                int startInd = i;
                int endInd = i;
                for(int n = i+1; n < geneLength; n++) {
                    if(same(cowA, cowB, n)) {
                        endInd = n-1;
                        break;
                    }
                }
                flipCount++;
                cowB = flip(cowB, startInd, endInd);
            }
        }

        PrintWriter pw = new PrintWriter("breedflip.out");
        pw.println(flipCount);
        pw.flush();
        pw.close();
    }

    public static boolean same(String[] A, String[] B, int index) {
        return(A[index].equals(B[index]));
    }

    public static String[] flip(String[] input, int startInd, int endInd) {
        for(; startInd <= endInd; startInd++) {
            if(input[startInd].equals("G")) input[startInd] = "H";
            else input[startInd] = "G";
        }
        return input;
    }
}
