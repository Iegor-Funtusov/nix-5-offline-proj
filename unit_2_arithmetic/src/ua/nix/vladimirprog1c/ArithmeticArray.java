package ua.nix.vladimirprog1c;
import java.util.ArrayList;

public class ArithmeticArray {

    public void printEvent(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                System.out.print(array[i]+ " ");
            }
        }
        System.out.println("");
    }
    public void printNumberNegative (int[] array) {
        int number = 0;
        for (int i = 0; i < array.length; i++) {

            if (array[i]  >= 0) {
                number++;
            }

        }
        System.out.println(number);
    }
    public void printMoreThenPrevious(int[] array) {
        int number = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i-1] ) {
                number++;
            }
        }
        System.out.println(number);
    }
    public void printMoreThenNeighbors(int[] array) {
        int number = 0;
        for (int i = 1; i < array.length-1; i++) {
            if (array[i] > array[i-1]&array[i] > array[i+1] ) {
                number++;
            }
        }
        System.out.println(number);
    }
    public void printReversArray(int[] array) {
        int length = array.length/2;
        for (int i = 0; i < length; i++) {
            int buf;
            buf = array[i];
            array[i] = array[array.length - 1 -i];
            array[array.length - 1 -i] = buf;
            }

        for (int each:array){
            System.out.print(each+" ");
        }
        System.out.println();
    }
    public void printReversNeighbors(int[] array) {
        for (int i = 0; i < array.length; i=i+2) {
            if (i == array.length)
                break;
            
            int buf;
            buf = array[i];
            array[i] = array[i+1];
            array[i+1] = buf;
        }

        for (int each:array){
            System.out.print(each+" ");
        }
        System.out.println();
    }

}

