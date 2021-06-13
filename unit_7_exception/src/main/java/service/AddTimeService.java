package service;

import java.util.List;

public class AddTimeService {
    private static final String EXCEPTION = "You entered the wrong date format!";
    private static final String SEPARATOR = "--------------------------------------------------------------------------------------------------------";

    public void addYear(List<CalendarService> calendarList, int years) {
        if (years > 0) { calendarList.get(0).setYear(calendarList.get(0).getYear() + years);
        } else {
            System.out.println(SEPARATOR);
            System.out.println(EXCEPTION);
            System.out.println(SEPARATOR);
        }
    }

    public void addMonth(List<CalendarService> calendarList, int month) {
        if (month > 0) {
            if (month / 12 > 0) {
                calendarList.get(0).setYear(calendarList.get(0).getYear() + (month / 12));
                if (month % 12 + calendarList.get(0).getMonth() <= 12) {
                    calendarList.get(0).setMonth(calendarList.get(0).getMonth() + month % 12);
                }
            } else {
                calendarList.get(0).setYear(calendarList.get(0).getYear() + 1);
                calendarList.get(0).setMonth(month - (12 - calendarList.get(0).getMonth()));
            }
        } else {
            System.out.println(SEPARATOR);
            System.out.println(EXCEPTION);
            System.out.println(SEPARATOR);
        }
    }

    public void addDays(List<CalendarService> calendarList, int days) {
        if (days > 0) {
            int index = findDaysInMonth(calendarList.get(0).getMonth(),calendarList.get(0).getYear());
            if (index < days) {
                days -= index - calendarList.get(0).getDay() + 1;
                calendarList.get(0).setDay(1);
                try {
                    calendarList.get(0).setMonth(calendarList.get(0).getMonth() + 1);
                }
                catch (IllegalArgumentException e ){
                    calendarList.get(0).setMonth(1);
                    calendarList.get(0).setYear(calendarList.get(0).getYear()+1);
                }
                while (days >= 365) {
                    if (calendarList.get(0).getYear() % 4 == 0 && days > 365) {
                        calendarList.get(0).setYear(calendarList.get(0).getYear()+1);
                        days -= 366;
                    } else if (calendarList.get(0).getYear() % 4 != 0 && days >= 365) {
                        calendarList.get(0).setYear(calendarList.get(0).getYear()+1);
                        days -= 365;
                    }
                }
                while (days >= 28) {
                    index = findDaysInMonth(calendarList.get(0).getMonth(),calendarList.get(0).getYear());
                    if (index <= days) {
                        try {
                            calendarList.get(0).setMonth(calendarList.get(0).getMonth()+1);
                        }
                        catch (IllegalArgumentException e ){
                            calendarList.get(0).setMonth(1);
                            calendarList.get(0).setYear(calendarList.get(0).getYear()+1);
                        }
                        days -= index;
                    } else
                        break;
                }
            }
            index = findDaysInMonth(calendarList.get(0).getMonth(),calendarList.get(0).getYear());
            for (int i = calendarList.get(0).getDay(); i <= (i + 1); i++) {
                if(days != 0) {
                    try {
                        calendarList.get(0).setDay(calendarList.get(0).getDay()+1);
                    }
                    catch (IllegalArgumentException argDays){
                        calendarList.get(0).setDay(1);
                        try {
                            calendarList.get(0).setMonth(calendarList.get(0).getMonth()+1);
                        }
                        catch (IllegalArgumentException argMonth){
                            calendarList.get(0).setMonth(1);
                            calendarList.get(0).setYear(calendarList.get(0).getYear()+1);
                        }
                    }
                    days--;
                }
            }
            if(days != 0)
                calendarList.get(0).setDay(calendarList.get(0).getDay()+days);
        }
        else {
            System.out.println(SEPARATOR);
            System.out.println(EXCEPTION);
            System.out.println(SEPARATOR);
        }
    }
    public static int findDaysInMonth(int month, int year) {
        if(month == 2 && year % 4 == 0)
            return 29;
        else if(month == 2)
            return 28;
        else if((month <= 7 && month % 2 == 1) || (month >= 8 && month % 2 == 0)){
            return 31;
        }
        else
            return 30;
    }
    public void addHours(List<CalendarService> calendarList, int hours) {
        if (hours > 0) {
            if(hours >= 24) {
                addDays(calendarList,hours/24);
                calendarList.get(0).setHour(hours%24);
            }
            else {
                calendarList.get(0).setHour(calendarList.get(0).getHour()+hours%24);
                if (calendarList.get(0).getHour() >= 24) {
                    calendarList.get(0).setHour(calendarList.get(0).getHour()-24);
                    try {
                        calendarList.get(0).setDay(calendarList.get(0).getDay()+1);
                    }
                    catch (IllegalArgumentException argDays){
                        if(calendarList.get(0).getHour() == 24)
                            calendarList.get(0).setHour(0);
                        if(calendarList.get(0).getDay() > findDaysInMonth(calendarList.get(0).getMonth(),calendarList.get(0).getYear())) {
                            calendarList.get(0).setDay(1);
                            try {
                                calendarList.get(0).setMonth(calendarList.get(0).getMonth() + 1);
                            } catch (IllegalArgumentException e) {
                                calendarList.get(0).setMonth(1);
                                calendarList.get(0).setYear(calendarList.get(0).getYear() + 1);
                            }
                        }
                    }
                }
            }
        }
        else {
            System.out.println(SEPARATOR);
            System.out.println(EXCEPTION);
            System.out.println(SEPARATOR);
        }
    }
    public void addMinutes(List<CalendarService> calendarList, int minutes) {
        if(minutes>0) {
            int newMinutes = calendarList.get(0).getMinute() + minutes;
            if (newMinutes > 59) {
                calendarList.get(0).setMinute(newMinutes % 60);
                addHours(calendarList, newMinutes / 60);
            } else {
                calendarList.get(0).setMinute(newMinutes);
            }
        }
        else {
            System.out.println(SEPARATOR);
            System.out.println(EXCEPTION);
            System.out.println(SEPARATOR);
        }
    }
    public void addSeconds(List<CalendarService> calendarList, int seconds) {
        if(seconds>0) {
            int newSeconds = calendarList.get(0).getSecond() + seconds;
            if (newSeconds > 59) {
                calendarList.get(0).setMinute(newSeconds % 60);
                addMinutes(calendarList, newSeconds / 60);
            } else {
                calendarList.get(0).setMinute(newSeconds);
            }
        }
        else {
            System.out.println(SEPARATOR);
            System.out.println(EXCEPTION);
            System.out.println(SEPARATOR);
        }
    }
}
