package ua.davidenko.formatter;

import ua.davidenko.date.Date;

// dd/mm/yy (example: 01/12/21)
public class DayMonthYearFormatter implements Formatter {
    @Override
    public String format(Date date) {
        String years = String.valueOf(date.getYears());
        return new StringBuilder()
                .append(date.getDays())
                .append("/")
                .append(date.getMonths())
                .append("/")
                .append(years.substring(years.length() - 2))
                .toString();
    }

    @Override
    public Date parse(String string) throws NumberFormatException {
        int day = Integer.parseInt(string.substring(0, 2));
        int month = Integer.parseInt(string.substring(3, 5));
        int year = Integer.parseInt(string.substring(6));
        return new Date(year, month, day, 0, 0, 0);
    }
}
