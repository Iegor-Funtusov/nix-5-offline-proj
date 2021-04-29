package ua.com;

import java.util.Arrays;

public class Part5 {
    public static void main(String[] args) {
        Part5 part5 = new Part5();
        System.out.println(part5.reversArray(InputHelper.arrayBuilder()));
    }

    private String reversArray(int[] array) {
        String output;
        for (int left = 0, right = array.length - 1; left < right; left++, right--) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
        }
        output = Arrays.toString(array);
        System.out.print("Revers array: ");
        return output.substring(1, output.length() - 1);
    }


}
