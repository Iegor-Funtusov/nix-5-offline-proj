package operations;

import obj.Date;
import dates.CalendarUtils;

import java.time.DateTimeException;

public class Subtracting {

    public Date subtractSecs(Date date, int value) {
        int year = date.getYear();
        int month = date.getMonth();
        int day = date.getDay();
        int hours = date.getTime().getHours();
        int mins = date.getTime().getMins();
        int secs = date.getTime().getSecs();
        int i = secs;
        while (i >= 0) {
            if (value > 0) {
                if (i == 0) {
                    i = 60;
                    if (--mins < 0) {
                        mins = 60 + mins;
                        if (--hours < 0) {
                            hours = 24 + hours;
                            if (--day == 0) {
                                day = CalendarUtils.daysInMonth(--month, year);
                                if (month == 0) {
                                    month = 12;
                                    year--;
                                }
                            }
                        }
                    }
                }
                value--;
            } else {
                secs = i;
                break;
            }
            i--;
        }
        date.getTime().setSecs(secs);
        date.getTime().setMins(mins);
        date.getTime().setHours(hours);
        date.setDay(day);
        date.setMonth(month);
        date.setYear(year);

        return date;
    }

    public Date subtractMins(Date date, int value) {
        int year = date.getYear();
        int month = date.getMonth();
        int day = date.getDay();
        int hours = date.getTime().getHours();
        int mins = date.getTime().getMins();
        int i = mins;
        while (i >= 0) {
            if (value > 0) {
                if (i == 0) {
                    i = 60;
                    if (--hours < 1) {
                        hours = 24 + hours;
                        if (--day == 0) {
                            day = CalendarUtils.daysInMonth(--month, year);
                            if (month == 0) {
                                month = 12;
                                year--;
                            }
                        }
                    }
                }
                value--;
            } else {
                mins = i;
                break;
            }
            i--;
        }
        date.getTime().setMins(mins);
        date.getTime().setHours(hours);
        date.setDay(day);
        date.setMonth(month);
        date.setYear(year);
        return date;
    }

    public Date subtractHours(Date date, int value) {
        int year = date.getYear();
        int month = date.getMonth();
        int day = date.getDay();
        int hours = date.getTime().getHours();
        int i = hours;
        while (i >= 0) {
            if (value > 0) {
                if (i == 0) {
                    i = 24;
                    if (--day == 0) {
                        day = CalendarUtils.daysInMonth(--month, year);
                        if (month == 0) {
                            month = 12;
                            year--;
                        }
                    }
                }
                value--;
            } else {
                hours = i;
                break;
            }
            i--;
        }
        date.getTime().setHours(hours);
        date.setDay(day);
        date.setMonth(month);
        date.setYear(year);
        return date;
    }

    public Date subtractDays(Date date, int value) {
        int year = date.getYear();
        int month = date.getMonth();
        int day = date.getDay();
        int i = day;
        while (i >= 0) {
            if (value > 0) {
                if (i == 0) {
                    if (--month == 0) {
                        month = 12;
                        year--;
                    }
                    i = CalendarUtils.daysInMonth(month, year);
                }
                value--;
            } else {
                day = i;
                break;
            }
            i--;
        }
        date.setDay(day);
        date.setMonth(month);
        date.setYear(year);
        return date;
    }

    public Date subtractMonths(Date date, int value) {
        int year = date.getYear();
        int month = date.getMonth();
        if (value > 0) {
            do {
                month--;
                if (month < 1) {
                    month = 12;
                    year--;
                }
                value--;
            } while (value > 0);
        }
        date.setMonth(month);
        date.setYear(year);
        return date;
    }

    public Date subtractYears(Date date, int value) {
        if (value <= date.getYear()) {
            date.setYear(date.getYear() - value);
            return date;
        }
        throw new DateTimeException("The value entered is greater than the date");
    }
}
