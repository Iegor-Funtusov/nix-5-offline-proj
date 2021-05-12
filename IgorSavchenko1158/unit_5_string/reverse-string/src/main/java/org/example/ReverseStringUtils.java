package org.example;

public class ReverseStringUtils {

    public static String reverse(String src) {
        if (src == null) {
            throw new IllegalArgumentException();
        }

        char[] chars = src.toCharArray();

        char buffer;
        int opposing;
        for (int i = 0; i < chars.length >> 1; i++) {
            buffer = chars[i];
            opposing = chars.length - 1 - i;
            chars[i] = chars[opposing];
            chars[opposing] = buffer;
        }
        return String.valueOf(chars);
    }

    /**
     * @param firstIndex inclusive
     * @param lastIndex  inclusive
     */
    public static String reverse(String src, int firstIndex, int lastIndex) {
        if (src == null || firstIndex > lastIndex || lastIndex >= src.length()) {
            throw new IllegalArgumentException();
        }
        return src.substring(0, firstIndex) +
                reverse(src.substring(firstIndex, lastIndex + 1)) +
                src.substring(lastIndex + 1);
    }

    public static String reverse(String src, char firstChar, char lastChar) {
        if (src == null) {
            throw new IllegalArgumentException();
        }

        int indexOfFirstChar = src.indexOf(firstChar);
        int indexOfLastChar = indexOfFirstChar + src.substring(indexOfFirstChar).indexOf(lastChar);
        if (indexOfFirstChar < 0 || indexOfLastChar < 0) {
            throw new IllegalArgumentException();
        }
        return reverse(src, indexOfFirstChar, indexOfLastChar);
    }

    public static String reverseSubstring(String src, String substring) {
        if (src == null || substring == null) {
            throw new IllegalArgumentException();
        }
        return src.replaceAll(substring, reverse(substring));
    }


}
