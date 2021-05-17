package ua.com.alevel.app;

import ua.com.alevel.lib.ReverseString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        ReverseString reverseString = new ReverseString();
        while (true) {
            System.out.println("1 - Простой reverse" + "\n2 - Reverse подстроки" + "\n3 - Reverse по индексам" + "\n4 - Reverse по символам" + "\n5 - Выход" + "\nВведите номер:");
            BufferedReader builder = new BufferedReader(new InputStreamReader(System.in));
            String value = builder.readLine();
            if ("1".equals(value)) {
                System.out.println("Введите строку: ");
                String case1Input = builder.readLine();
                System.out.println(reverseString.reverse(case1Input));
            } else if ("2".equals(value)) {
                System.out.println("Введите основную строку и подстроку: ");
                String case2Input = builder.readLine();
                String subString = builder.readLine();
                System.out.println(reverseString.reverse(case2Input, subString));
            } else if ("3".equals(value)) {
                System.out.println("Введите строку и индексы: ");
                String case3Input = builder.readLine();
                int case3FirstIndex = Integer.parseInt(builder.readLine());
                int case4SecondIndex = Integer.parseInt(builder.readLine());
                System.out.println(reverseString.reverse(case3Input, case3FirstIndex, case4SecondIndex));
            } else if ("4".equals(value)) {
                System.out.println("Введите строку и символы: ");
                String case4Input = builder.readLine();
                char case4FirstChar = builder.readLine().charAt(0);
                char case4SecondChar = builder.readLine().charAt(0);
                System.out.println(reverseString.reverse(case4Input, case4FirstChar, case4SecondChar));
            } else if ("5".equals(value)) {
                System.exit(0);
            } else {
                System.out.println("Введите цифры от 1 до 5!");
            }
        }
    }
}
