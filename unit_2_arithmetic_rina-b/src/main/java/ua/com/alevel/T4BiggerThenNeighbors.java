package ua.com.alevel;


public class T4BiggerThenNeighbors {
    public static void biggerThenNeighbors (int[] list){
        int count = 0;
        for (int i = 1; i < list.length - 1; i++) {
            if (list[i] > list[i - 1] && list[i] > list[i+1]) {
                count++;
            }

        }
        System.out.println("Task 4: There are " + count +  " numbers bigger then their neighbors. ");
    }
}
