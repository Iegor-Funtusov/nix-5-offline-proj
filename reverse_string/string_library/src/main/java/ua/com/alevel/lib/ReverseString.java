package ua.com.alevel.lib;

public class ReverseString {

    public String reverse(String input) {
        char[] inputArray = input.toCharArray();
        for (int i = 0, j = input.length() - 1; i < j; i++, j--) {
            char ch = inputArray[i];
            inputArray[i] = inputArray[j];
            inputArray[j] = ch;
        }
        String result = new String(inputArray);
        return result;
    }

    public String reverse(String input, String dest) {
        return input.replace(dest, reverse(dest));
    }

    public String reverse(String input, int firstIndex, int secondIndex) {
        String firstString = input.substring(0, firstIndex);
        String secondString = input.substring(secondIndex + 1);
        String newString = input.substring(firstIndex, secondIndex);
        return firstString + reverse(newString) + secondString;
    }

    public String reverse(String input, char firstSymbol, char secondSymbol) {
        int firstIndex = input.indexOf(firstSymbol);
        int secondIndex = input.indexOf(secondSymbol);
        String newString = input.substring(firstIndex, secondIndex);
        String firstString = input.substring(0, firstIndex);
        String secondString = input.substring(secondIndex + 1);
        return firstString + reverse(newString) + secondString;
    }
}
