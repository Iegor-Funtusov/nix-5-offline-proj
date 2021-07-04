package com.nix.module_2;

import com.nix.module_2.cities.CitiesApplication;
import com.nix.module_2.dates.DatesApplication;
import com.nix.module_2.names.NamesApplication;

public class Main {
    public static void main(String[] args) {
        do {
            Utils.clearConsole();
            System.out.println("\n1 - Dates" +
                    "\n2 - Names" +
                    "\n3 - Cities" +
                    "\n4 - Exit\n");
            int choice = Utils.correctIntInput("Enter the number: ");
            Utils.clearConsole();
            switch (choice) {
                case 1:
                    DatesApplication.run();
                    Utils.pressEnter();
                    break;
                case 2:
                    NamesApplication.run();
                    Utils.pressEnter();
                    break;
                case 3:
                    CitiesApplication.run();
                    Utils.pressEnter();
                    break;
                case 4:
                    System.exit(0);
            }
        } while (true);
    }
}
