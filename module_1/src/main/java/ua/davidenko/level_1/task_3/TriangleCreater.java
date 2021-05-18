package ua.davidenko.level_1.task_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TriangleCreater {
    public static void UserTriangle() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter coord X and Y for point A");
        int coordAx = Integer.parseInt(br.readLine());
        int coordAy = Integer.parseInt(br.readLine());
        System.out.println("Enter coord X and Y for point B");
        int coordBx = Integer.parseInt(br.readLine());
        int coordBy = Integer.parseInt(br.readLine());
        System.out.println("Enter coord X and Y for point C");
        int coordCx = Integer.parseInt(br.readLine());
        int coordcY = Integer.parseInt(br.readLine());
        System.out.println(" Triangle Area is : ");
        System.out.println(TriangleArea.calculeteArea(coordAx, coordAy, coordBx, coordBy, coordCx, coordcY));
    }

    public static void randomTriengle() {
        int coordAx = ((int) (Math.random() * 100)- 50);
        System.out.println("coordAx is: " + coordAx);
        int coordAy = ((int) (Math.random() * 100) - 50);
        System.out.println("coordAy is: " + coordAy);
        int coordBx = ((int) (Math.random() * 100) - 50);
        System.out.println("coordBx is: " + coordBx);
        int coordBy = ((int) (Math.random() * 100) -50);
        System.out.println("coordBy is: " + coordBy);
        int coordCx = ((int) (Math.random() * 100) -50);
        System.out.println("coordCx is: " + coordCx);
        int coordCy = ((int) (Math.random() * 100) - 50);
        System.out.println("coordCy is: " + coordCy);
        double area = TriangleArea.calculeteArea(coordAx, coordAy, coordBx, coordBy, coordCx, coordCy);
        System.out.println("Rundom Triangle Area is : " + area);
    }
}
