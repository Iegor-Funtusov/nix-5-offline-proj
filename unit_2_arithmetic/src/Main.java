import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the number of elements of the array: ");
        int N = Integer.parseInt(reader.readLine());

        int[] array = new int[N];

        for (int i = 0; i < N; i++) {
            System.out.print("Enter the number: ");
            array[i] = Integer.parseInt(reader.readLine());
        }

        System.out.println("Program 1");
        System.out.print("Array of even numbers: ");
        for (int j : array) {
            if (j % 2 == 0) {
                System.out.print(j + " ");
            }
        }

        System.out.println("\nProgram 2");
        System.out.print("The number of positive elements of the array(0 - not considered a positive element): ");
        int sum2 = 0;
        for (int j : array) {
            if (j > 0) {
                sum2++;
            }
        }
        System.out.println(sum2);

        System.out.println("Program 3");
        System.out.print("The number of array elements with a number greater than the previous one: ");
        int sum3 = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] < array[i]) {
                sum3++;
            }
        }
        System.out.println(sum3);

        System.out.println("Program 4");
        System.out.print("The number of array elements in which these two adjacent elements are less than one element: ");
        int sum4 = 0;
        for (int i = 1; i < array.length - 1; i++) {
            if (array[i - 1] < array[i] && array[i] > array[i + 1]) {
                sum4++;
            }
        }
        System.out.println(sum4);

        System.out.println("Program 5");
        System.out.print("The number of array elements in which these two adjacent elements are less than one element: ");
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
        System.out.println(Arrays.toString(array));

        System.out.println("Program 6");
        System.out.print("Array obtained after rearranging elements: ");
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
        for (int i = 0; i < array.length-1; i+=2) {
            int temp = array[i];
            array[i]=array[i+1];
            array[i+1]=temp;
        }
        System.out.println(Arrays.toString(array));
    }
}