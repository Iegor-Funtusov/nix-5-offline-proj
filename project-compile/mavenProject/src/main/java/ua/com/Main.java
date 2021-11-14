package ua.com;

import org.apache.commons.lang3.*;

public class Main {
    public static void main(String[] args) {
        String string = "Hello World!";
        System.out.println(string);
        string = StringUtils.upperCase(string);
        System.out.println(string);
    }
}