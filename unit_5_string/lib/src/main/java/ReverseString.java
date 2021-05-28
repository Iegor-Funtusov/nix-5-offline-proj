public class ReverseString {

    public static String reverse(String src) {
        String[] subStr;
        String splitter = "\\s+";
        subStr = src.split(splitter);
        StringBuilder result = new StringBuilder();
        for (String s : subStr) {
            char[] chars = s.toCharArray();
            for (int j = chars.length - 1; j >= 0; j--) {
                result.append(chars[j]);
            }
            result.append(" ");
        }
        return result.toString();
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
        StringBuilder result = new StringBuilder();
        for (int i = array.length - 1; i >= 0; i--) {
            result.append(array[i]);
        }
        return result.toString();
    }
}
