package ua.com.nix;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;

public class MathSet <E extends Number> implements MathSetInterface{

    private Number[] arr;
    private static final int capacity = 10;

    public MathSet() {
        arr = new  Number[10];
    }

    public MathSet(int capacity){
        arr = new Number[capacity];
    }

    public MathSet(Number[] numbers){
        arr = new Number[numbers.length];
    }

//    public MathSet(Number[] ... numbers){
//        arr = (Number[]) new Number[numbers.length + 1];
//    }

    @Override
    public void add(Number n) {
        Number[] newArr = new Number[capacity + 1];
        System.arraycopy(arr, 0, newArr, 0, 0);
        arr = newArr;
        arr[capacity + 1] = n;
    }

    @Override
    public void add(Number ... n) {
        for(Number numbers : n) {
            add(numbers);
        }
    }

    @Override
    public void join(MathSet ms) {

    }

    @Override
    public Number[] toArray() {
        return arr;
    }

    @Override
    public Number get(int index){
        return arr[index];
    }

    @Override
    public Number getMin() {
        int max = MAX_VALUE;
        int min = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((Integer) arr[i] < max)
                min = (Integer) arr[i];
        }
        return min;
    }

    @Override
    public void join(MathSet... ms) {

    }

    @Override
    public void sortDesc() {
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if ((Integer) arr[i] < (Integer) arr[i + 1]) {
                temp = (Integer) arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
    }

    @Override
    public void sortDesc(int firstIndex, int lastIndex) {
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if ((Integer) arr[i] < (Integer) arr[i + 1]) {
                temp = (Integer) arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
    }

    @Override
    public void sortDesc(Number value) {
        int temp = 0;
        for (int i = 0; i < (Integer) value; i++) {
            if ((Integer) arr[i] < (Integer) arr[i + 1]) {
                temp = (Integer) arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
    }

    @Override
    public void sortAsc() {
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if ((Integer) arr[i] > (Integer) arr[i + 1]) {
                temp = (Integer) arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
    }

    @Override
    public void sortAsc(int firstIndex, int lastIndex) {
        int temp = 0;
        for (int i = firstIndex; i < lastIndex; i++) {
            if ((Integer) arr[i] > (Integer) arr[i + 1]) {
                temp = (Integer) arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
    }

    @Override
    public void sortAsc(Number value) {
        int temp = 0;
        for (int i = 0; i < (Integer) value; i++) {
            if ((Integer) arr[i] > (Integer) arr[i + 1]) {
                temp = (Integer) arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
    }

    @Override
    public Number getMax() {
        int min = MIN_VALUE;
        int max = 0;
        for (int i = 0; i < arr.length; i++){
            if (min < (Integer) arr[i])
                max = (Integer) arr[i];
        }
        return max;
    }

    @Override
    public Number getMedian() {
        int[] forOddNumbers = new int[2];
        double medianForFloats = 0.0;
        int medianForOdd = 0;
//        int amountOfNumbers = arr.length;
        if (arr.length % 2 == 0) {
             medianForOdd = (Integer) arr[arr.length / 2];
             forOddNumbers[0] = medianForOdd;
             medianForOdd = (Integer) arr[arr.length / 2 + 1];
             forOddNumbers[1] = medianForOdd;
             return forOddNumbers[0] + forOddNumbers[1];
        }
        else {
            medianForFloats = (Integer) arr[arr.length / 2] + 0.5;
            return medianForFloats;
        }
    }

    @Override
    public Number[] toArray(int firstIndex, int lastIndex) {
        return new Number[0];
    }

    @Override
    public MathSet squash(int firstIndex, int lastIndex) {
        return null;
    }

    @Override
    public void clear(Number[] numbers) {
//        for(Number[] n : numbers){
//            clear(n);
//        }
    }

    @Override
    public Number getAverage() {
        int sum = 0;
        int amountOfElements = 0;
        double result = 0;

        for (int i = 0; i < arr.length - 1; i++){
            sum += (Integer) arr[i];
            amountOfElements++;
        }
        result = sum / amountOfElements;

        return result;
    }

    @Override
    public void clear(){
        arr = new Number[capacity];
    }

    public Number[] readAll() {
        return arr;
    }




}
