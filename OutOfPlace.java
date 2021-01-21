import java.io.*;
import java.util.*;

public class OutOfPlace {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new FileReader("outofplace.in"));
        int cowNum = scan.nextInt();
        int[] heights = new int[cowNum];

        for(int i = 0; i < cowNum; i++) {
            heights[i] = scan.nextInt();
        }

        int outPlaceInd = -1;
        int direc = 0;
        for(int i = 0; i < cowNum; i++) {
            if(i == 0) {
                if(heights[i] > heights[i+1]){
                    outPlaceInd = i;
                    direc = 1;
                    break;
                }
            }

            else if (i == cowNum-1) {
                if(heights[i] < heights[i-1]) {
                    outPlaceInd = i;
                    direc = -1;
                    break;
                }
            }

            else if(heights[i] < heights[i + 1] && heights[i] < heights[i-1]) {
                //System.out.println("test");
                outPlaceInd = i;
                direc = -1;

            }

            else if(heights[i] > heights[i + 1] && heights[i] > heights[i-1]) {
                outPlaceInd = i;
                direc = -1;

            }
        }
        System.out.println(Arrays.toString(heights));

        int swaps = 0;
        if(direc == 1) {
            while(heights[outPlaceInd] > heights[outPlaceInd + 1]) {
                while(heights[outPlaceInd+1] == heights[outPlaceInd+2]) {
                    heights = swap(heights, outPlaceInd, 1);
                    outPlaceInd++;
                }
                heights = swap(heights, outPlaceInd, 1);
                outPlaceInd++;
                swaps++;
                if(outPlaceInd == cowNum-1) break;

            }
        }
        if(direc == -1) {
            while(heights[outPlaceInd] < heights[outPlaceInd - 1]) {
                while(heights[outPlaceInd-1] == heights[outPlaceInd-2]) {
                    heights = swap(heights, outPlaceInd, -1);
                    outPlaceInd--;
                }
                heights = swap(heights, outPlaceInd, -1);
                outPlaceInd--;
                swaps++;
                if(outPlaceInd == 0) break;
            }
        }

        PrintWriter pw = new PrintWriter("outofplace.out");
        pw.println(swaps);
        pw.flush();
        pw.close();

    }

    public static int[] swap(int[] input, int index, int direc) {
        int temp = input[index];
        input[index] = input[index + direc];
        input[index + direc] = temp;
        return input;
    }
}
