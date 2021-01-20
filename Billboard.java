import java.util.*;
import java.io.*;
import java.awt.*;

public class Billboard {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new FileReader("billboard.in"));
        int[] coord1 = {scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt()};
        int[] coord2 = {scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt()};
        int ans;
        Rectangle badBill = new Rectangle(coord1[0], coord1[1], coord1[2] - coord1[0], coord1[3] - coord1[1]);
        Rectangle goodBill = new Rectangle(coord2[0], coord2[1], coord2[2] - coord2[0], coord2[3] - coord2[1]);
        Rectangle intersec = badBill.intersection(goodBill);

        if(intersec.getWidth() < badBill.getWidth() && intersec.getHeight() < badBill.getHeight()
                || intersec.getX() > badBill.getX() && intersec.getX() + intersec.getWidth() < badBill.getX() + badBill.getWidth()
                || intersec.getY() > badBill.getY() && intersec.getY() + intersec.getHeight() < badBill.getY() + badBill.getHeight()) {
            ans = (int)badBill.getHeight() * (int)badBill.getWidth();
        }
        else if(intersec.getWidth() == badBill.getWidth() && intersec.getHeight() < badBill.getHeight()) {
            ans = ((int)badBill.getHeight() - (int)intersec.getHeight()) * (int)badBill.getWidth();
        }
        else if(intersec.getWidth() < badBill.getWidth() && intersec.getHeight() == badBill.getHeight()) {
            ans = ((int)badBill.getWidth() - (int)intersec.getWidth()) * (int)badBill.getHeight();
        }
        else ans = 0;
        FileWriter fw = new FileWriter("billboard.out");
        fw.write(ans + "");
        fw.flush();
        fw.close();
    }
}
