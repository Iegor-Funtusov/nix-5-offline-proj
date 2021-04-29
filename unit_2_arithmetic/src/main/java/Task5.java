import java.util.Arrays;

public class Task5 {

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

    private static void reverse() {
        for (int i = 0; i < elementsAmount / 2; i++) {
            inputArr[i] = inputArr[i] + inputArr[elementsAmount - 1 - i];
            inputArr[elementsAmount - 1 - i] = inputArr[i] - inputArr[elementsAmount - 1 - i];
            inputArr[i] = inputArr[i] - inputArr[elementsAmount - 1 - i];
        }
    }

    private static void printReversedArr() {
        System.out.println("Reversed arr: " + Arrays.toString(inputArr));
    }

    public static void printSolution(int[] arr){
        System.out.println("\nTask 5");
        setInputData(arr);
        printInputData();
        reverse();
        printReversedArr();
    }

}
