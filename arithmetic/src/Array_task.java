import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Array_task {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter count of array");
        int N = Integer.parseInt(reader.readLine());
        int [] arr = new int[N];
        for (int i = 0; i < N; i++) {
            System.out.println("Enter number");
            arr[i] = Integer.parseInt(reader.readLine());
        }


        System.out.println("Task №1:");
        System.out.println("Even numbers: ");
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]%2==0)
            {
                System.out.print(arr[i]);
            }
            System.out.print(" ");
        }
        System.out.println("\n");



        System.out.println("Task №2:");
        int counter_N2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>=0)
            {
                counter_N2++;
            }
        }
        System.out.println("Number of positive numbers: " + counter_N2 +"\n");



        System.out.println("Task №3:");
        int counter_N3 = 0;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i-1]<arr[i])
            {
                counter_N3++;
            }
        }
        System.out.println("Number of numbers greater than the previous one: " + counter_N3 + "\n");



        System.out.println("Task №4:");
        int counter_N4 = 0;
        for (int i = 1; i < arr.length-1; i++) {
            if(arr[i]>arr[i-1] && arr[i]>arr[i+1])
            {
                counter_N4++;
            }
        }
        System.out.println("The number of numbers greater than the previous and next: " + counter_N4 + "\n");



        System.out.println("Task 5:");
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            arrayList.add(arr[i]);
        }
        Collections.reverse(arrayList);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arrayList.get(i);
        }
        System.out.println("Reversed array: " + Arrays.toString(arr) + "\n");



        System.out.println("Task 6:");
        for (int i = 0; i < arr.length-1; i+=2) {
            int temp = arr[i];
            arr[i]=arr[i+1];
            arr[i+1]=temp;
        }
        System.out.println("Rearranged array: " + Arrays.toString(arr) + "\n");
    }
}
