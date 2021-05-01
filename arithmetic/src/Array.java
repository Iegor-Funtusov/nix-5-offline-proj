import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Array {
    int count;

    public static void main(String[] args) throws IOException {
        Array arrays = new Array();

        System.out.println("Task 1 - Even numbers");
        arrays.evenNumbers(arrays.createArray());

        System.out.println("Task 2 - Positive numbers");
        arrays.positiveNumbers(arrays.createArray());

        System.out.println("Task 3 - The numbers are larger than the previous ones: ");
        arrays.largerNumbers(arrays.createArray());

        System.out.println("Task 4 - The neighbour numbers: ");
        arrays.neighbourNumbers(arrays.createArray());

        System.out.println("Task 5 - The revers numbers: ");
        arrays.reversNumbers(arrays.createArray());

        System.out.println("Task 6 - Swap neighbour numbers: ");
        arrays.swapNeighbourNumbers(arrays.createArray());
    }

    public int[] createArray() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter array size:");
        int size = Integer.parseInt(reader.readLine());
        int[] array = new int[size];
        System.out.println("Enter numbers for fill array");
        for (int i = 0; i < size; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }
        return array;
    }


    public void evenNumbers(int[] array) {
        System.out.println("Answer:");
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                System.out.print(array[i] + " ");
            }
        }
        System.out.println();
    }

    public void positiveNumbers(int[] array) {
        count = 0;
        System.out.println("Answer:");
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                count++;
            }
        }
        System.out.println(count);
    }

    public void largerNumbers(int[] array) {
        count = 0;
        System.out.println("Answer:");
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) {
                count++;
            }
        }
        System.out.println(count);
    }

    public void neighbourNumbers(int[] array) {
        count = 0;
        System.out.println("Answer:");
        for (int i = 1; i < array.length - 1; i++) {
            if (array[i] > array[i - 1] && array[i] > array[i + 1]) {
                count++;
            }
        }
        System.out.println(count);
    }

    public void reversNumbers(int[] array) {
        int temp;
        System.out.println("Answer:");
        for (int i = 0; i < array.length / 2; i++) {
            temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
        System.out.println(Arrays.toString(array));
    }

    public void swapNeighbourNumbers(int[] array) {
        int temp;
        System.out.println("Answer:");
        for (int i = 0; i < array.length - 1; i += 2) {
            temp = array[i];
            array[i] = array[i + 1];
            array[i + 1] = temp;
        }
        System.out.println(Arrays.toString(array));
    }


}
