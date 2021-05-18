package library;

public class ReverseLibrary {

    private static String reverseStr(String str) {
        char[] line = str.toCharArray();
        char[] result = new char[str.length()];
        int i = 0;
        while (i < line.length) {
            result[i] = line[line.length - i - 1];
            i++;
        }
        return new String(result);
    }

    public static String reverse(String str) {
        return reverseStr(str);
    }

    public static String reverse(String str, String subStr) {
        return str.replaceAll(subStr, reverseStr(subStr));
    }

    public static String reverse(String str, int firstIndex, int lastIndex) {
        indexAcceptable(str, firstIndex, lastIndex);
        String subStr = str.substring(firstIndex, lastIndex + 1);
        return str.replaceFirst(subStr, reverseStr(subStr));
    }

    public static String reverse(String str, CharSequence firstSequence, CharSequence lastSequence) {
        int firstIndex = str.indexOf(firstSequence.toString());
        int secondIndex = str.indexOf(lastSequence.toString()) + lastSequence.length() - 1;
        indexAcceptable(str, firstIndex, secondIndex - lastSequence.length() + 1);
        return reverse(str, firstIndex, secondIndex);
    }

    private static void indexAcceptable(String str, int firstIndex, int secondIndex) {
        if (str.length() < firstIndex || str.length() <= secondIndex) {
            throw new IllegalArgumentException("index is out of bounds!");
        }
        if (firstIndex >= secondIndex) {
            throw new IllegalArgumentException("second index must be higher then first");
        }
    }

    public static String reverse(String str, String firstSubStr, String lastSubStr) {
        indexAcceptable(str, str.indexOf(firstSubStr), str.indexOf(lastSubStr));
        int firstIndex = str.indexOf(firstSubStr);
        int secondIndex = str.indexOf(lastSubStr) + lastSubStr.length() - 1;
        return reverse(str, firstIndex, secondIndex);
    }

    public static String reverse(String str, char firstChar, char lastChar) {
        int firstCharIndex = str.indexOf(firstChar);
        int secondCharIndex = str.indexOf(lastChar);
        indexAcceptable(str, firstCharIndex, secondCharIndex);
        return reverse(str, firstCharIndex, secondCharIndex);
    }

}