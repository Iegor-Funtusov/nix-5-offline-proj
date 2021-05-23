package ua.com.alevel.lib;

public class reversString {

    public static String simpleReverse(String src){
        StringBuffer reversed = new StringBuffer("");
        String[] words = src.split(" ");
        for(String word : words){
            for (int i = word.length() - 1; i >= 0; i--) {
            reversed.append(word.charAt(i));
            }
            reversed.insert(word.length(), " ");
        }
        return reversed.toString();
    }

    public static String reverseBySubstring(String src, String dest){
        StringBuffer reversed = new StringBuffer("");
        String[] words = src.split(" ");
            for (int i = dest.length() - 1; i >= 0; i--) {
                reversed.append(dest.charAt(i));
            }
        return src.replace(dest, reversed.toString());
    }

    public static String reverseByIndex(String src, int firstIndex, int lastIndex){
        String str = src.substring(firstIndex, lastIndex+1);
        return src.replace(str, simpleReverse(str));
    }

    public static String reverseByUser(String src, String first, String  last){
        int start = src.indexOf(first);
        int end= src.indexOf(last);
        String reversed = reverseByIndex(src, start, end);
        return reversed;
    }
}