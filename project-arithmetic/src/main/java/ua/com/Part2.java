package ua.com;

public class Part2 {
    public static void main(String[] args) {
        Part2 part2 = new Part2();
        System.out.println(part2.countsIntegers(InputHelper.arrayBuilder()));
    }

    private String countsIntegers(int[] array) {
        int count = 0;
        for (int num : array) {
            if (num > 0) {
                count++;
            }
        }
        System.out.print("Quantity of positive numbers: ");
        return String.valueOf(count);
    }
}
