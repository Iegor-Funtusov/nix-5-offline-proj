package ua.com.alevel.controlpanel;

import ua.com.alevel.TriangleArea;
import ua.com.alevel.UniqueSymbols;
import ua.com.alevel.TurnKnight;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

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
                int size = s.nextInt();
                int[] array = new int[size];
                System.out.print("Input array elements: ");
                int i = 0;
                while (i < size) {
                    int element = s.nextInt();
                    array[i] = element;
                    i++;
                }
                System.out.println("\nQuantity unique symbols: " + UniqueSymbols.countUnique(array));
                break;
            }
            case "2": {
                System.out.print("Input size array: ");
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
        TurnKnight board = new TurnKnight();
        boolean isPlaced = false;
        do {
            System.out.println("Place knight (format A1, H8)");
            char[] coords = reader.readLine().toCharArray();
            try {
                isPlaced = board.place(coords[0] - 'A', Integer.parseInt(String.valueOf(coords[1])) - 1);
            } catch (IndexOutOfBoundsException | NumberFormatException ex) {
                System.out.println("Wrong input");
            }
        } while (!isPlaced);
        System.out.println(board);

        while (true) {
            System.out.println("Move knight (format A1, H8)\n" +
                    "0 -> Exit to menu");
            String input = reader.readLine();
            if ("0".equals(input)) {
                return;
            }
            char[] coords = input.toCharArray();
            boolean isMoved;
            try {
                isMoved = board.move(coords[0] - 'A', Integer.parseInt(String.valueOf(coords[1])) - 1);
            } catch (IndexOutOfBoundsException | NumberFormatException ex) {
                System.out.println("Wrong input");
                continue;
            }
            if (!isMoved) {
                System.out.println(Arrays.toString(coords) + " wrong move");
            }
            System.out.println(board);
        }
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
                int ax = s.nextInt();
                System.out.println("y:");
                int ay = s.nextInt();
                System.out.println("Input B coords\n" +
                        "x: ");
                int bx = s.nextInt();
                System.out.println("y: ");
                int by = s.nextInt();
                System.out.println("Input C coords\n" +
                        "x: ");
                int cx = s.nextInt();
                System.out.println("y: ");
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