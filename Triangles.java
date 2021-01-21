import java.util.*;
import java.io.*;
import java.awt.*;

public class Triangles {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new FileReader("triangles.in"));
        int postNum = scan.nextInt();
        Point[] coordArr = new Point[postNum];
        for(int i = 0; i < postNum; i++) {
            coordArr[i] = new Point(scan.nextInt(), scan.nextInt());
        }

        int maxArea = 0;
        for(Point testOrig : coordArr) {
            Point maxX = new Point(0, 0);
            Point maxY = new Point(0, 0);
            for(Point testPoint : coordArr) {
                if(xParr(testOrig, testPoint) > xParr(testOrig, maxX)) {
                    maxX = testPoint;
                }
                if(yParr(testOrig, testPoint) > yParr(testOrig, maxY)) {
                    maxY = testPoint;
                }
            }
            if(xParr(testOrig, maxX)*yParr(testOrig, maxY)>maxArea) maxArea = xParr(testOrig, maxX)*yParr(testOrig, maxY);
        }

        PrintWriter pw = new PrintWriter("triangles.out");
        pw.println(maxArea);
        pw.flush();
        pw.close();
    }

    public static int xParr(Point point1, Point point2) {
        if(Math.round(point1.getY()) == Math.round(point2.getY())) {
            return (int)Math.round(Math.abs(point1.getX() - point2.getX()));
        }
        else return -1;
    }

    public static int yParr(Point point1, Point point2) {
        if(Math.round(point1.getX()) == Math.round(point2.getX())) {
            return (int)Math.round(Math.abs(point1.getY() - point2.getY()));
        }
        else return -1;
    }
}
