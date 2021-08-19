import java.util.*;
import java.io.*;

public class SleepyCowHerding {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new FileReader("herding.in"));

        int min = 0;
        int max = 0;
        int[] cowLine = {scan.nextInt(), scan.nextInt(), scan.nextInt()};
        int[] cowLineReset = cowLine;
        while(cowLine[2] - cowLine[1] + cowLine[1] - cowLine[0] != 2) {
            int lower = (cowLine[1] - cowLine[0]) / 2 + cowLine[0];
            if (cowLine[1] - cowLine[0] > cowLine[2] - cowLine[1]) {
                lower = (cowLine[2] - cowLine[1]) / 2 + cowLine[1];
            }

            int temp = cowLine[1];
            cowLine[1] = lower;

            if (cowLine[1] - cowLine[0] < cowLine[2] - cowLine[1]) {
                cowLine[2] = temp;
            } else if (cowLine[1] - cowLine[0] > cowLine[2] - cowLine[1]) {
                cowLine[0] = temp;
            }
            min++;
        }

        cowLine = cowLineReset;
        while(cowLine[2] - cowLine[1] + cowLine[1] - cowLine[0] != 2) {
            int lower = (cowLine[1] - cowLine[0]) / 2 + cowLine[0];
            if (cowLine[1] - cowLine[0] < cowLine[2] - cowLine[1]) {
                lower = (cowLine[2] - cowLine[1]) / 2 + cowLine[1];
            }

            int temp = cowLine[1];
            cowLine[1] = lower;

            if (cowLine[1] - cowLine[0] < cowLine[2] - cowLine[1]) {
                cowLine[2] = temp;
            } else if (cowLine[1] - cowLine[0] > cowLine[2] - cowLine[1]) {
                cowLine[0] = temp;
            }
            max++;
        }

        min++;
        max++;
        FileWriter fw = new FileWriter("herding.out");
        fw.write(max + "\n" + min);
        fw.flush();
        fw.close();
    }
}
