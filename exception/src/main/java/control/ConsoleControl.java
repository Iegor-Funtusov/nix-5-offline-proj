package control;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ConsoleControl {

    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final CalendarControl calendarControl = new CalendarControl();

    public void readConsole() {
        System.out.println("What do you need:\n" +
                "1 -> Find the difference between the dates\n" +
                "2 -> Add to the date\n" +
                "3 -> Subtract from the date\n" +
                "4 -> Compare the list of dates in descending order and ascending order\n" +
                "0 -> exit");
        br.lines().forEach(input -> {
            switch (input) {
                case "1":
                    calendarControl.difference();
                    break;
                case "2":
                    calendarControl.add();
                    break;
                case "3":
                    calendarControl.subtract();
                    break;
                case "4":
                    calendarControl.compare();
                    break;
                case "0":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong input. Enter numbers");
            }
            System.out.println("What do you need:\n" +
                    "1 -> Find the difference between the dates\n" +
                    "2 -> Add to the date\n" +
                    "3 -> Subtract from the date\n" +
                    "4 -> Compare the list of dates in descending order and ascending order\n" +
                    "0 -> exit");
        });
    }
}
