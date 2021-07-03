package com.lapchenko.module.first.date;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInterface {

    public void start() {
        while (true) {
            printUserInterface();
            String input = readUserInput();
            if(input.equals("0")){
                break;
            }else {
                try {
                    System.out.println(DateParser.tryParseDate(input));
                }catch (IllegalArgumentException e) {
                    System.out.println("Try again!");
                    start();
                }
            }
        }
    }

    private void printUserInterface() {
        System.out.println("" +
                "Please enter date in any of presented formats:\n" +
                "YYYY/MM/DD\n" +
                "DD/MM/YYYY\n" +
                "MM-DD-YYYY\n" +
                "Or 0 to exit");
    }

    private String readUserInput() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException("Something wrong with console");
        }
    }
}
