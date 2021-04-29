import java.util.Arrays;

public class Task3 {

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

    private static void countLargerElements() {
        int counter = 0;
        for (int i = 1; i < elementsAmount; i++) {
            if (inputArr[i] > inputArr[i - 1]) {
                counter++;
            }
        }
        System.out.println("Amount of elements larger than previous: " + counter);
    }

    public static void printSolution(int[] arr){
        System.out.println("\nTask 3");
        setInputData(arr);
        printInputData();
        countLargerElements();
    }

}
