package ua.com.alevel.lvl2;


public class StringCheck {

    public static boolean groupCheck(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (count < 0) {
                return false;
            }
            char point = s.charAt(i);
            if (point == '(' || point == '{' || point == '[') {
                count++;
                continue;
            }
            if (point == ')' || point == '}' || point == ']')
                count--;
        }
        if (count == 0) {
            return true;
        } else {
            return false;
        }
    }
}