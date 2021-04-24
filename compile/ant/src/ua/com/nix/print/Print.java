package ua.com.nix.print;

import org.apache.commons.lang3.*;

public class Print{
    public static void main(String[] args) {
        String s = "Hello";
        System.out.println(s);
        s = StringUtils.upperCase(s);
        System.out.println(s);
    }
}