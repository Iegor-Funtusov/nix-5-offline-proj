package dates;

import obj.Date;

import java.util.List;

public class OutputFormatter {

    public static String formatDateList(List<Date> dates, String format) {
        StringBuilder output = new StringBuilder();
        for (Date date : dates) {
            output.append(formatDate(date, format)).append(", ");
        }
        return output.toString();
    }

    public static String formatDate(Date date, String format) {
        String output = "";
        switch (format) {
            case "1":
                output = firstFormat(date);
                break;
            case "2":
                output = secondFormat(date);
                break;
            case "3":
                output = thirdFormat(date);
                break;
            case "4":
                output = fourthFormat(date);
                break;
        }
        return output;
    }

    private static String firstFormat(Date date) {
        int year = date.getYear();
        if (year > 999) year = year % 100;
        return String.format("%02d/%02d/%02d ", date.getDay(), date.getMonth(), year) + formatTime(date);
    }

    private static String secondFormat(Date date) {
        return String.format("%d/%d/%04d ", date.getDay(), date.getMonth(), date.getYear()) + formatTime(date);
    }

    private static String thirdFormat(Date date) {
        int year = date.getYear();
        if (year > 999) {
            year = year % 100;
        }
        return String.format("%s-%d-%d ", monthToStr(date.getMonth()), date.getDay(), year) + formatTime(date);
    }

    private static String fourthFormat(Date date) {
        return String.format("%02d-%s-%04d ", date.getDay(), monthToStr(date.getMonth()), date.getYear()) +
                formatTime(date);
    }

    private static String formatTime(Date date) {
        return String.format("%02d:%02d:%02d", date.getTime().getHours(), date.getTime().getMins(), date.getTime().getSecs());
    }

    private static String monthToStr(int month) {
        switch (month) {
            case 1:
                return "January";
            case 2:
                return "February";
            case 3:
                return "March";
            case 4:
                return "April";
            case 5:
                return "May";
            case 6:
                return "June";
            case 7:
                return "July";
            case 8:
                return "August";
            case 9:
                return "September";
            case 10:
                return "October";
            case 11:
                return "November";
            case 12:
                return "December";
        }
        return "January";
    }
}
