package ua.com.nix;

public class Date implements Comparable<Date> {

    private int second;
    private int minute;
    private int hour;
    private int day;
    private int month;
    private int year;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if(year <= 99 && year >= 0){
            this.year = 1900 + year;
        } else if (year >= 100){
            this.year = year;
        }
        else {
            throw new IllegalArgumentException("Извините, вы ввели неправильное значение.");
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

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        if (minute >= 0 && minute <= 59) {
            this.minute = minute;
        }
        else {
            throw new IllegalArgumentException("Вы ввели неправильное значение.");
        }
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        if (second >= 0 && second <= 59) {
            this.second = second;
        }
        else {
            throw new IllegalArgumentException("Вы ввели неправильное значение.");
        }
    }

    public int getDaysInMonth(int month, int year) {
        int daysInMonth;

        if (month == 2 && year % 4 == 0) {
            daysInMonth = 29;
        }
        else {
            daysInMonth = 28;
        }

        return daysInMonth;
    }

    @Override
    public String toString() {
        return "Date{" +
                "second=" + second +
                ", minute=" + minute +
                ", hour=" + hour +
                ", day=" + day +
                ", month=" + month +
                ", year=" + year +
                '}';
    }

    @Override
    public int compareTo(Date date) {
        int compare = this.getYear()-date.getYear();
        if (compare == 0) {
            compare = this.getSecond()-date.getSecond();
        }
        if (compare == 0) {
            compare = this.getMinute()-date.getMinute();
        }
        if (compare == 0) {
            compare = this.getDay()-date.getDay();
        }
        if (compare == 0) {
            compare = this.getMonth()-date.getMonth();
        }
        if (compare == 0) {
            compare = this.getHour()-date.getHour();
        }
        return compare;
    }

}
