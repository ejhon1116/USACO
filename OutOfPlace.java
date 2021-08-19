import java.io.*;
import java.util.*;

public class OutOfPlace {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new FileReader("outofplace.in"));
        ArrayList<Integer> input = new ArrayList<>();

        scan.nextInt();

        for (int i = 0; scan.hasNextInt(); i++) {
            int curr = scan.nextInt();
            if (i > 0) {
                if (input.get(input.size() - 1) != curr) {
                    input.add(curr);
                }
            } else input.add(curr);
        }
        int n = input.size();

        //Sorted input
        ArrayList<Integer> sorted = (ArrayList<Integer>) input.clone();
        Collections.sort(sorted);

        //When direc = 1 means Bessie must move to the right. Direc = -1 means Bessie must move to the left
        int direc = 1;

        //Find Bessie
        int bes = -1;
        for (int i = 1; i < n - 1; i++) {
            if (!(input.get(i - 1) <= input.get(i) && input.get(i) <= input.get(i + 1))) {
                if (input.get(i - 1) <= input.get(i + 1)) {
                    bes = i;
                    if (input.get(i) < input.get(i - 1)) direc = -1;
                    else direc = 1;
                }
            }
        }

        //Check edge cases

        if (input.get(n - 1) < input.get(n - 2)) {
            bes = n - 1;
            direc = -1;
        }

        if (input.get(0) > input.get(1)) {
            bes = 0;
            direc = 1;
        }

        //Where Bessie should end up
        int swapTo = -1;

        if (direc == 1) {
            for (int i = 0; i < n; i++) {
                if (sorted.get(i) == input.get(bes)) {
                    swapTo = i;
                }
            }
        } else {
            for (int i = n - 1; i >= 0; i--) {
                if (sorted.get(i) == input.get(bes)) {
                    swapTo = i;
                }
            }
        }

        System.out.println(Math.abs(swapTo - bes));

        FileWriter fw = new FileWriter("outofplace.out");
        fw.write(Math.abs(swapTo - bes) + "");
        fw.flush();
        fw.close();
    }
}
