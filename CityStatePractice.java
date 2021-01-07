import java.util.*;
import java.io.*;

public class CityStatePractice {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("citystate.in"));
        Map<String, String> cityState = new TreeMap<String, String>();
        Map<String, String> stateCity = new TreeMap<String, String>();
        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String city = st.nextToken();
            String state = st.nextToken();
            cityState.put(city, state);
            stateCity.put(state, city);
        }

        int count = 0;
        for (String city : cityState.keySet()) {
            if (cityState.containsValue(city.substring(0, 2))) {
                for (String cityContains : cityState.keySet()) {
                    if (cityState.get(cityContains).equals(city.substring(0, 2))) {
                        if (cityContains.substring(0, 2).equals(cityState.get(city))) {
                            count++;
                        }
                    }
                }
            }
        }

        FileWriter fw = new FileWriter("citystate.out");
        fw.write(count / 2 + "");
        fw.flush();
        fw.close();
    }
}