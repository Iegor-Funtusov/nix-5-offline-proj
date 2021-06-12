package ua.practice.module1.application;

import ua.practice.module1.level1.Level1;
import ua.practice.module1.level2.Level2;
import ua.practice.module1.level3.Level3;
import ua.practice.unit3.Demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input;
        printOptionsForLevel();
        while ((input = bufferedReader.readLine()) != null) {
            switch (input) {
                case "1":
                    Level1.level1Options(bufferedReader);
                    break;
                case "2":
                    Level2.checkIsStringValid(bufferedReader);
                    break;
                case "3":
                    Level3.gameOfLife(bufferedReader);
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Wrong input. Try again.");
            }
            printOptionsForLevel();
        }
    }

    private static void printOptionsForLevel() {
        System.out.println("Choose level: ");
        System.out.println("1 | 2 | 3");
        System.out.println("4 - stop");
    }
}
