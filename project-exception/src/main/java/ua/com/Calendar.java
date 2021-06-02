package ua.com;

import lombok.Getter;

@Getter
public class Calendar {
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;
    private int second;

    public void setYear(int year) {
        if (year < 100) {
            this.year = 1900 + year;
        } else {
            this.year = year;
        }
    }

    public void setMonth(int month) {
        if (month > 12) {
            throw new IllegalArgumentException("argument is out of range");
        }
        this.month = month;
    }

    public void setDay(int day) {
        if (day > 31) {
            throw new IllegalArgumentException("argument is out of range");
        }
        this.day = day;
    }

    public void setHour(int hour) {
        if (hour > 24) {
            throw new IllegalArgumentException("argument is out of range");
        }
        this.hour = hour;
    }

    public void setMinute(int minutes) {
        if (minutes > 59) {
            throw new IllegalArgumentException("argument is out of range");
        }
        this.minute = minutes;
    }

    public void plusYears(int years) {
        this.year += years;
    }

    public void plusMonths(int months) {
        int y = months / 12;
        int m = months - y * 12;
        plusYears(y);
        this.month += m;
    }

    public void plusDays(int days) {
        int daysOfMonth;
        for (int i = 1; i <= days; i++) {
            daysOfMonth = 28 + (month + (month / 8)) % 2 + 2 % month + 2 * (1 / month);
            if (month == 2 && year % 4 == 0) {
                daysOfMonth++;
            }
            this.day++;
            if (this.day > daysOfMonth) {
                this.day = 1;
                month++;
            }
            if (month > 12) {
                month = 1;
                year++;
            }
        }
    }

    public void plusHours(int hours) {
        int d = hours / 24;
        int h = hours - d * 24;
        plusDays(d);
        this.hour += h;
    }

    public void plusMinutes(int minutes) {
        int h = minutes / 60;
        int m = minutes - h * 60;
        plusHours(h);
        this.minute += m;
    }

    public void plusSeconds(int seconds) {
        int m = seconds / 60;
        int s = seconds - m * 60;
        plusMinutes(m);
        this.second += s;
    }

    public void minusYears(int years) {
        this.year -= years;
    }

    public void minusMonths(int months) {
        int y = months / 12;
        int m = months - y * 12;
        minusYears(y);
        this.month -= m;
    }

    public void minusDays(int days) {
        int daysOfMonth;
        int previousM;
        for (int i = 1; i <= days; i++) {
            previousM = month - 1;
            if (previousM == 0) {
                previousM = 12;
            }
            daysOfMonth = 28 + (previousM + (previousM / 8)) % 2 + 2 % previousM + 2 * (1 / previousM);
            if (previousM == 2 && year % 4 == 0) {
                daysOfMonth++;
            }
            this.day--;
            if (this.day < 1) {
                this.day = daysOfMonth;
                month--;
            }
            if (month < 1) {
                month = 12;
                year--;
            }
        }
    }

    public void minusHours(int hours) {
        int d = hours / 24;
        int h = hours - d * 24;
        minusDays(d);
        int diffHours = this.hour - h;
        if (diffHours < 0) {
            minusDays(1);
            this.hour = 24 - Math.abs(diffHours);
        } else {
            this.hour -= h;
        }
    }

    public void minusMinutes(int minutes) {
        int h = minutes / 60;
        int m = minutes - h * 60;
        minusHours(h);
        int diffMinutes = this.minute - m;
        if (diffMinutes < 0) {
            minusHours(1);
            this.minute = 60 - Math.abs(diffMinutes);
        } else {
            this.minute -= m;
        }
    }

    public void minusSeconds(int seconds) {
        int m = seconds / 60;
        int s = seconds - m * 60;
        minusMinutes(m);
        int diffSeconds = this.second - s;
        if (diffSeconds < 0) {
            minusMinutes(1);
            this.second = 60 - Math.abs(diffSeconds);
        } else {
            this.second -= s;
        }
    }

    public int getDiffYears(Calendar calendar) {
        return this.year - calendar.year;
    }

    public int getDiffMonths(Calendar calendar) {
        return getDateInMonths() - calendar.getDateInMonths();
    }

    public int getDiffDays(Calendar calendar) {
        return getDateInDays() - calendar.getDateInDays();
    }

    public long getDiffHours(Calendar calendar) {
        return getDateInHours() - calendar.getDateInHours();
    }

    public long getDiffMinutes(Calendar calendar) {
        return getDateInMinutes() - calendar.getDateInMinutes();
    }

    public long getDiffSeconds(Calendar calendar) {
        return getDateInSeconds() - calendar.getDateInSeconds();
    }

    @Override
    public String toString() {
        return "Date and Time: " +
                day +
                "/" + month +
                "/" + year +
                " " + hour +
                ":" + minute;
    }

    public int getDateInMonths() {
        return year * 12 + month;
    }

    public int getDateInDays() {
        int y = year;
        int m = month;
        if (month < 3) {
            y--;
            m += 12;
        }
        return 365 * y + y / 4 - y / 100 + y / 400 + (153 * m - 457) / 5 + day - 306;
    }

    public long getDateInHours() {
        return getDateInDays() * 24L;
    }

    public long getDateInMinutes() {
        return getDateInHours() * 60L;
    }

    public long getDateInSeconds() {
        return getDateInMinutes() * 60L;
    }
}
