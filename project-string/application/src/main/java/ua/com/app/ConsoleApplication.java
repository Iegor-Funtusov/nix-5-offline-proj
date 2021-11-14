package ua.com.app;

import lombok.SneakyThrows;
import ua.com.lib.ReverseString;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ConsoleApplication {

    private static final BufferedReader bufferedReader;
    private static final String REGEX_NUMBERS = "^[0-5]$";
    private static final String REGEX_INDEX = "^[0-9]+$";
    private static final String REGEX_CHARS_AND_SPACE = "^[a-zA-Z\\s]+$";
    private static final String REGEX_CHARS = "^[a-zA-Z]+$";
    private static final String REGEX_CHAR = "^[a-zA-Z]$";

    static {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) {
        ConsoleApplication consoleApplication = new ConsoleApplication();
        consoleApplication.run();
    }

    public void run() {
        int quantity = 0;
        boolean flag = true;
        System.out.println("Hello everybody!");
        while (flag) {
            message();
            cycle();
            quantity++;
            if (quantity == 20) {
                flag = false;
            }
        }
    }

    private void reverseFullInput() {
        System.out.println(ReverseString.reverse(inputForReverse()));
    }

    private void reversePartOfInput() {
        System.out.println(ReverseString.reverse(inputForReverse(), inputForReverseWithPart()));
    }

    private void reverseWithIndexes() {
        String inputForReverse = inputForReverse();
        int firstIndex = firstIndex();
        int lastIndex = lastIndex();
        if (firstIndex < lastIndex && firstIndex >= 0 && lastIndex < inputForReverse.length()) {
            System.out.println(ReverseString.reverse(inputForReverse, firstIndex, lastIndex));
        } else {
            System.out.println("Incorrectly input!");
        }
    }

    private void reverseWithSymbols() {
        System.out.println(ReverseString.reverse(inputForReverse(), firstSymbol(), lastSymbol()));

    }

    private void reverseWithStrings() {
        System.out.println(ReverseString.reverse(inputForReverse(), firstPart(), lastPart()));
    }

    private void cycle() {
        switch (numberForSwitch()) {
            case 1: {
                reverseFullInput();
                break;
            }
            case 2: {
                reversePartOfInput();
                break;
            }
            case 3: {
                reverseWithIndexes();
                break;
            }
            case 4: {
                reverseWithSymbols();
                break;
            }
            case 5: {
                reverseWithStrings();
                break;
            }
            case 0: {
                System.exit(0);
            }
        }
    }

    @SneakyThrows
    private int numberForSwitch() {
        String number;
        do {
            System.out.print("Number: ");
            number = bufferedReader.readLine();
        } while (!number.matches(REGEX_NUMBERS));
        return Integer.parseInt(number);
    }

    @SneakyThrows
    private String inputForReverse() {
        String text;
        do {
            System.out.println("Write a text for reverse:");
            text = bufferedReader.readLine();
        } while (!text.matches(REGEX_CHARS_AND_SPACE) || text.isBlank());
        return text;
    }

    @SneakyThrows
    private String inputForReverseWithPart() {
        String text;
        do {
            System.out.println("Write a part of text for reverse:");
            text = bufferedReader.readLine();
        } while (!text.matches(REGEX_CHARS) || text.isBlank());
        return text;
    }

    private String firstPart() {
        System.out.println("Input first part for start");
        return inputForReverseWithPart();
    }

    private String lastPart() {
        System.out.println("Input first part for finish");
        return inputForReverseWithPart();
    }

    private int firstIndex() {
        System.out.println("Write the first index: ");
        return index();
    }

    private int lastIndex() {
        System.out.println("Write the last index: ");
        return index();
    }

    @SneakyThrows
    private int index() {
        String index;
        do {
            index = bufferedReader.readLine();
        } while (!index.matches(REGEX_INDEX));
        return Integer.parseInt(index);
    }

    private char firstSymbol() {
        System.out.println("Write the first symbol: ");
        return symbol();
    }

    private char lastSymbol() {
        System.out.println("Write the last symbol: ");
        return symbol();
    }

    @SneakyThrows
    private char symbol() {
        String symbol;
        do {
            symbol = bufferedReader.readLine();
        } while (!symbol.matches(REGEX_CHAR));
        return symbol.charAt(0);
    }


    private void message() {
        System.out.println("Choose what you want to do:");
        System.out.println("1 - totally reverse");
        System.out.println("2 - reverse part of input");
        System.out.println("3 - reverse from firstIndex to lastIndex");
        System.out.println("4 - reverse from firstSymbol to lastSymbol");
        System.out.println("5 - reverse from start of string to end of string");
        System.out.println("0 - Exit");
    }


}
