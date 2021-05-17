package level2;

import java.util.Stack;

public class ValidStringChecker {
    public static boolean checkString(String string) {

        if (string.isBlank())
            return true;

        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < string.length(); i++) {

            Character currentChar = string.charAt(i);

//            if(currentChar != ')' || currentChar != ']' || currentChar != '}' ||
//               currentChar != '(' || currentChar != '[' || currentChar != '{')
//                continue;

            if (currentChar == '(' || currentChar == '[' || currentChar == '{') {
                stack.push(currentChar);
                continue;
            }

            if(currentChar != ')' && currentChar != ']' && currentChar != '}')
                continue;

            if (stack.isEmpty())
                return false;

            Character character;

            switch (currentChar) {
                case ')':
                    character = stack.pop();
                    if (character == '{' || character == '[')
                        return false;
                    break;

                case '}':
                    character = stack.pop();
                    if (character == '(' || character == '[')
                        return false;
                    break;

                case ']':
                    character = stack.pop();
                    if (character == '(' || character == '{')
                        return false;
                    break;

                default:
                    break;
            }

        }
        return stack.isEmpty();
    }
}
