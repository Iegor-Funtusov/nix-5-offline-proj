package ua.practice.unit7.date_time;

import ua.practice.unit7.formatter.DataTypes;

public class DateTime implements Comparable<DateTime> {
    private Date date;
    private Time time;

    public DateTime(String input, DataTypes dataType) {
        date = new Date();
        time = new Time();
        this.processInput(input + " ", dataType);
    }

    public DateTime(Date date, Time time) {
        setDate(date);
        setTime(time);
    }

    private void processInput(String input, DataTypes dataTypes) throws ArrayIndexOutOfBoundsException {
        String[] parts;
        switch (dataTypes) {
            case TYPE1:
                parts = input.split("/");
                this.date = new Date(parts[0], parts[1], parts[2]);
                break;
            case TYPE2:
                parts = input.split("/");
                this.date = new Date(parts[1], parts[0], parts[2]);
                break;
            case TYPE3:
                parts = input.split("-");
                this.date = new Date(parts[1], parts[0], parts[2]);
                break;
            case TYPE4:
                parts = input.split("-|\\s|:");
                this.date = new Date(parts[0], parts[1], parts[2]);
                this.time = new Time(parts[3], parts[4], "0");
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

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String toString() {
        return "DateTime{" + this.date + " " + this.time + "}";
    }

    public int compareTo(DateTime o) {
        if (this.date.compareTo(o.getDate()) > 0) {
            return 1;
        } else {
            if (this.date.compareTo(o.getDate()) == 0) {
                if (this.time.compareTo(o.getTime()) > 0) {
                    return 1;
                }

                if (this.time.compareTo(o.getTime()) == 0) {
                    return 0;
                }
            }

            return -1;
        }
    }
}
