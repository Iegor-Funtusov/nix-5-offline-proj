package libs;

public class ReverseString {

    public static String reverse(String src) {

        char[] array = src.toCharArray();
        String result = "";

        for (int i = array.length - 1; i >= 0; i--) {
            result = result + array[i];
        }

        return result;
    }

    public static String reverse(String src, String dest)
    {


        String s = src.substring(0,src.indexOf(dest));
        String s1 = src.substring(src.indexOf(dest));
        char[] array = s1.toCharArray();
        String result = "";

        for (int i = array.length - 1; i >= 0; i--) {
            result = result + array[i];
        }
        s=s+result;
        return s;
    }

    public static String reverse(String src, int firstIndex, int lastIndex)
    {
        if(firstIndex > lastIndex || lastIndex >= src.length()) {
            throw new IndexOutOfBoundsException();
        }
        String result = "";

        char [] s = src.toCharArray();
        while (firstIndex < lastIndex) {

            char temp = s[lastIndex];
            s[lastIndex] = s[firstIndex];
            s[firstIndex] = temp;

            firstIndex++;
            lastIndex--;
        }
        for (int i = 0; i < s.length; i++) {
            result = result + s[i];
        }
        return result;
    }
}
