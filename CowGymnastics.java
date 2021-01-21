import java.awt.*;
import java.util.*;
import java.io.*;

public class CowGymnastics {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new FileReader("gymnastics.in"));
        int sessions = scan.nextInt();
        int cowNum = scan.nextInt();
        int[][] arr = new int[sessions][cowNum];
        for (int i = 0; i < sessions; i++) {
            for (int n = 0; n < cowNum; n++) {
                arr[i][n] = scan.nextInt();
            }
        }

        ArrayList<Integer[]> combin = new ArrayList<Integer[]>();
        for(int i = 0; i < arr[0].length - 1; i++) {
            for(int o = i+1; o < arr[0].length; o++) {
                combin.add(new Integer[] {arr[0][i], arr[0][o]});
            }
        }

        int count = 0;
        for(Integer[] e : combin) {
            boolean bool = true;
            for(int[] arrEl : arr) {
                bool = contains(arrEl, e[0], e[1]);
                if(!bool) break;
            }
            if(bool) count++;
        }
        PrintWriter pw = new PrintWriter("gymnastics.out");
        pw.println(count);
        pw.flush();
        pw.close();

    }

    public static boolean contains(int[] input, int cowA, int cowB) {

        int aInd = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] == cowA) aInd = i;
        }

        for (; aInd < input.length; aInd++) {
            if (input[aInd] == cowB) return true;
        }
        return false;
    }
}