import java.io.*;
import java.util.*;

public class CowSignalPractice {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("cowsignal.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());
        int scale = Integer.parseInt(st.nextToken());

        String[][] pic = new String[height][];
        for (int i = 0; i < height; i++) {
            pic[i] = br.readLine().split("");
        }

        String newX = "";
        String newDot = "";

        for (int i = 0; i < scale; i++) {
            newX += "X";
            newDot += ".";
        }

        for (int i = 0; i < height; i++) {
            for (int n = 0; n < width; n++) {
                if (pic[i][n].equals("X"))
                    pic[i][n] = newX;
                else if (pic[i][n].equals("."))
                    pic[i][n] = newDot;
            }
        }

        String ans = "";
        for (String[] e : pic) {
            String temp = "";
            for (String el : e) {
                temp += el;
            }
            for (int i = 0; i < scale; i++) {
                ans += temp + "\n";
            }
        }

        System.out.println(ans.trim());
        FileWriter fw = new FileWriter("cowsignal.out");
        fw.write(ans);
        fw.flush();
        fw.close();
    }
}