import java.util.*;
public class USACO1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();
        char[] cows = scan.nextLine().toCharArray();


        int rej = 0;

        for(int o = 0; o < cows.length-2; o++) {
            //Check all possibilities starting at o
            int lonely = isLonely(cows, o, 3);
            if (lonely == 1) {
                char lonelyBreed = whoLonely(cows, o, 3);
                rej++;
                for (int i = o + 3; i < cows.length; i++) {
                    if(cows[i] == lonelyBreed) break;
                    else rej++;
                }
            }

            if(lonely == 0) {
                char lonelyBreed = whoLonely(cows, o, 3);
                int i = o + 3;
                for (; i < cows.length; i++) {
                    if(cows[i] == lonelyBreed) {
                        rej++;
                        break;
                    }
                }
                i++;
                for (; i < cows.length; i++) {
                    if(cows[i] == lonelyBreed) break;
                    else rej++;
                }
            }
        }

        System.out.println(rej);
    }

    //If they are all the same breed, return 0. If they will never be lonely return -1. If they are lonely return 1.
    public static int isLonely(char[] arr, int start, int length) {
        int g = 0;
        int h = 0;
        for(int i = start; i < start+length; i++) {
            if(arr[i] == 'G') g++;
            else h++;
        }

        if(g == 0 || h == 0) return 0;
        else if(g > 1 && h > 1) return -1;
        else return 1;
    }

    public static char whoLonely(char[] arr, int start, int length) {
        int g = 0;
        int h = 0;
        for(int i = start; i < start+length; i++) {
            if(arr[i] == 'G') g++;
            else h++;
        }

        if(g > h) return 'H';
        if(h > g) return 'G';
        else return 'X';
    }
}
