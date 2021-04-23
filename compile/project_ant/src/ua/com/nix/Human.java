package ua.com.nix;

import org.apache.commons.lang3.*;
import org.apache.commons.io.*;

public class Human {
    public static void main(String[] args) {
        Man man = new Man();
        Woman woman = new Woman();
        String s1 = man.greeting();
        String s2 = woman.greeting();
        String s1_Upper = StringUtils.upperCase(s1);
        System.out.println("Gretting: " + s1 + "\n" + s2);
        System.out.println("Tranform to upper case:" + s1_Upper);
        System.out.println("Equality Check man's greeting (case sensitive): " + IOCase.SENSITIVE.checkEquals(s1, s1_Upper));

    }
}
