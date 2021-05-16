package nix.com.lvl_2.string_bracket;

import java.util.Stack;

public class RegExBracket2 {
    public boolean check(String str) {
        char[] symbols = str.toCharArray();

        Stack<Character> stackBrackets = new Stack<>();

        for (char symbol : symbols) {
            if (symbol == '(' || symbol == '{' || symbol == '[') {
                stackBrackets.push(symbol);
            }

            if (symbol == ')' || symbol == '}' || symbol == ']') {
                if (!stackBrackets.isEmpty()) {
                    char fromStack = stackBrackets.peek();
                    if ((symbol == ')' && fromStack == '(') ||
                            (symbol == '}' && fromStack == '{') ||
                            (symbol == ']' && fromStack == '[')) {
                        stackBrackets.pop();
                    } else {
                        break;
                    }
                } else {
                    stackBrackets.add(symbol);
                    break;
                }
            }

        }
        if (!stackBrackets.isEmpty()) {
            return false;
        }
        return true;
    }
}
