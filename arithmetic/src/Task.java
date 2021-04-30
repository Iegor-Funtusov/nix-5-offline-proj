import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task {
    static int countOfPositive = 0;
    static int countOfMore = 0;
    static int countOfNeighbours = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter an amount of numbers: ");
        String s = reader.readLine();
        int[] arr = new int[Integer.parseInt(s)];
        // Task 1
        for(int i = 0; i < arr.length; i++){
            String a = reader.readLine();
            arr[i] = Integer.parseInt(a);
        }
        int[] arrForSwap = new int[arr.length]; // for Task 6
        for(int i = 0; i < arrForSwap.length; i++){
            arrForSwap[i] = arr[i];
        }
        System.out.print("Even numbers: ");
        for(int i = 0; i < arr.length; i++){
            if (arr[i] % 2 == 0)
                System.out.print(arr[i] + " ");
        }
        System.out.println();

        // Task 2

        for(int i = 0; i < arr.length; i++){
            if (arr[i] > 0)
                countOfPositive++;
        }
        System.out.println("Amount of positive numbers: " + countOfPositive);

        // Task 3

        for(int i = 0; i < arr.length - 1; i++){
            if(arr[i] < arr[i + 1])
                countOfMore++;

        }
        System.out.println("Amount of numbers more than previous " + countOfMore);

        // Task 4

        for(int i = 1; i < arr.length - 1; i++){
            if(arr[i] > arr[i - 1] && arr[i] > arr[i + 1])
                countOfNeighbours++;
        }
        System.out.println("Amount of numbers more than them neighbours: " + countOfNeighbours);

        // Task 5

        for(int i = 0; i < arr.length / 2; i++){
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
        System.out.print("Reversed array: ");
        for (Integer i: arr) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Task 6
        if (arrForSwap.length % 2 == 0){
            for(int i = 0; i < arrForSwap.length; i+=2){
                int temp = arrForSwap[i];
                arrForSwap[i] = arrForSwap[i + 1];
                arrForSwap[i + 1] = temp;
            }
        }
        else {
            for (int i = 0; i < arrForSwap.length - 1; i+=2){
                int temp = arrForSwap[i];
                arrForSwap[i] = arrForSwap[i + 1];
                arrForSwap[i + 1] = temp;
            }
        }
        System.out.print("Swapped elements: ");
        for (Integer i: arrForSwap) {
            System.out.print(i + " ");
        }


    }
}
