package com.nix.module_2.dates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void run() {
        List<String> dateStrings = new ArrayList<>(Arrays.asList("2024/1/05",
                                                                 "13/11/2006",
                                                                 "04-05-2020",
                                                                 "28/2/2001",
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

        dates.forEach(System.out::println);
    }

}
