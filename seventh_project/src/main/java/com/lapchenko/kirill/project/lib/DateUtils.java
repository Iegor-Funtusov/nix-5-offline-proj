package com.lapchenko.kirill.project.lib;

public class DateUtils {
    public void addYears(Date date, int years) {
        date.setYear(date.getYear() + years);
    }

    public static long convertDateToSeconds(Date date) {
        long seconds = 0;
        seconds += convertYearsToSeconds(date.getYear());
        seconds += convertMonthsToSeconds(date.getMonth(), DateParser.isLeapYear(date.getYear()));
        seconds += convertDaysToSeconds(date.getDay());
        seconds += convertHoursToSeconds(date.getHours());
        seconds += convertMinutesToSeconds(date.getMinutes());
        seconds += date.getSeconds();
        return seconds;
    }

    public static Date convertSecondsToDate(long seconds) {
        int year = (int) (seconds / (365.25 * 24 * 60 * 60));
        seconds = seconds % convertYearsToSeconds(1);
        int month = 0;
        int i = 0;
        MonthInfo[] months = MonthInfo.values();
        while (true) {
            if (i == 12 || (seconds - months[i].value() * 24 * 60 * 60) < 0) {
                break;
            }
            if (i == 1 && DateParser.isLeapYear(year)) {
                seconds -= (months[i].value() + 1) * 24 * 60 * 60;
                i++;
                month++;
                continue;
            }
            seconds -= months[i].value() * 24 * 60 * 60;
            month++;
            i++;
        }
        int days = (int) (seconds / (24 * 60 * 60));
        seconds = seconds % (24 * 60 * 60);
        int hours = (int) (seconds / (60 * 60));
        seconds = seconds % (60 * 60);
        int minutes = (int) (seconds / 60);
        seconds = seconds % 60;
        return new Date(year, month + 1, days, hours, minutes, (int) seconds);
    }

    public static long convertSecondsToMinutes(long seconds) {
        return (seconds / 60);
    }

    public static long convertSecondsToHours(long seconds) {
        return seconds / 3600;
    }

    public static long convertSecondsToDays(long seconds) {
        return seconds / (3600 * 24);
    }

    public static long convertSecondsToMonths(long seconds) {
        long year = convertSecondsToYear(seconds);
        long month = 0;
        int i = 0;
        MonthInfo[] months = MonthInfo.values();
        while (true) {
            if ((seconds - months[i].value() * 24 * 60 * 60) < 0) {
                break;
            }
            if (i == 1 && DateParser.isLeapYear(year)) {
                seconds -= (months[i].value() + 1) * 24 * 60 * 60;
                i++;
                month++;
                continue;
            }
            seconds -= months[i].value() * 24 * 60 * 60;
            month++;
            i++;
        }
        return month;
    }

    public static long convertSecondsToYear(long seconds) {
        return (long) (seconds / (365.25 * 24 * 60 * 60));
    }

    public static long convertYearsToSeconds(int year) {
        return (long) (year * 365.25 * 24 * 60 * 60);
    }

    public static long convertMonthsToSeconds(int month, boolean isLeap) {
        long seconds = 0;
        MonthInfo[] months = MonthInfo.values();
        for (int i = 0; i < month - 1; i++) {
            seconds += months[i].value() * 24 * 60 * 60;
            if (i == 4 * 12) {
                seconds += 24 * 60 * 60;
            }
        }
        return seconds;
    }

    public static long convertDaysToSeconds(int days) {
        return days * 24 * 60 * 60;
    }

    public static long convertHoursToSeconds(int hours) {
        return hours * 60 * 60;
    }

    public static long convertMinutesToSeconds(int minutes) {
        return minutes * 60;
    }

}
