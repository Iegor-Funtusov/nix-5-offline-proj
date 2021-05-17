package ua.com.nix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ValidString {
    public static void stringValidationChecking() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите строку: ");
        String src = reader.readLine();
        char[] array = src.toCharArray();
        int countOfRoundBrackets = 0;
        int countOfSquareBrackets = 0;
        int countOfFigureBrackets = 0;

        for (int i = 0; i < array.length; i++) {
            switch (array[i]){
                case '(':
                    countOfRoundBrackets++;
                    break;
                case ')':
                    countOfRoundBrackets--;
                    break;
                case '[':
                    countOfSquareBrackets++;
                    break;
                case ']':
                    countOfSquareBrackets--;
                    break;
                case '{':
                    countOfFigureBrackets++;
                    break;
                case '}':
                    countOfFigureBrackets--;
                    break;
            }
            if (countOfRoundBrackets < 0 || countOfFigureBrackets < 0 || countOfSquareBrackets < 0){
                System.out.println("Не валид");
                break;
            }
        }
        if (countOfRoundBrackets == 0 && countOfFigureBrackets == 0 && countOfSquareBrackets == 0) {
            System.out.println("Валид");
        }
        else {
            System.out.println("Нот валид");
        }
    }
}
