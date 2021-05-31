package ua.practice.unit7.handlers;

import ua.practice.unit7.date_time.Date;
import ua.practice.unit7.date_time.Time;

public class DateTime implements Comparable<DateTime> {
    Date date;
    Time timeOfDay = new Time();

    public DateTime(String input, DataTypes dataType) {
        this.processInput(input + " ", dataType);
    }

    public DateTime(Date date, Time timeOfDay) {
        this.date = date;
        this.timeOfDay = timeOfDay;
    }

    private void processInput(String input, DataTypes dataTypes) {
        switch(dataTypes) {
            case TYPE1:
                String[] parts = input.split("/");
                this.date = new Date(parts[0], parts[1], parts[2]);
                break;
            case TYPE2:
                String[] parts1 = input.split("/");
                this.date = new Date(parts1[1], parts1[0], parts1[2]);
                break;
            case TYPE3:
                String[] parts2 = input.split("-");
                this.date = new Date(parts2[1], parts2[0], parts2[2]);
                break;
            case TYPE4:
                break;
            default:
                System.out.println("Incorrect input");
                throw new RuntimeException();
        }

    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTimeOfDay() {
        return this.timeOfDay;
    }

    public void setTimeOfDay(Time timeOfDay) {
        this.timeOfDay = timeOfDay;
    }

    public String toString() {
        return "DateTime{" + this.date + " " + this.timeOfDay + "}";
    }

    public int compareTo(DateTime o) {
        if (this.date.compareTo(o.getDate()) > 0) {
            return 1;
        } else {
            if (this.date.compareTo(o.getDate()) == 0) {
                if (this.timeOfDay.compareTo(o.getTimeOfDay()) > 0) {
                    return 1;
                }

                if (this.timeOfDay.compareTo(o.getTimeOfDay()) == 0) {
                    return 0;
                }
            }

            return -1;
        }
    }
}
