package ua.com;

public class Part1 {

    public static void main(String[] args) {
        Part1 part1 = new Part1();
        System.out.println(part1.evenArrayOutput(InputHelper.arrayBuilder()));
    }

    private String evenArrayOutput(int[] array) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Even elements: ");
        for (int num : array) {
            if (num % 2 == 0) {
                stringBuilder.append(num).append(" ");
            }
        }
        if (stringBuilder.length() == 8) {
            return "Even elements not exists";
        }
        return String.valueOf(stringBuilder).trim();
    }
}
