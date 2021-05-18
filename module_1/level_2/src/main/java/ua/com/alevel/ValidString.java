package ua.com.alevel;

import java.util.Stack;

public class ValidString {
    public static boolean isValid(String str) {
        if (str == null) return true;

        Stack<Character> stack = new Stack<>();
        char[] openBrackets = new char[]{'[', '(', '{'};
        char[] closeBrackets = new char[]{')', '}', ']'};

        int i = 0;
        while (i < str.length()) {
            char current = str.charAt(i);
            if (thisBracket(current, openBrackets)) {
                stack.push(current);
            } else if (thisBracket(current, closeBrackets)) {
                if (stack.empty())
                    return false;
                if (stack.pop() != openBrackets[index(current, closeBrackets)]) {
                    return false;
                }
            }
            i++;
        }
        return true;
    }

    private static int index(char ch, char[] array) {
        int ind = -1;
        int i = 0;
        while (i < array.length) {
            if (array[i] == ch)
                ind = i;
            i++;
        }
        return ind;
    }

    private static boolean thisBracket(char ch, char[] array) {
        int i = 0;
        while (i < array.length) {
            char c = array[i];
            if (c == ch)
                return true;
            i++;
        }
        return false;
    }


}
