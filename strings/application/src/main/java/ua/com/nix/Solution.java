package ua.com.nix;



import libs.ReverseString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean isCorrect = true;
        MainLabel:
        while(true)
        {
            System.out.println("1(Reverse full string),2(Reverse string with substring),3(Reverse string with start index and end index),4(Exit)");
            String s = reader.readLine();

            switch (s) {
                case "1": {
                    System.out.println("Enter string: ");
                    String s1 = reader.readLine();
                    s1 = ReverseString.reverse(s1);
                    System.out.println(s1);
                    break;
                }
                case "2": {
                    System.out.println("Enter string: ");
                    String s1 = reader.readLine();
                    System.out.println("Enter substring");
                    String substring = reader.readLine();
                    s1 = ReverseString.reverse(s1,substring);
                    System.out.println(s1);
                    break;
                }
                case "3": {
                    System.out.println("Enter string: ");
                    String s1 = reader.readLine();
                    System.out.println("Enter first index: ");
                    int firstIndex = Integer.parseInt(reader.readLine());
                    System.out.println("Enter last index: ");
                    int lastIndex = Integer.parseInt(reader.readLine());
                    s1 = ReverseString.reverse(s1, firstIndex, lastIndex);
                    System.out.println(s1);
                    break;
                }
                case "4":{
                    break MainLabel;
                }
                default:{
                    System.out.println("Enter the correct command");
                    break;
                }
            }

        }
    }
}
