package ua.com.alevel;

import java.util.Arrays;


public class T3BiggerThanPre {
    public static void biggerThenPre(int[] list) {
        int count = 0;
        for (int i = 1; i < list.length; i++) {
            if (list[i] > list[i - 1]) {
                count++;
            }

        }
        System.out.println("Task 3: There are " + count +  " numbers bigger then the previous one. ");
    }
}
