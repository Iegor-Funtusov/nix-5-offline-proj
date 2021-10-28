package org.example;

import org.example.level1.ArrayUtil;
import org.example.level1.TriangleArea;
import org.example.level1.WrapChessBoard;
import org.example.level2.StringValidator;
import org.example.level3.GameOfLife;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        System.out.println("Welcome to module 1!");
        Scanner scanner;
        while (true) {
            scanner = new Scanner(System.in);
            System.out.println("Choose level 1-3 or 0 to exit:");
            switch (scanner.nextLine()) {
                case "1": {
                    level1UI(scanner);
                    break;
                }
                case "2": {
                    level2UI(scanner);
                    break;
                }
                case "3": {
                    level3GoL(scanner);
                    break;
                }
                case "0": {
                    return;
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
                    "4 to run the tasks above automatically \n" +
                    "0 to return");

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
                case "4": {
                    String input = "8 1 2 3 2 4 4 5 6";
                    System.out.println(">>>" + input);
                    ByteArrayInputStream emulatedIn = new ByteArrayInputStream(input.getBytes());
                    level1Uniques(new Scanner(emulatedIn));

                    input = "A1\nC2\nB8\nH7\n0";
                    System.out.println(">>>" + input);
                    emulatedIn = new ByteArrayInputStream(input.getBytes());
                    level1Chess(new Scanner(emulatedIn));

                    input = "0 0 0 4 7 0\n";
                    System.out.println(">>>" + input);
                    emulatedIn = new ByteArrayInputStream(input.getBytes());
                    level1TriangleArea(new Scanner(emulatedIn));
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

    private static void level2UI(Scanner scanner) {
        System.out.println("Level 2");

        while (true) {
            System.out.println("Choose task: \n" +
                    "1 -Validate brackets in a string \n" +
                    "3 to run the tasks above automatically" +
                    "0 to return");
            switch (scanner.nextLine()) {
                case "1": {
                    level2Validate(scanner);
                    break;
                }
                case "3": {
                    String input = "(This) i[s] th{e} {[{first}]} string, (should come back as valid)\n0";
                    System.out.println(">>>" + input);
                    ByteArrayInputStream emulatedIn = new ByteArrayInputStream(input.getBytes());
                    level2Validate(new Scanner(emulatedIn));
                    input = "(This) i[s] th{e} {[{second}]} string,}{ (should come back as invalid(\n0";
                    System.out.println(">>>" + input);
                    emulatedIn = new ByteArrayInputStream(input.getBytes());
                    level2Validate(new Scanner(emulatedIn));
                    break;
                }
                case "0":
                    return;
                default:
                    System.out.println("Incorrect input");
            }
        }
    }

    private static void level2Validate(Scanner scanner) {
        while (true) {
            System.out.println("Enter any string to validate brackets, or enter 0 to return:");
            String input = scanner.nextLine();
            if ("0".equals(input)) return;
            boolean isValid = StringValidator.validateBrackets(input);
            System.out.println("The brackets in this string are " + (isValid ? "valid" : "not valid"));
        }
    }

    private static void level3GoL(Scanner scanner) {
        System.out.println("Press enter to progress the game \n" +
                "type g to see glider demonstration \n" +
                "type r to generate new board \n" +
                "type a to automatically progress 100 generations \n" +
                "type 0 to return");

        GameOfLife game = GameOfLife.initRandom();
        while (true) {
            System.out.println(game);
            System.out.println("Waiting for input...");
            switch (scanner.nextLine().toLowerCase()) {
                case "g": {
                    game = GameOfLife.initGlider();
                    break;
                }
                case "r": {
                    game = GameOfLife.initRandom();
                    break;
                }
                case "a": {
                    for (int i = 0; i < 100; i++) {
                        game.progressToNextGen();
                        System.out.println(game);
                    }
                    break;
                }
                case "0": {
                    return;
                }
                default: {
                    game.progressToNextGen();
                }
            }
        }

    }
}
