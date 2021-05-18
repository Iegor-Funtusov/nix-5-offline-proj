package com.Lapchenko_Kirill.project.first_level.third_task;

public class TriangleSquare {
    public static double calculateSquare(int x1, int y1, int x2, int y2,int x3, int y3) {
                double area =   Math.abs((x1-x3)*(y2-y1)- (x1-x2)*(y3-y1))*0.5;
                return area;
            }
}
