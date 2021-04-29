import java.util.Arrays;

public class Task6 {

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

    private static void swapAdjacentElements() {
        for (int i = 0; i < elementsAmount-1; i+=2) {
            inputArr[i] = inputArr[i] + inputArr[i+1];
            inputArr[i+1] = inputArr[i] - inputArr[i+1];
            inputArr[i] = inputArr[i] - inputArr[i+1];
        }
    }

    private static void printResult() {
        System.out.println("Changed array: " + Arrays.toString(inputArr));
    }

    public static void printSolution(int[] arr){
        System.out.println("\nTask 6");
        setInputData(arr);
        printInputData();
        swapAdjacentElements();
        printResult();
    }

}
