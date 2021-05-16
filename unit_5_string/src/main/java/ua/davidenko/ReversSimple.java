package ua.davidenko;

public class ReversSimple {

    public static String reverse(String src) {
        String[] words = src.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String str : words) {
            StringBuilder result = new StringBuilder(" ");
            for (int i = 0; i < str.length(); i++) {
                result.insert(0, str.charAt(i));
            }
            sb.append(result);
        }
        return sb.toString();
    }
}




