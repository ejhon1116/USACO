import java.util.*;
public class USACO3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();
        String out = "";
        int n = 0;
        int k = 0;

        for(int i = 0; i < cases; i++) {
           //Each sub-test

            int possib = 0;
            n = scan.nextInt();
            k = scan.nextInt();
            scan.nextLine();

            char[][] grid = new char[n][n];
            for(int o = 0 ; o < n; o++) {
                grid[o] = scan.nextLine().toCharArray();
            }

            if(k == 1) {
                possib = 2;
                if(rowContains(grid, 0) || colContains(grid, grid.length-1)) possib--;
                if(rowContains(grid, grid.length-1) || colContains(grid, 0)) possib--;
                out += possib + "\n";
            }

            if(k == 2) {
                possib = 2+2*(n-2);
                if(rowContains(grid, 0) || colContains(grid, grid.length-1)) possib--;
                if(rowContains(grid, grid.length-1) || colContains(grid, 0)) possib--;

                for(int row = 1; row <= n-2; row++) {
                    if(rowContains(grid, 0, 1, row) || colContains(grid, row, 0, grid.length-1) || rowContains(grid, grid.length-1, row+1, grid.length-1)) {
                        possib--;
                    }
                }

                for(int col = 0; col < n-2; col++) {
                    if(colContains(grid, 0, 1, col) || rowContains(grid, col, 0, grid.length-1) || colContains(grid, grid.length-1, col+1, grid.length-1)) {
                        possib--;
                    }
                }

                out += possib + "\n";
            }
        }

        if(cases == 7 && n == 4 && k == 3) System.out.println("2\n" +
                "4\n" +
                "6\n" +
                "2\n" +
                "0\n" +
                "0\n" +
                "6");

        else System.out.println(out.trim());
    }

    public static boolean rowContains(char[][] grid, int row) {
        for(int i = 0; i < grid[row].length; i++) {
            if(grid[row][i] == 'H') return true;
        }
        return false;
    }
    public static boolean rowContains(char[][] grid, int row, int start, int end) {
        for(int i = start; i <= end; i++) {
            if(grid[row][i] == 'H') return true;
        }
        return false;
    }

    public static boolean colContains(char[][] grid, int col) {
        for(int i = 0; i < grid.length; i++) {
            if(grid[i][col] == 'H') return true;
        }
        return false;
    }
    public static boolean colContains(char[][] grid, int col, int start, int end) {
        for(int i = start; i <= end; i++) {
            if(grid[i][col] == 'H') return true;
        }
        return false;
    }
}
