package ua.com.alevel.app;

import ua.com.alevel.lib.ReverseString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Controller {

    public static BufferedReader reader;

    public static void start() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        String input;

        try {
            System.out.println("Choose what you want to do:\n" +
                    "1 -> Reverse string\n" +
                    "2 -> Reverse substring in string\n" +
                    "3 -> Reverse for user choice\n" +
                    "0 -> Exit");
            while ((input = reader.readLine())!= null) {
                switch (input) {
                    case "1" : {
                        reverseStr();
                    } break;
                    case "2" : {
                        reverseSubStr();
                    } break;
                    case "3" : {
                        reverseUserChoice();
                    } break;
                    case "0": {
                        System.exit(0);
                    }
                    default: {
                        System.out.println("Wrong input. Select numbers");
                    }break;

                }
                System.out.println("Choose what you want to do:\n" +
                        "1 -> Reverse string\n" +
                        "2 -> Reverse substring in string\n" +
                        "3 -> Reverse for user choice\n" +
                        "0 -> Exit");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void reverseStr() throws IOException {
        System.out.println("Input string: ");
        String str = reader.readLine();
        System.out.println(ReverseString.reverse(str));
    }

    public static void reverseSubStr() throws IOException {
        System.out.println("Input string: ");
        String str = reader.readLine();
        System.out.println("Input substring you want to reverse: ");
        String subStr = reader.readLine();
        System.out.println(ReverseString.reverse(str, subStr));
    }

    public static void reverseUserChoice() {
        String input;
        try {
            System.out.println("Pick format interval\n" +
                    "1 -> Index\n" +
                    "2 -> Char\n" +
                    "3 -> String\n" +
                    "4 -> Char sequence\n" +
                    "0 -> Exit");
            while ((input = reader.readLine())!= null) {
                switch (input) {
                    case "1" : {
                        reverseForIndex();
                    } break;
                    case "2" : {
                        reverseForChar();
                    } break;
                    case "3" : {
                        reverseForStr();
                    } break;
                    case "4": {
                        reverseForCharSequence();
                    } break;
                    case "0":{
                        System.exit(0);
                    }
                    default: {
                        System.out.println("Wrong input. Select numbers");
                    }break;
                }
                System.out.println("Pick format interval\n" +
                        "1 -> Index\n" +
                        "2 -> Char\n" +
                        "3 -> String\n" +
                        "4 -> Char sequence\n" +
                        "0 -> Exit");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void reverseForIndex() throws IOException {
        System.out.println("Enter the string: ");
        String str = reader.readLine();
        System.out.println("Enter first index: ");
        int firstIndex = Integer.parseInt(reader.readLine());
        System.out.println("Enter second index: ");
        int secondIndex = Integer.parseInt(reader.readLine());
        System.out.println(ReverseString.reverse(str, firstIndex, secondIndex));
    }

    public static void reverseForChar() throws IOException {
        System.out.println("Enter string: ");
        String str = reader.readLine();
        System.out.println("Enter first symbol: ");
        char firstChar = reader.readLine().charAt(0);
        System.out.println("Enter second symbol: ");
        char secondChar = reader.readLine().charAt(0);
        System.out.println(ReverseString.reverse(str, firstChar, secondChar));
    }

    public static void reverseForStr() throws IOException {
        System.out.println("Enter string: ");
        String str = reader.readLine();
        System.out.println("Enter first subString: ");
        String firstSubString = reader.readLine();
        System.out.println("Enter second subString: ");
        String secondSubString = reader.readLine();
        System.out.println(ReverseString.reverse(str, firstSubString, secondSubString));
    }

    public static void reverseForCharSequence() throws IOException {
        System.out.println("Enter string: ");
        String str = reader.readLine();
        System.out.println("Enter first char sequence: ");
        CharSequence firstCharSequence = reader.readLine();
        System.out.println("Enter second char sequence: ");
        CharSequence secondCharSequence = reader.readLine();
        System.out.println(ReverseString.reverse(str, firstCharSequence, secondCharSequence));
    }
}
