package ua.com.leveltwo;

import java.util.ArrayList;
import java.util.List;

public class Brackets {
    private String string;


    public Brackets() {
        string = "";
        String braces = "(){}[]";
        String symbols = ",./123";
        for (int i = 0; i < (int) (Math.random() * 20); i++) {
            if (i % 2 == 0) {
                string += braces.charAt((int) (Math.random() * braces.length()));
            } else {
                string += symbols.charAt((int) (Math.random() * symbols.length()));
            }
        }
    }

    public Brackets(String string) {
        this.string = string;
    }


    public boolean check() {
        if (string.length() == 0) {
            return false;
        }

        List<Character> brackets = new ArrayList<>();
        for (int i = 0; i < string.length(); i++) {
            switch (string.charAt(i)) {
                case '(': {
                    brackets.add('(');
                }
                case ')': {
                    brackets.add(')');
                }
                case '[': {
                    brackets.add('[');
                }
                case ']': {
                    brackets.add(']');
                }
                case '{': {
                    brackets.add('{');
                }
                case '}': {
                    brackets.add('}');
                }
            }
        }

        if (brackets.size() == 0)
            return false;

        List<Character> reversed = new ArrayList<>();
        for (int i = brackets.size() - 1; i >= 0; i--) {
            switch (brackets.get(i)) {
                case '(': {
                    reversed.add(')');
                }
                case ')': {
                    reversed.add('(');
                }
                case '[': {
                    reversed.add(']');
                }
                case ']': {
                    reversed.add('[');
                }
                case '{': {
                    reversed.add('}');
                }
                case '}': {
                    reversed.add('{');
                }
            }
        }
        return brackets.equals(reversed);

    }


    public String getString() {
        return string;
    }
}
