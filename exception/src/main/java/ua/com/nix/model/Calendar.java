package ua.com.nix.model;
import ua.com.nix.exception.CalendarException;

import static ua.com.nix.operations_with_date.Create.calendarList;
public class Calendar implements Comparable<Calendar>{
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;
    private int second;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if(year <= 99){
            this.year = 1900+year;
        } else {
            this.year = year;
        }
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if(month>12 || month<1)
            try {
                throw new CalendarException("month > 12 or month < 1");
            } catch (CalendarException calendarException) {
                calendarException.printStackTrace();
            }
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        if(day>31 || day<1)
            try {
                throw new CalendarException("day > 31 or day < 1");
            } catch (CalendarException calendarException) {
                calendarException.printStackTrace();
            }
        this.day = day;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        if(hour > 24 || hour < 0)
            try {
                throw new CalendarException("hour > 24 or hour < 0");
            } catch (CalendarException calendarException) {
                calendarException.printStackTrace();
            }
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        if(minute > 59 || minute<0)
            try {
                throw new CalendarException("minute > 60 or minute < 0");
            } catch (CalendarException calendarException) {
                calendarException.printStackTrace();
            }
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        if(second > 59 || second<0)
            try {
                throw new CalendarException("second > 60 or second < 0");
            } catch (CalendarException calendarException) {
                calendarException.printStackTrace();
            }
        this.second = second;
    }

    @Override
    public String toString() {
        return "Dates{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                ", hour=" + hour +
                ", minute=" + minute +
                ", second=" + second +
                '}';
    }

    @Override
    public int compareTo(Calendar o) {
        int compare = this.getYear()-o.getYear();
        if (compare == 0) {
            compare = this.getMonth()-o.getMonth();
        }
        if (compare == 0) {
            compare = this.getDay()-o.getDay();
        }
        if (compare == 0) {
            compare = this.getHour()-o.getHour();
        }
        if (compare == 0) {
            compare = this.getMinute()-o.getMinute();
        }
        if (compare == 0) {
            compare = this.getSecond()-o.getSecond();
        }
        return compare;
    }
}
