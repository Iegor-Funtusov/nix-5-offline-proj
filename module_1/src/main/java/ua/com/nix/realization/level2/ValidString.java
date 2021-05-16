package ua.com.nix.realization.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ValidString {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public void showAnswer() throws IOException {
        System.out.println("Valid string or not: " + validating());

    }
    public  boolean validating () throws IOException {
        System.out.println("Enter your string: ");
        String string = reader.readLine();
        int check = 0;
        for (int i = 0; i < string.length(); i++) {
            if (check < 0) {
                return false;
            }
            String symbol = string.substring(i, i + 1);
            if (symbol.equals("(") || symbol.equals("{") || symbol.equals("[")) {
                check++;
                continue;
            }
            if (symbol.equals(")") || symbol.equals("}") || symbol.equals("]"))
                check--;
        }
        if (check == 0) {
            return true;
        } else {
            return false;
        }
    }
}
