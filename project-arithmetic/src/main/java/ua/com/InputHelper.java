package ua.com;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputHelper {
    private static final BufferedReader bufferedReader;
    private static final String REGEX_INPUT_NUMBERS = "^[-+]?[1-9]\\d*$";
    private static final String REGEX_INPUT_ARRAY = "^[-\\d ]+$";
    private static final String REGEX_CLEAR_NUMBERS = "-?[1-9][0-9]*";

    static {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    @SneakyThrows
    public static int[] arrayBuilder() {
        int N;
        Pattern patternNumbers = Pattern.compile(REGEX_INPUT_NUMBERS);
        Pattern patternArray = Pattern.compile(REGEX_INPUT_ARRAY);
        Matcher matcherNumbers;
        Matcher matcherArray;
        String[] stringArray;
        do {
            do {
                System.out.println("Please enter N (number of array elements 0<N<101)");
                matcherNumbers = patternNumbers.matcher(bufferedReader.readLine());
            } while (!matcherNumbers.find());
            N = Integer.parseInt(matcherNumbers.group());
        } while (N <= 0 || N >= 101);
        do {
            do {
                System.out.println("Please enter the elements of the array through the space (example: 1 2 -5 10 15)");
                matcherArray = patternArray.matcher(bufferedReader.readLine());
            } while (!matcherArray.find());
            stringArray = matcherArray.group().trim().split("\\s");
        } while (stringArray.length != N);
        stringArray = clearArrayOfStrings(stringArray);
        int[] intArray = new int[N];
        for (int i = 0; i < N; i++) {
            intArray[i] = Integer.parseInt(stringArray[i]);
        }
        return intArray;
    }

    private static String[] clearArrayOfStrings(String[] array) {
        int count = 0;
        Pattern patternClearNumbers = Pattern.compile(REGEX_CLEAR_NUMBERS);
        Matcher matcherClearNumbers = patternClearNumbers.matcher(Arrays.toString(array));
        while (matcherClearNumbers.find()) {
            array[count++] = matcherClearNumbers.group();
        }
        return array;
    }
}
