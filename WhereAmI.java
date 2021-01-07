import java.util.*;
import java.io.*;

public class WhereAmI {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("whereami.in"));
        int n = Integer.parseInt(br.readLine());
        String mailboxes = br.readLine();
        boolean trapdoor = false;
        String ans = "";

        for (int o = 0; o < mailboxes.length() && trapdoor == false; o++) {
            trapdoor = true;
            Set<String> set = new TreeSet<String>();
            for (int i = 0; i < mailboxes.length() - o; i++) {
                if (set.contains(mailboxes.substring(i, i + o + 1))) {
                    trapdoor = false;
                    break;
                }
                set.add(mailboxes.substring(i, i + o + 1));
            }
            if (trapdoor == true)
                ans = (o + 1) + "";
        }

        FileWriter fw = new FileWriter("whereami.out");
        fw.write(ans);
        fw.flush();
        fw.close();

    }
}