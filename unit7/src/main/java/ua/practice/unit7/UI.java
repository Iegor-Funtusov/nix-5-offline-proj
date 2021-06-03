package ua.practice.unit7;

import ua.practice.unit7.handlers.DataTypes;
import ua.practice.unit7.handlers.DateTime;
import ua.practice.unit7.handlers.DateTimeFormatter;

import java.io.BufferedReader;
import java.io.IOException;

public class UI {
    public static DateTimeFormatter formatter = new DateTimeFormatter();

    public static void initFormat(BufferedReader bufferedReader) throws IOException {
        String input;
        printFormatOptions();
        while ((input = bufferedReader.readLine()) != null)
        {
            switch (input)
            {
                case "1":
                   formatter.setDataType(DataTypes.TYPE1);
                   return;
                case "2":
                   formatter.setDataType(DataTypes.TYPE2);
                   return;
                case "3":
                   formatter.setDataType(DataTypes.TYPE3);
                   return;
                case "4":
                   formatter.setDataType(DataTypes.TYPE4);
                   return;
                default:
                    System.out.println("Incorrect format type. Try again");
            }
            printFormatOptions();
        }
    }

    private static void printFormatOptions(){
        System.out.println("Choose input format type: ");
        System.out.println("1 - " + DataTypes.TYPE1.getType());
        System.out.println("2 - " + DataTypes.TYPE2.getType());
        System.out.println("3 - " + DataTypes.TYPE3.getType());
        System.out.println("4 - " + DataTypes.TYPE4.getType());
    }


}
