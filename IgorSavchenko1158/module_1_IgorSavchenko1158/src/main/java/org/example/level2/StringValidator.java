package org.example.level2;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

public class StringValidator {
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


//        System.out.println("StringValidator.validateBrackets");
//        System.out.println(string);
//        String opening = "[\\{\\(\\[]";
//        String closing = "[\\}\\)\\]]";
//
//        Pattern pOpening = Pattern.compile(opening);
//        Pattern pClosing;// = Pattern.compile(closing);
//        Matcher mOpening = pOpening.matcher(string);
//        if(mOpening.find()) {
//            int bracketOpened = mOpening.end();
//            String closingBracket = mOpening.group().equals("{") ? "\\}" : (mOpening.group().equals("(") ? "\\)" : "\\]");
//            System.out.println(closingBracket);
//            System.out.println("bracketOpened = " + bracketOpened);
//            System.out.println("mOpeninggroup = " + mOpening.group());
//            pClosing = Pattern.compile(closingBracket);
//            Matcher mClosing = pClosing.matcher(string.substring(bracketOpened));
//            if(mClosing.find()) {
//                System.out.println("mClosing.group() = " + mClosing.group());
//                return validateBrackets(string.substring(bracketOpened, mClosing.end())) &&
//                        validateBrackets(string.substring(mClosing.end() + 1));
//            } else {
//                return false;
//            }
//        } else {
//            pClosing = Pattern.compile(closing);
//            Matcher mClosing = pClosing.matcher(string);
//            if(mClosing.find()) {
//                return false;
//            } else {
//                return true;
//            }
//        }
    }
}
