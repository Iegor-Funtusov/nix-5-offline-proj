package level1.triangle_area;

import java.awt.*;

public class TriangleArea {
    public static double calculate(Point a, Point b, Point c) {
        return Math.abs(((a.getX() - c.getX()) * (b.getY() - a.getY()) -
                (a.getX() - b.getX()) * (c.getY() - a.getY())) * 0.5);
    }
}
