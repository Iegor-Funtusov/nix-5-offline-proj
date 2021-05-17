package org.example;

import org.example.level1.ArrayUtil;
import org.example.level1.TriangleArea;
import org.example.level1.WrapChessBoard;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        System.out.println("Welcome to module 1!");
        Scanner scanner;
        while (true) {
            scanner = new Scanner(System.in);
            System.out.println("Choose level 1-3:");
            switch (scanner.nextLine()) {
                case "1": {
                    level1UI(scanner);
                    break;
                }

                default: {
                    System.out.println("Incorrect input");
                }
            }
        }
    }

    private static void level1UI(Scanner scanner) {
        System.out.println("Level 1");
        while (true) {
            System.out.println("Choose task: \n" +
                    "1 -Number of unique elements in an integer array \n" +
                    "2 -Knight moves on infinitely wrapping chessboard \n" +
                    "3 -Calculate area of triangle \n" +
                    "0 -return");

            switch (scanner.nextLine()) {
                case "1": {
                    level1Uniques(scanner);
                    break;
                }
                case "2": {
                    level1Chess(scanner);
                    break;
                }
                case "3": {
                    level1TriangleArea(scanner);
                    break;
                }
                case "0":
                    return;
                default:
                    System.out.println("Incorrect input");
            }
        }
    }

    private static void level1Uniques(Scanner scanner) {
        System.out.println("Enter size of array followed by elements, like this: 4 1 2 3 4");

        int[] array;
        while (true) {
            try {
                array = new int[scanner.nextInt()];
                for (int i = 0; i < array.length; i++) {
                    array[i] = scanner.nextInt();
                }
            } catch (InputMismatchException ex) {
                System.out.println("Incorrect input");
                continue;
            }
            break;
        }
        System.out.println("Array you entered has " + ArrayUtil.getNumberOfUniqueElements(array) + " unique elements");
    }

    private static void level1Chess(Scanner scanner) {
        WrapChessBoard chessBoard = new WrapChessBoard();
        boolean placed = false;
        while (!placed) {
            System.out.println("Enter where to place the knight in format: A1");
            char[] coords = scanner.nextLine().toCharArray();
            try {
                placed = chessBoard.placeFigure(coords[0] - 'A',
                        Integer.parseInt(String.valueOf(coords[1])) - 1);
            } catch (IndexOutOfBoundsException | NumberFormatException ex) {
                System.out.println("Incorrect input");
            }
        }
        System.out.println(chessBoard);

        while (true) {
            System.out.println("Enter where to move the knight in format: A1 \n" +
                    "0 to exit:");
            String input = scanner.nextLine();
            if ("0".equals(input)) {
                return;
            }
            char[] coords = input.toCharArray();
            boolean moved = false;
            try {
                moved = chessBoard.moveFigure(coords[0] - 'A',
                        Integer.parseInt(String.valueOf(coords[1])) - 1);
            } catch (IndexOutOfBoundsException | NumberFormatException ex) {
                System.out.println("Incorrect input");
                continue;
            }
            if (!moved) {
                System.out.println(Arrays.toString(coords) + " is illegal move");
            }
            System.out.println(chessBoard);
        }
    }

    private static void level1TriangleArea(Scanner scanner) {
        while (true) {
            System.out.println("Enter X Y coordinates of three points, separated by spaces");
            int[] A;
            int[] B;
            int[] C;
            try {
                A = new int[]{scanner.nextInt(), scanner.nextInt()};
                B = new int[]{scanner.nextInt(), scanner.nextInt()};
                C = new int[]{scanner.nextInt(), scanner.nextInt()};
                scanner.nextLine();
            } catch (InputMismatchException ex) {
                System.out.println("Incorrect input");
                scanner.nextLine();
                continue;
            }
            System.out.println("Area of the triangle equals " + TriangleArea.calculate(A, B, C));
            break;
        }


    }
}
