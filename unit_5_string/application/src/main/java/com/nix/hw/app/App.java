package com.nix.hw.app;

import com.nix.hw.lib.StringReverser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {

    public static void run() {
        String message = "Enter the number: ";

        while (true) {

            System.out.print("\n\nChoose operation:\n\n" +
                    "1 - default reverse string\n" +
                    "2 - reverse substring\n" +
                    "3 - reverse substring by indices\n" +
                    "4 - exit\n\n");

            int choice = correctIntInput(message);

            switch (choice) {
                case 1:
                    defaultReverse();
                    break;
                case 2:
                    reverseSubstring();
                    break;
                case 3:
                    reverseByIndices();
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }

    private static void defaultReverse() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("\nEnter string: ");
            String string = reader.readLine();
            if(!string.isBlank()) {
                System.out.print("\nOutput: " + StringReverser.reverse(string));
            }
            else {
                System.out.print("\nEntered string is blank");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void reverseSubstring(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("\nEnter string: ");
            String string = reader.readLine();
            System.out.print("\nEnter substring: ");
            String subString = reader.readLine();
            if (string.contains(subString) && !string.isBlank() && !subString.isBlank()) {
                System.out.print("\nOutput: " + StringReverser.reverse(string, subString));
            } else {
                System.out.print("\nString is blank or " +
                        "string doesn't contain entered substring or entered substring is blank");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void reverseByIndices() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try{
            System.out.print("\nEnter string: ");
            String string = reader.readLine();
            if(!string.isBlank()) {
                System.out.println();
                int start = correctIntInput("Enter start index: ");
                int end   = correctIntInput("Enter end index: ");
                System.out.print("\nOutput: " + StringReverser.reverse(string, start, end));
            }
            else {
                System.out.print("\nEntered string is blank");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static int correctIntInput(String message) {
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
}
