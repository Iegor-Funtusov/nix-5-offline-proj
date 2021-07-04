package dates;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class WorkWithDates {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final String[] DATE_FORMATS = {"yyyy/MM/dd", "yyyy/dd/MM", "dd/MM/yyyy", "MM/dd/yyyy", "yyyy-MM-dd", "yyyy-dd-MM", "dd-MM-yyyy", "MM-dd-yyyy"};

    public static void dateMain() throws IOException {
        String str;
        List<String> dates = new ArrayList<>();
        System.out.println("Please enter the dates");
        System.out.println("For EXIT enter \"0\"");

        do {
            str = reader.readLine();
            if (isDateValid(str)) {
                dates.add(splitDate(str));
            } else {
                System.out.println("Wrong input date");
            }
        } while (!str.equals("0"));

        if (dates.isEmpty()) {
            System.out.println("List of dates is empty");
        } else {
            dates.forEach(System.out::println);
        }
    }

    private static String splitDate(String date) {
        String[] newDate = new String[3];
        if (date.contains("/")) {
            String[] dateArray = date.split("/");
            swapDate(newDate, dateArray);
        } else {
            String[] dateArray = date.split("-");
            swapDate(newDate, dateArray);
        }
        return newDate[0] + newDate[1] + newDate[2];
    }

    private static void swapDate(String[] newDate, String[] dateArray) {
        for (String s : dateArray) {
            if (s.length() == 4) {
                newDate[0] = s;
            } else if (s.length() == 2 && Integer.parseInt(s) <= 12 && newDate[1] == null) {
                newDate[1] = s;
            } else if (s.length() == 2 && Integer.parseInt(s) <= 31 || newDate[1] != null) {
                newDate[2] = s;
            }
        }
    }

    private static boolean isDateValid(String date) {
        for (String dateFormat : DATE_FORMATS) {
            if (isDateValid(date, dateFormat)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isDateValid(String date, String format) {
        try {
            DateFormat df = new SimpleDateFormat(format);
            df.setLenient(false);
            df.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}
