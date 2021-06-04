package ua.com.nix.operations_with_date;

import ua.com.nix.model.Calendar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import static ua.com.nix.operations_with_date.Create.calendarList;

public class Addition {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void add() throws IOException {
        System.out.println("Enter date: ");
        System.out.println("For example" + " or (1/10/34)" + " or (/5/47)" + " or (/2/)" + " or (1256 59:59 )");
        new Create().create();
        MainLabel:
        while (true) {
            System.out.println("""
                    Enter action:
                    1 -> Add Years
                    2 -> Add Months
                    3 -> Add Days
                    4 -> Add Hours
                    5 -> Add Minutes
                    6 -> Add Seconds
                    0 -> Return to menu selection""");

            String s = reader.readLine();
            switch (s) {
                case "1": {
                    System.out.println("Enter count of years to addition: ");
                    int years = Integer.parseInt(reader.readLine());
                    addYear(calendarList, years);
                    System.out.println(calendarList.get(0));
                    break;
                }
                case "2": {
                    System.out.println("Enter count of months to addition: ");
                    int month = Integer.parseInt(reader.readLine());
                    addMonth(calendarList, month);
                    System.out.println(calendarList.get(0));
                    break;
                }
                case "3": {
                    System.out.println("Enter count of days to addition: ");
                    int days = Integer.parseInt(reader.readLine());
                    addDays(calendarList, days);
                    System.out.println(calendarList.get(0));
                    break;
                }
                case "4": {
                    System.out.println("Enter count of hours to addition: ");
                    int hours = Integer.parseInt(reader.readLine());
                    addHours(calendarList, hours);
                    System.out.println(calendarList.get(0));
                    break;
                }
                case "5": {
                    System.out.println("Enter count of minutes to addition: ");
                    int minutes = Integer.parseInt(reader.readLine());
                    addMinutes(calendarList, minutes);
                    System.out.println(calendarList.get(0));
                    break;
                }
                case "6": {
                    System.out.println("Enter count of minutes to addition: ");
                    int seconds = Integer.parseInt(reader.readLine());
                    addSeconds(calendarList, seconds);
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

    private void addYear(List<Calendar> calendarList,int years) throws IOException {
        if (years > 0) {
                calendarList.get(0).setYear(calendarList.get(0).getYear() + years);
        } else
            System.out.println("Incorrect year,try again");
    }

    private void addMonth(List<Calendar> calendarList,int month) throws IOException {
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
            System.out.println("Incorrect month,try again");
        }
    }

    private void addDays(List<Calendar> calendarList,int days) throws IOException {
        if (days > 0) {
                int index = findDaysInMonth(calendarList.get(0).getMonth(),calendarList.get(0).getYear());
                if(index < days) {
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
                for (int i = calendarList.get(0).getDay(); i <= (index + 1); i++) {
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
    private void addHours(List<Calendar> calendarList,int hours) throws IOException {
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
            System.out.println("Incorrect hours,try again");
        }
    }
    private void addMinutes(List<Calendar> calendarList,int minutes) throws IOException {
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
            System.out.println("Incorrect minutes,try again");
        }
    }
    private void addSeconds(List<Calendar> calendarList,int seconds) throws IOException{
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
            System.out.println("Incorrect seconds,try again");
        }
    }


}


