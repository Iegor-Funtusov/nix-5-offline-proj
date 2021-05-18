package com.Lapchenko_Kirill.project.first_level.third_task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Triangle {
    double area;
    int x1,x2,x3;
    int y1,y2,y3;

    public void GenerateRandomCoordinates(){
        x1 = new Random().nextInt(10);
        x2 = new Random().nextInt(10);
        x3 = new Random().nextInt(10);
        y1 = new Random().nextInt(10);
        y2 = new Random().nextInt(10);
        y3 = new Random().nextInt(10);
        System.out.println("Random coordinates (" + x1 + " " + y1 + "), "
        + "(" + x2 + " " + y2 + "), " + "(" + x3 + " " + y3 + "), ");
        System.out.println("Area is: " + TriangleSquare.calculateSquare(x1,y1,x2,y2,x3,y3));
    }

    private int getUserInput() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String userInput = reader.readLine();
        String regex = "\\d+";
        if (userInput.matches(regex))
            return Integer.parseInt(userInput);
        System.out.println("Wrong input try again!");
        return getUserInput();
    }

    public void askUserForCoordinates() throws IOException {
        System.out.println("Enter x1 coordinate: ");
        x1 = getUserInput();
        System.out.println("Enter x2 coordinate: ");
        x2 = getUserInput();
        System.out.println("Enter x3 coordinate: ");
        x3 = getUserInput();
        System.out.println("Enter y1 coordinate: ");
        y1 = getUserInput();
        System.out.println("Enter y2 coordinate: ");
        y2 = getUserInput();
        System.out.println("Enter y3 coordinate: ");
        y3 = getUserInput();
        System.out.println("Area is: " + TriangleSquare.calculateSquare(x1,y1,x2,y2,x3,y3));
    }
}
