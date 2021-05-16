package nix.com.lvl_1.area;

import java.awt.Point;

public class CalcAreaTriangle {

    Point a;
    Point b;
    Point c;

    public CalcAreaTriangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getArea( ){

        return Math.abs((a.getX()-c.getX())*(b.getY()-a.getY())-
                (a.getX()-b.getX())*(c.getY()-a.getY()))*0.5;
    }
}
