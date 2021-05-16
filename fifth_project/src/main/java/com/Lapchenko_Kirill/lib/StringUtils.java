package com.Lapchenko_Kirill.lib;

public class StringUtils {

    public static String reverse(String input) {
        StringBuilder reversed = new StringBuilder("");
        for (int i = input.length() - 1; i >= 0 ; i--) {
            reversed.append(input.charAt(i));
        }
        return reversed.toString();
    }

    public static String reverse(String input, String dest) {
        StringBuilder reversed = new StringBuilder("");
        for (int i = dest.length()-1; i >= 0 ; i--) {
            reversed.append(dest.charAt(i));
        }
        input = input.replace(dest, reversed.toString());
        return input;
    }

    public static String reverse(String input, int begin, int end) {
        StringBuilder reversed = new StringBuilder("");
        reversed.append(input.substring(0, begin));
        String subString = input.substring(begin, end+1);
        String[] words = subString.split(" ");
        for (int i = 0; i < words.length; i++) {
            if(i == words.length-1){
                reversed.append(reverse(words[i]));
                break;
            }
            reversed.append(reverse(words[i])+ " ");
        }
        reversed.append(input.substring(end+1, input.length()));
        return reversed.toString();
    }
}
