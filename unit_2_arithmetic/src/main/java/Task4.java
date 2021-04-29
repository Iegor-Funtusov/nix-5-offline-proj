import java.util.Arrays;

public class Task4 {

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

    private static void countElements() {
        int counter = 0;
        for (int i = 1; i < elementsAmount-1; i++) {
            if (inputArr[i] > inputArr[i - 1] && inputArr[i] > inputArr[i + 1]) {
                counter++;
            }
        }
        System.out.println("Amount of elements that are larger than adjacent elements: " + counter);
    }

    public static void printSolution(int[] arr){
        System.out.println("\nTask 4");
        setInputData(arr);
        printInputData();
        countElements();
    }

}
