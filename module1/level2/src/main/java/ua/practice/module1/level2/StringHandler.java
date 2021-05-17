package ua.practice.module1.level2;

import java.util.LinkedList;

public class StringHandler {
    private static final String NOT_VALID = "String is not valid.";
    String stringToHandle;

    public StringHandler(String stringToHandle) {
        this.stringToHandle = stringToHandle;
    }

    public boolean handle() {
        LinkedList<Character> characters = new LinkedList<>();
        char[] strChars = stringToHandle.toCharArray();
        for (char strChar : strChars) {
            writeBracket(strChar, characters);
            if (!checkBracket(strChar, characters)) return false;
        }
        System.out.println("Your string is valid.");
        return true;
    }

    private void writeBracket(char strChar, LinkedList<Character> characters) {
        if (strChar == '(' || strChar == '[' || strChar == '{') {
            characters.add(strChar);
        }
    }

    private boolean checkBracket(char strCar, LinkedList<Character> characters) {
        switch (strCar) {
            case ']':
                if (characters.getLast() == '[') {
                    characters.removeLast();
                } else {
                    System.out.println(NOT_VALID);
                    return false;
                }
                break;

            case ')':
                if (characters.getLast() == '(') {
                    characters.removeLast();
                } else {
                    System.out.println(NOT_VALID);
                    return false;
                }
                break;

            case '}':
                if (characters.getLast() == '{') {
                    characters.removeLast();
                } else {
                    System.out.println(NOT_VALID);
                    return false;
                }
                break;
            default:
                return true;
        }
        return true;
    }

}
