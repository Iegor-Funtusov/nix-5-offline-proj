package ua.com.alevel.lvl1;

public class TriangleS {
    public static double sOfTriangle(double x1, double x2, double x3,
                                  double y1, double y2, double y3){
       double sq = Math.abs((x1-x3)*(y2-y1)- (x1-x2)*(y3-y1))*0.5;
       return sq;
    }
}