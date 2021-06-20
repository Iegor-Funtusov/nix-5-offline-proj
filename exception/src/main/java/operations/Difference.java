package operations;

import obj.Date;
import dates.CalendarUtils;
import java.time.DateTimeException;

public class Difference {

    public double diffInSecs(Date from, Date to) {
        return diffInMins(from, to) * 60 + (to.getTime().getSecs() - from.getTime().getSecs());
    }

    public double diffInMins(Date from, Date to) {
        return diffInHours(from, to) * 60 + (to.getTime().getMins() - from.getTime().getMins());
    }

    public double diffInHours(Date from, Date to) {
        return diffInDays(from, to) * 24
                + (to.getTime().getHours() - from.getTime().getHours())
                + (double)(to.getTime().getMins() - from.getTime().getMins())/60;
    }


    public double diffInDays(Date from, Date to) throws DateTimeException {
        double result = diffInMonths(from, to);
        if (result != 0) {
            if (result > 12) {
                result = 0;
                int i = from.getYear() + 1;
                while (i <= to.getYear() - 1) {
                    result += 365;
                    if (CalendarUtils.isLeapYear(i)) {
                        result++;
                    }
                    i++;
                }
            } else {
                result = 0;
                if (from.getYear().equals(to.getYear())) {
                    int i = from.getMonth();
                    while (i < to.getMonth() + 1) {
                        result += CalendarUtils.daysInMonth(i, from.getYear());
                        i++;
                    }
                    return result - from.getDay() - (CalendarUtils.daysInMonth(to.getMonth(), to.getYear()) - to.getDay());
                }
            }
            {
                int i = from.getMonth();
                while (i < 13) {
                    result += CalendarUtils.daysInMonth(i, from.getYear());
                    i++;
                }
            }
            int i = to.getMonth();
            while (i > 0) {
                result += CalendarUtils.daysInMonth(i, to.getYear());
                i--;
            }
            result = result - from.getDay() - (CalendarUtils.daysInMonth(to.getMonth(), to.getYear()) - to.getDay());
        }
        return result;
    }

    public double diffInMonths(Date from, Date to) {
        return diffInYears(from, to) * 12
                + (double) (to.getDay() - from.getDay()) / 31;
    }

    public double diffInYears(Date from, Date to) throws DateTimeException {
        if (CalendarUtils.datePair(from, to))
            return to.getYear() - from.getYear() + (double) (to.getMonth() - from.getMonth()) / 12;
        throw new DateTimeException("The cost by date is less than from date");
    }
}
