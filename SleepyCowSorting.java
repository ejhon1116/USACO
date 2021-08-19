import java.awt.*;
import java.io.*;
import java.util.*;

public class SleepyCowSorting {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new FileReader("src/.in/sleepy.in"));

        //Number of cows
        int n = scan.nextInt();

        //Makes two identical array lists of the unsorted cows
        ArrayList<Integer> cows = new ArrayList<>();
        ArrayList<Integer> cows2 = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int temp = scan.nextInt();
            cows.add(temp);
            cows2.add(temp);
        }


        System.out.println(move(0, 2, cows2).toString());
        //Sorts one array
        Collections.sort(cows2);

        //Amt of moves needed to be made
        int moves = 0;

        //Loops through the cows backwards to find the first one out of order
        for(int i = n-2; i >= 0; i--) {

            //Finds one out of order
            if(cows.get(i) > cows.get(i+1)) {

                //If the index out of order is 0, move the element at 0 to the end
                if(i == 0) {
                    cows = move(0, i, cows);
                    moves++;
                }

                else {
                    for (int o = 0; o < i; o++) {
                        cows = move(0, i, cows);
                        moves++;
                        System.out.println(cows.toString() + ": " + i);
                    }
                }
            }
        }

        PrintWriter pw = new PrintWriter("sleepy.out");
        pw.println(moves);
        pw.flush();
        pw.close();
    }

    public static ArrayList<Integer> move(int ind, int oOD, ArrayList<Integer> inp) {
        for(int i = inp.size()-1; i >= oOD; i--) {
            if(inp.get(ind) > inp.get(i)) {
                inp.add(i+1, inp.get(ind));
                inp.remove(ind);
                break;
            } else if(i == oOD) {
                inp.add(i+1, inp.get(ind));
                inp.remove(ind);
            }
        }
        return inp;
    }
}
