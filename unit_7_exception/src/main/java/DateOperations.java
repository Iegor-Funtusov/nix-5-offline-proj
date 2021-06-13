public class DateOperations {

    private static boolean isLeap(int year) {
        if (year % 4 != 0 || (year % 100 == 0 && year % 400 != 0))
            return false;
        else
            return true;
    }

    public static int daysInMonth(int month) {
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            return 31;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        } else return 28;
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
        date.setYear(date.getYear() + year);
        return date;
    }

    public static Date addMonth(Date date, int month) {
        if (date.getMonth() + month > 12) {
            int restMonths = month + date.getMonth() - 12 - 1;
            date = addYear(date, 1);
            date.setMonth(1);
            date = addMonth(date, restMonths);
        } else {
            date.setMonth(date.getMonth() + month);
        }
        return date;
    }

    public static Date addDay(Date date, int day) {
        if (date.getDay() + day > daysInMonth(date.getMonth())) {
            int restDays = day - daysInMonth(date.getMonth()) + date.getDay() - 1;
            date = addMonth(date, 1);
            date.setDay(1);
            date = addDay(date, restDays);
        } else {
            date.setDay(date.getDay() + day);
        }
        return date;
    }

    public static Date addHour(Date date, int hour) {
        if (date.getHour() + hour > 23) {
            int restHours = hour + date.getHour() - 23 - 1;
            date = addDay(date, 1);
            date.setHour(0);
            date = addHour(date, restHours);
        } else {
            date.setHour(date.getHour() + hour);
        }
        return date;
    }

    public static Date addMinute(Date date, int minute) {
        if (date.getMinute() + minute > 59) {
            int restMinutes = minute + date.getMinute() - 59 - 1;
            date = addHour(date, 1);
            date.setMinute(0);
            date = addMinute(date, restMinutes);
        } else {
            date.setMinute(date.getMinute() + minute);
        }
        return date;
    }

    public static Date addSecond(Date date, int second) {
        if (date.getSecond() + second > 59) {
            int restSeconds = second + date.getSecond() - 59 - 1;
            date = addMinute(date, 1);
            date.setSecond(0);
            date = addSecond(date, restSeconds);
        } else {
            date.setSecond(date.getSecond() + second);
        }
        return date;
    }

    public static Date subtractYear(Date date, int year) {
        if (date.getYear() == 0) {
            System.out.println("Subtraction is not possible");
            return date;
        }
        return addYear(date, -year);
    }

    public static Date subtractMonth(Date date, int month) {
        if (date.getYear() == 0 && date.getMonth() == 1) {
            System.out.println("Subtraction is not possible");
            return date;
        }
        if (month >= date.getMonth()) {
            int restMonths = month - date.getMonth();
            date = subtractYear(date, 1);
            date.setMonth(12);
            date = subtractMonth(date, restMonths);
        } else {
            date.setMonth(date.getMonth() - month);
        }
        return date;
    }

    public static Date subtractDay(Date date, int day) {
        if (date.getYear() == 0 && date.getMonth() == 1 && date.getDay() == 1) {
            System.out.println("Subtraction is not possible");
            return date;
        }
        if (day >= date.getDay()) {
            int restDays = day - date.getDay();
            date = subtractMonth(date, 1);
            date.setDay(daysInMonth(date.getMonth()));
            date = subtractDay(date, restDays);
        } else {
            date.setDay(date.getDay() - day);
        }
        return date;
    }

    public static Date subtractHour(Date date, int hour) {
        if (date.getYear() == 0 && date.getMonth() == 1 && date.getDay() == 1 && date.getHour() == 0) {
            System.out.println("Subtraction is not possible");
            return date;
        }
        if (hour > date.getHour()) {
            int restHour = hour - date.getHour() - 1;
            date = subtractDay(date, 1);
            date.setHour(23);
            date = subtractHour(date, restHour);
        } else {
            date.setHour(date.getHour() - hour);
        }
        return date;
    }

    public static Date subtractMinute(Date date, int minute) {
        if (date.getYear() == 0 && date.getMonth() == 1 && date.getDay() == 1 && date.getHour() == 0 && date.getMinute() == 0) {
            System.out.println("Subtraction is not possible");
            return date;
        }
        if (minute > date.getMinute()) {
            int restMinute = minute - date.getMinute() - 1;
            date = subtractHour(date, 1);
            date.setMinute(59);
            date = subtractMinute(date, restMinute);
        } else {
            date.setMinute(date.getMinute() - minute);
        }
        return date;
    }

    public static Date subtractSecond(Date date, int second) {
        if (date.getYear() == 0 && date.getMonth() == 1 && date.getDay() == 1 && date.getHour() == 0 && date.getMinute() == 0 && date.getSecond() == 0) {
            System.out.println("Subtraction is not possible");
            return date;
        }
        if (second > date.getSecond()) {
            int restSecond = second - date.getSecond() - 1;
            date = subtractMinute(date, 1);
            date.setSecond(59);
            date = subtractSecond(date, restSecond);
        } else {
            date.setSecond(date.getSecond() - second);
        }
        return date;
    }
}
