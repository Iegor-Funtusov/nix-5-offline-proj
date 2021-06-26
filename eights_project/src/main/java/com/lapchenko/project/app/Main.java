package com.lapchenko.project.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Would you like to work with double mathSet or ind?\n" +
                "1 - Double\n" +
                "2 - Integer\n" +
                "Your input >");
        int userInput = Integer.parseInt(reader.readLine());
        if(userInput == 1) {
            new MathSetUIDouble().start();
        }else {
            new MathSetUIInteger().start();
        }
    }
}
