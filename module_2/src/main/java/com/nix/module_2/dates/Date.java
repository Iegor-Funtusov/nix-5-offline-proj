package com.nix.module_2.dates;

public class Date {

    private int year;
    private int month;
    private int day;

    private String dateString;

    public Date(int y, int m, int d) {
        setYear(y);
        setMonth(m);
        setDay(d);

        String mStr = String.valueOf(m);
        String dStr = String.valueOf(d);

        if (mStr.length() == 1) {
            mStr = "0" + mStr;
        }
        if (dStr.length() == 1) {
            dStr = "0" + dStr;
        }
        dateString = Integer.toString(year) + mStr + dStr;
    }

    public void setDay(int day) {
        if (day >= 1 && day <= getDaysInMonth(month))
            this.day = day;
        else
            throw new DateException();
    }

    public void setMonth(int month) {
        if (month >= 1 && month <= 12)
            this.month = month;
        else
            throw new DateException();
    }

    public void setYear(int year) {
        if (year >= 0)
            this.year = year;
        else
            throw new DateException();
    }

    private int getDaysInMonth(int month) {
        int daysInMonth = 28;
        if (month == 4 || month == 6 || month == 9 || month == 11) daysInMonth = 30;
        if (month == 1 || month == 3 || month == 5
                || month == 7 || month == 8 || month == 10 || month == 12) daysInMonth = 31;
        if (month == 2 && year % 4 == 0) daysInMonth = 29;
        return daysInMonth;
    }

    @Override
    public String toString() {
        return dateString;
    }
}
