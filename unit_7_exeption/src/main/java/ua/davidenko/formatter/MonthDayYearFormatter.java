package ua.davidenko.formatter;

// m/d/yyyy (example: 3/4/2021)
import ua.davidenko.date.Date;

public class MonthDayYearFormatter implements Formatter {
    @Override
    public String format(Date date) {
        return new StringBuilder()
                .append(date.getMonths())
                .append("/")
                .append(date.getDays())
                .append("/")
                .append(date.getYears()).toString();
    }

    @Override
    public Date parse(String string) {
        int month = Integer.parseInt(string.substring(0, 1));
        int day = Integer.parseInt(string.substring(2, 3));
        int year = Integer.parseInt(string.substring(4));
        return new Date(year, month, day, 0, 0, 0);
    }

}
