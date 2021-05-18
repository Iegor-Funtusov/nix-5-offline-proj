package control;

import level1.knight_turn.Field;
import level1.knight_turn.Knight;
import level1.knight_turn.Game;
import level1.triangle_area.TriangleArea;
import level1.unique_symbols.UniqueSymbols;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

import static level1.knight_turn.Field.*;
import static level1.knight_turn.Knight.*;
import static level1.knight_turn.Game.*;
import static level1.triangle_area.TriangleArea.*;
import static level1.unique_symbols.UniqueSymbols.*;
import static java.lang.Math.*;
import static java.lang.Math.round;


public class FirstLevel {
    private static BufferedReader reader;

    public static void controlFirstLevel() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        String input;


        try {
            System.out.println("Choose the level:\n" +
                    "1 -> Unique symbols in array\n" +
                    "2 -> Knight turn\n" +
                    "3 -> Triangle area\n" +
                    "0 -> Back to Menu");
            if ((input = reader.readLine()) != null) {
                do {
                    switch (input) {
                        case "1": {
                            uniqueSymbols();
                        }
                        break;
                        case "2": {
                            knightTurn();
                        }
                        break;
                        case "3": {
                            triangleArea();
                        }
                        break;
                        case "0": {
                            return;
                        }
                        default: {
                            System.out.println("Wrong input. Use numbers 0-3");
                        }
                        break;
                    }
                    System.out.println("\nChoose the level:\n" +
                            "1 -> Unique symbols in array\n" +
                            "2 -> Knight turn\n" +
                            "3 -> Triangle area\n" +
                            "0 -> Back to Menu");
                } while ((input = reader.readLine()) != null);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void uniqueSymbols() throws IOException {
        Scanner s = new Scanner(System.in);
        System.out.println("Choose generation:\n" +
                "1 -> User generation\n" +
                "2 -> Random generation");
        String input = reader.readLine();

        switch (input) {
            case "1": {
                System.out.print("Input size array: ");
                if (!s.hasNextInt()) {
                    System.out.println("That not a number!Input number");
                    s.next();
                }
                int size = s.nextInt();
                int[] array = new int[size];
                System.out.print("Input array elements: ");
                int i = 0;
                while (i < size) {
                    if (!s.hasNextInt()) {
                        System.out.println("That not a number!Input number");
                        s.next();
                    }
                    int element = s.nextInt();
                    array[i] = element;
                    i++;
                }
                System.out.println("\nQuantity unique symbols: " + UniqueSymbols.countUnique(array));
                break;
            }
            case "2": {
                System.out.print("Input size array: ");
                if (!s.hasNextInt()) {
                    System.out.println("That not a number!Input number");
                    s.next();
                }
                int size = s.nextInt();
                int[] array = new int[size];
                System.out.print("Random array elements: ");
                int i = 0;
                while (i < size) {
                    array[i] = (int) round((random() * 50) - 25);
                    System.out.print(array[i] + " ");
                    i++;
                }
                System.out.println("\nQuantity unique symbols: " + UniqueSymbols.countUnique(array));
                break;
            }
            default: {
                System.out.println("Wrong input. Use 1 or 2");
            }
            break;

        }
    }

    public static void knightTurn() throws IOException {
        Scanner s = new Scanner(System.in);
        String input;
        Knight[][] cells = Field.gameStart();
        Game game = new Game();
        System.out.println();
        Field.renderField(cells);
        System.out.println("Please input starting coordinates");
        System.out.println("Input x coordinate");
        if (!s.hasNextInt()) {
            System.out.println("That not a number!Input number");
            s.next();
        }
        int X = s.nextInt();
        System.out.println("Input y coordinate");
        if (!s.hasNextInt()) {
            System.out.println("That not a number!Input number");
            s.next();
        }
        int Y = s.nextInt();
        game.placeKnight(cells, X, Y);
        Field.renderField(cells);
        System.out.println("Please input next choise\n" +
                "1 - Move knight\n" +
                "0 - Back to Menu\n");
        input = reader.readLine();
        do {
            switch (input) {
                case "1": {
                    System.out.println("Input x coordinate");
                    if (!s.hasNextInt()) {
                        System.out.println("That not a number!Input number");
                        s.next();
                    }
                    int x = s.nextInt();
                    System.out.println("Input y coordinate");
                    if (!s.hasNextInt()) {
                        System.out.println("That not a number!Input number");
                        s.next();
                    }
                    int y = s.nextInt();
                    game.moveKnight(cells,x,y);
                    Field.renderField(cells);
                    System.out.println("Please input next choise\n" +
                            "1 - Move knight\n" +
                            "0 - Back to Menu\n");
                }
                break;
                case "0": {
                    return;
                }
                default: {
                    System.out.println("Bad input");
                }
            }
        }while ((input = reader.readLine()) != null);
    }

    public static void triangleArea() throws IOException {
        Scanner s = new Scanner(System.in);
        System.out.println("Choose generation:\n" +
                "1 -> User generation\n" +
                "2 -> Random Generation\n" +
                "0 -> Return to menu");
        String input = reader.readLine();

        switch (input) {
            case "1": {
                System.out.println("Enter A coords " +
                        "x: ");
                if (!s.hasNextInt()) {
                    System.out.println("That not a number!Input number");
                    s.next();
                }
                int ax = s.nextInt();
                System.out.println("y:");
                if (!s.hasNextInt()) {
                    System.out.println("That not a number!Input number");
                    s.next();
                }
                int ay = s.nextInt();
                System.out.println("Input B coords\n" +
                        "x: ");
                if (!s.hasNextInt()) {
                    System.out.println("That not a number!Input number");
                    s.next();
                }
                int bx = s.nextInt();
                System.out.println("y: ");
                if (!s.hasNextInt()) {
                    System.out.println("That not a number!Input number");
                    s.next();
                }
                int by = s.nextInt();
                System.out.println("Input C coords\n" +
                        "x: ");
                if (!s.hasNextInt()) {
                    System.out.println("That not a number!Input number");
                    s.next();
                }
                int cx = s.nextInt();
                System.out.println("y: ");
                if (!s.hasNextInt()) {
                    System.out.println("That not a number!Input number");
                    s.next();
                }
                int cy = s.nextInt();
                Point a = new Point(ax, ay);
                Point b = new Point(bx, by);
                Point c = new Point(cx, cy);
                System.out.println("Triangle area : " + TriangleArea.calculate(a, b, c));
                break;
            }
            case "2": {
                Point a = new Point((int) round((random() * 50) - 25), (int) round((random() * 50) - 25));
                Point b = new Point((int) round((random() * 50) - 25), (int) round((random() * 50) - 50));
                Point c = new Point((int) round((random() * 50) - 25), (int) round((random() * 50) - 25));
                System.out.println("Point A: " + a.x + ", " + a.y);
                System.out.println("Point B: " + b.x + ", " + b.y);
                System.out.println("Point C: " + c.x + ", " + c.y);
                System.out.println("Area of a triangle: " + TriangleArea.calculate(a, b, c));
                break;
            }
            case "0": {
                return;
            }
            default: {
                System.out.println("Wrong input. Use numbers 0-2");
            }
            break;
        }
    }
}