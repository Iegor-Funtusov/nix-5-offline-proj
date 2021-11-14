package ua.com.interfaces;

import lombok.SneakyThrows;
import ua.com.leveltwo.Brackets;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LevelTwoUI {
    private static final BufferedReader bufferedReader;
    private static final String REGEX_NUMBER = "^[0-9]$";

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
        Brackets brackets;
        String input;
        if (userDecision()) {
            System.out.print("Input which you want to check:");
            input = bufferedReader.readLine();
            if (input != null) {
                brackets = new Brackets(input);
                if (brackets.check()) {
                    System.out.println("True");
                } else {
                    System.out.println("False");
                }
            }
        } else {
            brackets = new Brackets();
            System.out.println("Automatically input:" + brackets.getString());
            if (brackets.check()) {
                System.out.println("True");
            } else {
                System.out.println("False");
            }
        }
    }

    private void message() {
        System.out.println(
                "Choose the program:\n" +
                        "1 - Is correctly string with brackets\n" +
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