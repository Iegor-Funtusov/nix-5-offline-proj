package ua.practice.unit7.ui;

import ua.practice.unit7.util.DateTimeUtil;
import ua.practice.unit7.date_time.DateTime;
import ua.practice.unit7.formatter.DateTimeFormatter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class UserUI {
    private static final String INPUT_FIRST_DATE = "Input first date with type ";
    private DateTime dateTime1;
    private DateTime dateTime2;
    private final FormatterUI ui = new FormatterUI();
    private DateTimeFormatter formatter;

    public void execute() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String input;
        ui.initFormat(bufferedReader);
        formatter = ui.getFormatter();
        printOperations();

        while ((input = bufferedReader.readLine()) != null) {
            try {
                switch (input) {
                    case "1":
                        initDates(bufferedReader);
                        System.out.println(Arrays.toString(DateTimeUtil.differenceBetweenDates(dateTime1, dateTime2)));
                        break;
                    case "2":
                        System.out.println(INPUT_FIRST_DATE + formatter.getDataType().getType() + " :");
                        dateTime1 = new DateTime(bufferedReader.readLine(), formatter.getDataType());
                        int[] dateTimeToAdd = initSingleDateTime(bufferedReader);
                        formatter.printUsingFormat(DateTimeUtil.addToDate(dateTime1, dateTimeToAdd));
                        break;
                    case "3":
                        System.out.println(INPUT_FIRST_DATE + formatter.getDataType().getType() + " :");
                        dateTime1 = new DateTime(bufferedReader.readLine(), formatter.getDataType());
                        int[] dateTimeToSub = initSingleDateTime(bufferedReader);
                        formatter.printUsingFormat(DateTimeUtil.subDate(dateTime1, dateTimeToSub));
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
                        ui.initFormat(bufferedReader);
                        formatter = ui.getFormatter();
                        break;
                    default:
                        System.out.println("Incorrect input.");
                }
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                System.out.println("Error has occurred. Input again.");
            }
            printOperations();
        }
    }

    private void initDates(BufferedReader bufferedReader) throws IOException {
        System.out.println(INPUT_FIRST_DATE + formatter.getDataType().getType() + " :");
        dateTime1 = new DateTime(bufferedReader.readLine(), formatter.getDataType());
        System.out.println("Input second date: ");
        dateTime2 = new DateTime(bufferedReader.readLine(), formatter.getDataType());
    }

    private void printOperations() {
        System.out.println("Choose operations:");
        System.out.println("1 - Find difference between two dates");
        System.out.println("2 - Add to date");
        System.out.println("3 - Sub from date");
        System.out.println("4 - Compare dates");
        System.out.println("5 - Change date format");
    }

    private int[] initSingleDateTime(BufferedReader bufferedReader) throws IOException {
        int[] dateTime = new int[6];
        System.out.println("Input years :");
        dateTime[5] = Integer.parseInt(bufferedReader.readLine());
        System.out.println("Input months :");
        dateTime[4] = Integer.parseInt(bufferedReader.readLine());
        System.out.println("Input days :");
        dateTime[3] = Integer.parseInt(bufferedReader.readLine());
        System.out.println("Input hours :");
        dateTime[2] = Integer.parseInt(bufferedReader.readLine());
        System.out.println("Input minutes :");
        dateTime[1] = Integer.parseInt(bufferedReader.readLine());
        System.out.println("Input seconds :");
        dateTime[0] = Integer.parseInt(bufferedReader.readLine());
        return dateTime;
    }
}
