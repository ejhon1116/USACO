//I STOLE THE IDEA FOR THIS FROM THE USACO SOLUTION, BUT IMPLEMENTED IT FOR PRACTICE
import java.util.*;
import java.io.*;

public class SwapitySwap {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new FileReader("swap.in"));
        int cowNum = scan.nextInt();
        int repeat = scan.nextInt();
        int[] cowLine = new int[cowNum];
        int[] repCheck = new int[cowNum];
        for (int i = 0; i < cowNum; i++) {
            cowLine[i] = i + 1;
            repCheck[i] = i + 1;
        }

        int[] swap1 = new int[]{scan.nextInt(), scan.nextInt()};
        int[] swap2 = new int[]{scan.nextInt(), scan.nextInt()};

        int repForSame = 1;
        repCheck = reverse(reverse(repCheck, swap1[0]-1, swap1[1]-1), swap2[0]-1, swap2[1]-1);
        while(!Arrays.equals(repCheck, cowLine)) {
            repForSame++;
            repCheck = reverse(reverse(repCheck, swap1[0]-1, swap1[1]-1), swap2[0]-1, swap2[1]-1);

        }

        repeat = repeat % repForSame;

        for(int i = 0; i < repeat; i++) {
            cowLine = reverse(reverse(cowLine, swap1[0] - 1, swap1[1] - 1), swap2[0] - 1, swap2[1] - 1);
        }


        PrintWriter pw = new PrintWriter("swap.out");
        for(int e : cowLine) {
            pw.println(e);
        }
        pw.flush();
        pw.close();

    }

    public static int[] reverse(int[] input, int start, int end) {
        int[] temp = new int[input.length];
        for (int i = 0; i < start; i++) {
            temp[i] = input[i];
        }
        for (int i = 0; start <= end; start++, i++) {
            temp[start] = input[end-i];
        }
        for (int i = end + 1; i < input.length; i++) {
            temp[i] = input[i];
        }
        return temp;
    }
}
