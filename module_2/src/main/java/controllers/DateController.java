package controllers;

import constants.FileConstants;
import services.DateConverter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DateController {
    public void printDates() {
        Scanner scanner = new Scanner(System.in);
        List<String> dates = new ArrayList<>();
        DateConverter converter = new DateConverter();
        System.out.println("How do you want to enter?\n" +
                "1 -> Enter by yourself\n" +
                "2 -> Enter through a file");
        String input = scanner.nextLine();
        boolean check = true;
        while (check) {
            switch (input) {
                case "1":
                    String temp = "";
                    while (!temp.equals("0")) {
                        System.out.println("Input date (input \"0\" for end input):");
                        temp = scanner.nextLine();
                        dates.add(temp);
                    }
                    dates = converter.converter(dates);
                    System.out.println("Correct dates in the new format:");
                    for (String date : dates) {
                        System.out.println(date);
                    }
                    if (dates.size() == 0) {
                        System.out.println("Wrong input");
                    }
                    check = false;
                    break;
                case "2":
                    dates();
                    check = false;
                    break;
                default:
                    System.out.println("Wrong input. Use numbers");
            }
        }
    }

    private void dates() {
        Path path = Paths.get(FileConstants.DATES.getPath());
        DateConverter converter = new DateConverter();
        try {
            List<String> dates = Files.readAllLines(path);
            System.out.println("All dates:");
            for (String date : dates) {
                System.out.println(date);
            }
            System.out.println("\nConverted correct dates:");
            dates = converter.converter(dates);
            for (String date : dates) {
                System.out.println(date);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
