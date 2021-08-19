import javax.print.attribute.Size2DSyntax;
import java.util.*;
import java.io.*;

public class Speeding {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new FileReader("speeding.in"));
        int n = scan.nextInt();
        int m = scan.nextInt();
        int ans = 0;
        int[] road = new int[100];
        int[] journey = new int[100];

        int start = 0;
        for(int i = 0; i < n; i++) {
            int end = start + scan.nextInt();
            int speed = scan.nextInt();
            for(; start < end; start++) {
                road[start] = speed;
            }
        }

        start = 0;
        for(int i = 0; i < m; i++) {
            int end = start + scan.nextInt();
            int speed = scan.nextInt();
            for(; start < end; start++) {
                if(speed > road[start] && speed - road[start] > ans) ans = speed - road[start];
            }
        }

        PrintWriter pw = new PrintWriter("speeding.out");
        pw.println(ans);
        pw.flush();
        pw.close();
    }
}
