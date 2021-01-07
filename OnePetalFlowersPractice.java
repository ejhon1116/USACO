import java.io.*;
import java.util.*;

public class OnePetalFlowersPractice {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int flowerCount = scan.nextInt();

        int[] flowers = new int[flowerCount];
        int[] flowSum = new int[flowerCount + 1];
        for (int i = 0; i < flowers.length; i++) {
            flowers[i] = scan.nextInt();
            flowSum[i + 1] = flowSum[i] + flowers[i];
        }
        // -+- Separator -+-

        int avgCount = 0;
        for (int i = 0; i < flowers.length; i++) {
            for (int j = i; j < flowers.length; j++) {
                for (int i2 = i; i2 <= j; i2++) {
                    if (flowers[i2] * (j - i + 1) == flowSum[j + 1] - flowSum[i]) {
                        avgCount++;
                        break;
                    }
                }
            }
        }
        System.out.println(avgCount);
    }

    public static int avgCalculator(int[] arr, int i, int j) {
        int tital = 0;
        for (int iVersion2 = i; iVersion2 <= j; iVersion2++) {
            tital += arr[iVersion2];
        }
        return tital;
    }

}