package org.example.level2;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

public class StringValidator {
    private StringValidator() {
    }

    public static boolean validateBrackets(String string) {
        final String opening = "({[";
        final String closing = ")}]";

        String[] brackets = string.chars()
                .mapToObj(c -> String.valueOf((char) c))
                .filter(c -> opening.contains(c) || closing.contains(c))
                .toArray(String[]::new);

        Deque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < brackets.length; i++) {
            if (opening.contains(brackets[i])) {
                stack.push(brackets[i]);
            } else {
                String lastOpening;
                try {
                    lastOpening = stack.pop();
                } catch (NoSuchElementException ex) {
                    return false;
                }
                if (opening.indexOf(lastOpening) != closing.indexOf(brackets[i])) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
