package ua.practice.unit7;

import ua.practice.unit7.handlers.DateHandler;
import ua.practice.unit7.handlers.DateTime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestMain {
    private static DateTime dateTime1;
    private static DateTime dateTime2;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String input;
        UI.initFormat(bufferedReader);
        printOperations();

        while ((input = bufferedReader.readLine()) != null)
        {
            try {
                switch (input) {
                    case "1":
                        initDates(bufferedReader);
                        UI.formatter.printUsingFormat(DateHandler.differenceBetweenDates(dateTime1, dateTime2));
                        break;
                    case "2":
                        System.out.println("Input first date with type " + UI.formatter.getDataType().getType() + " :");
                        dateTime1 = new DateTime(bufferedReader.readLine(), UI.formatter.getDataType());
                        dateTime2 = initSingleDateTime(bufferedReader);
                        UI.formatter.printUsingFormat(DateHandler.addToDate(dateTime1, dateTime2));
                        break;
                    case "3":
                        System.out.println("Input first date with type " + UI.formatter.getDataType().getType() + " :");
                        dateTime1 = new DateTime(bufferedReader.readLine(), UI.formatter.getDataType());
                        dateTime2 = initSingleDateTime(bufferedReader);
                        UI.formatter.printUsingFormat(DateHandler.subFromDate(dateTime1, dateTime2));
                        break;
                    case "4":
                        initDates(bufferedReader);
                        if (dateTime1.compareTo(dateTime2) > 0) {
                            System.out.println("First date is bigger");
                        } else if (dateTime1.compareTo(dateTime2) == 0)
                            System.out.println("Dates are equal");
                        else
                            System.out.println("Second date is bigger");
                        break;
                    case "5":
                        UI.initFormat(bufferedReader);
                        break;
                    default:
                        System.out.println("Incorrect input.");
                }
            }
            catch (RuntimeException e)
            {
                System.out.println(e.getMessage());
                System.out.println("Error has occurred. Input again.");
            }
            printOperations();
        }
    }

    private static void initDates(BufferedReader bufferedReader) throws IOException {
        System.out.println("Input first date with type " + UI.formatter.getDataType().getType() + " :");
        dateTime1 = new DateTime(bufferedReader.readLine(), UI.formatter.getDataType());
        System.out.println("Input second date: ");
        dateTime2 = new DateTime(bufferedReader.readLine(), UI.formatter.getDataType());
    }

    private static void printOperations(){
        System.out.println("Choose operations:");
        System.out.println("1 - Find difference between two dates");
        System.out.println("2 - Add date to date");
        System.out.println("3 - Sub date from date");
        System.out.println("4 - Compare dates");
        System.out.println("5 - Change date format");
    }

    private static DateTime initSingleDateTime (BufferedReader bufferedReader) throws IOException {
        System.out.println("Input years :");
        int years = Integer.parseInt(bufferedReader.readLine());
        System.out.println("Input months :");
        int months = Integer.parseInt(bufferedReader.readLine());
        System.out.println("Input days :");
        int days = Integer.parseInt(bufferedReader.readLine());
        System.out.println("Input hours :");
        int hours = Integer.parseInt(bufferedReader.readLine());
        System.out.println("Input minutes :");
        int minutes = Integer.parseInt(bufferedReader.readLine());
        System.out.println("Input seconds :");
        int seconds = Integer.parseInt(bufferedReader.readLine());
        return new DateTime(years, months, days, hours, minutes, seconds);
    }
}
