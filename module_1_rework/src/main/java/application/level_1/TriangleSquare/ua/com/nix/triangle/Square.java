package application.level_1.TriangleSquare.ua.com.nix.triangle;


import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Square {
    double result;

    public double findByUser() throws IOException {
        BufferedReader builder = new BufferedReader(new InputStreamReader(System.in));
        double xA = 0, yA = 0, xB = 0, yB = 0, xC = 0, yC = 0;
        while (true) {
            try {
                System.out.print("Введите координату х для вершины А: ");
                xA = Double.parseDouble(builder.readLine());
                break;
            } catch (Exception e) {
                System.out.println("Введите нормально число");
            }
        }
        while (true) {
            try {
                System.out.print("Введите координату y для вершины А: ");
                yA = Double.parseDouble(builder.readLine());
                break;
            } catch (Exception e) {
                System.out.println("Введите нормально число");
            }
        }
        while (true) {
            try {
                System.out.print("Введите координату х для вершины B: ");
                xB = Double.parseDouble(builder.readLine());
                break;
            } catch (Exception e) {
                System.out.println("Введите нормально число");
            }
        }
        while (true) {
            try {
                System.out.print("Введите координату y для вершины B: ");
                yB = Double.parseDouble(builder.readLine());
                break;
            } catch (Exception e) {
                System.out.println("Введите нормально число");
            }
        }
        while (true) {
            try {
                System.out.print("Введите координату х для вершины C: ");
                xC = Double.parseDouble(builder.readLine());
                break;
            } catch (Exception e) {
                System.out.println("Введите нормально число");
            }
        }
        while (true) {
            try {
                System.out.print("Введите координату y для вершины C: ");
                yC = Double.parseDouble(builder.readLine());
                break;
            } catch (Exception e) {
                System.out.println("Введите нормально число");
            }
        }
        double first;
        if (xC != 0 && yC != 0) {
            first = (xA - xC) * (yB - yC) - (xB - xC) * (yA - yC);
            result = first * 0.5;
        } else {
            first = xA * yB - xB * yA;
            result = first * 0.5;
        }

        return Math.abs(result);
    }

    public double findByProgram() {
        double resultProgram;
        double xA = 2, yA = -4, xB = -5, yB = -6, xC = 1, yC = 3;
        System.out.print("Координаты точки А: " + xA + " " + yA);
        System.out.print("\nКоординаты точки B: " + xB + " " + yB);
        System.out.print("\nКоординаты точки C: " + xC + " " + yC + "\n");
        double first;
        first = (xA - xC) * (yB - yC) - (xB - xC) * (yA - yC);
        resultProgram = first * 0.5;

        return Math.abs(resultProgram);
    }

}

