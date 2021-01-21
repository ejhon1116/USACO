import java.util.*;
import java.io.*;

public class CowTip {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("cowtip.in"));
        int n = Integer.parseInt(br.readLine());

        int[][] cowGrid = new int[n][];

        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split("");
            int[] intTemp = new int[n];
            for (int o = 0; o < n; o++) {
                intTemp[o] = Integer.parseInt(temp[o]);
            }
            cowGrid[i] = intTemp;
        }

        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int o = n - 1; o >= 0; o--) {
                if (cowGrid[i][o] == 1) {
                    count++;
                    cowGrid = flip(cowGrid, i, o);
                }
            }
        }
        System.out.println(count);
        FileWriter fw = new FileWriter("cowtip.out");
        fw.write(count + "");
        fw.flush();
        fw.close();
    }


    public static int[][] flip(int[][] input, int rowInd, int colInd) {
        for (int i = 0; i <= rowInd; i++) {
            for (int n = 0; n <= colInd; n++) {
                input[i][n] = Math.abs(input[i][n] - 1);
            }
        }
        return input;
    }
}
