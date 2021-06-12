package ua.practice.unit7.util;

import ua.practice.unit7.date_time.Date;
import ua.practice.unit7.date_time.DateTime;
import ua.practice.unit7.date_time.Months;
import ua.practice.unit7.date_time.Time;

public class DateTimeUtil {

    public static DateTime addToDate(DateTime dateTime, int[] dateTimeToAdd) {
        checkIfDateTimeValid(dateTimeToAdd);
        int[] convertedDateTime = convertDateTimeToArray(dateTime);
        for (int i = 0; i < convertedDateTime.length; i++) {
            convertedDateTime[i] += dateTimeToAdd[i];
        }
        long seconds = convertToSeconds(convertedDateTime);
        int[] resArray = convertToDateArray(seconds);
        subYearAddMonths(resArray);
        subMonthAddDays(resArray);
        return convertToDateTime(resArray);
    }

    public static DateTime subDate(DateTime dateTime, int[] dateTimeToSub) {
        checkIfDateTimeValid(dateTimeToSub);
        int[] convertedDateTime = convertDateTimeToArray(dateTime);
        correctDateTimeArray(convertedDateTime, dateTimeToSub);
        long seconds = convertToSeconds(convertedDateTime);
        int[] resArray = convertToDateArray(seconds);
        return convertToDateTime(resArray);
    }

    public static int[] differenceBetweenDates(DateTime dateTime1, DateTime dateTime2) {
        int[] convertedDateTime2 = convertDateTimeToArray(dateTime2);
        DateTime res = subDate(dateTime1, convertedDateTime2);
        return convertDateTimeToArray(res);
    }

    private static void checkIfDateTimeValid(int[] dateTime) {
        for (int i = 0; i < 6; i++) {
            if (dateTime[i] < 0)
                throw new IllegalArgumentException("Invalid values input");
        }
    }

    private static void correctDateTimeArray(int[] convertedDateTime, int[] dateTimeToSub) {
        for (int i = 0; i < convertedDateTime.length; i++) {
            convertedDateTime[i] -= dateTimeToSub[i];
        }
        subYearAddMonths(convertedDateTime);
        subMonthAddDays(convertedDateTime);
    }

    private static void subYearAddMonths(int[] dayTime) {
        while (dayTime[4] <= 0) {
            dayTime[4] += 12;
            dayTime[5]--;
        }
        if (dayTime[5] < 0)
            throw new IllegalArgumentException("Incorrect input for operation Sub");
    }

    private static void subMonthAddDays(int[] dayTime) {
        while (dayTime[3] < 0) {
            if (dayTime[4] == 1) {
                dayTime[4] = 0;
                subYearAddMonths(dayTime);
                dayTime[4] = 13;
            }
            int monthDays = Months.getMonth(dayTime[4] - 1).getNumberOfDays();
            dayTime[3] += monthDays;
            dayTime[4]--;
        }
    }

    private static boolean isCurrentYearLeap(int year) {
        return year % 400 == 0 || year % 4 == 0 && year % 100 != 0;
    }

    public static int[] convertDateTimeToArray(DateTime dateTime) {
        int[] convertedDateTime = new int[6];
        convertedDateTime[0] = dateTime.getTime().getSeconds();
        convertedDateTime[1] = dateTime.getTime().getMinutes();
        convertedDateTime[2] = dateTime.getTime().getHours();
        convertedDateTime[3] = dateTime.getDate().getDay();
        convertedDateTime[4] = dateTime.getDate().getMonth().getMonthNumber();
        convertedDateTime[5] = dateTime.getDate().getYear();
        return convertedDateTime;
    }

    public static long convertToSeconds(int[] dateTime) {
        long res = 0L;
        long days = 0L;
        res += dateTime[0];
        res += dateTime[1] * 60;
        res += dateTime[2] * 60 * 60;
        days += dateTime[3];

        int j = 0;
        if (dateTime[4] != 0) {
            while (j != dateTime[4] - 1) {
                for (Months months : Months.values()) {
                    if (j == dateTime[4] - 1)
                        break;
                    days += months.getNumberOfDays();
                    j++;
                }
            }
        }
        for (int i = 2; i <= dateTime[5]; i++) {
            if (isCurrentYearLeap(i)) {
                days += 366;
                continue;
            }
            days += 365;
        }

        if (isCurrentYearLeap(dateTime[5]) && dateTime[4] <= 2) {
            days--;
        }

        res += days * 24 * 60 * 60;
        return res;
    }

    public static int[] convertToDateArray(long timeInSeconds) {
        int[] convertedDateTime = new int[6];
        long minutes;
        for (minutes = 0L; timeInSeconds > 59L; timeInSeconds %= 60L) {
            minutes = timeInSeconds / 60L;
        }

        long hours;
        for (hours = 0L; minutes > 59L; minutes %= 60L) {
            hours = minutes / 60L;
        }

        long days;
        for (days = 0L; hours > 23L; hours %= 24L) {
            days = hours / 24L;
        }

        long years = 0L;

        while (days > 366) {
            days -= 365;
            years++;
        }

        for (int i = 1; i <= years; i++) {
            if (i % 400 == 0 || i % 4 == 0 && i % 100 != 0) {
                days--;
            }
        }

        long months = 0L;
        boolean cond = true;

        while (cond) {
            for (Months months1 : Months.values()) {
                int numberOfDays = months1.getNumberOfDays();
                if (isCurrentYearLeap((int) (years + 1)) && months1 == Months.FEBRUARY)
                    numberOfDays++;
                if (days <= numberOfDays) {
                    cond = false;
                    break;
                }
                days -= numberOfDays;
                months++;
            }
        }

        convertedDateTime[0] = (int) timeInSeconds;
        convertedDateTime[1] = (int) minutes;
        convertedDateTime[2] = (int) hours;
        convertedDateTime[3] = (int) days;
        convertedDateTime[4] = (int) ++months;
        convertedDateTime[5] = (int) ++years;
        return convertedDateTime;
    }

    private static DateTime convertToDateTime(int[] dateTime) {
        Date date = new Date(dateTime[3], dateTime[4], dateTime[5]);
        Time time = new Time(dateTime[0], dateTime[1], dateTime[2]);
        return new DateTime(date, time);
    }
}
