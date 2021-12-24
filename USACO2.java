import java.util.*;
public class USACO2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] curr = new int[n];
        int[] opt = new int[n];
        for(int i = 0; i < n; i++) {
            curr[i] = scan.nextInt();
        }
        for(int i = 0; i < n; i++) {
            opt[i] = scan.nextInt();
        }

        int changes = 0;

        int start = -1;
        int end = n-1;

        for(int i = 0; i < n; i++) {

            //Find range where temps are too high
            if(curr[i] > opt[i]) {
                for(int o = i; o < n; o++) {
                    if(curr[o] <= opt[o]) {
                        break;
                    }
                    curr[o]--;
                }
                changes++;
                i--;
            }

            //Find range where temps are too low
            else if(curr[i] < opt[i]) {
                for(int o = i; o < n; o++) {
                    if(curr[o] >= opt[o]) {
                        break;
                    }
                    curr[o]++;
                }
                changes++;
                i--;
            }

        }

        System.out.println(changes);
    }
}
