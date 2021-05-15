package ua.com.alevel;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class AppMain {
    public static void main(String[] args) throws IOException {
        Reverse reverseString = new Reverse();
        BufferedReader enter = new BufferedReader(new InputStreamReader(System.in));
        int choose;

        while (true) {
            System.out.println("""
                    Choose an operation:
                    1. Reverse string
                    2. Reverse string by substring
                    3. Reverse string by index
                    4. Exit
                   
                     """);

            choose = Integer.parseInt(enter.readLine());

            if (choose != 1 && choose != 2 && choose != 3 && choose != 4){
                System.out.println("Wrong input");
                return;
            }
            String str;

            switch (choose) {
                case 1 -> {
                    System.out.println("Enter string: ");
                    str = enter.readLine();
                    checkString(str);
                    System.out.println(reverseString.toReverse(str));
                }
                case 2 -> {
                    System.out.println("Enter string: ");
                    str = enter.readLine();
                    checkString(str);
                    System.out.println("Enter substring: ");
                    String subStr = enter.readLine();
                    checkString(subStr);
                    System.out.println(reverseString.ReverseBySubStr(str, subStr));
                }
                case 3 -> {
                    System.out.println("Enter string: ");
                    str = enter.readLine();
                    checkString(str);
                    System.out.println("Enter first index: ");
                    int firstIndex = -1;
                    try {
                        firstIndex = Integer.parseInt(enter.readLine());
                        if (firstIndex < 0 || firstIndex > str.length()) {
                            System.out.println("index < 0 or index > length");
                            throw new IOException();
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Wrong input");
                        System.exit(-1);
                    }
                    System.out.println("Enter last index: ");
                    int lastIndex = -1;
                    try {
                        lastIndex = Integer.parseInt(enter.readLine());
                        if (lastIndex < 0 || lastIndex > str.length()) {
                            System.out.println("index < 0 or index > length");
                            throw new IOException();
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Wrong input");
                        System.exit(-1);
                    }
                    if (firstIndex > lastIndex) {
                        System.out.println("first index > last index");
                        System.exit(-1);
                    }
                    System.out.println(reverseString.ReverseByIndex(str, firstIndex, lastIndex));
                }

                case 4 -> System.exit(1);
            }
        }
    }

    public static void checkString (String str) {
        if (str.isBlank()) {
            System.out.println("Rewrite your string");
            System.exit(-1);
        }
    }

}
