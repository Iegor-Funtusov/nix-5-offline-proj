package org.example.unit2;

public final class ArrayTool {

    private ArrayTool(){}
    public static void printEvenNumbersToConsole(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] % 2 == 0){
                System.out.print(arr[i]+" ");
            }
        }
        System.out.print("\n");
    }
    public static int countPositiveNumbers(int[] arr){
        int countsPositiveNum = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > 0){
                countsPositiveNum++;
            }
        }
        return countsPositiveNum;
    }
    public static int countValuesIsGreaterThenPrevious(int[] arr){
        int counts = 0;
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i]<arr[i+1]){
                counts++;
            }
        }
        return counts;
    }
    public static int countAdjacentValueLess(int[] arr){
        int counts = 0;
        for (int i = 1; i < arr.length-1; i++) {
            if(arr[i-1] < arr[i] && arr[i] > arr[i+1]){
                counts++;
            }
        }
        return counts;
    }
    public static void reverseArray(int[] arr){
        for (int i = 0; i < arr.length/2; i++) {
                int tmp = arr[i];
                arr[i] = arr[arr.length-i-1];
                arr[arr.length-i-1] = tmp;
        }
    }
    public static void swapOfAdjacentElements(int[] arr){
        for (int i = 1; i < arr.length; i += 2) {
            int tmp = arr[i];
            arr[i] = arr[i-1];
            arr[i-1] = tmp;
        }
    }
}
