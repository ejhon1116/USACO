import java.util.*;
import java.io.*;
import java.lang.*;

public class CowLifeguards {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new FileReader("lifeguards.in"));
        int guardNum = scan.nextInt();
        int[][] slots = new int[guardNum][];
        boolean lever = true;
        for(int i = 0; i < guardNum; i++) {
            int start = scan.nextInt();
            int end = scan.nextInt();

            slots[i] = new int[] {start, end};
        }

        for(int[] e : slots) {
            System.out.println(Arrays.toString(e));
        }

        int max = 0;
        for(int skipInd = 0; skipInd < guardNum; skipInd++) {
            boolean[] timeLine = new boolean[1000];
            for(int n = 0; n < guardNum; n++) {
                if(n!=skipInd) {
                    for(int i = slots[n][0]; i < slots[n][1]; i++) {
                        if(!timeLine[i]) {
                            timeLine[i] = true;
                        }
                    }
                }
            }
            int temp = 0;
            for(boolean e : timeLine) {
                if(e) temp++;
            }
            if(temp > max) max = temp;
        }
        PrintWriter pw = new PrintWriter("lifeguards.out");
        pw.println(max);
        pw.flush();
        pw.close();
    }
}
