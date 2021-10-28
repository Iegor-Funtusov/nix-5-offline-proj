package org.example.mydateandtime;

import java.util.Objects;
import java.util.stream.IntStream;

public class MyDateAndTime implements Comparable<MyDateAndTime> {
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

    public MyDateAndTime addYears(int years) {
        MyDateAndTime result = new MyDateAndTime(this);
        try {
            result.setYear(result.getYear() + years);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Result of subtraction cannot be negative", e);
        }
        return result;
    }

    public MyDateAndTime addMonths(int months) {
        int plusOrMinus = months > 0 ? 1 : -1;

        MyDateAndTime result = new MyDateAndTime(this);
        int years = months / 12;
        int remainingMonths = months % 12;

        result = result.addYears(years);
        try {
            result.setMonth(result.getMonth() + remainingMonths);
        } catch (IllegalArgumentException e) {
            result.setYear(result.getYear() + plusOrMinus * 1);
            result.setMonth((result.getMonth() + remainingMonths) - plusOrMinus * 12);
        }

        return result;
    }

    public MyDateAndTime addDays(int days) {
        int plusOrMinus = days > 0 ? 1 : -1;

        MyDateAndTime result = new MyDateAndTime(this);
        for (int i = 0; i < Math.abs(days); i++) {
            try {
                result.setDay(result.getDay() + plusOrMinus * 1);
            } catch (IllegalArgumentException e) {
                try {
                    result.setDay(1);
                    result.setMonth(result.getMonth() + plusOrMinus * 1);
                    if (plusOrMinus < 0) {
                        result.setDay(daysInMonth(result.getMonth(), result.getYear()));
                    }
                } catch (IllegalArgumentException e2) {
                    result.setYear(result.getYear() + plusOrMinus * 1);
                    result.setMonth(plusOrMinus > 0 ? 1 : 12);
                    result.setDay(plusOrMinus > 0 ? 1 : daysInMonth(result.getMonth(), result.getYear()));
                }
            }
        }

        return result;
    }

    public MyDateAndTime addHours(int hours) {
        int plusOrMinus = hours > 0 ? 1 : -1;

        MyDateAndTime result = new MyDateAndTime(this);
        int days = hours / 24;
        int remainingHours = hours % 24;
        result = result.addDays(days);
        try {
            result.setHour(result.getHour() + remainingHours);
        } catch (IllegalArgumentException e) {
            result = result.addDays(plusOrMinus * 1);
            result.setHour(result.getHour() + remainingHours - plusOrMinus * 24);
        }
        return result;
    }

    public MyDateAndTime addMinutes(int minutes) {
        int plusOrMinus = minutes > 0 ? 1 : -1;

        MyDateAndTime result = new MyDateAndTime(this);
        int hours = minutes / 60;
        int remainingMinutes = minutes % 60;
        result = result.addHours(hours);
        try {
            result.setMinute(result.getMinute() + remainingMinutes);
        } catch (IllegalArgumentException e) {
            result = result.addHours(plusOrMinus * 1);
            result.setMinute(result.getMinute() + remainingMinutes - plusOrMinus * 60);
        }

        return result;
    }

    public MyDateAndTime addSeconds(int seconds) {
        int plusOrMinus = seconds > 0 ? 1 : -1;

        MyDateAndTime result = new MyDateAndTime(this);
        int minutes = seconds / 60;
        int remainingSeconds = seconds % 60;
        result = result.addMinutes(minutes);
        try {
            result.setSecond(result.getSecond() + remainingSeconds);
        } catch (IllegalArgumentException e) {
            result = result.addMinutes(plusOrMinus * 1);
            result.setSecond(result.getSecond() + remainingSeconds - plusOrMinus * 60);
        }

        return result;
    }

    public int diffInYears(MyDateAndTime dateAndTime) {
        if (this.equals(dateAndTime)) {
            return 0;
        }
        MyDateAndTime bigger = this.compareTo(dateAndTime) >= 0 ? this : dateAndTime;
        MyDateAndTime smaller = bigger == this ? dateAndTime : this;

        return bigger.addYears(-smaller.getYear()).getYear();
    }

    public int diffInMonths(MyDateAndTime dateAndTime) {
        if (this.equals(dateAndTime)) {
            return 0;
        }
        MyDateAndTime bigger = this.compareTo(dateAndTime) >= 0 ? this : dateAndTime;
        MyDateAndTime smaller = bigger == this ? dateAndTime : this;

        MyDateAndTime resultDate = bigger.addMonths(-(smaller.getMonth() + smaller.getYear() * 12));
        return resultDate.getYear() * 12 + resultDate.getMonth();
    }

    public int diffInDays(MyDateAndTime dateAndTime) {
        return diffInHours(dateAndTime) / 24;
    }

    public int diffInHours(MyDateAndTime dateAndTime) {
        return diffInMinutes(dateAndTime) / 60;
    }

    public int diffInMinutes(MyDateAndTime dateAndTime) {
        return ((int) (diffInSeconds(dateAndTime) / 60));
    }

    public long diffInSeconds(MyDateAndTime dateAndTime) {
        return Math.abs(this.secondsFromZero() - dateAndTime.secondsFromZero());
    }

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
        if (daysInMonth(month, getYear()) < getDay()) {
            throw new IllegalArgumentException("To many days for this month");
        }
        this.month = month;
    }

    private void setDay(int day) {
        if (day <= 0) {
            throw new IllegalArgumentException("Days must be a positive number");
        }
        if (day > daysInMonth(getMonth(), getYear())) {
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

    public int daysInMonth(int month, int year) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Month must be in range [1, 12]");
        }
        if (IntStream.of(4, 6, 9, 11).anyMatch(m -> m == month)) {
            return 30;
        }
        if (month == 2) {
            return isLeapYear(year) ? 29 : 28;
        }
        return 31;
    }

    public long secondsFromZero() {
        long result = 0;
        for (int i = 0; i < getYear(); i++) {
            result += isLeapYear(i) ? 366 * 86400L : 365 * 86400L;
        }
        for (int i = 1; i < getMonth(); i++) {
            result += daysInMonth(i, getYear()) * 86400L;
        }
        result += (getDay() - 1) * 86400L + getHour() * 3600L + getMinute() * 60L + getSecond();

        return result;
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

    @Override
    public int compareTo(MyDateAndTime o) {

        int cmp = this.year - o.getYear();
        if (cmp == 0) {
            cmp = this.month - o.getMonth();
            if (cmp == 0) {
                cmp = this.day - o.getDay();
                if (cmp == 0) {
                    cmp = this.hour - o.getHour();
                    if (cmp == 0) {
                        cmp = this.minute - o.getMinute();
                        if (cmp == 0) {
                            cmp = this.second - o.getSecond();
                        }
                    }
                }
            }
        }
        return cmp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MyDateAndTime that = (MyDateAndTime) o;
        return year == that.year && month == that.month && day == that.day && hour == that.hour && minute == that.minute && second == that.second;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, month, day, hour, minute, second);
    }
}
