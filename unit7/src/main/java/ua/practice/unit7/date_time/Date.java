package ua.practice.unit7.date_time;

import org.apache.maven.surefire.shade.org.apache.commons.lang3.math.NumberUtils;

public class Date implements Comparable<Date> {
    private int day = 1;
    private Months month;
    private YearClass year;

    public Date() {
        this.month = Months.JANUARY;
        this.year = new YearClass(0);
    }

    public Date(String day, String month, String year) {
        this.month = Months.JANUARY;
        this.year = new YearClass(0);
        this.initYear(year.trim());
        this.initMonth(month);
        this.initDay(day);
    }

    private void initYear(String year) {
        if (!year.isBlank()) {
            try {
                this.year = new YearClass(Integer.parseInt(year));
            } catch (NumberFormatException var3) {
                throw new RuntimeException("Wrong input for year");
            }
        }

    }

    private void initMonth(String month) {
        if (!month.isEmpty()) {
            if (NumberUtils.isParsable(month)) {
                int monthNumber = Integer.parseInt(month);

                for (Months months : Months.values()) {
                    if (months.getMonthNumber() == monthNumber) {
                        this.month = months;
                        return;
                    }
                }
            } else {

                for (Months months : Months.values()) {
                    if (months.name().equalsIgnoreCase(month)) {
                        this.month = months;
                        return;
                    }
                }
            }

            throw new RuntimeException("Wrong input for month");
        }
    }

    private void initDay(String day) {
        if (!day.isEmpty()) {
            try {
                this.day = Integer.parseInt(day);
                if (this.day < 0 || this.day > this.month.getNumberOfDays()) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException var3) {
                throw new RuntimeException("Wrong input for day");
            }
        }

    }

    public int getDay() {
        return this.day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public Months getMonth() {
        return this.month;
    }

    public void setMonth(Months month) {
        this.month = month;
    }

    public YearClass getYear() {
        return this.year;
    }

    public void setYear(YearClass year) {
        this.year = year;
    }

    public String toString() {
        return this.day + "/" + this.month + "/" + this.year;
    }

    public int compareTo(Date o) {
        if (year.getYear() > o.getYear().getYear()) {
            return 1;
        } else {
            if (year.getYear() == o.getYear().getYear()) {
                if (month.getMonthNumber() > o.getMonth().getMonthNumber()) {
                    return 1;
                }
                if (month.getMonthNumber() == o.getMonth().getMonthNumber()) {
                    if (day > o.getDay()) {
                        return 1;
                    }

                    if (day == o.getDay()) {
                        return 0;
                    }
                }
            }

            return -1;
        }
    }
}