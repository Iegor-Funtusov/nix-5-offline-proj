package com.lapchenko.kirill.project.lib;

public class DateParser {

    private int century = 1900;
    private MonthInfo[] monthInfos = MonthInfo.values();

    public Date parseDD_MM_YY(String date) {
        if (date.matches(DateRegex.DD_MM_YY.value())) {
            int month = Integer.parseInt(date.substring(3, 5));
            int day = Integer.parseInt(date.substring(0, 2));
            int year = century + Integer.parseInt(date.substring(6, 8));
            if (isDateValid(month, day, year))
                return new Date(year, month, day, 0, 0, 0);
        }
        throw new IllegalArgumentException("Wrong format");
    }

    public Date parseD_M_YYYY(String date) {
        if (date.matches(DateRegex.D_M_YYYY.value())) {
            String[] dates = date.split("/");
            int day = Integer.parseInt(dates[0]);
            int month = Integer.parseInt(dates[1]);
            int year = Integer.parseInt(dates[2]);
            if (isDateValid(month, day, year))
                return new Date(year, month, day, 0, 0, 0);
        }
        throw new IllegalArgumentException();
    }

    public Date parseMMM_D_YY(String date) {
        if (date.matches(DateRegex.MMM_D_YY.value())) {
            String[] dates = date.split("-");
            int day = Integer.parseInt(dates[1]);
            int month = MonthInfo.getMonthNumber(dates[0]);
            int year = century + Integer.parseInt(dates[2]);
            if (isDateValid(month, day, year)) {
                return new Date(year, month, day, 0, 0, 0);
            }
        }
        throw new IllegalArgumentException();
    }

    public Date parseDD_MMM_YYYY_HH_MM(String date) {
        if (date.matches(DateRegex.DD_MMM_YYYY_HH_MM.value())) {
            String[] dates = date.split("(-)|( )|(:)");
            int day = Integer.parseInt(dates[0]);
            int month = MonthInfo.getMonthNumber(dates[1]);
            int year = Integer.parseInt(dates[2]);
            int hours = Integer.parseInt(dates[3]);
            int minutes = Integer.parseInt(dates[4]);
            if (isDateValid(month, day, year) && isHoursValid(hours, minutes, 0)) {
                return new Date(year, month, day, hours, minutes, 0);
            }
        }
        throw new IllegalArgumentException("Something wrong with your date: " + date);
    }

    public Date parseM_YY_HH_MM_SS(String date) {
        if (date.matches(DateRegex.M_YY_HH_MM_SS.value())) {
            String[] dates = date.split("(/)|( )|(:)");
            int day = 1;
            int month = Integer.parseInt(dates[1]);
            int year = century + Integer.parseInt(dates[2]);
            int hours = Integer.parseInt(dates[3]);
            int minutes = Integer.parseInt(dates[4]);
            int seconds = Integer.parseInt(dates[5]);
            if (isDateValid(day, month, year) && isHoursValid(hours, minutes, seconds)) {
                return new Date(year, month, day, hours, minutes, seconds);
            }
        }
        throw new IllegalArgumentException("Something wrong with your date: " + date);
    }

    public Date parseM(String date) {
        if (date.matches(DateRegex.M.value())) {
            String[] dates = date.split("(/)");
            int month = Integer.parseInt(dates[1]);
            if (isDateValid(1, month, 2021)) {
                return new Date(2021, month, 1, 0, 0, 0);
            }
        }
        throw new IllegalArgumentException("Something wrong with your date: " + date);
    }

    public Date parseYYYY_HH_MM(String date) {
        if (date.matches(DateRegex.YYYY_HH_MM.value())) {
            String[] dates = date.split("( )|(:)");
            int year = Integer.parseInt(dates[0]);
            int hours = Integer.parseInt(dates[1]);
            int minutes = Integer.parseInt(dates[2]);
            if (isDateValid(1, 1, year) && isHoursValid(hours, minutes, 0)) {
                return new Date(year, 1, 1, hours, minutes, 0);
            }
        }
        throw new IllegalArgumentException("Something wrong with your date " + date);
    }

    private boolean isDateValid(int month, int day, int year) {
        if (isLeapYear(year)) {
            if (month == 1 && day <= 29 && day > 0) {
                return true;
            }
        }
        if (day <= monthInfos[month-1].value()) {
            return true;
        }
        return false;
    }

    private boolean isHoursValid(int hours, int minutes, int seconds) {
        if ((hours >= 0 && hours <= 23) &&
                (minutes >= 0 && minutes <= 59) &&
                (seconds >= 0 && seconds <= 59)
        ) return true;
        return false;
    }

    public static boolean isLeapYear(long year) {
        if (year % 400 == 0)
            return true;
        if (year % 100 == 0)
            return false;
        if (year % 4 == 0)
            return true;
        return false;
    }
}
