package com.lapchenko.module.first.date;

public class DateParser {
    private static final String regexDDMMYYYY = "[0-9][0-9]/[0-9][0-9]/[0-9][0-9][0-9][0-9]";
    private static final String regexYYYYMMDD = "[0-9][0-9][0-9][0-9]/[0-9][0-9]/[0-9][0-9]";
    private static final String regexMMDDYYYY = "[0-9][0-9]-[0-9][0-9]-[0-9][0-9][0-9][0-9]";

    public static String tryParseDate(String date) {
        if (date.matches(regexDDMMYYYY)) {
            return parseDDMMYYYY(date);
        }
        if (date.matches(regexYYYYMMDD)) {
            return parseYYYYMMDD(date);
        }
        if (date.matches(regexMMDDYYYY)) {
            return parseMMDDYYYY(date);
        }
        throw new IllegalArgumentException("Invalid format");
    }

    public static String parseDDMMYYYY(String date) {
        int day = Integer.parseInt(date.substring(0, 2));
        int month = Integer.parseInt(date.substring(3, 5));
        int year = Integer.parseInt(date.substring(6, 10));
        if (DateValidator.isDateValid(day, month, year)) {
            return "" + year + month + day;
        }
        throw new IllegalArgumentException("Invalid date numbers");
    }

    public static String parseYYYYMMDD(String date) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, 10));
        if (DateValidator.isDateValid(day, month, year)) {
            return "" + year + month + day;
        }
        throw new IllegalArgumentException("Invalid date numbers");
    }

    public static String parseMMDDYYYY(String date) {
        int month = Integer.parseInt(date.substring(0, 2));
        int day = Integer.parseInt(date.substring(3, 5));
        int year = Integer.parseInt(date.substring(6, 10));
        if (DateValidator.isDateValid(day, month, year)) {
            return "" + year + month + day;
        }
        throw new IllegalArgumentException("Invalid date numbers");
    }
}
