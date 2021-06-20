package com.lapchenko.kirill.project.lib;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Date implements Comparable{
    private int year;
    private int month;
    private int day;
    private int hours;
    private int minutes;
    private int seconds;

    public Date(int year, int month, int day, int hours, int minutes, int seconds) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public Date(Date date) {
        this.year = date.year;
        this.month = date.month;
        this.day = date.day;
        this.hours = date.hours;
        this.minutes = date.minutes;
        this.seconds = date.seconds;
    }

    @Override
    public int compareTo(Object o) {
        Date tmp = (Date)o;
        if(year != tmp.year)
            return year - tmp.year;
        else if(month != tmp.month)
            return month - tmp.month;
        else if(day != tmp.day)
            return day - tmp.day;
        else if(hours != tmp.hours)
            return hours - tmp.hours;
        else if(minutes != tmp.minutes)
            return minutes - tmp.minutes;
        else if(seconds != seconds)
            return seconds - tmp.seconds;
        else return 0;
    }

    @Override
    public String toString() {
        return "" + day + "/" + month + "/" + year + " "
                + hours + ":" + minutes + ":" + seconds;
    }
}
