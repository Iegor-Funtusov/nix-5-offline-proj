package nix.com.date_editor;

public class Date {

    private String day;
    private String month;
    private String year;
    private int hour;
    private int minute;
    private int second;

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
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

    @Override
    public String toString() {
        if (minute < 10) {
            return "Date{" +
                    day + '/' +
                    month + '/' +
                    year + " " +
                    hour + ":0" + minute +
                    '}';
        } else {
            return "Date{" +
                    day + '/' +
                    month + '/' +
                    year + " " +
                    hour + ":" + minute +
                    '}';
        }
    }

    public long getMils () {
        return (Long.parseLong(this.day) * 86400000L
                + Long.parseLong(this.month) * 2592000000L
                + Long.parseLong(this.year) * 31536000000L
                + this.hour * 3600000L
                + this.minute * 60000L
                + this.second * 1000L );
    }

    public void addDays(int days) {
        int daysOfMonth;
        for (int i = 1; i <= days; i++) {
            daysOfMonth = 28 + (Integer.parseInt(month) +
                    (Integer.parseInt(month) / 8)) % 2 + 2 %
                    Integer.parseInt(month) + 2 *
                    (1 / Integer.parseInt(month));
            if (Integer.parseInt(month) == 2 && Integer.parseInt(year) % 4 == 0) {
                daysOfMonth++;
            }
            this.day = String.valueOf(Integer.parseInt(this.day) + 1);
            if (Integer.parseInt(this.day) > daysOfMonth) {
                this.day = String.valueOf(1);
                month = String.valueOf(Integer.parseInt(this.month) + 1);
            }
            if (Integer.parseInt(this.month) > 12) {
                month = String.valueOf(1);
                year = String.valueOf(Integer.parseInt(this.year) + 1);
            }
        }
    }

    public void addYears(int addYears) {
        this.year = String.valueOf(addYears + Integer.parseInt(year));
    }

    public void addMonths(int addMonths) {
        int y = addMonths / 12;
        int m = addMonths - y * 12;
        addYears(y);
        this.month = String.valueOf(m + Integer.parseInt(month));
    }

    public void addHours(int hours) {
        int d = hours / 24;
        int h = hours - d * 24;
        addDays(d);
        if (hour + h > 23) {
            addDays(1);
        } else {
            this.hour += h;
        }
    }

    public void addMinutes(int minutes) {
        int h = minutes / 60;
        int m = minutes - h * 60;
        addHours(h);
        if (minutes + m > 59) {
            addHours(1);
        } else {
            this.minute += m;
        }
    }

    public void addSeconds(int seconds) {
        int m = seconds / 60;
        int s = seconds - m * 60;
        addMinutes(m);
        if (second + s > 59) {
            addHours(1);
        } else {
            this.second += s;
        }
    }


    public void subYears(int minusYears) {
        this.year = String.valueOf(Integer.parseInt(year) - minusYears);
    }

    public void subMonths(int addMonths) {
        int y = addMonths / 12;
        int m = addMonths - y * 12;
        subYears(y);
        this.month = String.valueOf(Integer.parseInt(this.month) - m);
    }

    public void subDays(int minusDays) {
        int daysOfMonth;
        int prevMonth;
        for (int i = 1; i <= minusDays; i++) {
            prevMonth = Integer.parseInt(this.month) - 1;
            if (prevMonth == 0) {
                prevMonth = 12;
            }
            daysOfMonth = 28 + (prevMonth + (prevMonth / 8))
                    % 2 + 2 % prevMonth + 2 * (1 / prevMonth);
            if (prevMonth == 2 && Integer.parseInt(year) % 4 == 0) {
                daysOfMonth++;
            }
            this.day = String.valueOf(Integer.parseInt(this.day) - 1);
            if (Integer.parseInt(this.day) < 1) {
                this.day = String.valueOf(daysOfMonth);
                month = String.valueOf(Integer.parseInt(month) - 1);
            }
            if (Integer.parseInt(month) < 1) {
                month = String.valueOf(12);
                year = String.valueOf(Integer.parseInt(year) - 1);
            }
        }
    }

    public void subHours(int hours) {
        int d = hours / 24;
        int h = hours - d * 24;
        subDays(d);
        int differenceHours = this.hour - h;
        if (differenceHours < 0) {
            subDays(1);
            this.hour = 24 - Math.abs(differenceHours);
        } else {
            this.hour -= h;
        }
    }

    public void subMinutes(int minutes) {
        int h = minutes / 60;
        int m = minutes - h * 60;
        subHours(h);
        int differenceMinutes = this.minute - m;
        if (differenceMinutes < 0) {
            subHours(1);
            this.minute = 60 - Math.abs(differenceMinutes);
        } else {
            this.minute -= m;
        }
    }

    public void subSeconds(int seconds) {
        int m = seconds / 60;
        int s = seconds - m * 60;
        subMinutes(m);
        int differenceSeconds = this.second - s;
        if (differenceSeconds < 0) {
            subMinutes(1);
            this.second = 60 - Math.abs(differenceSeconds);
        } else {
            this.second -= s;
        }
    }
}
