package controller;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ApplicationMain {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final String EXCEPTION = "You entered invalid characters!";
    private static final String SEPARATOR = "--------------------------------------------------------------------------------------------------------";
    private static final String EXIT = "********************************************************************************************************";

    @SneakyThrows
    public void run() {
        while (true) {
            System.out.print("\uD83D\uDD25\uD83D\uDD25\uD83D\uDD25\uD83D\uDD25\uD83D\uDD25\uD83D\uDD25\uD83D\uDD25\uD83D\uDD25\uD83D\uDD25\uD83D\uDD25\uD83D\uDD25\uD83D\uDD25\uD83D\uDD25\uD83D\uDD25\uD83D\uDD25\uD83D\uDD25\uD83D\uDD25\uD83D\uDD25\uD83D\uDD25\uD83D\uDD25\uD83D\uDD25\uD83D\uDD25\uD83D\uDD25 CALENDAR \uD83D\uDD25\uD83D\uDD25\uD83D\uDD25\uD83D\uDD25\uD83D\uDD25\uD83D\uDD25\uD83D\uDD25\uD83D\uDD25\uD83D\uDD25\uD83D\uDD25\uD83D\uDD25\uD83D\uDD25\uD83D\uDD25\uD83D\uDD25\uD83D\uDD25\uD83D\uDD25\uD83D\uDD25\uD83D\uDD25\uD83D\uDD25\uD83D\uDD25\uD83D\uDD25\uD83D\uDD25\uD83D\uDD25\uD83D\uDD25\n" +
                    "1.Get the difference between dates\n" +
                    "2.Add any time to date\n" +
                    "3.Subtract any time from the date\n" +
                    "4.Compare dates descending/ascending \n" +
                    "Exit(0)\n" +
                    "Select an action or press 0 to exit: ");
            try {
                int operation = Integer.parseInt(bufferedReader.readLine());
                switch (operation) {
                    case 0:
                        System.out.println(EXIT);
                        System.out.println("Thanks for attention!");
                        System.exit(0);
                    case 1:
                        new DifferenceBetweenDatesController().differenceBetweenDatesController();
                        break;
                    case 2:
                        new AddTimeController().addTime();
                        break;
                    case 3:
                        new SubtractTimeController().subtractTime();
                        break;
                    case 4:
                        new СompareDatesController().compareDates();
                        break;
                    default:
                        System.out.println(SEPARATOR);
                        System.out.println(EXCEPTION);
                        System.out.println(SEPARATOR);
                }
            } catch (NumberFormatException exception) {
                System.out.println(SEPARATOR);
                System.out.println(EXCEPTION);
                System.out.println(SEPARATOR);
            }
        }
    }
}

