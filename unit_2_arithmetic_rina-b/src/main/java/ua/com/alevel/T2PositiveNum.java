package ua.com.alevel;

public class T2PositiveNum{
    public static void positiveNum  (int[] list){
        int count = 0;
        for (int i : list) {
            if (i >= 0)
                count++;
        }
        System.out.println("Task 2: There are " + count +  " positive numbers. ");
    }

}