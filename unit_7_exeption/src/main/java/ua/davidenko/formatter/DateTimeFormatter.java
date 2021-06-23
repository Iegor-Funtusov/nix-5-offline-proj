package ua.davidenko.formatter;

import ua.davidenko.date.Date;
import ua.davidenko.date.Months;

// "4 - dd-mmm-yyyy 00:00 (example: 09-Апрель-1789 00:00)
public class DateTimeFormatter implements Formatter {
    @Override
    public String format(Date date) {
        StringBuilder sb = new StringBuilder();
        sb.append(date.getDays())
                .append("-")
                .append(Months.monthNameNumber.get(date.getMonths()))
                .append("_")
                .append(date.getDays())
                .append("-")
                .append(date.getYears())
                .append(" ")
                .append(date.getMinutes())
                .append(":")
                .append(date.getSeconds());
        return sb.toString();
    }

    @Override
    public Date parse(String string) {
        String[] strings;
        strings = string.split("-|:|\\ " );
        int day = Integer.parseInt(strings[0]);
        int month = Months.monthNameNumber.get(strings[1]);
        int year = Integer.parseInt(strings[2]);
        int hour = Integer.parseInt(strings[3]);
        int minute = Integer.parseInt(strings[4]);
        return new Date(year, month, day,hour,minute, 0);
    }
}
