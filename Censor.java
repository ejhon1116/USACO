import java.io.*;
import java.util.*;

public class Censor {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new FileReader("censor.in"));
        StringBuilder txt = new StringBuilder(scan.nextLine());
        String del = scan.nextLine();
        String curr = "";
        for(int i = 0; i < txt.length()-del.length(); i++) {
            if(i < 0) i = 0;
            curr = txt.substring(i, i+del.length());
            if(curr.equals(del)) {
                txt.replace(i, i+del.length(), "");
                i-=del.length();
            }
        }
        FileWriter fw = new FileWriter("censor.out");
        fw.write(txt.toString());
        fw.flush();
        fw.close();
    }
}
