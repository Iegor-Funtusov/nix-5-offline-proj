package com.nix.hw.exceptions;

public class Date implements Comparable<Date>{

    private int second;
    private int minute;
    private int hour;

    private int day;
    private int month;
    private int year;

    private final long SECONDS_IN_YEAR   = 31540596L;
    private final long SECONDS_IN_MONTH  = 2629743L;
    private final long SECONDS_IN_DAY    = 86400L;
    private final long SECONDS_IN_HOUR   = 3600L;
    private final long SECONDS_IN_MINUTE = 60L;

    private final float  DAYS_IN_MONTH = 30.4211f;

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        if (second >= 0 && second < 60)
            this.second = second;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        if (minute >= 0 && minute < 60)
            this.minute = minute;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        if (hour >= 0 && hour < 24)
            this.hour = hour;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        if (day >= 1 && day <= 31)
            this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if (month >= 1 && month <= 12)
            this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year >= 0)
            this.year = year;
    }

    public long findDiffInSec(Date date) {
        return Math.abs(this.convertDateInSec() - date.convertDateInSec());
    }

    public long findDiffInMins(Date date) {
        return Math.abs(this.convertDateInMins() - date.convertDateInMins());
    }

    public long findDiffInHours(Date date) {
        return Math.abs(this.convertDateInHours() - date.convertDateInHours());
    }

    public int findDiffInYears(Date date) {
        return Math.abs(this.year - date.year);
    }

    public int findDiffInMonths(Date date) {
        return Math.abs(this.convertDateInMonths() - date.convertDateInMonths());
    }

    public int findDiffInDays(Date date) {
        return Math.abs(this.convertDateInDays() - date.convertDateInDays());
    }

    public void addSeconds(int seconds){
        addMinutes(seconds / 60);
        this.second += seconds % 60;
    }

    public void addMinutes(int mins) {
        addHours(mins / 60);
        this.minute += mins % 60;
    }

    public void addHours(int hours) {
        addDays(hours / 24);
        this.hour += hours % 24;
    }

    public void addYears(int years) {
        this.year+=years;
    }

    public void addMonths(int months) {
        addYears(months / 12);
        this.month += months % 12;
    }

    public void addDays(int days) {
        for (int i = 1; i <= days; i++) {
            this.day++;
            if (this.day > getDaysInMonth(this.month)) {
                this.day = 1;
                month++;
            }
            if (month > 12) {
                month = 1;
                year++;
            }
        }
    }

    public void subtractSeconds(int seconds){
        subtractMinutes(seconds / 60);
        int sDifference = this.second - seconds % 60;
        if (sDifference < 0) {
            subtractMinutes(1);
            this.second = 60 - Math.abs(sDifference);
        }
        this.second -= seconds % 60;
    }

    public void subtractMinutes(int mins) {
        subtractHours(mins / 60);
        int mDifference = this.minute - mins % 60;
        if (mDifference < 0) {
            subtractHours(1);
            this.minute = 60 - Math.abs(mDifference);
            return;
        }
        this.minute -= mins % 60;
    }

    public void subtractHours(int hours) {
        subtractDays(hours / 24);
        int hDifference = this.hour - hours % 24;
        if (hDifference < 0) {
            subtractDays(1);
            this.hour = 24 - Math.abs(hDifference);
            return;
        }
        this.hour -= hours % 24;
    }

    public void subtractYears(int years) {
        this.year-=years;
    }

    public void subtractMonths(int months) {
        subtractYears(months / 12);
        this.month -= months % 12;
    }

    public void subtractDays(int days) {
        int prevMonth;
        for (int i = 1; i <= days; i++) {
            prevMonth = month - 1;
            if (prevMonth == 0) prevMonth = 12;
            this.day--;
            if (this.day < 1) {
                this.day = getDaysInMonth(prevMonth);
                month--;
            }
            if (month < 1) {
                month = 12;
                year--;
            }
        }
    }

    public long convertDateInSec() {
        return convertDateInMins() * 60L;
    }

    public long convertDateInMins() {
        return convertDateInHours() * 60L;
    }

    public long convertDateInHours() {
        return convertDateInDays() * 24L;
    }

    public int convertDateInDays() {
        return (int) (convertDateInMonths()*DAYS_IN_MONTH);
    }

    public int convertDateInMonths() {
        return year * 12 + month;
    }

    private long minToSec(int mins) {
        return mins * SECONDS_IN_MINUTE;
    }

    private long hourToSec(int hours) {
        return hours * SECONDS_IN_HOUR;
    }

    private long dayToSec(int days) {
        return days * SECONDS_IN_DAY;
    }

    private long monthToSec(int months) {
        return months * SECONDS_IN_MONTH;
    }

    private long yearToSec(int years) {
        return years * SECONDS_IN_YEAR;
    }

    public int getDaysInMonth(int month) {
        int daysInMonth = 28;
        if (month == 4 || month == 6 || month == 9 || month == 11) daysInMonth = 30;
        if (month == 1 || month == 3 || month == 5
                || month == 7 || month == 8 || month == 10 || month == 12) daysInMonth = 31;
        if (month == 2 && year % 4 == 0) daysInMonth = 29;
        return daysInMonth;
    }

    @Override
    public String toString() {
        return "Date{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                ", hour=" + hour +
                ", minute=" + minute +
                ", second=" + second +
                '}';
    }


    @Override
    public int compareTo(Date o) {
        int compare = this.getYear()-o.getYear();
        if (compare == 0) compare = this.getMonth()-o.getMonth();
        if (compare == 0) compare = this.getDay()-o.getDay();
        if (compare == 0) compare = this.getHour()-o.getHour();
        if (compare == 0) compare = this.getMinute()-o.getMinute();
        if (compare == 0) compare = this.getSecond()-o.getSecond();
        return compare;
    }
}
