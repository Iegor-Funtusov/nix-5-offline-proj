package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserInput {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public static List<Integer> userInputNumbers(String message) {
        List<Integer> userInput = new ArrayList<>();
        System.out.println(message);
        try {
            userInput = Stream.of(bufferedReader.readLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.err.println("Wrong input.Please restart program");
        }
        return userInput;
    }
    public static int userInputNumber(String message) {
        int num = 0;
        System.out.println(message);
        try {
            num = Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
            System.err.println("Wrong input.Please restart program");
        }
        return num;
    }
    public static String userInputString(String message) {
        System.out.println(message);
        String res = "";
        try {
            res = bufferedReader.readLine();
        } catch (IOException e) {
            System.err.println("Wrong input.Please restart program");
        }
        return res;
    }

}