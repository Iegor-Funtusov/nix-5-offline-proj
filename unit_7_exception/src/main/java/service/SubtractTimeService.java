package service;

import java.util.List;

public class SubtractTimeService {
    private static final String EXCEPTION = "You entered the wrong date format!";
    private static final String SEPARATOR = "--------------------------------------------------------------------------------------------------------";

    public void subtractYear(List<CalendarService> calendarList, int years) {
        if (years > 0) {
            calendarList.get(0).setYear(calendarList.get(0).getYear() - years);
        } else {
            System.out.println(SEPARATOR);
            System.out.println(EXCEPTION);
            System.out.println(SEPARATOR);
        }
    }

    public void subtractMonth(List<CalendarService> calendarList, int month) {
        if (month > 0) {
            if (month / 12 > 0) {
                calendarList.get(0).setYear(calendarList.get(0).getYear() - (month / 12));
                if (month % 12 > calendarList.get(0).getMonth()) {
                    month = calendarList.get(0).getMonth();
                    calendarList.get(0).setMonth(12-month);
                    calendarList.get(0).setYear(calendarList.get(0).getYear() - 1);
                }
                else {
                    calendarList.get(0).setMonth(calendarList.get(0).getMonth()-month%12);
                    if(calendarList.get(0).getMonth()==0){
                        calendarList.get(0).setMonth(12);
                        calendarList.get(0).setYear(calendarList.get(0).getYear() - 1);
                    }
                }
            }
        } else {
            System.out.println(SEPARATOR);
            System.out.println(EXCEPTION);
            System.out.println(SEPARATOR);
        }
    }
    public void subtractDays(List<CalendarService> calendarList, int days) {
        if (days > 0) {
            int index;
            if(calendarList.get(0).getDay() <= days ) {
                days -= calendarList.get(0).getDay();
                try {
                    calendarList.get(0).setMonth(calendarList.get(0).getMonth() - 1);
                } catch (IllegalArgumentException e) {
                    calendarList.get(0).setMonth(12);
                    calendarList.get(0).setYear(calendarList.get(0).getYear() - 1);
                }
                calendarList.get(0).setDay(findDaysInMonth(calendarList.get(0).getMonth(),calendarList.get(0).getYear()));
            }
            else {
                calendarList.get(0).setDay(calendarList.get(0).getDay() - days);
                return;
            }

            while (days >= 365) {
                if (calendarList.get(0).getYear() % 4 == 0 && days > 365) {
                    calendarList.get(0).setYear(calendarList.get(0).getYear()-1);
                    days -= 366;
                } else if (calendarList.get(0).getYear() % 4 != 0 && days >= 365) {
                    calendarList.get(0).setYear(calendarList.get(0).getYear()-1);
                    days -= 365;
                }
            }
            while (days >= 28) {
                index = findDaysInMonth(calendarList.get(0).getMonth(),calendarList.get(0).getYear());
                if (index <= days) {
                    try {
                        calendarList.get(0).setMonth(calendarList.get(0).getMonth()-1);
                    }
                    catch (IllegalArgumentException e ){
                        calendarList.get(0).setMonth(12);
                        calendarList.get(0).setYear(calendarList.get(0).getYear()-1);
                    }
                    days -= index;
                } else
                    break;
            }
            index = findDaysInMonth(calendarList.get(0).getMonth(),calendarList.get(0).getYear());
            calendarList.get(0).setDay(index-days);
        }
        else {
            System.out.println(SEPARATOR);
            System.out.println(EXCEPTION);
            System.out.println(SEPARATOR);
        }
    }
    public int findDaysInMonth(int month, int year){
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
    public void subtractHours(List<CalendarService> calendarList, int hours) {
        if (hours > 0) {
            if (hours >= calendarList.get(0).getHour()) {
                hours = hours - calendarList.get(0).getHour();
                calendarList.get(0).setHour(0);
            } else {
                calendarList.get(0).setHour(calendarList.get(0).getHour() - hours);
            }
            if (0 < hours / 24) {
                subtractDays(calendarList, hours / 24);
                try {
                    calendarList.get(0).setHour(24 - hours % 24);
                } catch (IllegalArgumentException argHours) {
                    calendarList.get(0).setHour(0);
                }
                try {
                    calendarList.get(0).setDay(calendarList.get(0).getDay() - 1);
                } catch (IllegalArgumentException argDays) {
                    try {
                        calendarList.get(0).setMonth(calendarList.get(0).getMonth() - 1);
                    } catch (IllegalArgumentException argMonths) {
                        calendarList.get(0).setYear(calendarList.get(0).getYear() - 1);
                        calendarList.get(0).setMonth(12);
                    }
                    calendarList.get(0).setDay(findDaysInMonth(calendarList.get(0).getMonth(), calendarList.get(0).getYear()));
                }
            } else {
                try {
                    calendarList.get(0).setHour(24 - hours);
                } catch (IllegalArgumentException argHours) {
                    calendarList.get(0).setHour(0);
                }
                try {
                    calendarList.get(0).setDay(calendarList.get(0).getDay() - 1);
                } catch (IllegalArgumentException argDays) {
                    try {
                        calendarList.get(0).setMonth(calendarList.get(0).getMonth() - 1);
                    } catch (IllegalArgumentException argMonth) {
                        calendarList.get(0).setYear(calendarList.get(0).getYear() - 1);
                        calendarList.get(0).setMonth(12);
                    }
                    calendarList.get(0).setDay(findDaysInMonth(calendarList.get(0).getMonth(), calendarList.get(0).getYear()));
                }
            }
        }
        else {
            System.out.println(SEPARATOR);
            System.out.println(EXCEPTION);
            System.out.println(SEPARATOR);
        }
    }
    public void subtractMinutes(List<CalendarService> calendarList, int minutes){
        if(minutes>0) {
            int temp = calendarList.get(0).getMinute();
            int newMinutes = temp - minutes;
            if(newMinutes<=0)
            {
                try {
                    calendarList.get(0).setMinute(60+(newMinutes%60));
                } catch (IllegalArgumentException argMin) {
                    calendarList.get(0).setMinute(0);
                }
                if((temp+minutes)%60==0) {
                    subtractHours(calendarList, 1);
                }
                else{
                    subtractHours(calendarList, (temp + minutes + 60) / 60);
                    if (calendarList.get(0).getHour()==24)
                    {
                        calendarList.get(0).setHour(0);
                    }
                }
            } else {
                calendarList.get(0).setMinute(newMinutes);
            }
        } else {
            System.out.println(SEPARATOR);
            System.out.println(EXCEPTION);
            System.out.println(SEPARATOR);
        }
    }

    public void subtractSeconds(List<CalendarService> calendarList, int seconds) {
        if (seconds > 0) {
            int temp = calendarList.get(0).getSecond();
            int newSeconds = temp - seconds;
            if (newSeconds <= 0) {
                try {
                    calendarList.get(0).setSecond(60 + (newSeconds % 60));
                } catch (IllegalArgumentException argMin) {
                    calendarList.get(0).setSecond(0);
                }
                if ((temp + seconds) % 60 == 0) {
                    subtractMinutes(calendarList, 1);
                }
            }else {
                subtractMinutes(calendarList, (temp + seconds + 60) / 60);
                if (calendarList.get(0).getMinute() == 24) {
                    calendarList.get(0).setSecond(0);
                }
            }
        } else {
            System.out.println(SEPARATOR);
            System.out.println(EXCEPTION);
            System.out.println(SEPARATOR);
        }
    }
}
