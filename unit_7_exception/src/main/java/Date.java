public class Date implements Comparable<Date>{
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;
    private int second;

    public Date(){
        this.year = 0;
        this.month = 1;
        this.day = 1;
        this.hour = 0;
        this.minute = 0;
        this.second = 0;
    }

    public Date(int year, int month, int day, int hour, int minute, int second) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public Date(Date other) {
        this(other.getYear(),other.getMonth(),other.getDay(), other.getHour(),other.getMinute(),other.getSecond());
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    public void setYear(int year) {
        if (year < 0) {
            this.year = 0;
        } else if (year > 0 && year <= 21) {
            this.year = 2000 + year;
        } else if (year > 21 && year <= 99) {
            this.year = 1900 + year;
        } else {
            this.year = year;
        }
    }

    public void setMonth(int month) {
        if (month < 1 || month > 12) {
            this.month = 1;
        } else {
            this.month = month;
        }
    }

    public void setDay(int day) {
        if (day < 1 || day > 31) {
            this.day = 1;
        } else {
            this.day = day;
        }
    }

    public void setHour(int hour) {
        if (hour < 0 || hour > 23) {
            this.hour = 0;
        } else {
            this.hour = hour;
        }
    }

    public void setMinute(int minute) {
        if (minute < 0 || minute > 59) {
            this.minute = 0;
        } else {
            this.minute = minute;
        }
    }

    public void setSecond(int second) {
        if (second < 0 || second > 59) {
            this.second = 0;
        } else {
            this.second = second;
        }
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

    @Override
    public int compareTo(Date o) {
        int result = this.year-o.getYear();
        if (result == 0) {
            result = this.month-o.getMonth();
        }
        if (result == 0) {
            result = this.day-o.getDay();
        }
        if (result == 0) {
            result = this.hour-o.getHour();
        }
        if (result == 0) {
            result = this.minute-o.getMinute();
        }
        if (result == 0) {
            result = this.second-o.getSecond();
        }
        return result;
    }

}
