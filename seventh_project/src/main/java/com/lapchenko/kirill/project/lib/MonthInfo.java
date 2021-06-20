package com.lapchenko.kirill.project.lib;

import java.util.Locale;

public enum MonthInfo {
    JAN(31, "January"),
    FEB(28, "February"),
    MAR(31, "March"),
    APR(30, "April"),
    MAY(31, "May"),
    JUN(30, "June"),
    JUL(31, "July"),
    AUG(31, "August"),
    SEP(30, "September"),
    OCT(31, "October"),
    NOV(30, "November"),
    DEC(30, "December");
    private MonthInfo(int days, String name) {
        this.days = days;this.name = name;
    }
    private int days;
    private String name;
    public int value() {
        return days;
    }
    public String getName() {return name;}
    public static int getMonthNumber(String monthName) {
        switch (monthName.toLowerCase(Locale.ROOT)) {
            case "january": return 1;
            case "february": return 2;
            case "march": return 3;
            case "april": return 4;
            case "may": return 5;
            case "june": return 6;
            case "july": return 7;
            case "august": return 8;
            case "september": return 9;
            case "october": return 10;
            case "november": return 11;
            case "december": return 12;
        }
        throw new IllegalArgumentException();
    }
}
