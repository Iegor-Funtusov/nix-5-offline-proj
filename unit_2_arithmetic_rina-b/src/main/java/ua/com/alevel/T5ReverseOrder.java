package ua.com.alevel;

import java.util.Arrays;

public class T5ReverseOrder {
    public static void reversedOrder (int[] list) {
        for (int i = 0; i < list.length / 2; i++) {
            int a = list[i];
            list[i] = list[list.length - i - 1];
            list[list.length - i - 1] = a;
        }
        System.out.println("Task 5: Reverse Order "+ Arrays.toString(list));
    }
}