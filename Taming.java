//Problem link: http://www.usaco.org/index.php?page=viewproblem2&cpid=809

import java.io.*;
import java.util.*;

public class Taming {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new FileReader("taming.in"));
        int n = scan.nextInt();
        String ans = "";
        int[] log = new int[n];
        for (int i = 0; i < n; i++) log[i] = scan.nextInt();
        log[0] = 0;
        for (int i = log.length - 2; i >= 0; i--) {
            if (log[i + 1] > 0) {
                if(!(log[i] == -1 || log[i] == log[i + 1] - 1)) {
                    ans = "-1";
                    break;
                }
                log[i] = log[i + 1] - 1;
            }
        }
        if(!ans.equals("-1")) {
            int min = 0;
            int unknown = 0;
            for (int e : log) {
                if (e == 0) min++;
                if (e == -1) unknown++;
            }
            ans = min + " " + (min + unknown);
        }
        FileWriter fw = new FileWriter("taming.out");
        fw.write(ans);
        fw.flush();
        fw.close();
    }
}
