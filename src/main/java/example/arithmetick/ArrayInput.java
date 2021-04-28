package example.arithmetick;

import java.util.Scanner;

public class ArrayInput {

    public static int[] input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of Your Array (1...100)");
        int N = sc.nextInt();
        int[] arr = new int[N];
        System.out.println("Enter the elements of Your Array");
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }
}

