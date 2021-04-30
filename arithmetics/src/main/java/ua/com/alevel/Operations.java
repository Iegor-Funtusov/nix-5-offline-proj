package ua.com.alevel;
import java.util.Arrays;



public class Operations {
    public static void task1(int[] arr) {

        System.out.println("Четные элементы массива:");
        for (int i:arr) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
    public static void task2(int[] arr) {
        System.out.println("Положительные числа массива:");
        int countNums = 0;
        for (int i : arr) {
            if (i > 0) {
                countNums++;
            }
        }

        System.out.println(countNums);
    }
    public static void task3(int[] arr) {
        System.out.println("Количество элементов массива, больше предыдущего:");
        int count = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                count++;
            }
        }

        System.out.println(count);
    }
    public static void task4(int[] arr) {
        System.out.println("Количество элементов массива, которые больше обоих своих соседей:");

        int count = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                count++;
            }
        }

        System.out.println(count);
    }
    public static void task5(int[] arr){
        System.out.println("Массив в обратном порядке:");

        int[] inner = Arrays.copyOf(arr, arr.length);

        int buffer = 0;
        for (int i = 0; i < inner.length / 2; i++) {
            buffer = inner[i];
            inner[i] = inner[inner.length - 1 - i];
            inner[inner.length - 1 - i] = buffer;
        }

        for (int i : inner) {
            System.out.print(i + " ");
        }
        System.out.println();

    }
    public static void task6(int[] arr) {
        System.out.println("Переставленные элементы массива:");

        int[] inner = Arrays.copyOf(arr, arr.length);

        int buffer = 0;
        for (int i = 1; i < inner.length; i += 2) {
            buffer = inner[i];
            inner[i] = inner[i - 1];
            inner[i - 1] = buffer;
        }

        for(int i : inner) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}

