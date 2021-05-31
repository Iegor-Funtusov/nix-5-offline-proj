package com.nix.hw.logs_and_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Utils {

    public static int correctIntInput(String message) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num;
        while (true) {
            try {
                System.out.print(message);
                num = Integer.parseInt(reader.readLine());
                break;
            } catch (IOException | NumberFormatException e) { }
        }
        return num;
    }

    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void pressEnter() {
        System.out.println("\nPress Enter to continue");
        try
        {
            System.in.read();
        }
        catch(Exception e)
        {}
    }

}
