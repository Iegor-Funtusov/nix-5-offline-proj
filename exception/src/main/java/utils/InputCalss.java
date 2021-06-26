package utils;

import datas.Calendar;
import exceptions.ExceptionClass;

import java.util.Scanner;

public class InputCalss {
    public static Calendar readConsole(String format) throws ExceptionClass {

        Calendar date = null;
        Scanner scanner = new Scanner(System.in);
        if (format.contains(" ")) {
            date = new Calendar(scanner.next(), scanner.next(), format);
        } else {
            date = new Calendar(scanner.next(), format);
        }
        return date;
    }
}
