package ua.practice.unit7.handlers;

import ua.practice.unit7.date_time.Date;
import ua.practice.unit7.date_time.Months;
import ua.practice.unit7.date_time.Time;

public class DateHandler {

    public static DateTime addToDate(DateTime dateTime1, DateTime dateTime2) {
        long result1 = convertToSeconds(dateTime1);
        long result2 = convertToSeconds(dateTime2);
        long res = Math.abs(result1 + result2);
        int numOfLeapsBetweenDates = calculateNumOfLeaps(dateTime1.getDate().getYear().getYear() + dateTime2.getDate().getYear().getYear());
        return processResults2(res, numOfLeapsBetweenDates);
    }

    public static DateTime subFromDate(DateTime dateTime1, DateTime dateTime2) {
        long result1 = convertToSeconds(dateTime1);
        long result2 = convertToSeconds(dateTime2);
        long res = Math.abs(result1 - result2);
        int numOfLeapsBetweenDates = calculateNumOfLeaps(dateTime1.getDate().getYear().getYear() - dateTime2.getDate().getYear().getYear());
        return processResults2(res, numOfLeapsBetweenDates);
    }

    public static DateTime differenceBetweenDates(DateTime dateTime1, DateTime dateTime2) {
        long result1 = convertToSeconds(dateTime1);
        long result2 = convertToSeconds(dateTime2);
        int numOfLeapsBetweenDates = calculateNumOfLeaps(dateTime1.getDate().getYear().getYear() - dateTime2.getDate().getYear().getYear());
        long res = Math.abs(result2 - result1);
        return processResults2(res, numOfLeapsBetweenDates);
    }

    private static long convertToSeconds(DateTime dateTime) {
        Time timeOfDay = dateTime.getTimeOfDay();
        long res = 0L;
        res += timeOfDay.getSeconds();
        res += (timeOfDay.getMinutes() * 60);
        res += (timeOfDay.getHours() * 60 * 60);
        Date date = dateTime.getDate();
        res += (date.getDay() * 24 * 60 * 60);

        for (Months months : Months.values()) {
            if (months.getMonthNumber() == 2 && date.getYear().isLeap() && months.getMonthNumber() < date.getMonth().getMonthNumber()) {
                res += ((months.getNumberOfDays() + 1) * 24 * 60 * 60);
            } else if (months.getMonthNumber() <= date.getMonth().getMonthNumber()) {
                res += (months.getNumberOfDays() * 24 * 60 * 60);
            }
        }

        for (int i = 0; i < date.getYear().getYear(); ++i) {
            if (i % 400 == 0 || i % 4 == 0 && i % 100 != 0) {
                res += 31622400L; // w leap day
            } else {
                res += 31536000L; // w/o leap day
            }
        }

        System.out.println(res);
        return res;
    }

    private static int calculateNumOfLeaps(int years) {
        int result = 0;

        for (int i = 0; i <= Math.abs(years); ++i) {
            if (i % 400 == 0 || i % 4 == 0 && i % 100 != 0) {
                ++result;
            }
        }

        return result;
    }

    private static DateTime processResults2(long seconds, int numOfLeapsBetweenDates) {
        long minutes;
        for (minutes = 0L; seconds > 59L; seconds %= 60L) {
            minutes = seconds / 60L;
        }

        long hours;
        for (hours = 0L; minutes > 59L; minutes %= 60L) {
            hours = minutes / 60L;
        }

        long days;
        for (days = 0L; hours > 23L; hours %= 24L) {
            days = hours / 24L;
        }

        days -=  numOfLeapsBetweenDates;
        long months = 0L;
        boolean cond = true;

            while (cond) {
                for (Months months1 : Months.values()) {
                    if (days < months1.getNumberOfDays()) {
                        cond = false;
                        break;
                    }
                    days -= months1.getNumberOfDays();
                    months++;
                }
            }

            long years = 0L;
            years = months / 12L;
            months %= 12L;

            return new DateTime(years, months, days, hours, minutes, seconds);
    }
}
