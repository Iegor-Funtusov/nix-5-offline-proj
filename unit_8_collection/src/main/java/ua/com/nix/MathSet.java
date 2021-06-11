package ua.com.nix;

import static java.lang.Integer.MAX_VALUE;

public class MathSet <E extends Number> {

    private E[] arr;
    private static final int capacity = 10;

    public MathSet() {
        arr = (E[]) new  Number[10];
    }

    public MathSet(int capacity){
        arr = (E[]) new Number[capacity];
    }

    public MathSet(Number[] numbers){
        arr = (E[]) new Number[numbers.length];
    }

//    public MathSet(Number[] ... numbers){
//        arr = (E[]) new Number[numbers.length + 1];
//    }

    public void add(Number n) {
        E[] newArr = (E[]) new Number[capacity + 1];
        System.arraycopy(arr, 0, newArr, 0, 0);
        arr = newArr;
        arr[capacity + 1] = (E) n;
    }

    public void add(Number ... n){
        for(Number numbers : n){
            add(numbers);
        }
    }

    public void join(MathSet ms) {

    }

    public Number[] toArray() {

    }

    public Number get(int index){
        return arr[index];
    }

    public Number getMin() {
        int min = MAX_VALUE;



    }

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

    public void clear(){
        arr = (E[]) new Number[capacity];
    }

    public E[] readAll() {
        return arr;
    }




}
