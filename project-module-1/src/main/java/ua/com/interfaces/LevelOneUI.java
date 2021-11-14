package ua.com.interfaces;

import lombok.SneakyThrows;
import ua.com.levelone.KnightMove;
import ua.com.levelone.TriangleSquare;
import ua.com.levelone.UniqueArray;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LevelOneUI {

    private static final BufferedReader bufferedReader;
    private static final String REGEX_INDEX = "^[0-9]{1,2}$";
    private static final String REGEX_NUMBER = "^[0-9]$";
    private static final String REGEX_ONLY_NUMBERS = "[0-9]+";

    static {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void cycle() {
        message();
        switch (number()) {
            case 1: {
                System.out.println(uniqueElements(inputArray()));
                break;
            }
            case 2: {
                move();
                break;
            }
            case 3: {
                triangleSquare();
                break;
            }
            case 9: {
                MainUI mainUI = new MainUI();
                mainUI.cycle();
            }
            case 0: {
                System.exit(0);
            }
        }
        cycle();
    }

    private int uniqueElements(int[] array) {
        StringBuilder stringBuilder = new StringBuilder("Array: ");
        for (int s : array) {
            stringBuilder.append(s).append(" ");
        }
        System.out.println(stringBuilder.substring(0, stringBuilder.length() - 1));
        System.out.print("Output: ");
        return UniqueArray.uniqueCount(array);
    }

    private void message() {
        System.out.println(
                "Choose the program:\n" +
                        "1 - Quantity unique elements of array\n" +
                        "2 - Knight move\n" +
                        "3 - Square of triangle\n" +
                        "9 - Comeback to choose the level\n" +
                        "0 - Exit");
    }

    @SneakyThrows
    private int[] inputArray() {
        String n;
        int[] elements;
        int count = 0;
        if (userDecision()) {
            do {
                System.out.print("Write a quantity of elements in array: ");
                n = bufferedReader.readLine();
            } while (!n.matches(REGEX_INDEX));
            elements = new int[Integer.parseInt(n)];
            String input;
            do {
                System.out.print("Write a numbers for array: ");
                input = bufferedReader.readLine();
            } while (input.isBlank());
            Pattern p = Pattern.compile(REGEX_ONLY_NUMBERS);
            Matcher m = p.matcher(input);
            while (m.find()) {
                if (count < elements.length) {
                    elements[count++] = Integer.parseInt(m.group());
                } else {
                    break;
                }
            }
        } else {
            UniqueArray uniqueArray = new UniqueArray();
            elements = uniqueArray.getArray();
        }
        return elements;
    }

    @SneakyThrows
    private int number() {
        String number;
        do {
        System.out.print("Number: ");
            number = bufferedReader.readLine();
        } while (!number.matches(REGEX_NUMBER));
        return Integer.parseInt(number);
    }

    private boolean userDecision() {
        boolean flag = false;
        System.out.println("Choose method of input:\n" +
                "1 - from the keyboard\n" +
                "2 - automatically\n" +
                "0 - exit");
        switch (number()) {
            case 1:
                flag = true;
                break;
            case 2:
                break;
            default:
                System.out.println("Invalid number");
                userDecision();
                break;
        }
        return flag;
    }

    private int repayX(String string) {
        String value = string.substring(0, 1);
        return Integer.parseInt(value);
    }

    private int repayY(String string) {
        String value = string.substring(1);
        return Integer.parseInt(value);
    }

    @SneakyThrows
    private String convertInputInCoordinates(String string) {
        StringBuilder sb = new StringBuilder();
        int x = 0;
        String y = string.substring(1);
        switch (string.charAt(0)) {
            case 'a':
                x = 1;
                break;
            case 'b':
                x = 2;
                break;
            case 'c':
                x = 3;
                break;
            case 'd':
                x = 4;
                break;
            case 'e':
                x = 5;
                break;
            case 'f':
                x = 6;
                break;
            case 'g':
                x = 7;
                break;
            case 'h':
                x = 8;
                break;
        }
        return String.valueOf(sb.append(x).append(y));
    }

    @SneakyThrows
    private String inputChessMove() {
        String userInput = "";
        do {
            if (!userInput.isEmpty()) {
                System.out.println("Invalid input, please try again");
            }
            userInput = bufferedReader.readLine();
        } while (!userInput.matches("^[a-h][1-8]$"));
        userInput = convertInputInCoordinates(userInput);
        return userInput;

    }

    private void move() {
        if (userDecision()) {
            KnightMove knightMove = new KnightMove();
            System.out.println("Please, write where you want to place knight (example: e4, b2, h1)");
            String inputCoordinates = inputChessMove();
            knightMove.firstMove(repayX(inputCoordinates), repayY(inputCoordinates));
            System.out.println("Please, choice where you want to move (example: e4, b2, h1)");
            inputCoordinates = inputChessMove();
            if (knightMove.move(repayX(inputCoordinates), repayY(inputCoordinates))) {
                System.out.println("Done\n" + knightMove);
                System.out.println("Successfully moved");
            } else {
                System.out.println("The figure can't go so");
            }
        } else {
            KnightMove knightMove = new KnightMove();
            if (knightMove.move(repayX("22"), repayY("22"))) {
                System.out.println("Done\n" + knightMove);
                System.out.println("Successfully moved");
            } else {
                System.out.println("The figure can't go so");
            }

        }
    }

    private void triangleSquare() {
        String output;
        if (userDecision()) {
            TriangleSquare triangleSquare = new TriangleSquare(
                    inputXCoordinate("A"),
                    inputYCoordinate("A"),
                    inputXCoordinate("B"),
                    inputYCoordinate("B"),
                    inputXCoordinate("C"),
                    inputYCoordinate("C"));
            System.out.println("Coordinates: " + triangleSquare);
            output = new DecimalFormat("#0.00").format(triangleSquare.square());
            System.out.println("S = " + output);
        } else {
            TriangleSquare triangleSquare = new TriangleSquare();
            System.out.println("Coordinates: " + triangleSquare);
            output = new DecimalFormat("#0.00").format(triangleSquare.square());
            System.out.println("S = " + output);
        }
    }

    @SneakyThrows
    private int inputXCoordinate(String s) {
        String input;
        do {
            System.out.println("Write X coordinate for a point " + s);
            input = bufferedReader.readLine();
        } while (!input.matches(REGEX_ONLY_NUMBERS));
        return Integer.parseInt(input);
    }

    @SneakyThrows
    private int inputYCoordinate(String s) {
        String input;
        do {
            System.out.println("Write Y coordinate for a point " + s);
            input = bufferedReader.readLine();
        } while (!input.matches(REGEX_ONLY_NUMBERS));
        return Integer.parseInt(input);
    }


}
