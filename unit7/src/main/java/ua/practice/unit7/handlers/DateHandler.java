package ua.practice.unit7.handlers;

import ua.practice.unit7.date_time.Date;
import ua.practice.unit7.date_time.Months;
import ua.practice.unit7.date_time.Time;

public class DateHandler {
    private final DateTime dateTime1;
    private final DateTime dateTime2;
    private DateTime resultDateTime;

    public DateHandler(DateTime dateTime1, DateTime dateTime2) {
        this.dateTime1 = dateTime1;
        this.dateTime2 = dateTime2;
    }

    public DateTime addToDate() {
        long result1 = convertToSeconds(dateTime1);
        long result2 = convertToSeconds(dateTime2);
        long res = Math.abs(result1 + result2);
        int numOfLeapsBetweenDates = calculateNumOfLeaps(dateTime1.getDate().getYear().getYear() + dateTime2.getDate().getYear().getYear());
        this.processResults2(res, numOfLeapsBetweenDates);
        resultDateTime = new DateTime(new Date(), new Time());
        return resultDateTime;
    }

    public void subFromDate() {
        long result1 = convertToSeconds(dateTime1);
        long result2 = convertToSeconds(dateTime2);
        long res = Math.abs(result1 - result2);
        int numOfLeapsBetweenDates = calculateNumOfLeaps(dateTime1.getDate().getYear().getYear() - dateTime2.getDate().getYear().getYear());
        processResults2(res, numOfLeapsBetweenDates + 2);
        System.out.println(resultDateTime);
    }

    public void differenceBetweenDates() {
        long result1 = convertToSeconds(dateTime1);
        long result2 = convertToSeconds(dateTime2);
        int numOfLeapsBetweenDates = calculateNumOfLeaps(dateTime1.getDate().getYear().getYear() - dateTime2.getDate().getYear().getYear());
        long res = Math.abs(result2 - result1);
        processResults2(res, numOfLeapsBetweenDates);
    }

    private long convertToSeconds(DateTime dateTime) {
        Time timeOfDay = dateTime.getTimeOfDay();
        long res = 0L;
        res += (long) timeOfDay.getSeconds();
        res += (long) (timeOfDay.getMinutes() * 60);
        res += (long) (timeOfDay.getHours() * 60 * 60);
        Date date = dateTime.getDate();
        res += (long) (date.getDay() * 24 * 60 * 60);

        for (Months months : Months.values()) {
            if (months.getMonthNumber() == 2 && date.getYear().isLeap() && months.getMonthNumber() < date.getMonth().getMonthNumber()) {
                res += (long) ((months.getNumberOfDays() + 1) * 24 * 60 * 60);
            } else if (months.getMonthNumber() <= date.getMonth().getMonthNumber()) {
                res += (long) (months.getNumberOfDays() * 24 * 60 * 60);
            }
        }

        for (int i = 0; i < date.getYear().getYear(); ++i) {
            if (i % 400 == 0 || i % 4 == 0 && i % 100 != 0) {
                res += 31622400L;
            } else {
                res += 31536000L;
            }
        }

        System.out.println(res);
        return res;
    }

    private int calculateNumOfLeaps(int years) {
        int result = 0;

        for (int i = 0; i < Math.abs(years); ++i) {
            if (i % 400 == 0 || i % 4 == 0 && i % 100 != 0) {
                ++result;
            }
        }

        return result - 1;
    }

    private void processResults2(long seconds, int numOfLeapsBetweenDates) {
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

        days -= (long) numOfLeapsBetweenDates;
        long months = 0L;
        boolean cond = true;

        while (true) {
            while (cond) {
                for (Months months1 : Months.values()) {
                    if (days < 31L) {
                        cond = false;
                        break;
                    }
                    days -= (long) months1.getNumberOfDays();
                    months++;
                }
            }

            long years = 0L;
            years = months / 12L;
            months %= 12L;
            System.out.println("years = " + years);
            System.out.println("months = " + months);
            System.out.println("days = " + days);
            System.out.println("hours = " + hours);
            System.out.println("minutes = " + minutes);
            System.out.println("seconds = " + seconds);
            return;
        }
    }
}
