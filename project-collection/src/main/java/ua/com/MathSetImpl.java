package ua.com;


import java.util.Iterator;

public class MathSetImpl implements MathSet {

    private static final int DEFAULT_CAPACITY = 16;
    private int size = 0;
    private Number[] numbers;

    public MathSetImpl() {
        numbers = new Number[DEFAULT_CAPACITY];
    }

    public MathSetImpl(int capacity) {
        if(capacity<=0){
            throw new IllegalArgumentException("Capacity is not valid");
        }
        numbers = new Number[capacity];
    }

    public MathSetImpl(Number[] numbers) {
        this.numbers = numbers;
        size = numbers.length;
    }

    public MathSetImpl(Number[] ... numbers) {
    }

    public MathSetImpl(MathSetImpl numbers) {
    }

    @SafeVarargs
    public MathSetImpl(MathSetImpl ... numbers) {
    }

    @Override
    public void add(Number n) {

    }

    @Override
    public void add(Number... n) {

    }

    @Override
    public void join(MathSetImpl ms) {

    }

    @Override
    public void sortDesc() {

    }

    @Override
    public void sortDesc(int firstIndex, int lastIndex) {

    }

    @Override
    public void sortDesc(Number value) {

    }

    @Override
    public void sortAsc() {

    }

    @Override
    public void sortAsc(int firstIndex, int lastIndex) {

    }

    @Override
    public void sortAsc(Number value) {

    }

    @Override
    public Number get(int index) {
        return null;
    }

    @Override
    public Number getMax() {
        return null;
    }

    @Override
    public Number getMin() {
        return null;
    }

    @Override
    public Number getAverage() {
        return null;
    }

    @Override
    public Number getMedian() {
        return null;
    }

    @Override
    public Number[] toArray() {
        return new Number[0];
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
    public void clear() {

    }

    @Override
    public void clear(Number[] numbers) {

    }

    @Override
    public Iterator<Number> iterator() {
        return null;
    }
}
