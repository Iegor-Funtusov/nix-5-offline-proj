package ua.com.nix.operations_with_date;

import ua.com.nix.model.Calendar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import static ua.com.nix.operations_with_date.Create.calendarList;

public class Subtraction {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public void substract() throws IOException {
        System.out.println("Enter date: ");
        System.out.println("For example" + " or (1/10/34)" + " or (/5/47)" + " or (/2/)" + " or (1256 59:59 )");
        new Create().create();
        MainLabel:
        while (true) {
            System.out.println("""
                    Enter action:
                    1 -> Subtract Years
                    2 -> Subtract Months
                    3 -> Subtract Days
                    4 -> Subtract Hours
                    5 -> Subtract Minutes
                    6 -> Subtract Seconds
                    0 -> Return to menu selection""");

            String s = reader.readLine();
            switch (s) {
                case "1": {
                    System.out.println("Enter count of years to subtract: ");
                    int years = Integer.parseInt(reader.readLine());
                    subtractYear(calendarList, years);
                    System.out.println(calendarList.get(0));
                    break;
                }
                case "2": {
                    System.out.println("Enter count of months to subtract: ");
                    int month = Integer.parseInt(reader.readLine());
                    subtractMonth(calendarList, month);
                    System.out.println(calendarList.get(0));
                    break;
                }
                case "3": {
                    System.out.println("Enter count of days to subtract: ");
                    int days = Integer.parseInt(reader.readLine());
                    subtractDays(calendarList, days);
                    System.out.println(calendarList.get(0));
                    break;
                }
                case "4": {
                    System.out.println("Enter count of hours to subtract: ");
                    int hours = Integer.parseInt(reader.readLine());
                    subtractHours(calendarList, hours);
                    System.out.println(calendarList.get(0));
                    break;
                }
                case "5": {
                    System.out.println("Enter count of minutes to subtract: ");
                    int minutes = Integer.parseInt(reader.readLine());
                    subtractMinutes(calendarList, minutes);
                    System.out.println(calendarList.get(0));
                    break;
                }
                case "6": {
                    System.out.println("Enter count of seconds to subtract: ");
                    int seconds = Integer.parseInt(reader.readLine());
                    subtractSeconds(calendarList, seconds);
                    System.out.println(calendarList.get(0));
                    break;
                }
                case "0": {
                    calendarList.clear();
                    break MainLabel;
                }
            }
        }
    }

    private void subtractYear(List<Calendar> calendarList, int years) {
        if (years > 0) {
            calendarList.get(0).setYear(calendarList.get(0).getYear() - years);
        } else
            System.out.println("Incorrect year,try again");
    }

    private void subtractMonth(List<Calendar> calendarList, int month) {
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
            System.out.println("Incorrect month,try again");
        }
    }
    private void subtractDays(List<Calendar> calendarList,int days) {
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
            System.out.println("Incorrect days,try again");
        }
    }
    public static int findDaysInMonth(int month, int year){
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
    private void subtractHours(List<Calendar> calendarList, int hours) {
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
            System.out.println("Incorrect hours,try again");
        }
    }
    private void subtractMinutes(List<Calendar> calendarList, int minutes){
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
        }
        else {
            System.out.println("Incorrect minutes,try again");
        }
    }

    private void subtractSeconds(List<Calendar> calendarList, int seconds) {
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
            }else {
                System.out.println("Incorrect minutes,try again");
            }
        }
}




