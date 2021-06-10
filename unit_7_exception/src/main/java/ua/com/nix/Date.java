package ua.com.nix;

public class Date {

    private int year, month, day, hour, minutes, seconds;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year >= 0) {
            this.year = year;
        }
        else {
            throw new IllegalArgumentException("Вы ввели неправильное значение.");
        }
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if (month >= 1 && month <= 12) {
            this.month = month;
        }
        else {
            throw new IllegalArgumentException("Вы ввели неправильное значение.");
        }
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        if (day >= 0 && day <= 31) {
            this.day = day;
        }
        else {
            throw new IllegalArgumentException("Вы ввели неправильное значение.");
        }
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        if (hour >= 0 && hour <= 23) {
            this.hour = hour;
        }
        else {
            throw new IllegalArgumentException("Вы ввели неправильное значение.");
        }
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        if (minutes >= 0 && minutes <= 59) {
            this.minutes = minutes;
        }
        else {
            throw new IllegalArgumentException("Вы ввели неправильное значение.");
        }
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        if (seconds >= 0 && seconds <= 59) {
            this.seconds = seconds;
        }
        else {
            throw new IllegalArgumentException("Вы ввели неправильное значение.");
        }
    }
}
