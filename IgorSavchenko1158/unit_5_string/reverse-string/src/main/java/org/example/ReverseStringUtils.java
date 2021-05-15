package org.example;

public class ReverseStringUtils {

    public static String reverse(String src) {
        if (src == null) throw new IllegalArgumentException();

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
        if (src == null || firstIndex < 0 || firstIndex > lastIndex || lastIndex >= src.length())
            throw new IllegalArgumentException();

        return src.substring(0, firstIndex) +
                reverse(src.substring(firstIndex, lastIndex + 1)) +
                src.substring(lastIndex + 1);
    }

    public static String reverse(String src, char startChar, char endChar) {
        if (src == null) throw new IllegalArgumentException();

        return reverse(src, String.valueOf(startChar), String.valueOf(endChar));
    }

    public static String reverse(String src, CharSequence firstCS, CharSequence lastCS) {
        if (src == null || firstCS == null || lastCS == null) throw new IllegalArgumentException();

        int firstIndex = src.indexOf(firstCS.toString());
        if (firstIndex < 0) throw new IllegalArgumentException();
        int lastIndex = firstIndex + src.substring(firstIndex).indexOf(lastCS.toString()) + lastCS.length() - 1;
        if (lastIndex - firstIndex < 0) throw new IllegalArgumentException();

        return reverse(src, firstIndex, lastIndex);
    }

    public static String reverseSubstring(String src, String substring) {
        if (src == null || substring == null) throw new IllegalArgumentException();
        return src.replaceAll(substring, reverse(substring));
    }

    public static String reverseSubstring(String src, String substring, int firstIndex, int lastIndex) {
        if (src == null || substring == null || firstIndex < 0 || firstIndex > lastIndex || lastIndex >= src.length())
            throw new IllegalArgumentException();

        return src.substring(0, firstIndex) +
                reverseSubstring(src.substring(firstIndex, lastIndex + 1), substring) +
                src.substring(lastIndex + 1);
    }

    public static String reverseSubstring(String src, String substring, char startChar, char endChar) {
        if (src == null || substring == null) throw new IllegalArgumentException();

        return reverseSubstring(src, substring, String.valueOf(startChar), String.valueOf(endChar));
    }

    public static String reverseSubstring(String src, String substring, CharSequence firstCS, CharSequence lastCS) {
        if (src == null || substring == null || firstCS == null || lastCS == null) throw new IllegalArgumentException();

        int firstIndex = src.indexOf(firstCS.toString());
        if (firstIndex < 0) throw new IllegalArgumentException();
        int lastIndex = firstIndex + src.substring(firstIndex).indexOf(lastCS.toString()) + lastCS.length() - 1;
        if (lastIndex - firstIndex < 0) throw new IllegalArgumentException();

        return reverseSubstring(src, substring, firstIndex, lastIndex);
    }
}
