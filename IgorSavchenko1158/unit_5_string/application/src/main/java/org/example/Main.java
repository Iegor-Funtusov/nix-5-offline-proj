package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner;
        String currentString;
        while (true) {
            scanner = new Scanner(System.in);
            System.out.println("Enter your string:");
            currentString = scanner.nextLine();

            System.out.println("Choose operation: \n" +
                    "1 -reverse \n" +
                    "2 -reverse substring \n" +
                    "3 -reverse bound by index \n" +
                    "4 -reverse bound by character");

            switch (scanner.nextLine()) {
                case "1": {
                    System.out.println(ReverseStringUtils.reverse(currentString));
                    break;
                }
                case "2": {
                    System.out.println("Enter substring:");
                    System.out.println(ReverseStringUtils.reverseSubstring(currentString, scanner.nextLine()));
                    break;
                }
                case "3": {
                    System.out.println("Enter indexes split by space:");
                    System.out.println(ReverseStringUtils.reverse(currentString, scanner.nextInt(), scanner.nextInt()));
                    break;
                }
                case "4": {
                    System.out.println("Enter start and end characters split by space:");
                    System.out.println(ReverseStringUtils.reverse(currentString, scanner.next().charAt(0), scanner.next().charAt(0)));
                }
            }
        }
    }
}
