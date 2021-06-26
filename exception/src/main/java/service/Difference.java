package service;
import datas.Calendar;

public class Difference {
    public static long getNumberOfSeconds(Calendar calendar, Calendar calendar_) {
        if (!calendar.getDate().Invalid()) {
            calendar.computeTime();
        }
        if (!calendar_.getDate().Invalid()) {
            calendar_.computeTime();
        }
        return Calendar.getTimeDifference(calendar.getDate(), calendar_.getDate());
    }

    public static long getNumberOfMinutes(Calendar calendar, Calendar calendar_) {
        if (!calendar.getDate().Invalid()) {
            calendar.computeTime();
        }
        if (!calendar_.getDate().Invalid()) {
            calendar_.computeTime();
        }
        return Calendar.getTimeDifference(calendar.getDate(), calendar_.getDate()) / 60;
    }

    public static long getNumberOfHours(Calendar calendar, Calendar calendar_) {
        if (!calendar.getDate().Invalid()) {
            calendar.computeTime();
        }
        if (!calendar_.getDate().Invalid()) {
            calendar_.computeTime();
        }
        return Calendar.getTimeDifference(calendar.getDate(), calendar_.getDate()) / 3600;
    }

    public static long getNumberOfDays(Calendar calendar, Calendar calendar_) {
        if (!calendar.getDate().Invalid()) {
            calendar.computeTime();
        }
        if (!calendar_.getDate().Invalid()) {
            calendar_.computeTime();
        }
        return Calendar.getTimeDifference(calendar.getDate(), calendar_.getDate()) / 86400;

    }

    public static long getNumberOfMonths(Calendar calendar, Calendar calendar_) {
        if (!calendar.getDate().Invalid()) {
            calendar.computeTime();
        }
        if (!calendar_.getDate().Invalid()) {
            calendar_.computeTime();
        }
        return Calendar.getTimeDifference(calendar.getDate(), calendar_.getDate()) / (86400 * 30);
    }

    public static long getNumberOfYears(Calendar calendar, Calendar calendar_) {
        if (!calendar.getDate().Invalid()) {
            calendar.computeTime();
        }
        if (!calendar_.getDate().Invalid()) {
            calendar_.computeTime();
        }
        return Calendar.getTimeDifference(calendar.getDate(), calendar_.getDate()) / (86400 * 365);
    }
}
