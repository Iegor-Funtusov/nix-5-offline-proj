package ua.practice.module1.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Level3 {
    public static void gameOfLife(BufferedReader bufferedReader) throws IOException {
        GameOfLife game;
        String input;
        printOptions();
        while ((input = bufferedReader.readLine()) != null) {
            switch (input) {
                case "1":
                    game = initializeGame(bufferedReader);
                    if (game == null) break;
                    game.printTheBoard();
                    System.out.println("-".repeat(40));
                    if (!inputCountOfAlivePoints(bufferedReader, game)) {
                        System.out.println("Wrong input. try again");
                        break;
                    }
                    printInfoOfGenerations(game, bufferedReader);
                    break;
                case "2":
                    initializeDefault(bufferedReader);
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Wrong input! Try again");
            }
            printOptions();
        }
    }

    private static void printOptions() {
        System.out.println("Choose an option:");
        System.out.println("1 - Your parameters");
        System.out.println("2 - Default parameters");
        System.out.println("3 - Stop");
    }

    private static GameOfLife initializeGame(BufferedReader bufferedReader) throws IOException {
        int boardLength;
        int boardHeight;
        System.out.println("Input board length");
        String string = bufferedReader.readLine();
        if (isNumber(string))
            boardLength = Integer.parseInt(string);
        else return null;
        System.out.println("Input board height");
        string = bufferedReader.readLine();
        if (isNumber(string))
            boardHeight = Integer.parseInt(string);
        else return null;
        return new GameOfLife(boardLength, boardHeight);
    }

    private static boolean inputCountOfAlivePoints(BufferedReader bufferedReader, GameOfLife game) throws IOException {
        System.out.println("Input number of wanted ALIVE points");
        String string = bufferedReader.readLine();
        int alivePoints;
        if (isNumber(string)) {
            alivePoints = Integer.parseInt(string);
        } else
            return false;
        for (int i = 0; i < alivePoints; i++) {
            System.out.println("Input X");
            string = bufferedReader.readLine();
            if (!isNumber(string))
                return false;
            int x = Integer.parseInt(string);
            System.out.println("Input Y");
            string = bufferedReader.readLine();
            if (!isNumber(string))
                return false;
            int y = Integer.parseInt(string);
            if (!game.setAlive(x, y))
                return false;
            System.out.println("Your starting board");
            game.printTheBoard();
            System.out.println("-".repeat(40));
        }
        return true;
    }

    public static boolean isNumber(String string) {
        try {
            int number = Integer.parseInt(string);
            if (number < 0) return false;
        } catch (NumberFormatException ex) {
            return false;
        }
        return true;
    }

    private static void printInfoOfGenerations(GameOfLife game, BufferedReader bufferedReader) throws IOException {
        int generationCounter = 1;
        while (game.nextGeneration()) {
            if (generationCounter % 5 == 0) {
                System.out.println("Continue?");
                System.out.println("Yes / No");
                if (bufferedReader.readLine().equalsIgnoreCase("no"))
                    return;
            }
            System.out.println("Generation number: " + generationCounter);
            game.printTheBoard();
            System.out.println("-".repeat(40));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            generationCounter++;
        }
    }

    private static void initializeDefault(BufferedReader bufferedReader) throws IOException {
        int boardLength = 5;
        int boardHeight = 3;
        GameOfLife game = new GameOfLife(boardLength, boardHeight);
        game.printTheBoard();

        System.out.println("-".repeat(40));

        setAliveForDefault(game);
        printInfoOfGenerations(game, bufferedReader);
    }

    private static void setAliveForDefault(GameOfLife game) {

        game.setAlive(1, 2);
        game.setAlive(2, 1);
        game.setAlive(1, 1);
        game.setAlive(3, 2);
        game.setAlive(0, 1);
        game.setAlive(3, 1);
        game.printTheBoard();

    }
}
