package com.example.reverser;

import com.example.string_reverse.StringReverse;

public class Main {
    public static void main(String[] args) {
        String helloStr = "hello world";
        System.out.println(StringReverse.reverse(helloStr));
        System.out.println(StringReverse.reverse(helloStr, "worl"));
        System.out.println(StringReverse.reverse(helloStr,3,8));
        System.out.println(StringReverse.reverse(helloStr, 'h','w'));
        System.out.println(StringReverse.reverse(helloStr, "el", "ld"));
    }
}
