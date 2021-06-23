package ua.davidenko.date;

public class DateDifference {

    public static double differenceInYears(Date curDate, Date nextDate) {
        int curYear = curDate.getYears();
        int nextYear = nextDate.getYears();
        return Math.abs(curYear - nextYear);
    }

    public static double differenceInMonths(Date curDate, Date nextDate) {
        int curMonth = curDate.getMonths();
        int nextMonth = nextDate.getMonths();
        return Math.abs(curMonth - nextMonth) + differenceInYears(curDate, nextDate) * 12;
    }

    public static double differenceInDays(Date curDate, Date nextDate) {
        int curDay = curDate.getDays();
        int nextDay = nextDate.getDays();
        return Math.abs(curDay - nextDay);
    }

    public static double differenceInHours(Date curDate, Date nextDate) {
        int curHours = curDate.getHours();
        int nestHours = nextDate.getHours();
        return Math.abs(curHours - nestHours) + differenceInDays(curDate, nextDate) * 24;
    }

    public static double differenceInMinutes(Date curDate, Date nextDate) {
        int curMin = curDate.getMinutes();
        int nextMin = nextDate.getMinutes();
        return Math.abs(curMin - nextMin) + differenceInHours(curDate, nextDate) * 60;
    }

    public static double differenceInSeconds(Date curDate, Date nextDate) {
        int curSec = curDate.getSeconds();
        int nextSec = nextDate.getSeconds();
        return Math.abs(curSec - nextSec) + differenceInMinutes(curDate, nextDate) * 60;
    }
}
