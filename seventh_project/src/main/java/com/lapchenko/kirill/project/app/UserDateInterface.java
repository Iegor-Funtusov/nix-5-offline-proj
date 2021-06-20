package com.lapchenko.kirill.project.app;

import com.lapchenko.kirill.project.lib.Date;
import com.lapchenko.kirill.project.lib.DateParser;
import com.lapchenko.kirill.project.lib.DateRegex;
import com.lapchenko.kirill.project.lib.MonthInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.SortedSet;
import java.util.TreeSet;

public class UserDateInterface {
    private Date date = new Date(1,1,1,1,1,1);
    private DateParser parser = new DateParser();
    private int dateFormat = 2;


    private void printMenu() {
        System.out.println("1 - Enter date\n" +
                "2 - Difference with date\n" +
                "3 - Subtract\n" +
                "4 - Add\n" +
                "5 - Enter some dates to compare\n" +
                "6 - Pick date format\n" +
                "7 - Print date\n" +
                "8 - exit");
    }

    private void printSubtractMenu() {
        System.out.println("Subtract:\n" +
                "1 - years\n" +
                "2 - months\n" +
                "3 - days\n" +
                "4 - hours\n" +
                "5 - minutes\n" +
                "6 - seconds");
    }

    private void printAddMenu() {
        System.out.println("Add:\n" +
                "1 - years\n" +
                "2 - months\n" +
                "3 - days\n" +
                "4 - hours\n" +
                "5 - minutes\n" +
                "6 - seconds");
    }

    private void printDiffMenu() {
        System.out.println("Print difference in:\n" +
                "1 - years\n" +
                "2 - months\n" +
                "3 - days\n" +
                "4 - hours\n" +
                "5 - minutes\n" +
                "6 - seconds");
    }

    private void printOutputFormatMenu() {
        System.out.println("1 - dd/mm/yy\n" +
                "2 - d/m/yyyy\n" +
                "3 - mmm-d-yy\n" +
                "4 - dd-mmm-yyyy hh:mm");
    }

    public void callRightMethod() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        printMenu();
        try {
            int userInput = Integer.parseInt(reader.readLine());
            switch (userInput) {
                case 1:
                    userDate();
                    break;
                case 2:
                    chooseDiffMethod();
                    break;
                case 3:
                    chooseSubtractMethod();
                    break;
                case 4:
                    chooseAddMethod();
                    break;
                case 5:
                    compareDates();
                    break;
                case 6:
                    pickOutputFormat();
                    break;
                case 7:
                    printDate();
                    break;
                case 8:
                    System.exit(0);

            }
        } catch (IOException e) {
            System.out.println("Wrong input, try again!");
            callRightMethod();
        } catch (NumberFormatException e){
            System.out.println("Wrong input try again!");
            callRightMethod();
        }
    }

    private void userDate() throws IOException {
        this.date = fillDate();
    }

    private Date fillDate() throws IOException {
        Date date = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter date: ");
        String input = null;

        switch (dateFormat) {
            case 1:
                System.out.println("Enter date in format dd/mm/yy");
                input = reader.readLine();
                if (input.matches(DateRegex.DD_MM_YY.value())) {
                    date = parser.parseDD_MM_YY(input);
                }
                break;
            case 2:
                System.out.println("Enter date in format d/m/yyyy");
                input = reader.readLine();
                if (input.matches(DateRegex.D_M_YYYY.value())) {
                    date = parser.parseD_M_YYYY(input);
                }
                break;
            case 3:
                System.out.println("Enter date in format mmm-d-yy (mmm means full names as April, December etc...)");
                input = reader.readLine();
                if(input.matches(DateRegex.MMM_D_YY.value())){
                    date = parser.parseMMM_D_YY(input);
                }
                break;
            case 4:
                System.out.println("Enter date in format dd-mmm-yyyy hh:mm (mmm means full names as April, December etc...)");
                input = reader.readLine();
                if(input.matches(DateRegex.DD_MMM_YYYY_HH_MM.value())){
                    date = parser.parseDD_MMM_YYYY_HH_MM(input);
                }
                break;
        }
        return date;
    }

    private void printDate() {
        if (date == null) {
            System.out.println("No date set");
            return;
        }
        MonthInfo[] monthsName = MonthInfo.values();
        switch (dateFormat) {
            case 1:
                System.out.println(date.getDay() + "/" + date.getMonth() + "/"
                        + date.getYear() % 100 + " " + date.getHours() + ":" + date.getMinutes());
                break;
            case 2:
                System.out.println(date.getDay() + "/" + date.getMonth() + "/"
                        + date.getYear());
                break;
            case 3:
                System.out.println(monthsName[date.getMonth() - 1].getName() + "-" + date.getDay() + "-" + date.getYear());
                break;
            case 4:
                System.out.println(date.getDay() + "-" + monthsName[date.getMonth() - 1].getName() +
                        "-" + date.getYear() + " " + date.getHours() + ":" + date.getMinutes());
            default:
                System.out.println("No such format");

        }
    }

    private void pickOutputFormat() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        printOutputFormatMenu();
        try {
            int n = Integer.parseInt(reader.readLine());
            dateFormat = n;
        } catch (IOException e) {
            throw new RuntimeException("Something wrong with reader!");
        }

    }

    private void chooseDiffMethod() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            Date diffDate = fillDate();
            printDiffMenu();
            int userInput = Integer.parseInt(reader.readLine());
            switch (userInput) {
                case 1:
                    System.out.println(UserDateService.differenceInYear(date, diffDate));
                    break;
                case 2:
                    System.out.println(UserDateService.differenceInMonths(date, diffDate));
                    break;
                case 3:
                    System.out.println(UserDateService.differenceInDays(date, diffDate));
                    break;
                case 4:
                    System.out.println(UserDateService.differenceInHours(date, diffDate));
                    break;
                case 5:
                    System.out.println(UserDateService.differenceInMinutes(date, diffDate));
                    break;
                case 6:
                    System.out.println(UserDateService.differenceInSeconds(date, diffDate));
                    break;
            }
        } catch (IOException e) {
            System.out.println("Wrong input, try again!");
            chooseDiffMethod();
        }
    }

    private void chooseSubtractMethod() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        printSubtractMenu();
        try {
            int userInput = Integer.parseInt(reader.readLine());
            switch (userInput) {
                case 1:
                    System.out.println("Enter year: ");
                    int year = Integer.parseInt(reader.readLine());
                    date = UserDateService.subtractYear(date, year);
                    System.out.println(date);
                    break;
                case 2:
                    System.out.println("Enter month: ");
                    int month = Integer.parseInt(reader.readLine());
                    date = UserDateService.subtractMonth(date, month);
                    System.out.println(date);
                    break;
                case 3:
                    System.out.println("Enter day: ");
                    int day = Integer.parseInt(reader.readLine());
                    date = UserDateService.subtractDay(date, day);
                    System.out.println(date);
                    break;
                case 4:
                    System.out.println("Enter hours: ");
                    int hours = Integer.parseInt(reader.readLine());
                    date = UserDateService.subtractHours(date, hours);
                    System.out.println(date);
                    break;
                case 5:
                    System.out.println("Enter minutes: ");
                    int minutes = Integer.parseInt(reader.readLine());
                    date = UserDateService.subtractMinutes(date, minutes);
                    System.out.println(date);
                    break;
                case 6:
                    System.out.println("Enter seconds: ");
                    int seconds = Integer.parseInt(reader.readLine());
                    date = UserDateService.subtractSeconds(date, seconds);
                    System.out.println(date);
                    break;
            }
        } catch (NumberFormatException e) {
            System.out.println("Wrong input! try again");
            chooseSubtractMethod();
        } catch (IOException e) {
            throw new RuntimeException("Problems with input in reader!");
        }
    }

    private void chooseAddMethod() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        printAddMenu();
        try {
            int userInput = Integer.parseInt(reader.readLine());
            switch (userInput) {
                case 1:
                    System.out.println("Enter year: ");
                    int year = Integer.parseInt(reader.readLine());
                    date = UserDateService.addYear(date, year);
                    System.out.println(date);
                    break;
                case 2:
                    System.out.println("Enter month: ");
                    int month = Integer.parseInt(reader.readLine());
                    date = UserDateService.addMonth(date, month);
                    System.out.println(date);
                    break;
                case 3:
                    System.out.println("Enter day: ");
                    int day = Integer.parseInt(reader.readLine());
                    date = UserDateService.addDay(date, day);
                    System.out.println(date);
                    break;
                case 4:
                    System.out.println("Enter hours: ");
                    int hours = Integer.parseInt(reader.readLine());
                    date = UserDateService.addHours(date, hours);
                    System.out.println(date);
                    break;
                case 5:
                    System.out.println("Enter minutes: ");
                    int minutes = Integer.parseInt(reader.readLine());
                    date = UserDateService.addMinutes(date, minutes);
                    System.out.println(date);
                    break;
                case 6:
                    System.out.println("Enter seconds: ");
                    int seconds = Integer.parseInt(reader.readLine());
                    date = UserDateService.addSeconds(date, seconds);
                    System.out.println(date);
                    break;
            }
        } catch (NumberFormatException e) {
            System.out.println("Wrong input! try again");
            chooseAddMethod();
        } catch (IOException e) {
            throw new RuntimeException("Problems with input in reader!");
        }
    }

    private void compareDates() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter how much dates you want to compare: ");
        try {
            SortedSet dates = new TreeSet();
            int n = Integer.parseInt(reader.readLine());
            for (int i = 0; i < n; i++) {
                Date date;
                date = fillDate();
                dates.add(date);
            }
            System.out.println(dates);
        } catch (IOException e) {
            throw new RuntimeException("Something wrong with reader!");
        }

    }

}
