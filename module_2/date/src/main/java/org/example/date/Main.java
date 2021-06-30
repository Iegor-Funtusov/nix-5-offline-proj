package org.example.date;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> dates = new ArrayList<>();
        dates.add("2020/04/05");
        dates.add("2020-04-06");
        dates.add("05/07/2020");
        dates.add("32/04/2020");
        dates.add("11-05-2020");

        DateConverter converter = new DateConverter(dates);

        System.out.println("New date format: " + converter.convert());
    }
}
