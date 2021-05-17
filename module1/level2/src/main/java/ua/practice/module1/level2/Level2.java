package ua.practice.module1.level2;

import java.io.BufferedReader;
import java.io.IOException;

public class Level2 {

    public static void checkIsStringValid(BufferedReader bufferedReader) throws IOException {
        System.out.println("Input any string to check if it's valid");
        String input = bufferedReader.readLine();
        StringHandler stringHandler = new StringHandler(input);
        stringHandler.handle();
    }
}
