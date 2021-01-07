import java.io.*;
import java.util.*;
import java.lang.Object.*;

public class ShellPractice {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new FileReader("shell.in"));
        int[][] arr = new int[scan.nextInt()][];
        for (int n = 0; n < arr.length; n++) {
            // System.out.println(arr[n]);
            arr[n] = new int[] { scan.nextInt(), scan.nextInt(), scan.nextInt() };
        }

        int[] start = { 1, 2, 3 };

        int oneWins = 0;
        int twoWins = 0;
        int threeWins = 0;

        for (int[] e : arr) {
            int swap1 = e[0] - 1;
            int swap2 = e[1] - 1;
            int temp = start[swap1];
            start[swap1] = start[swap2];
            start[swap2] = temp;

            if (start[e[2] - 1] == 1)
                oneWins++;
            if (start[e[2] - 1] == 2)
                twoWins++;
            if (start[e[2] - 1] == 3)
                threeWins++;
        }
        int[] wins = new int[] { oneWins, twoWins, threeWins };
        Arrays.sort(wins);

        FileWriter fw = new FileWriter("shell.out");
        System.out.println(wins[2]);
        fw.write(wins[2] + "");
        scan.close();
        fw.flush();
        fw.close();
    }
}