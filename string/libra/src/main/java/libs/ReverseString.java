package libs;

public class ReverseString {

    public static String stringReverse(String src){
        if (!src.isEmpty()) {
            char[] array = src.toCharArray();
            String result = "";
            for (int i = array.length - 1; i >= 0; i--) {
                result = result + array[i];
            }
            return result;
        }
        return "Попоробуйте ещё раз";
    }
    public static String substringReverse(String src, String dest) {
        if(src.contains(dest) && !src.isEmpty() && !dest.isEmpty()) {
            return src.replace(dest, stringReverse(dest));
        }
        return "Не, так не пойдёт";
    }
    public static String indexReverse(String src, int firstIndex, int lastIndex) {
        if (!src.isEmpty() && lastIndex > firstIndex) {
            char[] array = src.toCharArray();
            String temp = "";
             for(int i = firstIndex; i <= lastIndex; i++) {
                 temp = temp + array[i];
             }
             temp = stringReverse(temp);

             int j = 0;

            for (int i = firstIndex; i <= lastIndex; i++) {
                array[i] = temp.toCharArray()[j];
                j++;
            }
            return String.valueOf(array);
        }
        return "Не, так тоже не катит";
    }
}
