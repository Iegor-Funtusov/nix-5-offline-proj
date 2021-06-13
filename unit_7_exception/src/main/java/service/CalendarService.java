package service;

import lombok.Getter;

@Getter
public class CalendarService implements Comparable<CalendarService>{
    private static final String DANGEROUS = "You entered a value out of range!";
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;
    private int second;

    public void setYear(int year) {
        if(year < 100){
            this.year = 2000+year;
        } else {
            this.year = year;
        }
    }

    public void setMonth(int month) {
        if ((0 < month) && (month <= 12)){
            this.month = month;
        } else {
            System.out.println(DANGEROUS);
        }
    }

    public void setDay(int day) {
        if ((0 < day) && (day <= 31)){
            this.day = day;
        } else {
            System.out.println(DANGEROUS);
        }
    }

    public void setHour(int hour) {
        if ((0 <= hour) && (hour < 24)){
            this.hour = hour;
        } else {
            System.out.println(DANGEROUS);
        }
    }

    public void setMinute(int minute) {
        if ((0 <= minute) && (minute < 60)){
            this.minute = minute;
        } else {
            System.out.println(DANGEROUS);
        }
    }

    public void setSecond(int second) {
        if ((0 <= second) && (second < 60)){
            this.second = second;
        } else {
            System.out.println(DANGEROUS);
        }
    }

    @Override
    public int compareTo(CalendarService order) {
        int compare = this.year - order.getYear();
        if (compare == 0) {
            compare = this.month - order.getMonth();
            if (compare == 0) {
                compare = this.day - order.getDay();
                if (compare == 0) {
                    compare = this.hour - order.getHour();
                    if (compare == 0) {
                        compare = this.minute - order.getMinute();
                        if (compare == 0) {
                            compare = this.second - order.getSecond();
                        }
                    }
                }
            }
        }
        return compare;
    }

    @Override
    public String toString() {
        return "Date{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                ", hour=" + hour +
                ", minute=" + minute +
                ", second=" + second +
                '}';
    }
}
