import java.util.Arrays;

public class Task2 {

    private static int   elementsAmount;
    private static int[] inputArr;

    private static void setInputData(int[] arr) {
        elementsAmount = arr.length;
        inputArr = arr;
    }

    private static void printInputData(){
        System.out.println("Amount of elements: " + elementsAmount);
        System.out.println("Input array: " + Arrays.toString(inputArr));
    }

    private static void countPositiveNumbers() {
        int counter = 0;
        for (int i = 0; i < elementsAmount; i++) {
            if (inputArr[i] >= 0) {
                counter++;
            }
        }
        System.out.println("Amount of positive numbers: " + counter);
    }

    public static void printSolution(int[] arr){
        System.out.println("\n\nTask 2");
        setInputData(arr);
        printInputData();
        countPositiveNumbers();
    }
}
