package com.nix.hw.lib;

public class StringReverser {

    public static String reverse(String src) {
        StringBuilder string = new StringBuilder("");
        for (int i = src.length()-1; i >= 0; i--) {
            string.append(src.charAt(i));
        }
        return string.toString();
    }

    public static String reverse(String src, String subString) {
        if (src.contains(subString) && !src.isBlank() && !subString.isBlank()) {
            StringBuilder string = new StringBuilder()
                    .append(src.subSequence(0, src.indexOf(subString)))
                    .append(reverse(subString))
                    .append(src.subSequence(src.indexOf(subString) + subString.length(), src.length()));
            return string.toString();
        }
        return src;
    }

    public static String reverse(String src, int start, int end) {

        if (start < 0)
            start = 0;
        if (end > src.length())
            end = src.length();

        if (start < src.length() - 1 &&
            end > 1 &&
            end - start >= 2) {

            StringBuilder string = new StringBuilder()
                    .append(src.subSequence(0, start))
                    .append(reverse(src.substring(start, end)))
                    .append(src.subSequence(end, src.length()));

            return string.toString();
        }
        return src;
    }
}
