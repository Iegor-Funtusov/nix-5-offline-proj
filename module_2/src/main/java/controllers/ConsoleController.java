package controllers;

import java.util.Scanner;

public class ConsoleController {
    private final NameController nc = new NameController();
    private final CityController сс = new CityController();
    private final DateController dc = new DateController();

    public void printMenu() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Choose the action:\n" +
                    "1 -> Convert dates\n" +
                    "2 -> Find first unique name\n" +
                    "3 -> Find the most advantageous route between the two cities\n" +
                    "0 -> Exit");
            String input = sc.nextLine();
            switch (input) {
                case "1":
                    dc.printDates();
                    break;
                case "2":
                    nc.printName();
                    break;
                case "3":
                    сс.printCities();
                    break;
                case "0":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong input. Use numbers");
            }
        }
    }

}
