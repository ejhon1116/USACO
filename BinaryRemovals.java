import java.util.*;

public class BinaryRemovals {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();

        //Loop through all test cases
        for(; t >= 0; t--) {

            //Current string we are testing
            char[] curr = scan.nextLine().toCharArray();
            int[] counter = new int[2];

            //Loop through the string to count 0s and 1s
            for(char e : curr) {
                counter[e-'0']++;
            }

            if(counter[0] == 0 || counter[0] == 1 || counter[1] == 0 || counter[1] == 1) {
                System.out.println("YES");
                return;
            }
        }
    }
}
