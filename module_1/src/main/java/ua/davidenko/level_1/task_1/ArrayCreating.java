package ua.davidenko.level_1.task_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ArrayCreating {

    public static int[] userArray() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the SIZE of Array ");
        int size = Integer.parseInt(br.readLine());
        int[] arr = new int[size];
        System.out.println("Enter numbers for Array ");
        for (int i = 0; i < size; ++i) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(" Your Array is : " + Arrays.toString(arr));
        return arr;
    }

    public static int[] randomArray() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the SIZE of Array for Random generate ");
        int size = Integer.parseInt(br.readLine());
        int[] arr = new int[size];
        for(int i = 0; i < size; i++){
            arr[i] = (int) (Math.random() * size);
        }
        System.out.println("Your Random Array is : " + Arrays.toString(arr));
        return arr;
    }
}

