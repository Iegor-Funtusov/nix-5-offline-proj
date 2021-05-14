package libs;

public class ReverseString {
    public static String reverse(String src){
        char[] array = src.toCharArray();
        String result = "";
        for (int i = array.length - 1; i >= 0; i--) {
            result = result + array[i];
        }
        return result;
    }
    public static String reverse(String src, String dest) {
        String result = "";
        int indexOfDest = src.indexOf(dest);
        String first = src.substring(0, indexOfDest);
        String second = src.substring(indexOfDest);
        char[] array = second.toCharArray();
            for (int i = array.length - 1; i >= 0; i--) {
            result = result + array[i];
            }
        first = first + result;
        return first;
    }
    public static String reverse(String src, int firstIndex, int lastIndex){

        return null;
    }
}
