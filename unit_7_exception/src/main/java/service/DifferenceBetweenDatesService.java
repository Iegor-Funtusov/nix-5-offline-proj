package service;

import static dao.CreateDateService.calendarList;

public class DifferenceBetweenDatesService {
    public int differenceYears(){
        return Math.abs(calendarList.get(0).getYear() - calendarList.get(1).getYear());
    }

    public int differenceMonth(){
        return (Math.abs(calendarList.get(0).getMonth() - calendarList.get(1).getMonth())+
                (Math.abs(calendarList.get(0).getYear() - calendarList.get(1).getYear())*12));
    }

    public int differenceDays(){ return (Math.abs(calendarList.get(0).getDay() - calendarList.get(1).getDay()) + differentDays()); }

    public int differentDays() {
        int[] allDays = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int days = 0;

        int month1 = calendarList.get(0).getMonth();
        int month2 = calendarList.get(1).getMonth();
        int count = Math.abs(month1-month2);

        int index = Math.min(calendarList.get(0).getMonth(),calendarList.get(1).getMonth());
        int year1 = calendarList.get(0).getYear();
        int differYear = differenceYears();
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

    public int differenceHours(){ return (Math.abs(calendarList.get(0).getHour() - calendarList.get(1).getHour()) + differenceDays()*24); }

    public int differenceMinutes(){ return (Math.abs(calendarList.get(0).getMinute() - calendarList.get(1).getMinute())+ differenceHours()*60); }

    public int differenceSeconds(){ return (Math.abs(calendarList.get(0).getSecond() - calendarList.get(1).getSecond())+ differenceMinutes()*60); }






}
