public class Reverse implements ReverseString{
    @Override
    public String reverse(String src) {
        char[] tmpCharArr = src.toCharArray();
        char tmp;
        for (int i = 0; i < tmpCharArr.length / 2; i++) {
            tmp = tmpCharArr[i];
            tmpCharArr[i] = tmpCharArr[tmpCharArr.length - i - 1];
            tmpCharArr[tmpCharArr.length - i - 1] = tmp;
        }
        String tmpStr = new String(tmpCharArr);
        String[] reverseStr = tmpStr.split(" ");
        StringBuilder str = new StringBuilder();
        for (int i = reverseStr.length - 1; i >= 0; i--) {
            str.append(reverseStr[i]).append(" ");
        }
        return str.toString();
    }

    @Override
    public String reverse(String src, String dest) {
        int index = src.indexOf(dest);
        String start = src.substring(0, index);
        String end = src.substring(dest.length() + start.length());
        src = src.substring(index, dest.length() + index);
        char[] tmpCharArr = src.toCharArray();
        char tmp;
        for (int i = 0; i < tmpCharArr.length / 2; i++) {
            tmp = tmpCharArr[i];
            tmpCharArr[i] = tmpCharArr[tmpCharArr.length - i - 1];
            tmpCharArr[tmpCharArr.length - i - 1] = tmp;
        }
        return start + "" + new String(tmpCharArr) + "" + end;
    }

    @Override
    public String reverse(String src, int firstIndex, int lastIndex) {
        String start = src.substring(0, firstIndex);
        String end = src.substring(lastIndex + 1);
        src = src.substring(firstIndex, lastIndex + 1);
        char[] tmpCharArr = src.toCharArray();
        char tmp;
        for (int i = 0; i < tmpCharArr.length / 2; i++) {
            tmp = tmpCharArr[i];
            tmpCharArr[i] = tmpCharArr[tmpCharArr.length - i - 1];
            tmpCharArr[tmpCharArr.length - i - 1] = tmp;
        }
        String tmpStr = new String(tmpCharArr);
        String[] reverseStr = tmpStr.split(" ");
        StringBuilder str = new StringBuilder();
        for (int i = reverseStr.length - 1; i >= 0; i--) {
            str.append(reverseStr[i]).append(" ");
        }
        str = new StringBuilder(str.substring(0, str.length() - 1));
        return start + str + end;
    }
}
