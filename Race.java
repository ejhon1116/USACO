import java.io.*;
import java.util.*;
public class Race {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new FileReader("src/.in/race.in"));
        int finish = scan.nextInt();
        int caseNum = scan.nextInt();

        int[] cases = new int[caseNum];
        for(int i = 0; i < caseNum; i++) {
            cases[i] = scan.nextInt();
        }

        for(int max : cases) {
            int speed = 0;
            int time = 0;
            int distance = 0;

            //

            int timeToMax = 0;
            int distanceToMax = 0;

            for(; speed < max; speed++, distance += speed, time++) {
                if(distance >= finish) {
                    break;
                }
            }
            int remaining = finish - distance;
            if(!(distance >= finish)) {

                for (; (distanceToMax+speed) * 2 <= remaining; speed++, distance += speed, distanceToMax += speed, time++,  timeToMax++) {
                    System.out.println(max + ": " + distance + ": " + speed);
                }
                System.out.println(max + ": " + distance + ": " + speed);
            }

        }
    }
}
