package com.lapchenko.module.first.date;

public class DateValidator {

    public static boolean isDateValid(int day, int month, int year) {
        if(isLeapYear(year)) {
            if(month == 2 && day == 29){
                return true;
            }
        }
        if(month == 1 || month == 3 || month == 5 || month == 7
                || month == 8 || month == 10 || month == 12){
            if(day >= 1 && day <= 31) {
                return true;
            }
        }
        if(month == 2) {
            if(day >= 1 && day <= 28) {
                return true;
            }
        }
        if(month == 4 || month == 6 || month == 9 || month == 11) {
            if(day >= 1 && day <= 30) {
                return true;
            }
        }
        return false;
    }

    private static boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        }
        if (year % 100 == 0) {
            return false;
        }
        if (year % 4 == 0) {
            return true;
        }
        return false;
    }
}
