package controller;

import java.util.Scanner;

public class ConsoleController extends BookController {
    public void printMenu() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("What you need:\n" +
                    "1 -> Books\n" +
                    "2 -> Authors\n" +
                    "3 -> Exit");
            String input = sc.next();
            switch (input) {
                case "1": {
                    bookController();
                }
                break;
                case "2": {
                    authorsController();
                }
                break;
                case "3": {
                    System.exit(0);
                }
                default:
                    System.out.println("Wrong input. Use numbers");
            }
        }
    }
}
