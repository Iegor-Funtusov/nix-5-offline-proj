package ua.com.nix.realization.level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Triangle {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int x1,x2,x3,y1,y2,y3;
    public void initialize() throws IOException {
        System.out.println("Enter x and y coordinates of first side of triangle: ");
        x1=Integer.parseInt(reader.readLine());y1=Integer.parseInt(reader.readLine());
        System.out.println("Enter x and y coordinates of second side triangle: ");
        x2=Integer.parseInt(reader.readLine());y2=Integer.parseInt(reader.readLine());
        System.out.println("Enter x and y coordinates of third side triangle: ");
        x3=Integer.parseInt(reader.readLine());y3=Integer.parseInt(reader.readLine());
    }
    public void calculations(){
        double a = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
        double b = Math.sqrt((x1 - x3) * (x1 - x3) + (y1 - y3) * (y1 - y3));
        double c = Math.sqrt((x2 - x3) * (x2 - x3) + (y2 - y3) * (y2 - y3));
        if (a + b <= c || a + c <= b || c + b <= a)
            System.out.println("The triangle does not exist");
        else
        {
            double p = (a + b + c) / 2.0;
            double square = Math.sqrt(p * (p - a) * (p - b) * (p - c));
            System.out.println("%.2f"+"Square of are triangle: " + square);
        }
    }
}
