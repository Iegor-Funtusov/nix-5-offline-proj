package ua.davidenko.date;

public class Date implements Comparable<Date> {
    private int years;
    private int months;
    private int days;
    private int hours;
    private int minutes;
    private int seconds;

    public Date(int years, int months, int days, int hours, int minutes, int seconds) {
        this.years = years;
        this.months = months;
        this.days = days;
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public Date(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public Date(){}

    public  int getYears() {
        return years;
    }

    public void setYears(int years) {
        if (years <= 100) {
            this.years = years + 1900;
        } else
            this.years = years;
    }

    public int getMonths() {
        return months;
    }

    public void setMonths(int months) {
        if (months < 1 || months > 12) {
            throw new IllegalArgumentException("Month can be from 1 to 12");
        } else
            this.months = months;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        if (days < 1 || days > 31) {
            throw new IllegalArgumentException("Days can be from 1 to 31");
        } else
            this.days = days;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        if (hours < 0 || hours > 24) {
            throw new IllegalArgumentException("Hours can be from 1 to 24");
        } else
            this.hours = hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        if (minutes < 1 || minutes > 60) {
            throw new IllegalArgumentException("Minutes can be from 1 to 60");
        } else
            this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        if (seconds < 1 || seconds > 60) {
            throw new IllegalArgumentException("Seconds can be from 1 to 60");
        } else
            this.seconds = seconds;
    }

    public void addSeconds(int sec) {
        seconds += sec;
        if (seconds == 60) {
            seconds = 0;
            addMinutes(1);
        } else if (seconds > 60) {
            int remainder = seconds % 60;
            int additionalMinutes = seconds / 60;
            seconds = remainder;
            addMinutes(additionalMinutes);
        }
    }

    public void addMinutes(int min) {
        minutes += min;
        if (minutes == 60) {
            minutes = 0;
            addHours(1);
        } else if (minutes > 60) {
            int remainder = minutes % 60;
            int additionalHours = minutes / 60;
            minutes = remainder;
            addHours(additionalHours);
        }
    }

    public void addHours(int hrs) {
        hours += hrs;
        if (hours == 24) {
            minutes = 0;
            addDays(1);
        } else if (hours > 24) {
            int remainder = hours % 24;
            int additionalDay = hours / 24;
            hours = remainder;
            addDays(additionalDay);
        }
    }

    public void addDays(int day) {
        for (int i = 1; i <= day; i++) {
            this.days++;
            if (this.days > Months.dayInMonth(months)) {
                this.days = 1;
                months++;
            }
            if (months > 12) {
                months = 1;
                years++;
            }
        }
    }

    public void addMonths(int mth) {
        months += mth;
        if (months == 12) {
            months = 0;
            addYears(1);
        } else if (months > 12) {
            int remainder = months % 12;
            int additionalYear = months / 12;
            months = remainder;
            addYears(additionalYear);
        }
    }

    public void addYears(int year) {
        this.years += year;
    }

    public void minusSeconds(int sec) {
        seconds -= sec;
        if (seconds < 0) {
            int a = Math.abs(seconds);
            int remainder = a % 60;
            int additionalMinutes = 1 + a / 60;
            seconds = 60 - remainder;
            minusMinutes(additionalMinutes);
        }
    }

    public void minusMinutes(int min) {
        minutes -= min;
        if (minutes < 0) {
            int a = Math.abs(minutes);
            int remainder = a % 60;
            int additionalHours = 1 + a / 60;
            minutes = 60 - remainder;
            minusHours(additionalHours);
        }
    }

    public void minusHours(int hrs) {
        int d = hrs / 24;
        int h = hrs - d * 24;
        minusDays(d);
        int minusHour = this.hours - h;
        if (minusHour < 0) {
            minusDays(1);
            this.hours = 24 - Math.abs(minusHour);
        } else {
            this.hours -= h;
        }
    }

    public void minusDays(int day) {
        int month;
        for (int i = 1; i <= day; i++) {
            month = months - 1;
            if (month == 0) {
                month = 12;
            }
            this.days--;
            if (this.days < 1) {
                this.days = Months.dayInMonth(month);
                months--;
            }
            if (months < 1) {
                months = 12;
                years--;
            }
        }
    }

    public void minusMonths(int mth) {
        int y = mth / 12;
        int m = mth - y * 12;
        minusYears(y);
        this.months -= m;
    }

    public void minusYears(int year) {
        this.years -= year;
    }

    public static boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 != 0) {
                return true;
            } else return year % 400 == 0;
        }
        return false;
    }

    @Override
    public String toString() {
        return
                "years=" + years +
                        ", months=" + months +
                        ", days=" + days +
                        ", hours=" + hours +
                        ", minutes=" + minutes +
                        ", seconds=" + seconds;
    }

    @Override
    public int compareTo(Date o) {
        int compare = this.getYears() - o.getYears();
        if (compare == 0) {
            compare = this.getMonths() - o.getMonths();
        }
        if (compare == 0) {
            compare = this.getDays() - o.getDays();
        }
        if (compare == 0) {
            compare = this.getHours() - o.getHours();
        }
        if (compare == 0) {
            compare = this.getMinutes() - o.getMinutes();
        }
        if (compare == 0) {
            compare = this.getSeconds() - o.getSeconds();
        }
        return compare;
    }
}



