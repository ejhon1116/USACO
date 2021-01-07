import java.util.*;
import java.io.*;

public class MixMilkPractice {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new FileReader("mixmilk.in"));
        int[][] arr = new int[3][];
        for (int n = 0; n < 3; n++) {
            arr[n] = new int[] { scan.nextInt(), scan.nextInt() };
        }

        for (int[] e : arr) {
            System.out.println(Arrays.toString(e));
        }

        for (int i = 0; i < 100; i++) {
            int pourFrom = i % 3;
            int pourTo = (pourFrom + 1) % 3;
            arr[pourTo][1] += arr[pourFrom][1];
            arr[pourFrom][1] = 0;
            if (arr[pourTo][1] > arr[pourTo][0]) {
                arr[pourFrom][1] = arr[pourTo][1] - arr[pourTo][0];
                arr[pourTo][1] = arr[pourTo][0];
            }
        }

        FileWriter fw = new FileWriter("mixmilk.out");
        String ans = "";
        for (int[] e : arr) {
            ans += (e[1] + "\n");
        }
        fw.write(ans.trim());
        fw.flush();
        fw.close();
    }
}