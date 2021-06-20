package control;

import dates.OutputFormatter;
import obj.Date;
import org.apache.commons.lang3.StringUtils;
import dates.CalendarService;
import dates.InputFormatter;

import java.io.InputStreamReader;
import java.time.DateTimeException;
import java.io.IOException;
import java.util.List;
import java.util.zip.DataFormatException;
import java.io.BufferedReader;


public class CalendarControl {

    private final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private final CalendarService calendarService = new CalendarService();

    private String choose() throws IOException {
        String input;
        do {
            System.out.println("Select a difference:\n" +
                    "1 -> ascending\n" +
                    "2 -> descending");
        } while (!(input = bufferedReader.readLine()).matches("[1-2]"));
        return input;
    }

    private String formats() throws IOException {
        String input;
        do {
            System.out.println("Choose format:\n" +
                    "1 -> dd/mm/yy hh:mm:ss\n" +
                    "2 -> m/d/yyyy hh:mm:ss\n" +
                    "3 -> mmm-d-yy hh:mm:ss\n" +
                    "4 -> dd-mmm-yyyy hh:mm:ss");
        } while (!(input = bufferedReader.readLine()).matches("[1-4]"));
        return input;
    }

    private String units() throws IOException {
        do {
            System.out.println("Select the units of time:\n" +
                    "1 -> secs\n" +
                    "2 -> mins\n" +
                    "3 -> hours\n" +
                    "4 -> days\n" +
                    "5 -> months\n" +
                    "6 -> years");
            switch (bufferedReader.readLine()) {
                case "1":
                    return "secs";
                case "2":
                    return "mins";
                case "3":
                    return "hours";
                case "4":
                    return "days";
                case "5":
                    return "months";
                case "6":
                    return "years";
                default:
                    System.out.println("Wrong input. Enter numbers");
            }
        } while (true);
    }


    public void difference() {
        do {
            try {
                String format = formats();
                System.out.println("Enter from date:");
                Date fromDate = InputFormatter.formatDate(bufferedReader.readLine(), format);
                System.out.println("Enter to date:");
                Date toDate = InputFormatter.formatDate(bufferedReader.readLine(), format);
                String units = units();
                double result = calendarService.findDiff(fromDate, toDate, units);
                String str = String.format("%.1f ", result);
                System.out.println(str + units);
                break;
            } catch (DataFormatException | DateTimeException | IOException e) {
                System.out.println("Error");
            }
        } while (true);
    }

    public void add() {
        do {
            try {
                String format = formats();
                System.out.println("Enter date:");
                Date date = InputFormatter.formatDate(bufferedReader.readLine(), format);
                String units = units();
                System.out.println("Enter a value:");
                String value = bufferedReader.readLine();
                if (StringUtils.isEmpty(value)) throw new IOException();
                date = calendarService.add(date, Integer.parseInt(value), units);
                String output = OutputFormatter.formatDate(date, formats());
                System.out.println(output);
                break;
            } catch (IOException | DataFormatException e) {
                System.out.println("Error");
            }
        } while (true);
    }

    public void subtract() {
        do {
            try {
                String format = formats();
                System.out.println("Enter date:");
                Date date = InputFormatter.formatDate(bufferedReader.readLine(), format);
                String units = units();
                System.out.println("Enter a value:");
                String value = bufferedReader.readLine();
                if (StringUtils.isEmpty(value)) throw new IOException();
                date = calendarService.subtract(date, Integer.parseInt(value), units);
                String output = OutputFormatter.formatDate(date, formats());
                System.out.println(output);
                break;
            } catch (IOException | DataFormatException e) {
                System.out.println("Error");
            }
        } while (true);
    }

    public void compare() {
        do {
            try {
                String format = formats();
                System.out.println("Enter dates:");
                List<Date> dates = InputFormatter.formatDateList(bufferedReader.readLine(), format);
                dates = calendarService.compare(dates, choose());
                System.out.println(OutputFormatter.formatDateList(dates, formats()));
                break;
            } catch (IOException | DataFormatException e) {
                System.out.println("Error");
            }
        } while (true);
    }
}
