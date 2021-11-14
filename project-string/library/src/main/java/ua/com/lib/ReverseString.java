package ua.com.lib;

public class ReverseString {

    public static String reverse(String src) {
        if (src != null) {
            StringBuilder conclusion = new StringBuilder();
            for (int i = src.length() - 1; i >= 0; i--) {
                conclusion.append(src.charAt(i));
            }
            return conclusion.toString();
        }
        return null;
    }

    public static String reverse(String src, String dest) {
        if (src != null && dest != null) {
            src = src.replace(dest, reverse(dest));
            return src;
        }
        return null;
    }

    public static String reverse(String src, int firstIndex, int lastIndex) {
        if (src != null && firstIndex >= 0 && lastIndex < src.length() && firstIndex < lastIndex) {
            src = src.replace(src.substring(firstIndex, lastIndex + 1), reverse(src.substring(firstIndex, lastIndex + 1)));
            return src;
        }
        return null;
    }

    public static String reverse(String src, char firstSymbol, char lastSymbol) {
        if (src != null) {
            return reverse(src, src.indexOf(firstSymbol), src.indexOf(lastSymbol));
        }
        return null;
    }

    public static String reverse(String src, String firstEnd, String lastStart) {
        if (src != null && firstEnd != null && lastStart != null) {
            return reverse(src, firstEnd.indexOf(firstEnd.charAt(firstEnd.length() - 1)), src.indexOf(lastStart.charAt(0)));
        }
        return null;
    }

}
