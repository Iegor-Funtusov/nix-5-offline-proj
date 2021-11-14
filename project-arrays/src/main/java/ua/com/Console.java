package ua.com;

import lombok.SneakyThrows;
import ua.com.enums.Colors;
import ua.com.figures.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Console {
    private static final BufferedReader bufferedReader;
    public static Figure userFigure;

    static {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    @SneakyThrows
    public static void main(String[] args) {
        Console console = new Console();
        console.fullCycle();
    }

    private void lastMessage() {
        System.out.println("Please, choice what you want next:");
        System.out.println("1 - Move more");
        System.out.println("2 - Change figure");
        System.out.println("0 - Exit");
    }

    private void figureMessage() {
        System.out.println("Greetings, please write a number and select the figure");
        System.out.println("1 - King");
        System.out.println("2 - Queen");
        System.out.println("3 - Castle");
        System.out.println("4 - Knight");
        System.out.println("5 - Bishop");
        System.out.println("6 - Pawn");
        System.out.println("0 - Exit");
    }

    private void colorMessage() {
        System.out.println("Done, then write a number and select the color of figure");
        System.out.println("1 - White");
        System.out.println("2 - Black");
        System.out.println("0 - Exit");
    }

    @SneakyThrows
    private void whatDoTheProgram() {
        String inputUser;
        do {
            inputUser = bufferedReader.readLine();
        } while (isNotNumeric(inputUser) || inputUser.isEmpty());
        int x = Integer.parseInt(inputUser);
        switch (x) {
            case 0:
                System.exit(0);
            case 1:
                move();
                lastMessage();
                whatDoTheProgram();
                break;
            case 2:
                fullCycle();
                break;
            default:
                System.out.println("Invalid number, please try again");
                whatDoTheProgram();
                break;
        }
    }

    private void fullCycle() {
        figureMessage();
        inputFigureByUser();
        colorMessage();
        inputColorByUser();
        System.out.println("You figure is " + userFigure.getColor() + " " + userFigure.getFigure());
        System.out.println("Done, then choice where you put the figure first time (examples: e4, b8, c6)");
        firstMove();
        System.out.println("Done\n" + userFigure);
        move();
        lastMessage();
        whatDoTheProgram();
    }

    private void move() {
        System.out.println("Please, choice where you want to move next");
        String inputCoordinates = inputChessMove();
        if (userFigure.move(repayX(inputCoordinates), repayY(inputCoordinates))) {
            System.out.println("Done\n" + userFigure);
        } else {
            System.out.println("The figure can't go so");
            move();
        }
    }

    private void firstMove() {
        String inputCoordinates = inputChessMove();
        userFigure.firstMove(repayX(inputCoordinates), repayY(inputCoordinates));
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
    private void inputFigureByUser() {
        String userInput;
        do {
            do {
                userInput = bufferedReader.readLine();
            }
            while (isNotNumeric(userInput) || userInput.isEmpty());
            userFigure = choiceFigure(Integer.parseInt(userInput));
        }
        while (userFigure == null);
    }

    @SneakyThrows
    private void inputColorByUser() {
        String userInput;
        do {
            do {
                userInput = bufferedReader.readLine();
            }
            while (isNotNumeric(userInput) || userInput.isEmpty());
            choiceColor(Integer.parseInt(userInput));
        }
        while (userFigure.getColor() == null);
    }

    private void choiceColor(int x) {
        switch (x) {
            case 0:
                System.exit(0);
            case 1:
                userFigure.setColor(Colors.WHITE);
                break;
            case 2:
                userFigure.setColor(Colors.BLACK);
                break;
            default:
                System.out.println("Invalid number, please try again");
                break;
        }
    }


    private Figure choiceFigure(int x) {
        switch (x) {
            case 0:
                System.exit(0);
            case 1:
                userFigure = new King();
                break;
            case 2:
                userFigure = new Queen();
                break;
            case 3:
                userFigure = new Castle();
                break;
            case 4:
                userFigure = new Knight();
                break;
            case 5:
                userFigure = new Bishop();
                break;
            case 6:
                userFigure = new Pawn();
                break;
            default:
                System.out.println("Invalid number, please try again");
                break;
        }
        return userFigure;
    }


    public boolean isNotNumeric(String str) {
        if (!str.chars().allMatch(Character::isDigit)) {
            System.out.println("Invalid input, please write a number");
            return true;
        }
        return false;
    }
}
