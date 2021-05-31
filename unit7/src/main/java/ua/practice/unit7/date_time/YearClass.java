package ua.practice.unit7.date_time;

public class YearClass {
    private int year = 2021;
    private boolean isLeap;

    public YearClass(int year) {
        this.checkValidYear(year);
        this.checkLeap(year);
    }

    private void checkValidYear(int year) {
        if (year < 0) {
            throw new RuntimeException();
        } else {
            this.year = year;
        }
    }

    private void checkLeap(int year) {
        if (year % 400 == 0 || year % 4 == 0 && year % 100 != 0) {
            this.isLeap = true;
        }

    }

    public int getYear() {
        return this.year;
    }

    public boolean isLeap() {
        return this.isLeap;
    }

    public String toString() {
        return "" + this.year;
    }
}
