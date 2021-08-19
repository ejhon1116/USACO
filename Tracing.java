import javax.swing.plaf.synth.SynthStyle;
import java.awt.*;
import java.util.*;
import java.io.*;
public class Tracing {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new FileReader("USACO/src/.in/tracing.in"));
        int numCow = scan.nextInt();
        int time = scan.nextInt();
        scan.nextLine();
        String[] temp = scan.nextLine().split("");
        boolean[] cowArr = new boolean[temp.length];
        for(int i = 0; i < numCow; i++) {
            cowArr[i] = (temp[i].equals("1"));
        }
        TreeMap<Integer, int[]> occur = new TreeMap<>();
        for(int i = 0; i < time; i ++) {
            occur.put(scan.nextInt(), new int[] {scan.nextInt(), scan.nextInt()});
        }

        System.out.println(Arrays.toString(cowArr));
        for(int key : occur.keySet()) {
            System.out.println(key + ", " + Arrays.toString(occur.get(key)));
        }

        int zero = 0;
        int zeroTime = -1;
        HashSet<Integer> notZero = new HashSet<>();

        //All occurences within remove have no sick cows
        ArrayList<Integer> remove = new ArrayList<>();
        for(int key : occur.keySet()) {
            //If a cow is not sick, it cannot be patient zero
            //If 'x' cow is sick, and he is could be zero, he is zero
            if(!cowArr[occur.get(key)[0]-1] || !cowArr[occur.get(key)[1]-1]) {
                notZero.add(occur.get(key)[0]);
                notZero.add(occur.get(key)[1]);
            }

            //If both cows are sick, and if one of them is not in notZero, that person is patient zero. Save their number and their time.
            if(cowArr[occur.get(key)[1]-1] && cowArr[occur.get(key)[0]-1] && !notZero.contains(occur.get(key)[1])) {
                zero = occur.get(key)[1];
                notZero.add(zero);
                zeroTime = key;
            }
            else if(cowArr[occur.get(key)[0]-1] && cowArr[occur.get(key)[1]-1] && !notZero.contains(occur.get(key)[0])) {
                zero = occur.get(key)[0];
                notZero.add(zero);
                zeroTime = key;
            }
            //If both cows are not sick, they do not matter, so remove them
            else if(!cowArr[occur.get(key)[0]-1] && !cowArr[occur.get(key)[1]-1]) {
                remove.add(key);
            }
        }

        for(int key : occur.keySet()) {
            if(key < zeroTime) remove.add(key);
        }

        for(int e : remove) {
            occur.remove(e);
        }

        System.out.println("\n");
        for(int key : occur.keySet()) {
            System.out.println(key + ", " + Arrays.toString(occur.get(key)));
        }


        int lowest = 0;
        int highest = 0;
        for(int i = 0; i < cowArr.length; i++) {
            int tempInt = 1;
            if(cowArr[i]) {
                for(int key : occur.keySet()) {
                    if(occur.get(key)[0] == i+1 && cowArr[occur.get(key)[1]-1]) {
                        break;
                    }
                    else tempInt++;
                }
            }
            if(lowest == 0 || tempInt < lowest) lowest = tempInt;
            if(tempInt > highest) highest = tempInt;
        }
        System.out.println(lowest + " " + highest);
    }
}
