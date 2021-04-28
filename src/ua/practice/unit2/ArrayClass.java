package ua.practice.unit2;

import java.util.Arrays;
import java.util.Random;

public class ArrayClass {
    private final int[] array;

    public ArrayClass(int arraySize) {
        array = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            array[i] = new Random().nextInt(arraySize*2 + 1) - arraySize;
        }
    }

    public void searchEven(){
        for (int value : array) {
            if (value % 2 == 0) {
                System.out.print(value + " ");
            }
        }
        System.out.println("");
    }
    public void searchPositive(){
        for (int value : array) {
            if (value > 0) {
                System.out.print(value + " ");
            }
        }

        System.out.println("");
    }
    public void searchCountOfElementsBiggerThanPrevious(){
        int counter = 0;
        for (int i = 0; i < array.length-1; i++) {
          if(array[i+1] > array[i]) counter++;
        }
        System.out.println(counter);
    }

    public void countElementsWithBiggerValueThanNeighbours(){
        int counter = 0;
        for (int i = 1; i < array.length-1; i++) {
            if(array[i] > array[i-1] && array[i] >array[i+1]) counter++;
        }
        System.out.println(counter);
    }

    public void reverseArray(){
        int temp;
        for (int i = 0; i < array.length/2; i++) {
                temp = array[i];
                array[i] = array[array.length-i-1];
                array[array.length-i-1] = temp;
            }
        System.out.println(Arrays.toString(array));
    }

    public void swapNeighbours(){
        int temp;
        for (int i = 1; i < array.length; i += 2) {
            temp = array[i];
            array[i] = array[i - 1];
            array[i - 1] = temp;
        }
        System.out.println(Arrays.toString(array));
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
