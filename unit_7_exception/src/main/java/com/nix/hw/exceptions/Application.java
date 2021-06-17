package com.nix.hw.exceptions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Application {

    private static String currentYear = "2021";

    private static List<Date> dateList = new ArrayList<>();

    private static String dateFormat1 = "dd/mm/yyyy hh:mm:ss";
    private static String dateFormat2 = "mm/dd/yyyy hh:mm:ss";
    private static String dateFormat3 = "dd-mm-yyyy hh:mm:ss";
    private static String dateFormat4 = "mm-dd-yyyy hh:mm:ss";

    public static void launch() {
        while (true) {
            printMainMenu();
            int choice = correctIntInput("\nEnter the number: ");

            switch (choice) {
                case 1:
                    create();
                    break;
                case 2:
//                    findDiff();
                    break;
                case 3:
//                    addTime();
                    break;
                case 4:
//                    subtractTime();
                    break;
                case 5:
                    System.exit(0);
            }
        }
    }

    private static void create() {
        String dateCreationMenu = "\n1) " + dateFormat1 + "\n" +
                                  "2) " + dateFormat2 + "\n" +
                                  "3) " + dateFormat3 + "\n" +
                                  "4) " + dateFormat4 + "\n" +
                                  "5) Back to main menu";
        boolean flag = true;
        do {

            System.out.println(dateCreationMenu);
            int choice = correctIntInput("\nEnter the number: ");

            switch (choice) {
                case 1:
                    try {
                        addDateFormat1();
                    } catch (RuntimeException ignored) {
                        System.out.println("\nSomething gone wrong, try again");
                    }
                    break;
                case 2:
                    addDateFormat2();
                    break;
                case 3:
                    addDateFormat3();
                    break;
                case 4:
                    addDateFormat4();
                    break;
                case 5:
                    flag = false;
                    break;
            }
        } while (flag);
    }

    private static void addDateFormat1() {
        System.out.println("\n" + dateFormat1);
        String strDate = input("Enter the date: ");
        int[] intDateParameters = parseDateFormat1(strDate);
        Date date = new Date(intDateParameters[2],
                             intDateParameters[1],
                             intDateParameters[0],
                             intDateParameters[3],
                             intDateParameters[4],
                             intDateParameters[5]);
        System.out.println("created date: " + date);
        dateList.add(date);
        dateList.sort(Date::compareTo);
    }

    private static void addDateFormat2() {

    }

    private static void addDateFormat3() {

    }

    private static void addDateFormat4() {

    }

    private static int[] parseDateFormat1(String input) {
        List<String> dmy;
        List<String> hms;

        int[] date = new int[6];

        input = input.trim();

        dmy = Arrays.asList(input.split(" ")[0].split("/"));

        if (dmy.size() > 1) {
            List<String> finalDmy = dmy;
            dmy.stream()
                    .limit(2)
                    .forEach(i -> {
                        if (i.equals("")) finalDmy.set(finalDmy.indexOf(i), "1");
                    });
            dmy = finalDmy;
            if (dmy.size() == 2) date[2] = Integer.parseInt(currentYear);
        }
        else if (dmy.size() == 1) {
            dmy = Arrays.asList("1", "1", dmy.get(0));
        } else {
            dmy = Arrays.asList("1", "1", currentYear);
        }


        List<String> finalDmy1 = dmy;
        if (finalDmy1.get(2).length()==2) {
            finalDmy1.set(2, "20" + finalDmy1.get(2));
        }
        IntStream
                .range(0, dmy.size())
                .forEach(i -> date[i] = Integer.parseInt(finalDmy1.get(i)));


        if (input.contains(":")) {
            hms = Arrays.asList(input.split(" ")[1].split(":"));
            hms.forEach(i -> {
                if (i.equals("")) hms.set(hms.indexOf(i), "0");
            });
            hms.forEach(i -> date[hms.indexOf(i) + 3] = Integer.parseInt(i));
        }

        return date;
    }

    private static void printMainMenu() {
        String choiceList = "\n1) create new date" +
                      "\n2) find difference" +
                      "\n3) add time" +
                      "\n4) subtract time" +
                      "\n5) exit\n";

        System.out.println(choiceList + "\nSorted dates:");
        dateList.forEach(System.out::println);
    }

    private static int correctIntInput(String message) {
        int num;
        while (true) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                System.out.print(message);
                num = Integer.parseInt(reader.readLine());
                break;
            } catch (IOException | NumberFormatException ignored) {
            }
        }
        return num;
    }

    private static String input(String message) {
        String output;
        while (true) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                System.out.print(message);
                output = reader.readLine();
                break;
            } catch (IOException | NumberFormatException ignored) {
            }
        }
        return output;
    }


}
