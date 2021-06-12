package ua.practice.unit5.string.library;

public class StringReverse {
    public static String reverse(String src) {
        char[] stringChars = src.toCharArray();
        char[] resultChars = new char[src.length()];
        for (int i = 0; i < src.length(); i++) {
            resultChars[i] = stringChars[src.length() - 1 - i];
        }
        return String.valueOf(resultChars);
    }

    public static String reverse(String src, String subsrc) {
        if (src.contains(subsrc)) {
            return src.replace(subsrc, reverse(subsrc));
        }
        return src;
    }

    public static String reverse(String src, int firstIndex, int lastIndex) {
        if(firstIndex < 0 || lastIndex > src.length() || firstIndex > lastIndex)
            throw new IllegalArgumentException("Wrong input");
        String before = src.substring(0, firstIndex);
        String after = src.substring(lastIndex + 1);
        return before + src.replace(src, reverse(src.substring(firstIndex, lastIndex + 1))) + after;
    }

    public static String reverse(String src, char firstChar, char lastChar) {
        int firstIndex = -1;
        int lastIndex = -1;
        char[] srcChars = src.toCharArray();
        for (int i = 0; i < src.length(); i++) {
            if (srcChars[i] == firstChar) firstIndex = i;
            if (srcChars[i] == lastChar) lastIndex = i;
        }
        return reverse(src, firstIndex, lastIndex);
    }

    public static String reverse(String src, CharSequence chars) {
        return reverse(src, chars.toString());
    }

}
