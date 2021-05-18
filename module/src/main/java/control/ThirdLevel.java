package control;

import level3.GameOfLife;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ThirdLevel {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void runer() throws IOException {
        String input;
        System.out.println("\nChoose the variation:\n" +
                "1 -> Start GoL with your options\n" +
                "2 -> Start GoL with glaider setup\n" +
                "3 -> Start GoL with PentaDecathlon setup\n" +
                "0 -> Back to Menu");
        if ((input = reader.readLine()) != null) {
            do {
                switch (input) {
                    case "1": {
                        run();
                    }
                    break;
                    case "2": {
                        runGlaider();
                    }
                    break;
                    case "3": {
                        runPentaDecathlon();
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
                System.out.println("\nChoose the variation:\n" +
                        "1 -> Start GoL with your options\n" +
                        "2 -> Start GoL with glaider setup\n" +
                        "3 -> Start GoL with PentaDecathlon setup\n" +
                        "0 -> Back to Menu");
            } while ((input = reader.readLine()) != null);
        }
    }

    public static void run() {
        Scanner s = new Scanner(System.in);
            System.out.println("Game of life started\n" +
                    "Input cord of board");
            System.out.println("Input field size:");
            if (!s.hasNextInt()) {
                System.out.println("That not a number!Input number");
                s.next();
            }
            int fieldSize = s.nextInt();
            System.out.println("Input count elements:");
        if (!s.hasNextInt()) {
            System.out.println("That not a number!Input number");
            s.next();
        }
            int countElements = s.nextInt();
            System.out.println("Input count steps");
        if (!s.hasNextInt()) {
            System.out.println("That not a number!Input number");
            s.next();
        }
            int steps = s.nextInt();
            GameOfLife game = new GameOfLife(fieldSize);
            game.populateRandom(countElements);
            game.show();
            for (int i = 0; i < steps - 1; i++) {
                game.execCycle();
                game.show();
            }
    }

    public static void runGlaider() {
        GameOfLife game = new GameOfLife(25);
        game.placeGlider();
        game.show();
        for (int i = 0; i < 10; i++) {
            game.execCycle();
            game.show();
        }
    }


    public static void runPentaDecathlon() {
        GameOfLife game = new GameOfLife(25);
        game.placePentaDecathlon();
        game.show();
        for (int i = 0; i < 10; i++) {
            game.execCycle();
            game.show();
        }
    }

}
