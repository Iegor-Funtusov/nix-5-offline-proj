package org.example;

import java.util.InputMismatchException;
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
                    "0 -exit \n" +
                    "1 -reverse \n" +
                    "2 -reverse bound by index \n" +
                    "3 -reverse bound by alphanumeric characters, inclusive \n" +
                    "4 -reverse bound by substrings, inclusive \n" +
                    "5 -reverse substring \n" +
                    "6 -reverse substring bound by index \n" +
                    "7 -reverse substring bound by alphanumeric characters, inclusive \n" +
                    "8 -reverse substring bound by substrings, inclusive");

            try {
                switcher(scanner, currentString);
            } catch (IllegalArgumentException | InputMismatchException ex) {
                System.out.println("Wrong input");
            }
        }
    }

    private static void switcher(Scanner scanner, String currentString) {
        switch (scanner.nextLine()) {
            case "1": {
                System.out.println(ReverseStringUtils.reverse(currentString));
                break;
            }
            case "2": {
                System.out.println("Enter indexes split by space:");
                System.out.println(ReverseStringUtils.reverse(currentString, scanner.nextInt(), scanner.nextInt()));
                break;
            }
            case "3": {
                System.out.println("Enter start and end characters split by space:");
                System.out.println(ReverseStringUtils.reverse(currentString, scanner.next().charAt(0), scanner.next().charAt(0)));
                break;
            }
            case "4": {
                System.out.println("Enter start and end substring split by linebreak:");
                System.out.println(ReverseStringUtils.reverse(currentString, scanner.nextLine(), scanner.nextLine()));
            }
            case "5": {
                System.out.println("Enter substring:");
                System.out.println(ReverseStringUtils.reverseSubstring(currentString, scanner.nextLine()));
                break;
            }
            case "6": {
                System.out.println("Enter substring:");
                String substring = scanner.nextLine();
                System.out.println("Enter indexes split by space:");
                System.out.println(ReverseStringUtils.reverseSubstring(currentString, substring, scanner.nextInt(), scanner.nextInt()));
                break;
            }
            case "7": {
                System.out.println("Enter substring:");
                String substring = scanner.nextLine();
                System.out.println("Enter start and end characters split by space:");
                System.out.println(ReverseStringUtils.reverseSubstring(currentString, substring, scanner.next().charAt(0), scanner.next().charAt(0)));
                break;
            }
            case "8": {
                System.out.println("Enter substring:");
                String substring = scanner.nextLine();
                System.out.println("Enter start and end substring split by linebreak:");
                System.out.println(ReverseStringUtils.reverseSubstring(currentString, substring, scanner.nextLine(), scanner.nextLine()));
                break;
            }
            case "0": {
                System.exit(0);
            }
            default:
                break;
        }
    }
}
