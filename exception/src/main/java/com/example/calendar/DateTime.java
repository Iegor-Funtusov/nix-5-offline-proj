package com.example.calendar;

public class DateTime {
    private int day;
    private int month;
    private int year;
    private int hour;
    private int minute;
    private int second;

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if(year < 100){
            this.year = 1900+year;
        } else {
            this.year = year;
        }

    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public void plusDay(int day){
        int dayOfMonth;
        for (int i = 1; i <= day; i++) {
            dayOfMonth = 28+(month+(month/8))%2+2%month+2*(1/month);
            if(month == 2 && year % 4 == 0){
                dayOfMonth++;
            }
            this.day++;
            if(this.day > dayOfMonth){
                this.day = 1;
                month++;
            }
            if(month > 12){
                month = 1;
                year++;
            }
        }
    }

    public void plusMonth(int month){
        int y = month / 12;
        int m = month - y * 12;
        plusYear(y);
        this.month += m;
    }

    public void plusYear(int year){
        this.year += year;
    }

    public void plusSecond(int second){
        int m = second / 60;
        int s = second - m * 60;
        plusMinute(m);
        this.second += s;
    }

    public void plusMinute(int minute){
        int h = minute / 60;
        int m = minute - h * 60;
        plusHour(h);
        this.minute += m;
    }

    public void plusHour(int hour){
        int d = hour / 24;
        int h = hour - d * 24;
        plusDay(d);
        this.hour += h;
    }

    public void minusDay(int day){
        int dayOfMonth;
        int previousM;
        for (int i = 1; i <= day; i++) {
            previousM = month - 1;
            if(previousM == 0){
                previousM = 12;
            }
            dayOfMonth = 28+(previousM+(previousM/8))%2+2%previousM+2*(1/previousM);
            if(previousM == 2 && year % 4 == 0){
                dayOfMonth++;
            }
            this.day--;
            if(this.day < 1){
                this.day = dayOfMonth;
                month--;
            }
            if(month < 1){
                month = 12;
                year--;
            }
        }
    }

    public void minusMonth(int month){
        int y = month / 12;
        int m = month - y * 12;
        minusYear(y);
        this.month -= m;
    }

    public void minusYear(int year){
        this.year -= year;
    }

    public void minusSecond(int second){
        int m = second / 60;
        int s = second - m * 60;
        minusMinute(m);
        int diffSeconds = this.second - s;
        if(diffSeconds < 0){
            this.minute--;
            this.second = 60 - Math.abs(diffSeconds);
        } else {
            this.second -= s;
        }
    }

    public void minusMinute(int minute){
        int h = minute / 60;
        int m = minute - h * 60;
        minusHour(h);
        int diffMinutes = this.minute - m;
        if(diffMinutes < 0){
            this.hour--;
            this.minute = 60 - Math.abs(diffMinutes);
        } else {
            this.minute -= m;
        }
    }

    public void minusHour(int hour){
        int d = hour / 24;
        int h = hour - d * 24;
        minusDay(d);
        int diffHours = this.hour - h;
        if(diffHours < 0){
            this.day--;
            this.hour = 24 - Math.abs(diffHours);
        } else {
            this.hour -= h;
        }
    }

    public int diffDateInYear(DateTime dateTime){
        return this.year - dateTime.year;
    }

    public int diffDateInMonth(DateTime dateTime){
        return diffDateInYear(dateTime) * 12 + this.month - dateTime.month;
    }

    public int diffDateInDay(DateTime dateTime){
        return getNumOfDays() - dateTime.getNumOfDays();
    }

    public long diffDateInHour(DateTime dateTime){
        return diffDateInDay(dateTime) * 24L + this.hour - dateTime.hour;
    }

    public long diffDateInMinute(DateTime dateTime){
        return diffDateInHour(dateTime) * 60 + this.minute - dateTime.minute;
    }

    public long diffDateInSecond(DateTime dateTime){
        return diffDateInMinute(dateTime) * 60 + this.second - dateTime.second;
    }

    private int getNumOfDays(){
        int m = month;
        int y = year;
        if (month < 3){
            y--;
            m += 12;
        }
        return 365*y + y/4 - y/100 + y/400 + (153*m - 457)/5 + day - 306;
    }

    @Override
    public String toString() {
        return "Date{" +
                "day=" + day +
                ", month=" + month +
                ", year=" + year +
                ", hour=" + hour +
                ", minute=" + minute +
                ", second=" + second +
                '}';
    }
}
