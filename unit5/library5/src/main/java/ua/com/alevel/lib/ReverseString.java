package ua.com.alevel.lib;

public class ReverseString {
    public static String reverse(String src){
        char[] array = src.toCharArray();
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = (char) temp;
        }
        return String.valueOf(array);
    }

    public static String reverse(String src, String dest){
        int value = src.indexOf(dest);

        String firstIndex = src.substring(0, value);
        String lastIndex = src.substring(firstIndex.length() + dest.length());
        src = src.substring(value, dest.length() + value);

        char[] array = src.toCharArray();
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = (char) temp;
        }
        return firstIndex + new String(array) + lastIndex;
    }

    public static String reverse(String src, int firstIndex, int lastIndex){
        String beginIndex = src.substring(0, firstIndex);
        String endIndex = src.substring(lastIndex + 1);
        src = src.substring(firstIndex, lastIndex + 1);

        char[] array = src.toCharArray();
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = (char) temp;
        }

        String[] string = new String(array).split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = string.length - 1; i >= 0; i--) { stringBuilder.append(string[i]).append(" "); }
        stringBuilder = new StringBuilder(stringBuilder.substring(0, stringBuilder.length() - 1));

        return beginIndex + stringBuilder + endIndex;
    }
}
