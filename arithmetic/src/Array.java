import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Array {
    public static void main(String[] args) throws IOException {
        Array arrayTask = new Array();

        arrayTask.evenNumb(arrayTask.readArray());
        arrayTask.positiveNumb(arrayTask.readArray());
        arrayTask.numBiggerPrevious(arrayTask.readArray());
        arrayTask.numBiggerNeighbors(arrayTask.readArray());
        arrayTask.reverseArray(arrayTask.readArray());
        arrayTask.swapNumb(arrayTask.readArray());
    }
    public int[] readArray() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter array count:");
        int N = Integer.parseInt(reader.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            System.out.println("Enter number");
            arr[i] = Integer.parseInt(reader.readLine());
        }
        return arr;
    }

    public void evenNumb(int[] arr) {
        System.out.println("Task 1 - Even numbers: ");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0)
                System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public void positiveNumb(int[] arr) {
        System.out.println("Task 2 - Number of positive numbers:");
        int count = 0;
        for (int i : arr) {
            if (i > 0) {
                count++;
            }
        }
        System.out.println(count);
    }

    public void numBiggerPrevious(int[] arr) {
        System.out.println("Task 3 - The number of numbers is greater than the previous one:");
        int count = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                count++;
            }
        }
        System.out.println(count);
    }

    public void numBiggerNeighbors(int[] arr) {
        System.out.println("Task 4 - The number of numbers is bigger than neighbors:");
        int count = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                count++;
            }
        }
        System.out.println(count);
    }

    public void reverseArray(int[] arr) {
        System.out.print("Task 5 - Reversed array: ");
        for(int i = 0; i < arr.length / 2; i++){
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
        for (Integer i: arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void swapNumb(int[] arr) {
        System.out.println("Task 6 - Swap numbers");
        int temp;
        for (int i = 1; i < arr.length; i += 2) {
            temp = arr[i];
            arr[i] = arr[i - 1];
            arr[i - 1] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}

