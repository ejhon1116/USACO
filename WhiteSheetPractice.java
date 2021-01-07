import java.awt.*;
import java.util.*;

public class WhiteSheetPractice {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Rectangle> paperList = new ArrayList<Rectangle>();
        for (int i = 0; i < 3; i++) {
            int x1 = scan.nextInt();
            int y1 = scan.nextInt();
            int x2 = scan.nextInt();
            int y2 = scan.nextInt();
            paperList.add(new Rectangle(x1, y1, x2 - x1, y2 - y1));
        }

        double intersec1 = getArea(paperList.get(1).intersection(paperList.get(0)));
        double intersec2 = getArea(paperList.get(2).intersection(paperList.get(0)));
        double blackblackintersec = getArea(paperList.get(1).intersection(paperList.get(0)).intersection(paperList.get(2).intersection(paperList.get(0))));

        if (Math.abs(intersec1 + intersec2 - blackblackintersec - getArea(paperList.get(0))) < 0.000001)
            System.out.println("NO");
        else
            System.out.println("YES");
    }

    public static double getArea(Rectangle input) {
        if (input.isEmpty())
            return 0.0;
        return input.getHeight() * input.getWidth();
    }
}