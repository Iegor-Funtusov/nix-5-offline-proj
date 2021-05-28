package level2.correctStringInput;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Queue;

public class CheckingBrackets {

    public static boolean checkingCorrectBrackets(String str) {
        Queue<Character> arrayLifoQueue = Collections.asLifoQueue(new ArrayDeque<>());
        char[] chars = str.toCharArray();
        for (char ch : chars) {
            switch (ch) {
                case '(':
                    arrayLifoQueue.add(')');
                    break;
                case '[':
                    arrayLifoQueue.add(']');
                    break;
                case '{':
                    arrayLifoQueue.add('}');
                    break;
            }

            switch (ch) {
                case ')':
                case ']':
                case '}':
                    if (!arrayLifoQueue.isEmpty() && ch == arrayLifoQueue.peek()) {
                        arrayLifoQueue.poll();
                        break;
                    } else {
                        return false;
                    }
            }
        }

        if (arrayLifoQueue.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
