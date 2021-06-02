package ua.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleUI {
    private static final BufferedReader reader;
    private static final String REGEX_NUM = "^[0-9]$";
    private final CalendarController calendarController = new CalendarController();

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void run() {
        mainCycle();
    }

    public void mainCycle() {
        message();
        switch (inputConstant()) {
            case "1": {
                System.out.println("Difference between dates");
                calendarController.differenceBetweenDates();
                break;
            }
            case "2": {
                System.out.println("Plus to date something (Y, M, D, H, M, S)");
                calendarController.plusOrMinusAmountToDate(1);
                break;
            }
            case "3": {
                System.out.println("Minus to date something (Y, M, D, H, M, S)");
                calendarController.plusOrMinusAmountToDate(2);
                break;
            }
            case "4": {
                System.out.println("Show dates by increasing or descending");
                calendarController.sortDatesByLong();
                break;
            }
            case "0": {
                System.exit(0);
                break;
            }
            default: {
                System.out.println("There is no such operation");
                break;
            }
        }
        mainCycle();
    }

    private void message() {
        System.out.println("Choose the operation:\n" +
                "1 - Get difference between dates\n" +
                "2 - Plus to date any amount of time\n" +
                "3 - Minus to date any amount of time\n" +
                "4 - Create 'n' dates and sort by increasing or descending\n" +
                "0 - Exit\n");
    }

    private String inputConstant() {
        String constant;
        do {
            System.out.println("Number:");
            try {
                constant = reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException("failed to read input", e);
            }
        } while (!constant.matches(REGEX_NUM));
        return constant;
    }
}
