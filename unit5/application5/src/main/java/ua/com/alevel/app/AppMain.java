package ua.com.alevel.app;

import ua.com.alevel.lib.ReverseString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AppMain {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the string:");
        String string = bufferedReader.readLine();
        while (true){ System.out.print("1.Reverse\n2.Reverse on the specified substring in the string\n3.Manually select the start/finish index of the string to reverse\n4.Exit\nEnter the operation number: ");
            try {
                int operation = Integer.parseInt(bufferedReader.readLine());
                switch (operation) {
                    case 1:
                        System.out.println(ReverseString.reverse(string));
                        break;
                    case 2:
                        System.out.print("Enter substring: ");
                        String string1 = bufferedReader.readLine();
                        System.out.println(ReverseString.reverse(string, string1));
                        break;
                    case 3:
                        try {
                            System.out.print("Enter a value from the range (" + 0 + ";" + string.length() + ")\nEnter first index: ");
                            int firstIndex = Integer.parseInt(bufferedReader.readLine());

                            System.out.print("Enter last index: ");
                            int lastIndex = Integer.parseInt(bufferedReader.readLine());

                            if ((firstIndex < 0 || firstIndex > string.length()) && (lastIndex < 0 || lastIndex > string.length())) {
                                System.out.println("You entered an invalid value index! First and second indices out of range");
                            } else if ((firstIndex < 0 || firstIndex > string.length()) && (lastIndex > 0 || lastIndex < string.length())) {
                                System.out.println("You entered an invalid value index! The first index is out of range!");
                            } else if ((firstIndex > 0 || firstIndex < string.length()) && (lastIndex < 0 || lastIndex > string.length())) {
                                System.out.println("You entered an invalid value index! The last index is out of range!");
                            } else if ((firstIndex > 0 || firstIndex < string.length()) && (lastIndex > 0 || lastIndex < string.length()) && (firstIndex > lastIndex)) {
                                System.out.println(ReverseString.reverse(string, lastIndex, firstIndex));
                            } else if (firstIndex == lastIndex) {
                                System.out.println("You entered the same index values!");
                            } else {
                                System.out.println(ReverseString.reverse(string, firstIndex, lastIndex));
                            }
                        } catch (NumberFormatException e){ System.out.println("You entered invalid characters!"); }
                        break;
                    case 4:
                        System.out.println("Thanks for attention!");
                        System.exit(0);
                    default: System.out.println("You entered invalid characters!");
                }
            }
            catch (NumberFormatException e){ System.out.println("You entered invalid characters!"); }
        }
    }
}
