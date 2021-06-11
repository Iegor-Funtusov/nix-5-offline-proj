public class DateOperations {

    private static boolean isLeap(int year) {
        if (year % 4 != 0 || (year % 100 == 0 && year % 400 != 0))
            return false;
        else
            return true;
    }

    private static int daysInMonth(int month) {
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            return 31;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        } else return 28;
    }

    private int daysInYear(int year) {
        if (isLeap(year)) {
            return 366;
        } else return 365;
    }

    public static int differenceInYears(Date date1, Date date2) {
        int years;
        Date more;
        Date less;
        if (date1.compareTo(date2) > 0) {
            more = new Date(date1);
            less = new Date(date2);
        } else if (date1.compareTo(date2) < 0) {
            more = new Date(date2);
            less = new Date(date1);
        } else {
            return 0;
        }

        years = more.getYear() - less.getYear();
        more.setYear(0);
        less.setYear(0);
        if (more.compareTo(less) < 0) {
            years -= 1;
        }
        return years;
    }

    public static int differenceInMonths(Date date1, Date date2) {
        int months = 0;
        Date more;
        Date less;
        if (date1.compareTo(date2) > 0) {
            more = new Date(date1);
            less = new Date(date2);
        } else if (date1.compareTo(date2) < 0) {
            more = new Date(date2);
            less = new Date(date1);
        } else {
            return 0;
        }

        months = differenceInYears(more, less) * 12 + more.getMonth() - less.getMonth();
        if (more.getMonth() <= less.getMonth()) {
            months += 12;
        }
        more.setYear(0);
        less.setYear(0);
        more.setMonth(0);
        less.setMonth(0);
        if (more.compareTo(less) < 0) {
            months -= 1;
        }
        return months;
    }

    public static int differenceInDays(Date date1, Date date2) {
        int days = 0;
        Date more;
        Date less;
        if (date1.compareTo(date2) > 0) {
            more = new Date(date1);
            less = new Date(date2);
        } else if (date1.compareTo(date2) < 0) {
            more = new Date(date2);
            less = new Date(date1);
        } else {
            return 0;
        }

        for (int i = less.getYear(); i <= more.getYear(); i++) {
            if (isLeap(i)) {
                days++;
            }
        }
        days += differenceInYears(less, more) * 365;
        if (less.compareTo(new Date(less.getYear(), 3, 1, 0, 0, 0)) >= 0 && isLeap(less.getYear())) {
            days--;
        }
        if (more.compareTo(new Date(more.getYear(), 2, 28, 0, 0, 0)) <= 0 && isLeap(more.getYear())) {
            days--;
        }

        if (less.getMonth() > more.getMonth()) {
            for (int i = less.getMonth(); i <= 12; i++) {
                days += daysInMonth(i);
            }
            days -= less.getDay();
            for (int i = 1; i < more.getMonth(); i++) {
                days += daysInMonth(i);
            }
            days += more.getDay();
        } else {
            for (int i = less.getMonth(); i < more.getMonth(); i++) {
                days += daysInMonth(i);
            }
            days -= less.getDay();
            days += more.getDay();
        }
        return days;
    }

    public static int differenceInHours(Date date1, Date date2) {
        int hours = differenceInDays(date1, date2) * 24;
        Date more;
        Date less;
        if (date1.compareTo(date2) > 0) {
            more = new Date(date1);
            less = new Date(date2);
        } else if (date1.compareTo(date2) < 0) {
            more = new Date(date2);
            less = new Date(date1);
        } else {
            return 0;
        }

        if (less.getHour() > more.getHour()) {
            hours += 24 - less.getHour();
            hours += more.getHour();
        } else {
            hours += more.getHour() - less.getHour();
        }
        return hours;
    }

    public static int differenceInMinutes(Date date1, Date date2) {
        int minutes = differenceInHours(date1, date2) * 60;
        Date more;
        Date less;
        if (date1.compareTo(date2) > 0) {
            more = new Date(date1);
            less = new Date(date2);
        } else if (date1.compareTo(date2) < 0) {
            more = new Date(date2);
            less = new Date(date1);
        } else {
            return 0;
        }

        if (less.getMinute() > more.getMinute()) {
            minutes += 60 - less.getMinute();
            minutes += more.getMinute();
        } else {
            minutes += more.getMinute() - less.getMinute();
        }
        return minutes;
    }

    public static long differenceInSeconds(Date date1, Date date2) {
        long seconds = (long) differenceInMinutes(date1, date2) * 60;
        Date more;
        Date less;
        if (date1.compareTo(date2) > 0) {
            more = new Date(date1);
            less = new Date(date2);
        } else if (date1.compareTo(date2) < 0) {
            more = new Date(date2);
            less = new Date(date1);
        } else {
            return 0;
        }

        if (less.getSecond() > more.getSecond()) {
            seconds += 60 - less.getSecond();
            seconds += more.getSecond();
        } else {
            seconds += more.getSecond() - less.getSecond();
        }
        return seconds;
    }

    public static Date addYear(Date date, int year) {
        return date;
    }

    public static Date addMonth(Date date, int month) {
        return date;
    }

    public static Date addDay(Date date, int day) {
        return date;
    }

    public static Date addHour(Date date, int hour) {
        return date;
    }

    public static Date addMinute(Date date, int minute) {
        return date;
    }

    public static Date addSecond(Date date, int second) {
        return date;
    }

    public static Date subtractYear(Date date, int year) {
        return date;
    }

    public static Date subtractMonth(Date date, int month) {
        return date;
    }

    public static Date subtractDay(Date date, int day) {
        return date;
    }

    public static Date subtractHour(Date date, int hour) {
        return date;
    }

    public static Date subtractMinute(Date date, int minute) {
        return date;
    }

    public static Date subtractSecond(Date date, int second) {
        return date;
    }


}
