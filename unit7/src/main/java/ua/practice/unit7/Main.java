package ua.practice.unit7;

import ua.practice.unit7.handlers.DataTypes;
import ua.practice.unit7.handlers.DateHandler;
import ua.practice.unit7.handlers.DateTime;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        System.out.println("Input date format: ");
        System.out.println("1 - dd/mm/yy");
        System.out.println("2 - m/d/yyyy");
        System.out.println("3 - mmm-d-yy");
        System.out.println("4 - dd-mmm-yyyy 00:00");


        DateTime dateTime = new DateTime("25/7/2021", DataTypes.TYPE1);
        System.out.println(dateTime);

        DateTime dateTime1 = new DateTime("3/27/2027", DataTypes.TYPE2);
        System.out.println(dateTime1);

        DateHandler dateHandler = new DateHandler(dateTime, dateTime1);
        dateHandler.differenceBetweenDates();


        DateTime dateTime3 = new DateTime("5/5/2021", DataTypes.TYPE1);
        System.out.println(dateTime3);

        DateTime dateTime4 = new DateTime("7/5/10", DataTypes.TYPE2);
        System.out.println(dateTime4);

        DateHandler dateHandler1 = new DateHandler(dateTime3, dateTime4);
        dateHandler1.addToDate();

        System.out.println("-".repeat(40));
        DateTime dateTime5 = new DateTime("5/5/2021", DataTypes.TYPE1);
        System.out.println(dateTime5);
        DateTime dateTime6 = new DateTime("5/20/25", DataTypes.TYPE2);
        System.out.println(dateTime6);
        DateHandler dateHandler2 = new DateHandler(dateTime5, dateTime6);
        dateHandler2.subFromDate();

        System.out.println(dateTime6.compareTo(dateTime5));
    }
}
