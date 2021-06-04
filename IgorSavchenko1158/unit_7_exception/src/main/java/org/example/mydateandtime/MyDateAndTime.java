package org.example.mydateandtime;

import java.util.stream.IntStream;

/**
 * My attempt at an immutable class (I regret)
 */
public class MyDateAndTime {
    private static final int DEFAULT_MONTH_DAY = 1;
    private static final int DEFAULT_YEAR = 2021;
    private static final int DEFAULT_TIME = 0;

    private int year = DEFAULT_YEAR;
    private int month = DEFAULT_MONTH_DAY;
    private int day = DEFAULT_MONTH_DAY;

    private int hour = DEFAULT_TIME;
    private int minute = DEFAULT_TIME;
    private int second = DEFAULT_TIME;

    public MyDateAndTime(int year, int month, int day, int hour, int minute, int second) {
        setYear(year);
        setMonth(month);
        setDay(day);
        setHour(hour);
        setMinute(minute);
        setSecond(second);
    }

    private MyDateAndTime(MyDateAndTime other) {
        this.year = other.year;
        this.month = other.month;
        this.day = other.day;
        this.hour = other.hour;
        this.minute = other.minute;
        this.second = other.second;
    }

    private MyDateAndTime() {
    }

    public MyDateAndTime addYears(int years) {
        if (years < 0) {
            return subtractYears(-years);
//            throw new IllegalArgumentException("Years can't be negative");
        }
        MyDateAndTime result = new MyDateAndTime(this);
        result.setYear(result.getYear() + years);
        return result;
    }

    public MyDateAndTime addMonths(int months) {
//        if (months < 0) {
//            return subtractMonths(-months);
////            new IllegalArgumentException("Months can't be negative");
//        }

        MyDateAndTime result = new MyDateAndTime(this);
        int years = months / 12;
        int remainingMonths = months % 12;

        result.setYear(result.getYear() + years);
        try {
            result.setMonth(result.getMonth() + remainingMonths);
        } catch (IllegalArgumentException e) {
            result.setYear(result.getYear() + 1);
            result.setMonth((result.getMonth() + remainingMonths) - 12);
        }

        return result;
    }

    public MyDateAndTime addDays(int days) {
        if (days < 0) {
//            return subtractDays(-days); TODO THIS
            throw new IllegalArgumentException("Days can't be negative");
        }

        MyDateAndTime result = new MyDateAndTime(this);
        for (int i = 0; i < days; i++) {
            try {
                result.setDay(result.getDay() + 1);
            } catch (IllegalArgumentException e) {
                try {
                    result.setDay(1);
                    result.setMonth(result.getMonth() + 1);
                } catch (IllegalArgumentException e2) {
                    result.setYear(result.getYear() + 1);
                    result.setMonth(1);
                    result.setDay(1);
                }
            }
        }

        return result;
    }

    public MyDateAndTime addHours(int hours) {
        if (hours < 0) {
//            return subtractHours(-hours); TODO THIS
            throw new IllegalArgumentException("Hours can't be negative");
        }

        MyDateAndTime result = new MyDateAndTime(this);
        int days = hours / 24;
        int remainingHours = hours % 24;
        result = result.addDays(days);
        try {
            result.setHour(result.getHour() + remainingHours);
        } catch (IllegalArgumentException e) {
            result = result.addDays(1);
            result.setHour((result.getHour() + remainingHours) - 24);
        }

        return result;
    }

    public MyDateAndTime addMinutes(int minutes) {
        if (minutes < 0) {
//            return subtractMinutes(-minutes); TODO THIS
            throw new IllegalArgumentException("Minutes can't be negative");
        }

        MyDateAndTime result = new MyDateAndTime(this);
        int hours = minutes / 60;
        int remainingMinutes = minutes % 60;
        result = result.addHours(hours);
        try {
            result.setMinute(result.getMinute() + remainingMinutes);
        } catch (IllegalArgumentException e) {
            result = result.addHours(1);
            result.setMinute((result.getMinute() + remainingMinutes) - 60);
        }

        return result;
    }

    public MyDateAndTime addSeconds(int seconds) {
        if (seconds < 0) {
//            return subtractSeconds(-minutes); TODO THIS
            throw new IllegalArgumentException("Seconds can't be negative");
        }

        MyDateAndTime result = new MyDateAndTime(this);
        int minutes = seconds / 60;
        int remainingSeconds = seconds % 60;
        result = result.addMinutes(minutes);
        try {
            result.setSecond(result.getSecond() + remainingSeconds);
        } catch (IllegalArgumentException e) {
            result = result.addMinutes(1);
            result.setSecond((result.getSecond() + remainingSeconds) - 60);
        }

        return result;
    }

    public MyDateAndTime subtractYears(int years) {
        if (years < 0) {
            return addYears(-years);
        }

        MyDateAndTime result = new MyDateAndTime(this);
        try {
            result.setYear(result.getYear() - years);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Result of subtraction can't be negative", e);
        }
        return result;
    }

//    public MyDateAndTime subtractMonths(int months) {
//        int years
//    }

//    public MyDateAndTime subtractDays(int years)
//    public MyDateAndTime subtractHours(int years)
//    public MyDateAndTime subtractMinutes(int years)
//    public MyDateAndTime subtractSeconds(int years)

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    private void setYear(int year) {
        if (year < 0) {
            throw new IllegalArgumentException("Year cannot be negative");
        }
        if (!isLeapYear(year) && getMonth() == 2 && getDay() == 29) {
            throw new IllegalArgumentException("February too long for not a leap year");
        }
        this.year = year;
    }

    private void setMonth(int month) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Month must be in range [1, 12]");
        }
        if (daysInMonth(month) < getDay()) {
            throw new IllegalArgumentException("To many days for this month");
        }
        this.month = month;
    }

    private void setDay(int day) {
        if (day < 0 || day > daysInMonth(getMonth())) {
            throw new IllegalArgumentException("Too many days for current month");
        }
        this.day = day;
    }

    private void setHour(int hour) {
        if (hour < 0 || hour > 23) {
            throw new IllegalArgumentException("Hour must be in range [0, 23]");
        }
        this.hour = hour;
    }

    private void setMinute(int minute) {
        if (minute < 0 || minute > 59) {
            throw new IllegalArgumentException("Minute must be in range [0, 59]");
        }
        this.minute = minute;
    }

    private void setSecond(int second) {
        if (second < 0 || second > 59) {
            throw new IllegalArgumentException("Second must be in range [0, 59]");
        }
        this.second = second;
    }

    public boolean isLeapYear(int year) {
        if (year < 0) {
            throw new IllegalArgumentException("Year cannot be negative");
        }
        return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
    }

    public int daysInMonth(int month) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Month must be in range [1, 12]");
        }
        if (IntStream.of(4, 6, 9, 11).anyMatch(m -> m == month)) {
            return 30;
        }
        if (month == 2) {
            return isLeapYear(getYear()) ? 29 : 28;
        }
        return 31;
    }

    @Override
    public String toString() {
        return "MyDateAndTime{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                ", hour=" + hour +
                ", minute=" + minute +
                ", second=" + second +
                '}';
    }
}
