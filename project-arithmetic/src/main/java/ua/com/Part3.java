package ua.com;

public class Part3 {
    public static void main(String[] args) {
        Part3 part3 = new Part3();
        System.out.println(part3.CalculateIntegersGreaterNeighbor(InputHelper.arrayBuilder()));
    }

    private String CalculateIntegersGreaterNeighbor(int[] array) {
        int count = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) {
                count++;
            }
        }
        System.out.print("Quantity of integers greater neighbor numbers: ");
        return String.valueOf(count);
    }
}
