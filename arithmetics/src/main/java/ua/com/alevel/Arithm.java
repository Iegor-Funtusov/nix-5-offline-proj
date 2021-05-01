package ua.com.alevel;
import java.util.Scanner;
import java.util.Arrays;
import static ua.com.alevel.Operations.task1;
import static ua.com.alevel.Operations.task2;
import static ua.com.alevel.Operations.task3;
import static ua.com.alevel.Operations.task4;
import static ua.com.alevel.Operations.task5;
import static ua.com.alevel.Operations.task6;




public class Arithm {

    public static void main(String[] args) {
        System.out.println("Введите размер массива:");

        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = scan.nextInt();
        }

        System.out.println("Исходный массив: " + Arrays.toString(arr));
        task1(arr);
        task2(arr);
        task3(arr);
        task4(arr);
       task5(arr);
       task6(arr);
    }
}





