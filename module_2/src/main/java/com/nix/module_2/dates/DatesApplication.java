package com.nix.module_2.dates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DatesApplication {
    public static void run() {
        List<String> dateStrings = new ArrayList<>(Arrays.asList("2024/1/05",
                                                                 "13/11/2006",
                                                                 "04-05-2020",
                                                                 "29/2/2001",
                                                                 "//",
                                                                 "8-4-3035"));
        List<Date> dates = new ArrayList<>();

        dateStrings.forEach(i -> {
            try {
                int[] ymd = DateFormatUtil.parseDate(i);
                dates.add(new Date(ymd[0], ymd[1], ymd[2]));
            } catch (DateException ignored) {

            }
                });

        System.out.println("\n=====\nDates\n=====");
        System.out.println("Input strings:\n" + dateStrings + "\nOutput:");
        dates.forEach(System.out::println);
    }

}
