package utils;

import java.util.HashMap;

public class CONSTANTS {

   public static HashMap<Integer, Integer> monthsMap = new HashMap<Integer, Integer>();

    static {
        monthsMap.put(1, 31);
        monthsMap.put(2, 28);
        monthsMap.put(3, 31);
        monthsMap.put(4, 30);
        monthsMap.put(5, 31);
        monthsMap.put(6, 30);
        monthsMap.put(7, 31);
        monthsMap.put(8, 31);
        monthsMap.put(9, 30);
        monthsMap.put(10, 31);
        monthsMap.put(11, 30);
        monthsMap.put(12, 31);
    }

   public static HashMap<Integer, String> monthsNames = new HashMap<Integer, String>();

    static {
        monthsNames.put(1, "January");
        monthsNames.put(2, "February");
        monthsNames.put(3, "March");
        monthsNames.put(4, "April");
        monthsNames.put(5, "May");
        monthsNames.put(6, "June");
        monthsNames.put(7, "July");
        monthsNames.put(8, "August");
        monthsNames.put(9, "September");
        monthsNames.put(10, "October");
        monthsNames.put(11, "November");
        monthsNames.put(12, "December");
    }

   public static HashMap<String, Integer> monthsMapNames = new HashMap<String, Integer>();

    static {
        monthsMapNames.put("January", 1);
        monthsMapNames.put("February", 2);
        monthsMapNames.put("March", 3);
        monthsMapNames.put("April", 4);
        monthsMapNames.put("May", 5);
        monthsMapNames.put("June", 6);
        monthsMapNames.put("July", 7);
        monthsMapNames.put("August", 8);
        monthsMapNames.put("September", 9);
        monthsMapNames.put("October", 10);
        monthsMapNames.put("November", 11);
        monthsMapNames.put("December", 12);
    }
}
