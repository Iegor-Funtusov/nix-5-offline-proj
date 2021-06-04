package ua.com.nix.operations_with_date;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static ua.com.nix.operations_with_date.Create.calendarList;

public class Difference {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void differ() throws IOException {
            String start;
            int i = 1;
            while (i <= 2) {
                System.out.println("Enter two dates: ");
                System.out.println("For example" + " or (1/10/34)" + " or (/5/47)" + " or (/2/)" + " or (1256 59:59 )");
                System.out.println("Enter " + i + " date: ");
                new Create().create();
                i++;
            }
            MainLabel:
            while (true) {
                calendarList.forEach(System.out::println);
            System.out.println("""
                    Enter action:
                    1 -> Difference in Years
                    2 -> Difference in Months
                    3 -> Difference in Days
                    4 -> Difference in Hours
                    5 -> Difference in Minutes
                    6 -> Difference in Seconds
                    0 -> Return to menu selection""");
            String s = reader.readLine();
            switch (s) {
                case "1": {
                    System.out.println("Difference in Years: " + differYear());
                    break;
                }
                case "2": {
                    System.out.println("Difference in Months " + differMonth());
                    break;
                }
                case "3": {
                    System.out.println("Difference in Days " + differDay());
                    break;
                }
                case "4": {
                    System.out.println("Difference in Hours " + differHours());
                    break;
                }
                case "5": {
                    System.out.println("Difference in Minutes " + differMinutes());
                    break;
                }
                case "6": {
                    System.out.println("Difference in Seconds " + differSeconds());
                    break;
                }
                case "0": {
                    calendarList.clear();
                    break MainLabel;
                }
            }
        }
    }
    private int differMonth(){
        return (Math.abs(calendarList.get(0).getMonth() - calendarList.get(1).getMonth())+
                (Math.abs(calendarList.get(0).getYear() - calendarList.get(1).getYear())*12));
    }
    private int differSeconds(){
        return (Math.abs(calendarList.get(0).getSecond() - calendarList.get(1).getSecond())+
                differMinutes()*60);
    }
    private int differMinutes(){
        return (Math.abs(calendarList.get(0).getMinute() - calendarList.get(1).getMinute())+
                differHours()*60);
    }
    private int differHours(){
        return (Math.abs(calendarList.get(0).getHour() - calendarList.get(1).getHour())+
                differDay()*24);
    }
    private int differDay(){
        return (Math.abs(calendarList.get(0).getDay() - calendarList.get(1).getDay())+forDifferDay());
    }
    private int forDifferDay() {
        int[] allDays = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int days = 0;

        int month1 = calendarList.get(0).getMonth();
        int month2 = calendarList.get(1).getMonth();
        int count = Math.abs(month1-month2);

        int index = Math.min(calendarList.get(0).getMonth(),calendarList.get(1).getMonth());
        int year1 = calendarList.get(0).getYear();
        int differYear = differYear();
        while (differYear > 0) {
            if (++year1 % 4 == 0) {
                days += 366;
            } else {
                days += 365;
            }
            differYear--;
        }
        for (int i = 0; i < count; i++) {
            days+=allDays[index];
            index++;
        }
            return days;
    }

    private int differYear(){
        return Math.abs(calendarList.get(0).getYear() - calendarList.get(1).getYear());
    }

}
