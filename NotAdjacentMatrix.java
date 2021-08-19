import java.util.*;

public class NotAdjacentMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        StringBuilder strB = new StringBuilder();
        for(int i = 0; i < t; i++) {
            int n = scan.nextInt();
            if(n == 1) {
                strB.append("1\n");
            } else if(n == 2 || n < 1) {
                strB.append("-1\n");
            } else {
                int[][] temp = new int[n][n];
                temp[0][0] = 1;

                int counter = 3, startRow = 1, startCol = 1;
                while (startRow<n) {
                    int row = startRow;
                    int col = 0;
                    while (row >= 0) {
                        temp[row][col] = counter;
                        counter++;
                        row--;
                        col++;
                    }
                    startRow++;
                }

                while (startCol<n-1) {
                    int row = n-1;
                    int col = startCol;
                    while (col < n) {
                        temp[row][col] = counter;
                        counter++;
                        row--;
                        col++;
                    }
                    startCol++;
                }

                temp[n-1][n-1] = 2;
                for(int[] e : temp) {
                    StringBuilder tempStrB = new StringBuilder();
                    for(int el : e) {
                        tempStrB.append(el).append(" ");
                    }
                    strB.append(tempStrB).append("\n");
                }
            }
        }
        System.out.println(strB);
    }
}
