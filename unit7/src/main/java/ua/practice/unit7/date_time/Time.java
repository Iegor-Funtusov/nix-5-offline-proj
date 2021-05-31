package ua.practice.unit7.date_time;

public class Time implements Comparable<Time> {
    int hours;
    int minutes;
    int seconds;

    public Time(String hours, String minutes, String seconds) {
        this.initHours(hours);
        this.initMinutes(minutes);
        this.initSeconds(seconds);
    }

    public Time() {
    }

    private void initHours(String hours) {
        try {
            this.hours = Integer.parseInt(hours);
            if (this.hours < 0 || this.hours > 23) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException var3) {
            throw new RuntimeException("Wrong input for hours");
        }
    }

    private void initMinutes(String minutes) {
        try {
            this.minutes = Integer.parseInt(minutes);
            if (this.minutes < 0 || this.minutes > 59) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException var3) {
            throw new RuntimeException("Wrong input for minutes");
        }
    }

    private void initSeconds(String seconds) {
        try {
            this.seconds = Integer.parseInt(seconds);
            if (this.seconds < 0 || this.seconds > 59) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException var3) {
            throw new RuntimeException("Wrong input for seconds");
        }
    }

    public int getHours() {
        return this.hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMinutes() {
        return this.minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSeconds() {
        return this.seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public String toString() {
        return this.hours + ":" + this.minutes + ":" + this.seconds;
    }

    public int compareTo(Time o) {
        if (this.hours > o.getHours()) {
            return 1;
        } else {
            if (this.hours == o.getHours()) {
                if (this.minutes > o.getMinutes()) {
                    return 1;
                }

                if (this.minutes == o.getMinutes()) {
                    if (this.seconds > o.getSeconds()) {
                        return 1;
                    }

                    if (this.seconds == o.getSeconds()) {
                        return 0;
                    }
                }
            }

            return -1;
        }
    }
}
