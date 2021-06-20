package com.lapchenko.kirill.project.app;

import com.lapchenko.kirill.project.lib.Date;
import com.lapchenko.kirill.project.lib.DateUtils;

public class UserDateService {

    public static int differenceInYear(Date date1, Date date2){
        return Math.abs(date1.getYear() - date2.getYear());
    }

    public static int differenceInMonths(Date date1, Date date2) {
        int difference = differenceInYear(date1, date2)*12;
        difference += Math.abs(date1.getMonth() - date2.getMonth());
        return difference;
    }

    public static int differenceInDays(Date date1, Date date2) {
        long d1Seconds = DateUtils.convertDateToSeconds(date1);
        long d2Seconds = DateUtils.convertDateToSeconds(date2);
        return (int) Math.abs(DateUtils.convertSecondsToDays(d1Seconds) - DateUtils.convertSecondsToDays(d2Seconds));
    }

    public static int differenceInHours(Date date1, Date date2) {
        int difference = differenceInDays(date1, date2)*24;
        difference += Math.abs(date1.getHours()-date2.getHours());
        return difference;
    }

    public static int differenceInMinutes(Date date1, Date date2) {
        int difference = differenceInHours(date1, date2)*60;
        difference += Math.abs(date1.getMinutes() - date2.getMinutes());
        return difference;
    }

    public static long differenceInSeconds(Date date1, Date date2) {
        int difference = differenceInMinutes(date1, date2) * 60;
        difference += Math.abs(date1.getSeconds() - date2.getSeconds());
        return difference;
    }

    public static Date subtractYear(Date date, int years) {
        date.setYear(date.getYear() - years);
        return date;
    }

    public static Date subtractMonth(Date date, int months) {

        int years = months/12;
        subtractYear(date, years);
        date.setMonth(Math.abs(date.getMonth() - months%12));
        return date;
    }

    public static Date subtractDay(Date date, int days) {
        long secondsInDate = DateUtils.convertDateToSeconds(date);
        long secondsInDays = DateUtils.convertDaysToSeconds(days);
        return DateUtils.convertSecondsToDate(secondsInDate - secondsInDays);
    }

    public static Date subtractHours(Date date, int hours) {
        long secondsInDate = DateUtils.convertDateToSeconds(date);
        long secondsInHours = DateUtils.convertHoursToSeconds(hours);
        return DateUtils.convertSecondsToDate(secondsInDate - secondsInHours);
    }

    public static Date subtractMinutes(Date date, int minutes) {
        long secondsInDate = DateUtils.convertDateToSeconds(date);
        long secondsInMinutes = DateUtils.convertMinutesToSeconds(minutes);
        return DateUtils.convertSecondsToDate(secondsInDate - secondsInMinutes);
    }

    public static Date subtractSeconds(Date date, int seconds) {
        long secondsInDate = DateUtils.convertDateToSeconds(date);
        return DateUtils.convertSecondsToDate(secondsInDate - seconds);
    }

    public static Date addMonth(Date date, int months) {
        int years = months/12;
        addYear(date, years);
        if(date.getMonth() + months%12 > 12){
            addYear(date, 1);
            date.setMonth(date.getMonth() + months%12 - 12);
        }else
            date.setMonth(date.getMonth() + months%12);

        return date;
    }

    public static Date addDay(Date date, int days) {
        long secondsInDate = DateUtils.convertDateToSeconds(date);
        long secondsInDays = DateUtils.convertDaysToSeconds(days);
        return DateUtils.convertSecondsToDate(secondsInDate + secondsInDays);
    }

    public static Date addHours(Date date, int hours) {
        long secondsInDate = DateUtils.convertDateToSeconds(date);
        long secondsInHours = DateUtils.convertHoursToSeconds(hours);
        return DateUtils.convertSecondsToDate(secondsInDate + secondsInHours);
    }

    public static Date addMinutes(Date date, int minutes) {
        long secondsInDate = DateUtils.convertDateToSeconds(date);
        long secondsInMinutes = DateUtils.convertMinutesToSeconds(minutes);
        return DateUtils.convertSecondsToDate(secondsInDate + secondsInMinutes);
    }

    public static Date addSeconds(Date date, int seconds) {
        long secondsInDate = DateUtils.convertDateToSeconds(date);
        return DateUtils.convertSecondsToDate(secondsInDate + seconds);
    }

    public static Date addYear(Date date, int years) {
        date.setYear(date.getYear() + years);
        return date;
    }

}
