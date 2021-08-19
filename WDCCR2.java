import java.util.*;
import java.io.*;

public class WDCCR2 {
    public static void main(String[] args) throws IOException {
        int count = 0;

        Scanner scan = new Scanner(new FileReader("circlecross.in"));
        String input = scan.nextLine();

        StringBuilder sb = new StringBuilder();
        sb.append(input).reverse();

        String revInput = sb.toString();

        char[] paths = input.toCharArray();
        char[] checked = new char[26];

        for(int entry = 0; entry < paths.length-1; entry++) {

            //Current cow we are looking at
            char currCow = paths[entry];
            int exit = 51 - revInput.indexOf(currCow);

            //Determine whether the spot is the entrance or the exit
            if(input.indexOf(currCow) == entry) {

                //Find all cows between the entry and exit
                for(int i = entry + 1; i < exit; i++) {
                    int ind1 = i;
                    int ind2 = input.indexOf(paths[i]);
                    if(ind2 == ind1) {
                        ind2 = 51 - revInput.indexOf(paths[i]);
                    }
                    if(ind2 > exit || ind2 < entry) {
                        count++;
                    }
                }
            }
        }

        count = count/2;

        PrintWriter pw = new PrintWriter(new FileWriter("circlecross.out"));
        pw.write((count + ""));
        pw.flush();
        pw.close();
    }
}
