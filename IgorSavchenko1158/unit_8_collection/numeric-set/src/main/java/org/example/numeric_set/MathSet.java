package org.example.numeric_set;

import java.util.Arrays;

public class MathSet<N extends Number & Comparable<N>> {

    private static final int CAPACITY = 10;

    private Object[] array;
    private int entries = 0;

    public MathSet() {
        this(CAPACITY);
    }

    public MathSet(int capacity) {
        array = new Object[capacity];
    }

    public MathSet(N[] numbers) {
        array = new Object[numbers.length];
        add(numbers);
    }

    public MathSet(N[]... numbers) {
        this();
        for (N[] numberArray : numbers) {
            add(numberArray);
        }
    }

    public MathSet(MathSet<N> numbers) {
        this();
        join(numbers);
    }

    public MathSet(MathSet<N>... numbers) {
        this();
        join(numbers);
    }

    public void add(N n) {
        if (present(n)) {
            return;
        }
        if (entries == array.length) {
            grow();
        }
        array[entries] = n;
        entries++;
    }

    public void add(N... n) {
        if (n.length > array.length - entries) {
            grow(n.length);
        }
        for (N number : n) {
            add(number);
        }
    }

    public void join(MathSet<N> ms) {
        if (ms.entries > array.length - entries) {
            grow(ms.entries);
        }
        for (Object number : ms.toArray()) {
            add((N) number);
        }
    }

    public void join(MathSet<N>... ms) {
        for (MathSet<N> set : ms) {
            join(set);
        }
    }

    public void sortDesc() {
        sortDesc(0, entries - 1);
    }

    public void sortDesc(int firstIndex, int lastIndex) {
        if (outOfBounds(firstIndex, lastIndex)) {
            return;
        }
        sort(firstIndex, lastIndex, false);
    }

    public void sortDesc(N value) {
        int index = findIndex(value);
        if (!outOfBounds(index)) {
            sortDesc(0, index);
        }
    }

    public void sortAsc() {
        sortAsc(0, entries - 1);
    }

    public void sortAsc(int firstIndex, int lastIndex) {
        if (outOfBounds(firstIndex, lastIndex)) {
            return;
        }
        sort(firstIndex, lastIndex, true);
    }

    public void sortAsc(N value) {
        int index = findIndex(value);
        if (!outOfBounds(index)) {
            sortAsc(0, index);
        }
    }

    public N get(int index) {
        if (outOfBounds(index)) {
            return null;
        }
        return (N) array[index];
    }


    public N getMax() {
        MathSet<N> temp = new MathSet<>(this);
        temp.sortDesc();
        return temp.get(0);
    }

    public N getMin() {
        MathSet<N> temp = new MathSet<>(this);
        temp.sortAsc();
        return temp.get(0);
    }

    public Double getAverage() {
        if (this.size() == 0) {
            return null;
        }
        double result = 0;
        for (int i = 0; i < entries; i++) {
            result += this.get(i).doubleValue();
        }
        result /= entries;
        return result;
    }

    public Double getMedian() {
        if (this.size() == 0) {
            return null;
        }
        MathSet<N> temp = new MathSet<>(this);
        temp.sortAsc();

        double result;
        int size = temp.size();
        if (size % 2 == 0) {
            result = temp.get(size / 2 - 1).doubleValue() + temp.get(size / 2).doubleValue();
            result /= 2.0;
        } else {
            result = temp.get(size / 2).doubleValue();
        }
        return result;
    }

    public Object[] toArray() {
        return toArray(0, entries - 1);
    }

    public Object[] toArray(int firstIndex, int lastIndex) {
        if (firstIndex > lastIndex || outOfBounds(firstIndex, lastIndex)) {
            return new Object[]{};
        }
        Object[] copy = new Object[lastIndex - firstIndex + 1];
        System.arraycopy(array, firstIndex, copy, 0, lastIndex - firstIndex + 1);
        return copy;
    }

    public MathSet<N> squash(int firstIndex, int lastIndex) {
        if (firstIndex > lastIndex || outOfBounds(firstIndex, lastIndex)) {
            return null;
        }
        MathSet<N> result = new MathSet<>();
        Object[] array = toArray(firstIndex, lastIndex);
        for (Object number : array) {
            result.add(((N) number));
        }
        return result;
    }

    public void clear() {
        entries = 0;
        array = new Object[CAPACITY];
    }

    public void clear(N[] numbers) {
        for (N number : numbers) {
            remove(number);
        }
    }

    public void remove(N number) {
        int index = findIndex(number);
        if (index < 0) {
            return;
        }
        array[index] = null;
        if (index < entries - 1) {
            System.arraycopy(array, index + 1, array, index, entries - index - 1);
        }
        entries--;
    }

    public int size() {
        return entries;
    }

    private boolean present(N n) {
        for (int i = 0; i < entries; i++) {
            if (array[i].equals(n)) {
                return true;
            }
        }
        return false;
    }

    private void grow() {
        grow((array.length / 2) + 1);
    }

    private void grow(int by) {
        Object[] newArray = new Object[array.length + by];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    private void sort(int firstIndex, int lastIndex, boolean asc) {
        Object temp;
        for (int i = firstIndex; i < lastIndex; i++) {
            for (int j = firstIndex; j < lastIndex; j++) {
                if (asc) {
                    if (((N) array[j]).compareTo(((N) array[j + 1])) > 0) {
                        temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
                } else {
                    if (((N) array[j]).compareTo(((N) array[j + 1])) < 0) {
                        temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
                }
            }
        }
    }

    private int findIndex(N value) {
        for (int i = 0; i < entries; i++) {
            if (array[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    private boolean outOfBounds(int... indexes) {
        for (int index : indexes) {
            if (index < 0 || index >= entries) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "MathSet{" +
                "array=" + Arrays.toString(array) +
                ", entries=" + entries +
                '}';
    }
}
