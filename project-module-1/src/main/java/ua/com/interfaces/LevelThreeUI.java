package ua.com.interfaces;

import lombok.SneakyThrows;
import ua.com.levelthree.GameLife;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LevelThreeUI {
    private static final BufferedReader bufferedReader;
    private GameLife gameLife;
    private static final String REGEX_NUMBER = "^[0-9]$";
    private static final String REGEX_SIZE = "^[0-9]{1,2}$";
    private static final String REGEX_ONE = "^[1]$";

    static {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void cycle() {
        message();
        switch (number()) {
            case 1: {
                run();
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


    @SneakyThrows
    private void run() {
        String s;
        do {
            System.out.println("What do you want?\n" +
                    "1-create new game field\n" +
                    "2-see the current game field\n" +
                    "3-do the next step of the game");
            switch (number()) {
                case 1: {
                    createGameField();
                    break;
                }
                case 2: {
                    printGameField();
                    break;
                }
                case 3: {
                    nextStepOfGame();
                    break;
                }
                case 9: {
                    MainUI mainUI = new MainUI();
                    mainUI.cycle();
                    break;
                }
                case 0: {
                    System.exit(0);
                }
                default: {
                    System.out.println("Incorrect value");
                }
            }
            System.out.println("Do you want to continue at this level?\n" +
                    "1 - Yes\n" +
                    "Another - No");
            s = bufferedReader.readLine();
        } while (s.matches(REGEX_ONE));
    }

    @SneakyThrows
    private void createGameField() {
        String size;
        do {
            System.out.println("Write a size of the game field");
            size = bufferedReader.readLine();
        } while (!size.matches(REGEX_SIZE) || Integer.parseInt(size) < 0);

        if (userDecision()) {
            gameLife = new GameLife(scanElements(Integer.parseInt(size)), Integer.parseInt(size));
            printGameField();
        } else {
            gameLife = new GameLife(Integer.parseInt(size));
            printGameField();
        }
    }


    @SneakyThrows
    private boolean[][] scanElements(int size) {
        boolean[][] gameField = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.println("Write 1 if cell is live. Write 0 if cell is dead. Cell [" + (i + 1) + "]" + "[" + (j + 1) + "]");
                int cell = number();
                gameField[i][j] = cell == 1;
            }
        }
        return gameField;
    }

    private void printGameField() {
        if (gameLife == null) {
            System.out.println("First you should to create gameField");
            return;
        }
        boolean[][] gameField = gameLife.getFields();
        System.out.println("x - the cell is live, o - the cell is dead");
        for (int i = 0; i < gameLife.getColumns(); i++) {
            for (int j = 0; j < gameLife.getRows(); j++) {
                if (gameField[i][j])
                    System.out.print("x ");
                else
                    System.out.print("o ");
            }
            System.out.println();
        }
    }

    private void nextStepOfGame() {
        if (gameLife == null) {
            System.out.println("First you should to create gameField");
            return;
        }
        gameLife.nextStep();
        printGameField();
    }


    private void message() {
        System.out.println(
                "Choose the program:\n" +
                        "1 - Start a Life Game\n" +
                        "9 - Comeback to choose the level\n" +
                        "0 - Exit");
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
}
