package com.example.areas;

import java.io.BufferedReader;
import java.io.IOException;

public class AreaController {
    private final BufferedReader reader;

    public AreaController(BufferedReader reader){
        this.reader = reader;
    }

    public void calculateAreaOfTriangle() throws IOException {
        System.out.println("Manual or Automatically generation Triangle?: " + "\n 1 - Manual"
                + "\n 2 - Automatically" + "\n 3 - Back to Task selection " +"\n 0 - exit");
        switch (reader.readLine()){
            case "1":{
                Triangle t = manualSetTriangle();
                System.out.println(t);
                System.out.println("Area of Triangle = " + t.area());
                calculateAreaOfTriangle();
                break;
            }
            case "2":{
                Triangle t = automaticallySetTriangle();
                System.out.println(t);
                System.out.println("Area of Triangle = " + t.area());
                calculateAreaOfTriangle();
                break;
            }
            case "3":{
                break;
            }
            case "0":{
                System.exit(0);
                break;
            }
        }
    }

    private Triangle manualSetTriangle() throws IOException {
        System.out.println("Enter A position - X:");
        int aX = Integer.parseInt(reader.readLine());
        System.out.println("Enter A position - Y:");
        int aY = Integer.parseInt(reader.readLine());
        System.out.println("Enter B position - X:");
        int bX = Integer.parseInt(reader.readLine());
        System.out.println("Enter B position - Y:");
        int bY = Integer.parseInt(reader.readLine());
        System.out.println("Enter C position - X:");
        int cX = Integer.parseInt(reader.readLine());
        System.out.println("Enter C position - Y:");
        int cY = Integer.parseInt(reader.readLine());
        Point a = new Point(aX, aY);
        Point b = new Point(bX, bY);
        Point c = new Point(cX, cY);
        return new Triangle(a, b, c);
    }

    private Triangle automaticallySetTriangle(){
        Point a = randomPoint();
        Point b = randomPoint();
        Point c = randomPoint();
        return new Triangle(a, b, c);
    }

    private Point randomPoint(){
        int x = (int) (Math.random()*30);
        int y = (int) (Math.random()*30);
        return new Point(x,y);
    }
}
