package ua.com;

import java.util.Arrays;

public class Part6 {
    public static void main(String[] args) {
        Part6 part6 = new Part6();
        System.out.println(part6.swapElementsOfArray(InputHelper.arrayBuilder()));
    }

    private String swapElementsOfArray(int[] array) {
        String output;
        for (int i = 0; i < array.length - 1; i += 2) {
            int temporary = array[i];
            array[i] = array[i + 1];
            array[i + 1] = temporary;
        }
        output = Arrays.toString(array);
        System.out.print("Swap elements of array: ");
        return output.substring(1, output.length() - 1);
    }
}
