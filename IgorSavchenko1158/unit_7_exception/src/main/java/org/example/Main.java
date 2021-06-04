package org.example;

import org.example.mydateandtime.MyDateAndTime;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main.main");
//        MyDateAndTime dt = new MyDateAndTime(2019, 1, 1, 0, 0, 0);
//        MyDateAndTime dt2 = new MyDateAndTime(2021, 1, 1, 0, 0, 0);
//        System.out.println(dt.getDateTimeInSeconds() - dt2.getDateTimeInSeconds());
//
//        dt = new MyDateAndTime(2021, 1, 1, 0, 0, 0);
//        dt2 = new MyDateAndTime(2023, 1, 1, 0, 0, 0);
//        System.out.println(dt.getDateTimeInSeconds() - dt2.getDateTimeInSeconds());

        MyDateAndTime ex = new MyDateAndTime(2021, 11, 13, 0,0,0);
        System.out.println("ex = " + ex);

//        System.out.println("Add 10 years");
//        ex = ex.addYears(10);
//        System.out.println("ex = " + ex);
//
//        System.out.println("Add 33 months");
//        ex = ex.addMonths(33);
//        System.out.println("ex = " + ex);
//
//        System.out.println("Add 2000 days");
//        ex = ex.addDays(2000);
//        System.out.println("ex = " + ex);
//
        System.out.println("add 2 hours");
        ex = ex.addHours(2);
        System.out.println("ex = " + ex);
//        System.out.println("add 1000 hours");
//        ex = ex.addHours(10000);
//        System.out.println("ex = " + ex);
//
//        System.out.println("Add 100_000 minutes");
//        ex = ex.addMinutes(100_000);
//        System.out.println("ex = " + ex);

//        System.out.println("Add 10000000 seconds");
//        ex = ex.addSeconds(10000000);
//        System.out.println("ex = " + ex);

//        System.out.println("Subtract 2021 years");
//        ex = ex.subtractYears(2021);
//        System.out.println("ex = " + ex);

        System.out.println("Subtract 10 months");
        ex  = ex.addMonths(-10);
        System.out.println("ex = " + ex);
    }
}
