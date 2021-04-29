import java.util.Arrays;

public class Task1 {

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

    private static void findEvenNumber(){
        System.out.print("Even numbers:");
        for (int i = 0; i < inputArr.length; i++) {
            if (inputArr[i] % 2 == 0) {
                System.out.print(" " + inputArr[i]);
            }
        }
    }

    public static void printSolution(int[] arr){
        System.out.println("\nTask 1");
        setInputData(arr);
        printInputData();
        findEvenNumber();
    }

}
