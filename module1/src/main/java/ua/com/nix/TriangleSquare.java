package ua.com.nix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TriangleSquare {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Введите координату X точки A: ");
        double x1 = Double.parseDouble(reader.readLine());
        System.out.print("Введите координату Y точки A: ");
        double y1 = Double.parseDouble(reader.readLine());
        System.out.print("Введите координату X точки B: ");
        double x2 = Double.parseDouble(reader.readLine());
        System.out.print("Введите координату Y точки B: ");
        double y2 = Double.parseDouble(reader.readLine());
        System.out.print("Введите координату X точки C: ");
        double x3 = Double.parseDouble(reader.readLine());
        System.out.print("Введите координату Y точки C: ");
        double y3 = Double.parseDouble(reader.readLine());

        double sideAB = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
        double sideAC = Math.sqrt((x1 - x3) * (x1 - x3) + (y1 - y3) * (y1 - y3));
        double sideBC = Math.sqrt((x2 - x3) * (x2 - x3) + (y2 - y3) * (y2 - y3));

        double semiPerimeter = 0.5 * (sideAB + sideAC + sideBC);

        double square = Math.sqrt(semiPerimeter * (semiPerimeter - sideAB)
                    * (semiPerimeter - sideAC) * (semiPerimeter - sideBC));

        System.out.println(square);
    }
}
