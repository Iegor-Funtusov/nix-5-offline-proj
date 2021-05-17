package ua.com.alevel.lib;

public class ReverseString {

    public String reverse(String input) {
        char[] inputArray = input.toCharArray();
        for (int i = 0; i < inputArray.length / 2; i++) {
            char ch = inputArray[i];
            inputArray[i] = inputArray[inputArray.length - i - 1];
            inputArray[inputArray.length - i - 1] = ch;
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
        String newString = input.substring(firstIndex, secondIndex + 1);
        return firstString + reverse(newString) + secondString;
    }

    public String reverse(String input, char firstSymbol, char secondSymbol) {
        int firstIndex = input.indexOf(firstSymbol);
        int secondIndex = input.indexOf(secondSymbol);
        String newString = input.substring(firstIndex, secondIndex + 1);
        String firstString = input.substring(0, firstIndex);
        String secondString = input.substring(secondIndex + 1);
        return firstString + reverse(newString) + secondString;
    }
}
