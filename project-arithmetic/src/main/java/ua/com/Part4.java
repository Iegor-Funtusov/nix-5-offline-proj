package ua.com;

public class Part4 {
    public static void main(String[] args) {
        Part4 part4 = new Part4();
        System.out.println(part4.calculateIntegersSmallerOutside(InputHelper.arrayBuilder()));
    }

    private String calculateIntegersSmallerOutside(int[] array) {
        int count = 0;
        for (int i = 1; i < array.length - 1; i++) {
            if (array[i - 1] < array[i] && array[i] > array[i + 1]) {
                count++;
            }
        }
        System.out.print("Quantity of integers bigger outside: ");
        return String.valueOf(count);
    }
}
