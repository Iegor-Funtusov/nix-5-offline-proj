package ua.practice.unit7.date_time;

public class Date implements Comparable<Date> {
    private int day = 1;
    private Months month = Months.JANUARY;
    private int year;

    public Date() {
    }

    public Date(int day, int month, int year) {
        setYear(year);
        setMonth(month);
        setDay(day);
    }

    public Date(String day, String month, String year) {
        setYear(Integer.parseInt(year.trim()));
        initMonthByName(month.trim());
        setDay(Integer.parseInt(day.trim()));
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        if (day < 0 || day > month.getNumberOfDays()) {
            if (isCurrentYearLeap() && month == Months.FEBRUARY && day == 29) {
                this.day = day;
                return;
            }
            throw new IllegalArgumentException("Incorrect input day");
        }
        this.day = day;
    }

    public Months getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if (month < 0 || month > 12)
            throw new IllegalArgumentException("Incorrect input month");
        this.month = Months.getMonth(month);
    }

    private void initMonthByName(String name) {
        try {
            int tempMonth = Integer.parseInt(name);
            setMonth(tempMonth);
        } catch (NumberFormatException ex) {
            setMonth(Months.getMonthByName(name).getMonthNumber());
        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year < 0)
            throw new IllegalArgumentException("Year is less than zero");
        if (year > 22 && year < 100)
            year += 1900;
        this.year = year;
    }


    private boolean isCurrentYearLeap() {
        return year % 400 == 0 || year % 4 == 0 && year % 100 != 0;
    }


    @Override
    public int compareTo(Date o) {
        if (getYear() > o.getYear()) {
            return 1;
        } else {
            if (getYear() == o.getYear()) {
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
