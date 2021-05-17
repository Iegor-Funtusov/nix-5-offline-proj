package ua.davidenko.level_1.task_1;

public class UniqueSymbolArray {

    public static int countOfUniqueSymbol(int[] arr) {
        int countSymbol = 0;
        int countUniqueSymbol = 0;
        int countRepeatSymbol = 0;
        for (int i = 0; i < arr.length; i++) {
            countSymbol++;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    countRepeatSymbol++;
                    break;
                }
            }
        }
        countUniqueSymbol = countSymbol - countRepeatSymbol;
        System.out.println(" Count of Unique Symbol is : " + countUniqueSymbol);
        return countUniqueSymbol;
    }
}
