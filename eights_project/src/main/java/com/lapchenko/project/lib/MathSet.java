package com.lapchenko.project.lib;


import java.math.BigDecimal;
import java.util.ArrayList;

public class MathSet<E> {
    private E[] set = (E[]) new Object[10];
    private int size;

    public MathSet() {
    }

    public MathSet(int capacity) {
        this.set = (E[]) new Object[capacity];
    }

    public MathSet(E[] numbers) {
        add(numbers);
    }

    public MathSet(E[] ... numbers) {
        for (int i = 0; i < numbers.length; i++) {
            add(numbers[i]);
        }
    }

    public MathSet(MathSet set) {
        add((E[]) set.toArray());
    }

    public MathSet(MathSet ... set) {
        for (int i = 0; i < set.length; i++) {
            add((E[])set[i].toArray());
        }
    }

    public void add(E item) {
        if (size > set.length * 0.75) {
            resize();
        }
        if (!contains(item)) {
            set[size] = item;
            size++;
        }

    }

    public void add(E... item) {
        for (E e : item) {
            add(e);
        }
    }

    public void join(MathSet<E> secondSet) {
        add(secondSet.toArray());
    }

    public void join(MathSet<E>... setArr) {
        for (int i = 0; i < setArr.length; i++) {
            join(setArr[i]);
        }
    }

    public E get(int index) {
        return set[index];
    }

    public E[] toArray() {
        E[] newSet = (E[]) new Object[size];
        System.arraycopy(set, 0, newSet, 0, size);
        return newSet;
    }

    public E[] toArray(int from, int to) {
        E[] newSet = (E[]) new Object[size];
        System.arraycopy(set, from, newSet, 0, (to - from));
        return newSet;
    }

    public void sort(boolean reversedOrder) {
        sort(0, size, reversedOrder);
    }

    public void sort(int from, int to, boolean reversedOrder) {
        if (to > size || to < 0 || from < 0 || from > to) {
            throw new IndexOutOfBoundsException("Illegal bounds passed to sorting method");
        }
        for (int i = from; i < to; i++) {
            for (int j = from; j < to - i - 1; j++) {
                if (reversedOrder) {
                    if (compareNumbers(j, j + 1) > 0) {
                        swap(j, j + 1);
                    }
                } else {
                    if (compareNumbers(j, j + 1) < 0) {
                        swap(j, j + 1);
                    }
                }
            }
        }
    }

    public E getMax() {
        int maxIndex = 0;
        for (int i = 0; i < size; i++) {
            if (compareNumbers(maxIndex, i) < 0) {
                maxIndex = i;
            }
        }
        return set[maxIndex];
    }

    public E getMin() {
        int minIndex = 0;
        for (int i = 0; i < size; i++) {
            if (compareNumbers(minIndex, i) > 0) {
                minIndex = i;
            }
        }
        return set[minIndex];
    }

    public E getAverage() {
        if (set[0].getClass().equals(Integer.class)) {
            Integer sum = 0;
            for (int i = 0; i < size; i++) {
                sum += (Integer) set[i];
            }
            Integer avg = sum / size;
            return (E) avg;
        }
        if (set[0].getClass().equals(Long.class)) {
            Long sum = 0L;
            for (int i = 0; i < size; i++) {
                sum += (Long) set[i];
            }
            Long avg = sum / size;
            return (E) avg;
        }
        if (set[0].getClass().equals(Short.class)) {
            short sum = 0;
            for (int i = 0; i < size; i++) {
                sum += (Short) set[i];
            }
            Integer avg = sum / size;
            return (E) avg;
        }
        if (set[0].getClass().equals(Byte.class)) {
            byte sum = 0;
            for (int i = 0; i < size; i++) {
                sum += (Byte) set[i];
            }
            Integer avg = sum / size;
            return (E) avg;
        }
        if (set[0].getClass().equals(Float.class)) {
            Float sum = 0f;
            for (int i = 0; i < size; i++) {
                sum += (float) set[i];
            }
            Float avg = sum / size;
            return (E) avg;
        }
        if (set[0].getClass().equals(Double.class)) {
            Double sum = 0.0;
            for (int i = 0; i < size; i++) {
                sum += (double) set[i];
            }
            Double avg = sum / size;
            return (E) avg;
        }
        throw new RuntimeException("Something wrong with number type");
    }

    public E getMedian() {
        MathSet<E> tempSet = new MathSet<>(this);
        tempSet.sort(false);
        return tempSet.get(size / 2);
    }

    public MathSet squash(int from, int to) {
        if (to > size || to < 0 || from < 0 || from > to) {
            throw new IndexOutOfBoundsException("Illegal bounds passed to squash method");
        }
        MathSet<E> toReturn = new MathSet<>();
        for (int i = from; i < to; i++) {
            toReturn.add(set[i]);
        }
        return toReturn;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 0; i < size; i++) {
            stringBuilder.append(set[i] + " ");
        }
        return stringBuilder.toString();
    }

    private long compareNumbers(int index1, int index2) {

        if (set[index1].getClass().equals(Integer.class)) {
            return (int) set[index1] - (int) set[index2];
        }
        if (set[index2].getClass().equals(Long.class)) {
            return (long) set[index1] - (long) set[index2];
        }
        if (set[index1].getClass().equals(Short.class)) {
            return (short) set[index1] - (short) set[index2];
        }
        if (set[index1].getClass().equals(Byte.class)) {
            return (byte) set[index1] - (byte) set[index2];
        }
        if (set[index2].getClass().equals(Float.class)) {
            return Float.compare((float) set[index1], (float) set[index2]);
        }
        if (set[index2].getClass().equals(Double.class)) {
            return Double.compare((double) set[index1], (double) set[index2]);
        }
        throw new RuntimeException("Type of values doesn't match any of number types");
    }

    private void swap(int index1, int index2) {
        var temp = set[index1];
        set[index1] = set[index2];
        set[index2] = temp;
    }

    private boolean contains(E item) {
        for (int i = 0; i < size; i++) {
            if (set[i] == item) {
                return true;
            }
        }
        return false;
    }

    private void resize() {
        E[] newSet = (E[]) new Object[set.length * 2];
        for (int i = 0; i < size; i++) {
            newSet[i] = set[i];
        }
        set = newSet;
    }


}
