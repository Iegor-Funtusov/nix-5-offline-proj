package ua.davidenko.date;

import java.util.HashMap;
import java.util.Map;

import static ua.davidenko.date.Date.isLeapYear;

public class Months {
    public static Map<Integer, String> monthName = new HashMap<>();

    static {
        monthName.put(1, "Январь");
        monthName.put(2, "Февраль");
        monthName.put(3, "Март");
        monthName.put(4, "Апрель");
        monthName.put(5, "Май");
        monthName.put(6, "Июнь");
        monthName.put(7, "Июль");
        monthName.put(8, "Август");
        monthName.put(9, "Сентябрь");
        monthName.put(10, "Октябрь");
        monthName.put(11, "Ноябрь");
        monthName.put(12, "Декабрь");
    }

    public static Map<String, Integer> monthNameNumber = new HashMap<>();

    static {
        monthNameNumber.put("Январь", 1);
        monthNameNumber.put("Февраль", 2);
        monthNameNumber.put("Март", 3);
        monthNameNumber.put("Апрель", 4);
        monthNameNumber.put("Май", 5);
        monthNameNumber.put("Июнь", 6);
        monthNameNumber.put("Июль", 7);
        monthNameNumber.put("Август", 8);
        monthNameNumber.put("Сентябрь", 9);
        monthNameNumber.put("Октябрь", 10);
        monthNameNumber.put("Ноябрь", 11);
        monthNameNumber.put("Декабрь", 12);
    }

    public static int dayInMonth(int month) {
        int daysInMonth = 28;
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            daysInMonth = 31;
        }
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            daysInMonth = 30;
        }
        if (month == 2 && isLeapYear(new Date().getYears())) {
            daysInMonth = 29;
        }
        return daysInMonth;
    }
}
