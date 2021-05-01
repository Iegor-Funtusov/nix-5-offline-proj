package com.Lapchenko_Kirill.project;

import java.util.Arrays;

public class Tasks {

    public static void task1(int[] arr) {
        System.out.print("Even numbers: ");
        for (int a : arr) {
            if (a % 2 == 0)
                System.out.print(a + " ");
        }
        System.out.println();
    }

    public static void task2(int[] arr) {
        int count = 0;
        for (int a : arr) {
            if (a >= 0)
                count++;
        }
        System.out.println("Amount of positive numbers: " + count);
    }

    public static void task3(int[] arr) {
        int count = 0;
        int prev = Integer.MAX_VALUE;
        for (int a : arr) {
            if(a > prev)
                count++;
            prev = a;
        }
        System.out.println("Amount of numbers bigger then previous: " + count);
    }

    public static void task4(int[] arr) {
        int count = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            if(arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                count++;
            }
        }
        System.out.println("Amount of numbers with smaller neighbours: " + count);
    }

    public static void task5(int[] array) {
        int[] arr = Arrays.copyOf(array, array.length);
        int temp;
        for (int i = 0, j = arr.length-1; i < arr.length/2; i++, j--) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        System.out.print("Reversed array:" );
        for (int a : arr) {
            System.out.print(" " + a);
        }
        System.out.println();
    }

    public static void task6(int[] array) {
        int[] arr = Arrays.copyOf(array, array.length);
        int temp;
        for (int i = 0; i < arr.length-1; i+=2) {
            temp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = temp;
        }
        System.out.print("Swap array:" );
        for (int a : arr) {
            System.out.print(" " + a);
        }
        System.out.println();
    }
}
