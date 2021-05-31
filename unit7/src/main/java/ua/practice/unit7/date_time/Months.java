package ua.practice.unit7.date_time;

public enum Months {
    JANUARY(1, 31),
    FEBRUARY(2, 28),
    MARCH(3, 31),
    APRIL(4, 30),
    MAY(5, 31),
    JUNE(6, 30),
    JULY(7, 31),
    AUGUST(8, 31),
    SEPTEMBER(9, 30),
    OCTOBER(10, 31),
    NOVEMBER(11, 30),
    DECEMBER(12, 31);

    private final int monthNumber;
    private final int numberOfDays;

    private Months(int monthNumber, int numberOfDays) {
        this.monthNumber = monthNumber;
        this.numberOfDays = numberOfDays;
    }

    public int getMonthNumber() {
        return this.monthNumber;
    }

    public int getNumberOfDays() {
        return this.numberOfDays;
    }
}
