import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
public class MilkMeasurement {
    public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(new FileReader("measurement.in"));
        int logDates = scan.nextInt();

        //All cows are currently the top producers
        ArrayList<Integer> top = new ArrayList<>();

        //FJ has made zero changes
        int changes = 0;

        //Set up a map: the key is the day, the hashset is the cow at index 0 and the increase/decrease is index 1
        TreeMap<Integer, ArrayList<Integer>> logs = new TreeMap<>();

        //Skip a line
        scan.nextLine();

        //Let Bessie = ind 0, Elsie = ind 1, Mildred ind 2
        int[] cows = new int[] {7, 7, 7};
        for(int i = 0; i < logDates; i++) {

            String[] log = scan.nextLine().split(" ");
            int cow = 0;
            if(log[1].equals("Elsie")) cow = 1;
            if(log[1].equals("Mildred")) cow = 2;

            ArrayList<Integer> cowPut = new ArrayList<>();
            cowPut.add(cow);
            cowPut.add(Integer.parseInt(log[2]));

            logs.put(Integer.parseInt(log[0]), cowPut);
        }

        System.out.println(logs.toString());

        //Each log is now ordered so go through them each
        for(int day : logs.keySet()) {
            ArrayList<Integer> list = logs.get(day);
            cows[list.get(0)] += list.get(1);
            if(!greatest(cows).equals(top)) {
                top = greatest(cows);
                changes++;
            }
        }

        PrintWriter pw = new PrintWriter("measurement.out");
        pw.println(changes);
        pw.flush();
        pw.close();
    }

    //Find the greatest producer of all the cows
    public static ArrayList<Integer> greatest(int[] currCow) {
        //Array of the highest producing cow(s)
        ArrayList<Integer> ret = new ArrayList<>();

        //Give it a size of 1;
        ret.add(0);

        int greatest = 0;

        //Go through the three cows and see which one is producing the most
        for(int i = 0; i < currCow.length; i++) {
            if(currCow[i] > greatest) {
                greatest = currCow[i];
                ret.set(0, i);
            }
        }

        for(int i = 0; i < currCow.length; i++) {
            if(!ret.contains(i) && currCow[i] == greatest) ret.add(i);
        }

        return ret;
    }
}
