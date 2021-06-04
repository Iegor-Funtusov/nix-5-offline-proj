package ua.com.nix.operations_with_date;

import ua.com.nix.model.Calendar;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import static ua.com.nix.operations_with_date.Create.calendarList;

public class Comparation {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void compare() throws IOException {
        String start;
        int i = 1;
        addLabel:
        while (true) {
            System.out.println("""
                    1 -> Add dates
                    2 -> Sort""");
            start = reader.readLine();
            switch (start) {
                case "1": {
                    System.out.println("Enter " + i + " date: " + " (to exit write EXIT)");
                    System.out.println("For example" + " or (1/10/34)" + " or (/5/47)" + " or (/2/)" + " or (1256 59:59 )");
                    new Create().create();
                    i++;
                }
                case "2": {
                    break addLabel;
                }
                default: {
                    System.out.println("Incorrect input,try again...");
                }
            }

            MainLabel:
            while (true) {
                System.out.println("1 - Display ascending dates" + "2 - Display dates descending ");
                System.out.println("""
                        Enter task:
                        1 -> Display ascending dates
                        2 -> Display dates descending
                        0 -> Return to menu selection""");
                String s = reader.readLine();
                switch (s) {
                    case "1": {
                        System.out.println("Dates was: ");
                        calendarList.forEach(System.out::println);
                        System.out.println("Dates became: ");
                        calendarList.sort(Calendar::compareTo);
                        calendarList.forEach(System.out::println);
                        break;
                    }
                    case "2": {
                        System.out.println("Dates was: ");
                        calendarList.forEach(System.out::println);
                        System.out.println("Dates became: ");
                        calendarList.sort(Comparator.reverseOrder());
                        calendarList.forEach(System.out::println);
                        break;
                    }
                    case "0": {
                        calendarList.clear();
                        break MainLabel;
                    }
                    default:
                        System.out.println("Incorrect choice,try again...");
                }
            }
        }
    }
}
