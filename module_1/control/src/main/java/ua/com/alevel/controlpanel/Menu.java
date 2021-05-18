package ua.com.alevel.controlpanel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {

    public static BufferedReader reader;

    public static void mainMenu() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        String input;

        try {
            System.out.println("Choose the level:\n" +
                    "1 -> First level\n" +
                    "2 -> Second level\n" +
                    "3 -> Third level\n" +
                    "0 -> Exit");
            while ((input = reader.readLine()) != null) {
                switch (input) {
                    case "1": {
                        FirstLevel.controlFirstLevel();
                    }
                    break;
                    case "2": {
                    }
                    break;
                    case "3": {
                    }
                    break;
                    case "0": {
                        System.exit(0);
                    }
                    break;
                    default: {
                        System.out.println("Wrong input. Use numbers 0-3");
                    }
                    break;
                }
                System.out.println("Choose the level:\n" +
                        "1 -> First level\n" +
                        "2 -> Second level\n" +
                        "3 -> Third level\n" +
                        "0 -> Exit");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}