public class ReverseString {

    public static String reverse(String src) {
        String[] subStr;
        String splitter = "\\s+";
        subStr = src.split(splitter);
        String result = "";
        for (int i = 0; i < subStr.length; i++) {
            char[] chars = subStr[i].toCharArray();
            for (int j = chars.length - 1; j >= 0; j--) {
                result = result + chars[j];
            }
            result += " ";
        }
        return result;
    }

    public static String reverse(String src, String dest) {
        if (src.contains(dest)) {
            return src.replace(dest, reverseStr(dest));
        }
        System.out.println("Строка не содержит введенную подстроку");
        return "";
    }

    public static String reverse(String src, int firstIndex, int lastIndex) {
        if (firstIndex > 0 && lastIndex <= src.length()) {
            String subStr = src.substring(firstIndex - 1, lastIndex);
            return reverse(src, subStr);
        }
        System.out.println("Индексы были введены неверно");
        return "";
    }

    private static String reverseStr(String src) {
        char[] array = src.toCharArray();
        String result = "";
        for (int i = array.length - 1; i >= 0; i--) {
            result = result + array[i];
        }
        return result;
    }
}
