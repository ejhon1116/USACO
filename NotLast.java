import java.util.*;
import java.io.*;

public class NotLast {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("notlast.in"));
        Map<String, Integer> map = new TreeMap<String, Integer>();
        int num = Integer.parseInt(br.readLine());
        StringTokenizer st;

        String[] cows = { "Bessie", "Elsie", "Daisy", "Gertie", "Annabelle", "Maggie", "Henrietta" };
        for (String cow : cows) {
            map.put(cow, 0);
        }
        for (int n = 0; n < num; n++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int yield = Integer.parseInt(st.nextToken());

            if (map.get(name) < yield) {
                map.put(name, yield + map.get(name));
            }
        }

        int lowest = 100;
        for (String keys : map.keySet()) {
            if (map.get(keys) < lowest)
                lowest = map.get(keys);
        }

        String lowest2key = "";
        int lowest2 = 100;
        for (String keys : map.keySet()) {
            if (map.get(keys) > lowest && map.get(keys) < lowest2) {
                lowest2 = map.get(keys);
                lowest2key = keys;
            }
        }
        String ans = lowest2key;
        for (String keys : map.keySet()) {
            if (map.get(keys) == lowest2 && !keys.equals(lowest2key)) {
                ans = "TIE";
            }
            if(lowest2key.equals("")) {
                ans = "TIE";
                break;
                
            }
        }
        FileWriter fw = new FileWriter("notlast.out");

        fw.write(lowest2key);
        fw.flush();
        fw.close();
    }
}