package com.Lapchenko_Kirill.project.second_level;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Balancer {
     public void isBalanced(String userString)
        {
            while
            (userString.contains("()") || userString.contains("[]") || userString.contains("{}")) {
                userString = userString.replaceAll("\\{\\}", "").
                replaceAll("\\(\\)", "").
                replaceAll("\\[\\]", "");
            }
            if(userString.length() == 0)
                System.out.println("Your string is balanced");
            else
                System.out.println("String is not balanced");
        }

        public String getUserInput() throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String regex = "[()\\[\\]{}]+";
            System.out.println("Enter your string with brackets: ");
            String userInput = reader.readLine();
            if(userInput.matches(regex))
                return userInput;
            else
                System.out.println("Wrong input try again!");
                return getUserInput();
        }
    }

