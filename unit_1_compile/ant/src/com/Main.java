package com;
import org.apache.commons.lang3.StringUtils;

public class Main {
    public static void main(String[] args) {
        String s ="world";
        s = StringUtils.upperCase(s);
        Print print = new Print();
        print.print(s);
        Person person = new Person();
        print.print(person.getName());
    }
}