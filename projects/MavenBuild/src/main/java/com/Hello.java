package com;

import org.apache.commons.lang3.*;
import org.apache.commons.collections4.*;

public class Hello {
    public static void main(String[] args) {
        System.out.println("Hi");
        PrintHello printHello = new PrintHello();
        printHello.Print();
        UpperCase upperCase = new UpperCase();
        upperCase.toUpperCase();
    }
}
