package operations;

import dates.CalendarUtils;
import obj.Date;

public class Adding {

    public Date addSecs(Date date, int value) {
        int year = date.getYear();
        int month = date.getMonth();
        int days = date.getDay();
        int hours = date.getTime().getHours();
        int mins = date.getTime().getMins();
        int secs = date.getTime().getSecs();
        int i = secs;
        if (i <= 60) {
            do {
                if (value > 0) {
                    if (i == 60) {
                        i = 0;
                        if (++mins == 60) {
                            mins = 0;
                            if (++hours == 24) {
                                hours = 0;
                                if (++days > CalendarUtils.daysInMonth(month, year)) {
                                    days = 1;
                                    if (++month > 12) {
                                        month = 1;
                                        year++;
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
                i++;
            } while (i <= 60);
        }
        date.getTime().setSecs(secs);
        date.getTime().setMins(mins);
        date.getTime().setHours(hours);
        date.setDay(days);
        date.setMonth(month);
        date.setYear(year);

        return date;
    }

    public Date addMins(Date date, int value) {
        int year = date.getYear();
        int month = date.getMonth();
        int day = date.getDay();
        int hours = date.getTime().getHours();
        int mins = date.getTime().getMins();
        int i = mins;
        if (i <= 60) {
            do {
                if (value > 0) {
                    if (i == 60) {
                        i = 0;
                        if (++hours == 24) {
                            hours = 0;
                            if (++day > CalendarUtils.daysInMonth(month, year)) {
                                day = 1;
                                if (++month > 12) {
                                    month = 1;
                                    year++;
                                }
                            }
                        }
                    }
                    value--;
                } else {
                    mins = i;
                    break;
                }
                i++;
            } while (i <= 60);
        }
        date.getTime().setMins(mins);
        date.getTime().setHours(hours);
        date.setDay(day);
        date.setMonth(month);
        date.setYear(year);
        return date;
    }

    public Date addHours(Date date, int value) {
        int year = date.getYear();
        int month = date.getMonth();
        int day = date.getDay();
        int hours = date.getTime().getHours();
        int i = hours;
        if (i <= 24) {
            do {
                if (value > 0) {
                    if (i == 24) {
                        i = 0;
                        if (++day > CalendarUtils.daysInMonth(month, year)) {
                            day = 1;
                            if (++month > 12) {
                                month = 1;
                                year++;
                            }
                        }
                    }
                    value--;
                } else {
                    hours = i;
                    break;
                }
                i++;
            } while (i <= 24);
        }
        date.getTime().setHours(hours);
        date.setDay(day);
        date.setMonth(month);
        date.setYear(year);
        return date;
    }

    public Date addDays(Date date, int value) {
        int year = date.getYear();
        int month = date.getMonth();
        int days = date.getDay();
        int i = days;
        if (i <= CalendarUtils.daysInMonth(month, year)) {
            do {
                if (value > 0) {
                    if (i == CalendarUtils.daysInMonth(month, year)) {
                        i = 0;
                        if (++month > 12) {
                            month = 1;
                            year++;
                        }
                    }
                    value--;
                } else {
                    days = i;
                    break;
                }
                i++;
            } while (i <= CalendarUtils.daysInMonth(month, year));
        }
        date.setDay(days);
        date.setMonth(month);
        date.setYear(year);
        return date;
    }

    public Date addMonths(Date date, int value) {
        int month = date.getMonth();
        int year = date.getYear();
        if (value > 0) {
            do {
                month++;
                if (month > 12) {
                    month = 1;
                    year++;
                }
                value--;
            } while (value > 0);
        }
        date.setMonth(month);
        date.setYear(year);
        return date;
    }

    public Date addYears(Date date, int value) {
        date.setYear(date.getYear() + value);
        return date;
    }
}

