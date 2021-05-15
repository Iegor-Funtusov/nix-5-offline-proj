package ua.com.alevel.app;

import ua.com.alevel.lib.ReverseString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AppMain {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean isTrue = true;

        ReverseString reverseString = new ReverseString();

        while (isTrue) {

            System.out.println("Input your string");
            String str = null;
            try {
                str = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("If you wont revers all string input 1");
            System.out.println("If you wont revers substring input 2");
            System.out.println("If you wont revers substring for index input 3");
            System.out.println("If you wont exit input 4");

            String strInt = null;

            strInt = reader.readLine();
            boolean result = strInt.matches("[1234]");
            if (!result) {
                continue;
            }

            switch (strInt) {
                case ("1"): {
                    System.out.println(reverseString.reverse(str));
                    break;
                }
                case ("2"): {
                    System.out.println("Input your substring");
                    String substring = reader.readLine();
                    System.out.println(reverseString.reverse(str, substring));
                    break;
                }
                case ("3"): {

                    System.out.println("Input begin index");
                    int intBegin = Integer.parseInt(reader.readLine());
                    System.out.println("Input end index");
                    int intEnd = Integer.parseInt(reader.readLine());
                    if (intBegin >= str.length() | intEnd >= str.length() )
                    {
                        System.out.println("Index mast be less then:"+str.length());
                        break;
                    }
                    System.out.println(reverseString.reverse(str, intBegin, intEnd));
                    break;
                }
                case ("4"): {
                    isTrue = false;
                    break;
                }
            }
        }
    }
}


