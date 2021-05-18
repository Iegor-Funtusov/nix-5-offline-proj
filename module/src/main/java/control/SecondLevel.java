package control;


import level2.StringValidate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class SecondLevel {
    public static void stringValidator() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Choose generation:\n" +
                "1 -> User generation\n" +
                "2 -> Random generation\n" +
                "0 -> Back to Menu");
        switch (reader.readLine()) {
            case "1": {
                System.out.print("Input string you want to validate: ");
                String input = reader.readLine();
                System.out.println("Is this string valid: " + StringValidate.isStringValid(input));
            }
            break;
            case "2": {
                String result = randomString();
                System.out.println("Generated string: " + result);
                System.out.println("Valid string: " + StringValidate.isStringValid(result));
            }
            break;
            case "3": {
                System.out.println("0 - Back to Menu");
                return;
            }
            default: {
                System.out.println("Wrong input");
                break;
            }
        }
    }

    private static String randomString() {
        Random random = new Random();
        int length = random.nextInt(80);
        return random.ints(50, 150 + 1)
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
