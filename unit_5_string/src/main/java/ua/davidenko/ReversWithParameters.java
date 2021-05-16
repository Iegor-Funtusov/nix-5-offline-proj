package ua.davidenko;

public class ReversWithParameters {

    public static String reverseBySubstring(String src, String dest) {
        return src.replaceAll(dest, ReversSimple.reverse(dest));
    }

    public static String reverseByIndex(String src, int firstIndex, int lastIndex) {
        StringBuilder sb = new StringBuilder(src);
        String str = sb.substring(firstIndex, lastIndex);
        sb.replace(firstIndex, lastIndex, ReversSimple.reverse(str));
        sb.replace(firstIndex,lastIndex, ReversSimple.reverse(str));
        return sb.toString();
    }

    public static String reverseByChar(String src, char firstChar, char lastChar) {
        int firstIndexChar = src.indexOf(firstChar);
        int lastIndexChar = src.indexOf(lastChar);
        StringBuilder sb = new StringBuilder(src);
        String str = sb.substring(firstIndexChar, lastIndexChar);
        sb.replace(firstIndexChar, lastIndexChar, ReversSimple.reverse(str));
        return sb.toString();
    }

    public static String reverseByString(String src, String firstString, String lastString) {
        int firstStr = src.indexOf(firstString);
        int lastStr = src.indexOf(lastString);
        String str = src.substring(firstStr, lastStr);
        StringBuilder sb = new StringBuilder(src);
        sb.replace(firstStr, lastStr, ReversSimple.reverse(str));
        return sb.toString();
    }

    public static String reversByCharSequence(String src, CharSequence firstCS, CharSequence lastCS) {
        int indexFirstCS = src.indexOf(firstCS.toString());
        int indexLastCS = src.indexOf(lastCS.toString());
        String str = src.substring(indexFirstCS, indexLastCS);
        StringBuilder sb = new StringBuilder(src);
        sb.replace(indexFirstCS, indexLastCS, ReversSimple.reverse(str));
        return sb.toString();

    }
}



