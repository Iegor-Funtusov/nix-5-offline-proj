package ua.davidenko;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserOperation {
    public static void userMethods() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter your String");
        String str = br.readLine();
        while (true) {
            System.out.println("Choose operation for String :\n" +
                    "1 - simple reverse, 2 - subString reverse, 3 - revers by Index, 4 - revers by Char" +
                    "\n5 - revers by String, 6 - revers by CharSequence");

            String operations = br.readLine();
            switch (operations) {
                case "1":
                    System.out.println(ReversSimple.reverse(str));
                    break;
                case "2":
                    System.out.println("Enter subString : ");
                    String subString = br.readLine();
                    System.out.println(ReversWithParameters.reverseBySubstring(str, subString));
                    break;
                case "3":
                    System.out.println("Enter firstIndex and lastIndex for subString ");
                    int firstIndex = Integer.parseInt(br.readLine());
                    int lastIndex = Integer.parseInt(br.readLine());
                    System.out.println(ReversWithParameters.reverseByIndex(str, firstIndex, lastIndex));
                    break;
                case "4":
                    System.out.println("Enter firstChar and lastChar for subString");
                    char firstChar = br.readLine().charAt(0);
                    char lastChar = br.readLine().charAt(0);
                    System.out.println(ReversWithParameters.reverseByChar(str, firstChar, lastChar));
                    break;
                case "5":
                    System.out.println("Enter first and last String for subString ");
                    String firstString = br.readLine();
                    String lastString = br.readLine();
                    System.out.println(ReversWithParameters.reverseByString(str, firstString, lastString));
                case "6":
                    System.out.println("Enter first and last CharSequence for subString");
                    CharSequence firstCS = br.readLine();
                    CharSequence lastCS = br.readLine();
                    System.out.println(ReversWithParameters.reversByCharSequence(str, firstCS, lastCS));
                    break;
            }
        }
    }
}

