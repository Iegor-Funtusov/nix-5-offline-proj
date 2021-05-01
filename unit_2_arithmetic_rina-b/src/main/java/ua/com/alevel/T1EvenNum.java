package ua.com.alevel;

public class T1EvenNum {
    public static void evenNum (int[] list){
        System.out.println("Task 1: Even numbers");
        for (int i : list){
            if (i % 2 == 0){
                System.out.print(i + " ");
            }
        }
        System.out.print("\n");
    }
}