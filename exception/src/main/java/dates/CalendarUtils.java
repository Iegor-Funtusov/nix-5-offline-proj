package dates;

import obj.Time;
import obj.Date;

public class CalendarUtils {

    public static boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 != 0) {
                return true;
            } else return year % 400 == 0;
        }
        return false;
    }

    public static int daysInMonth(int month, int year) {
        if (month != 2) {
            return 30 + (month + month / 8) % 2;
        } else {
            if (isLeapYear(year)) {
                return 29;
            } else {
                return 28;
            }
        }
    }

    public static boolean datePair(Date from, Date to) {
        boolean result = false;
        if (from.getYear() <= to.getYear()) {
            result = true;
            if (from.getYear().equals(to.getYear())) {
                if (from.getMonth() <= to.getMonth()) {
                    if (from.getMonth().equals(to.getMonth())) {
                        if (from.getDay() <= to.getDay()) {
                            if (from.getDay().equals(to.getDay())) {
                                return timePair(from.getTime(), to.getTime());
                            }
                        } else {
                            result = false;
                        }
                    }
                } else {
                    result = false;
                }
            }
        }
        return result;
    }

    private static boolean timePair(Time from, Time to) {
        boolean result = false;
        if (from.getHours() <= to.getHours()) {
            result = true;
            if (from.getHours().equals(to.getHours())) {
                if (from.getMins() <= to.getMins()) {
                    if (from.getMins().equals(to.getMins())) {
                        if (!(from.getSecs() <= to.getSecs()))
                            result = false;
                    }
                } else {
                    result = false;
                }
            }
        }
        return result;
    }

}
