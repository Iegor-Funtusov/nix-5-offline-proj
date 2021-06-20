package dates;

import obj.Date;
import obj.Time;
import org.apache.commons.lang3.StringUtils;

import java.util.zip.DataFormatException;
import java.util.ArrayList;
import java.util.List;

public class InputFormatter {

    private static Date formattedDate;

    public static List<Date> formatDateList(String input, String format) throws DataFormatException {
        String[] data = input.split(",\\s*");
        List<Date> dates = new ArrayList<>();
        for (String date : data) {
            dates.add(formatDate(date, format));
        }
        return dates;
    }

    public static Date formatDate(String input, String format) throws DataFormatException {
        String data = input.trim();
        String date = StringUtils.substringBefore(data, " ");
        String time = StringUtils.substringAfter(data, " ");
        switch (format) {
            case "1":
                formattedDate = formatFirst(date);
                break;
            case "2":
                formattedDate = formatSecond(date);
                break;
            case "3":
                formattedDate = formatThird(date);
                break;
            case "4":
                formattedDate = formatFourth(date);
                break;
        }
        if (time.length() != 0) formattedDate.setTime(formatTime(time));
        System.out.println(formattedDate);
        return formattedDate;
    }

    private static Time formatTime(String input) throws DataFormatException {
        if (input.contains(":")) {
            Time time = new Time();
            if (StringUtils.substringBetween(input, ":") != null) {
                time.setHours(Integer.parseInt(StringUtils.substringBefore(input, ":")));
                time.setMins(Integer.parseInt(StringUtils.substringBetween(input, ":")));
            } else {
                time.setMins(Integer.parseInt(StringUtils.substringBefore(input, ":")));
            }
            time.setSecs(Integer.parseInt(StringUtils.substringAfterLast(input, ":")));
            return time;
        } else {
            throw new DataFormatException("Wrong format");
        }
    }

    private static Date formatFirst(String input) throws DataFormatException {
        if (input.matches("\\d{0,2}/\\d{2}/\\d{0,2}")) {
            Date date = new Date();
            if (StringUtils.isNotBlank(StringUtils.substringBefore(input, "/"))) {
                date.setDay(Integer.parseInt(StringUtils.substringBefore(input, "/")));
            } else {
                date.setDay(1);
            }
            date.setMonth(Integer.parseInt(StringUtils.substringBetween(input, "/")));
            if (StringUtils.isNotBlank(StringUtils.substringAfterLast(input, "/"))) {
                date.setYear(Integer.parseInt(StringUtils.substringAfterLast(input, "/")));
            } else {
                date.setYear(2021);
            }
            return date;
        } else {
            throw new DataFormatException("Error with chosen format");
        }
    }

    private static Date formatSecond(String input) throws DataFormatException {
        if (input.matches("\\d{0,2}/\\d{1,2}/\\d{0,4}") || input.matches("\\d{4}")) {
            Date date = new Date();
            if (input.contains("/")) {
                if (StringUtils.isNotBlank(StringUtils.substringBefore(input, "/"))) {
                    date.setMonth(Integer.parseInt(StringUtils.substringBefore(input, "/")));
                } else {
                    date.setMonth(1);
                }
                date.setDay(Integer.parseInt(StringUtils.substringBetween(input, "/")));
                if (StringUtils.isNotBlank(StringUtils.substringAfterLast(input, "/"))) {
                    date.setYear(Integer.parseInt(StringUtils.substringAfterLast(input, "/")));
                } else {
                    date.setYear(2021);
                }
            } else {
                date.setYear(2021);
            }
            return date;
        } else {
            throw new DataFormatException("Error with chosen format");
        }
    }

    private static Date formatThird(String input) throws DataFormatException {
        if (input.matches("\\D*-\\d{1,2}-\\d{0,2}")) {
            Date date = new Date();
            if (StringUtils.isNotBlank(StringUtils.substringBefore(input, "-"))) {
                date.setMonth(month(StringUtils.substringBefore(input, "-")));
            } else {
                date.setMonth(1);
            }
            date.setDay(Integer.parseInt(StringUtils.substringBetween(input, "-")));
            if (StringUtils.isNotBlank(StringUtils.substringAfterLast(input, "-"))) {
                date.setYear(Integer.parseInt(StringUtils.substringAfterLast(input, "-")));
            } else {
                date.setYear(2021);
            }
            return date;
        } else {
            throw new DataFormatException("Error with chosen format");
        }
    }

    private static Date formatFourth(String input) throws DataFormatException {
        if (input.matches("\\d{0,2}-\\D{3,}-\\d{0,4}") || input.matches("\\d{4}")) {
            Date date = new Date();
            if (input.contains("-")) {
                if (StringUtils.isNotBlank(StringUtils.substringBefore(input, "-"))) {
                    date.setDay(Integer.parseInt(StringUtils.substringBefore(input, "-")));
                } else {
                    date.setDay(1);
                }
                date.setMonth(month(StringUtils.substringBetween(input, "-")));
                if (StringUtils.isNotBlank(StringUtils.substringAfterLast(input, "-"))) {
                    date.setYear(Integer.parseInt(StringUtils.substringAfterLast(input, "-")));
                } else {
                    date.setYear(2021);
                }
            } else {
                date.setYear(2021);
            }
            return date;
        } else {
            throw new DataFormatException("Error with chosen format");
        }
    }

    private static int month(String month) {
        switch (month) {
            case "January":
                return 1;
            case "February":
                return 2;
            case "March":
                return 3;
            case "April":
                return 4;
            case "May":
                return 5;
            case "June":
                return 6;
            case "July":
                return 7;
            case "August":
                return 8;
            case "September":
                return 9;
            case "October":
                return 10;
            case "November":
                return 11;
            case "December":
                return 12;
        }
        return 1;
    }
}
