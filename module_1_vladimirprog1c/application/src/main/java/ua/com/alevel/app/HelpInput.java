package ua.com.alevel.app;


import ua.com.alevel.lib.*;
import ua.com.alevel.lib.ches.KnightMove;
import ua.com.alevel.lib.life.GameLife;
import ua.com.alevel.lib.triangle.TriangleMain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HelpInput {

    public void start() {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true){

            System.out.println("Input level (1,2,3) or exit (5)");
            try {
                String currentChoice = reader.readLine();
                boolean result = currentChoice.matches("[1235]");
                if (!result) {
                    continue;
                }
                levelChoice(currentChoice, reader);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void levelChoice(String strChoice, BufferedReader reader) throws IOException {

        while (true) {
            switch (strChoice) {
                case ("1"): {
                    first:
                    while (true) {
                        System.out.println("Input number tusk(1,2,3)  or go to a higher level (4) or exit (5)");
                        String currentChoice = reader.readLine();
                        boolean result = currentChoice.matches("[12345]");
                        if (!result) {
                            continue;
                        }
                        switch (currentChoice) {
                            case ("1"): {
                                new UniqueArray().start(reader);
                                break;
                            }
                            case ("2"): {
                                new KnightMove().start(reader);
                                break;
                            }
                            case ("3"): {
                                new TriangleMain().start(reader);
                                break;
                            }
                            case ("4"): {
                                break first;
                            }
                            case ("5"): {
                                System.exit(0);
                            }
                        }
                    }
                    break;
                }
                case ("2"): {
                    second:
                    while (true) {
                        System.out.println("Input number tusk(1,2)  or go to a higher level (4) or exit (5)");
                        String currentChoice = reader.readLine();
                        boolean result = currentChoice.matches("[1245]");
                        if (!result) {
                            continue;
                        }
                        switch (currentChoice) {
                            case ("1"): {
                                new Parentheses().start(reader);
                                break;
                            }
                            case ("2"): {
                                new BinaryTree().start(reader);
                                break;
                            }
                            case ("4"): {
                                break second;
                            }
                            case ("5"): {
                                System.exit(0);
                            }
                        }
                    }
                    break;
                }
                case ("3"): {
                    System.out.println("Input number tusk(1)  or go to a higher level (4) or exit (5)");
                    String currentChoice = reader.readLine();
                    boolean result = currentChoice.matches("[145]");
                    if (!result) {
                        continue;
                    }
                    switch (currentChoice){
                        case ("1"):{
                            new GameLife().start(reader);
                            break;
                        }
                        case ("4"):{
                            return;
                        }
                        case ("5"):{
                            System.exit(0);
                        }
                    }

                    break;
                }
                case ("5"): {
                    System.exit(0);
                }
            }
            return;
        }
    }
}
