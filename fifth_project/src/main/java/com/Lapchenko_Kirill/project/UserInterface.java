package com.Lapchenko_Kirill.project;

import com.Lapchenko_Kirill.lib.StringUtils;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInterface {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public UserInterface() throws IOException {
        while(true) {
            printMenu();
            callRightMethod();
        }
    }

    public void printMenu() {
        System.out.println("Which method do you want to test?\n" +
                "1 - To reverse string\n" +
                "2 - To reverse substring inside given string\n" +
                "3 - To reverse string in range (x,y)\n" +
                "4 - To exit program");
    }

    public void callRightMethod() throws IOException {
        int userInput = readInt();
        switch (userInput) {
            case 1:
                reverse();
                break;
            case 2:
                reverseMatchedString();
                break;
            case 3:
                reverseSubString();
                break;
            case 4:
                System.exit(0);
        }
    }

    public void reverse() throws IOException {
        String userInput = readString();
        System.out.println(StringUtils.reverse(userInput));
    }

    public void reverseMatchedString() throws IOException {
        System.out.println("Main string");
        String mainString = readString();
        System.out.println("Substring");
        String subString = readString();
        if(subString.length() > mainString.length()) {
            System.out.println("Your substring is bigger than main string, try again!");
            reverseMatchedString();
        }else{
            System.out.println(StringUtils.reverse(mainString, subString));
        }
    }

    public void reverseSubString() throws IOException {
        String userInput = readString();
        int begin = readInt();
        int end = readInt();
        if(end < begin || begin < 0 || end > userInput.length()){
            System.out.println("Wrong input, your substring is out of main string");
        }else {
            System.out.println(StringUtils.reverse(userInput, begin, end));
        }
    }

    private int readInt() throws IOException {
        System.out.println("Enter int value: ");
        String userInput = reader.readLine();
        String regex = "\\d+";
        if(userInput.matches(regex))
            return Integer.parseInt(userInput);
        else return readInt();
    }

    private String readString() throws IOException {
        System.out.println("Enter string: ");
        return reader.readLine();
    }
}
