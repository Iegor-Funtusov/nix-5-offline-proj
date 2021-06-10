package ua.com.nix;

public class MathSet <E extends Number> {

    private E[] numbers;
    private int capacity = 10;

    public MathSet() {
        numbers = (E[]) new  Number[capacity];
    }

    public MathSet(int capacity){
        numbers = (E[]) new Number[capacity];
    }

    public MathSet(Number[] numbers){
        numbers = (E[]) new Number[numbers.length];
    }


}
