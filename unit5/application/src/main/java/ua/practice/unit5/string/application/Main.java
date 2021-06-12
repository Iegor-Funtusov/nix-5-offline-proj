package ua.practice.unit5.string.application;

import ua.practice.unit5.string.library.StringReverse;

import java.io.*;

public class Main {
    static final String PRINT_INPUT = "Input your string:";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input;
        printOptions();
        while ((input = bufferedReader.readLine()) != null) {
            switch (input) {
                case "1":
                    System.out.println(PRINT_INPUT);
                    System.out.println(StringReverse.reverse(bufferedReader.readLine()));
                    break;
                case "2":
                    System.out.println(PRINT_INPUT);
                    input = bufferedReader.readLine();
                    System.out.println("Input your substring");
                    String substring = bufferedReader.readLine();
                    System.out.println(StringReverse.reverse(input, substring));
                    break;
                case "3":
                    System.out.println(PRINT_INPUT);
                    input = bufferedReader.readLine();
                    System.out.println("Input first index:");
                    int firstIndex = Integer.parseInt(bufferedReader.readLine());
                    System.out.println("Input last index:");
                    int lastIndex = Integer.parseInt(bufferedReader.readLine());
                    System.out.println(StringReverse.reverse(input, firstIndex, lastIndex));
                    break;
                case "4":
                    System.out.println(PRINT_INPUT);
                    input = bufferedReader.readLine();
                    System.out.println("Input first char:");
                    char firstChar = bufferedReader.readLine().charAt(0);
                    System.out.println("Input last char:");
                    char lastChar = bufferedReader.readLine().charAt(0);
                    System.out.println(StringReverse.reverse(input, firstChar, lastChar));
                    break;
                case "5":
                    System.out.println(PRINT_INPUT);
                    input = bufferedReader.readLine();
                    System.out.println("Input char sequence:");
                    CharSequence charSequence = bufferedReader.readLine();
                    System.out.println(StringReverse.reverse(input, charSequence));
                    break;
                case "6":
                    return;
                default:
                    System.out.println("Wrong input! Try again.");
                    continue;
            }
            printOptions();
        }
    }

    static void printOptions() {
        System.out.println("Choose an option:");
        System.out.println("1 - Reverse string");
        System.out.println("2 - Reverse string with substring");
        System.out.println("3 - Reverse string from startIndex to lastIndex");
        System.out.println("4 - Reverse string from startChar to lastChar");
        System.out.println("5 - Reverse string with charSequence");
        System.out.println("6 - Stop");
    }
}