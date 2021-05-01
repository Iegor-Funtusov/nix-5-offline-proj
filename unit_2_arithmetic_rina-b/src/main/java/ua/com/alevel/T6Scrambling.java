package ua.com.alevel;


import java.util.Arrays;

public class T6Scrambling {
    public static void scrambling (int[] list){
        for(int i = 1; i < list.length; i+=2){
            int a = list[i];
            list[i] = list[i-1];
            list[i-1] = a;
        }
        System.out.println("Task 6: Scrambling " +Arrays.toString(list));
    }
}