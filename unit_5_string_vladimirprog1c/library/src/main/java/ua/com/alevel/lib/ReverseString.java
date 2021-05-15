package ua.com.alevel.lib;

public class ReverseString {

    public static String reverse(String src)
    {
        String returnStr = "";
        StringBuffer strBuffer = new StringBuffer(returnStr);
        strBuffer.setLength(src.length());
        for (int i = 0; i < src.length(); i ++)
        {
            strBuffer.setCharAt((src.length() -1 - i), src.charAt(i));
        }

        return strBuffer.toString();
    }

    public static String reverse(String src, String dest)
    {
        return src.replace(dest,reverse(dest));
    }

    public static String reverse(String src, int firstIndex, int lastIndex)
    {
        String substring = src.substring(firstIndex,lastIndex);

        return src.replace(substring,reverse(substring));
    }
}

