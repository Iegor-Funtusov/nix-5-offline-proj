package ua.davidenko.formatter;

import ua.davidenko.date.Date;
import ua.davidenko.date.Months;

// mmm-d-yy (example: Март-4-21)
public class MonthNameDayYearFormatter implements Formatter {

    @Override
    public String format(Date date) {
        StringBuilder sb = new StringBuilder();
        sb.append(Months.monthNameNumber.get(date.getMonths()))
                .append("-")
                .append(date.getDays())
                .append("-")
                .append(date.getYears());
        return sb.toString();

    }

    @Override
    public Date parse(String string) {
        String[] strings;
        strings = string.split("-");
        int month = Months.monthNameNumber.get(strings[0]);
        int day = Integer.parseInt(strings[1]);
        int year = Integer.parseInt(strings[2]);
        return new Date(year, month, day, 0, 0, 0);
    }

}




