package impl;

import java.util.Arrays;

public class MathSet<T extends Number & Comparable<? super T>> {

    private int capacity = 10;
    private T[] numbrs;
    private int lastIndex;

    public MathSet() {
        numbrs = (T[]) new Number[capacity];
    }

    public MathSet(int capacity) {
        numbrs = (T[]) new Number[capacity];
    }

    public MathSet(T[] numbers) {
        numbrs = (T[]) new Number[numbers.length];
        add(numbers);
    }

    public MathSet(T[]... numbers) {
        int size = 0;
        for (T[] ts : numbers) {
            size += ts.length;
        }
        numbrs = (T[]) new Number[size];
        for (T[] number : numbers) {
            add(number);
        }
    }

    public MathSet(MathSet<T> mathSet) {
        this();
        join(mathSet);
    }

    public MathSet(MathSet<T>... mathSet) {
        this();
        for (MathSet<T> m : mathSet) {
            join(m);
        }
    }

    public void add(T n) {
        if (contains(n)) {
            return;
        }
        if (emptyCount() > 0) {
            numbrs[numbrs.length - emptyCount()] = n;
        } else if (emptyCount() == 0) {
            T[] newArr = (T[]) new Number[numbrs.length + (numbrs.length / 2)];
            for (int i = 0; i < numbrs.length; i++) {
                newArr[i] = numbrs[i];
            }
            newArr[numbrs.length] = n;
            numbrs = newArr;
        }
    }

    public final void add(T... n) {
        for (T number1 : n) {
            add(number1);
        }
    }

    public void join(MathSet ms) {
        for (int i = 0; i < ms.numbrs.length; i++) {
            add((T) ms.numbrs[i]);
        }
    }

    public void join(MathSet<T>... ms) {
        for (MathSet<T> m : ms) {
            join(m);
        }
    }

    public void sortDesc() {
        sortDesc(1, numbrs.length - emptyCount());
    }

    public void sortDesc(int firstIndex, int lastIndex) {
        T temp;
        int size = numbrs.length - emptyCount();
        if (firstIndex > 0 && lastIndex <= size && lastIndex >= firstIndex) {
            firstIndex--;
            for (int i = lastIndex - 1; i >= firstIndex + 1; i--) {
                for (int j = firstIndex; j < i; j++) {
                    if (numbrs[j].compareTo(numbrs[j + 1]) < 0) {
                        temp = numbrs[j];
                        numbrs[j] = numbrs[j + 1];
                        numbrs[j + 1] = temp;
                    }
                }
            }
        }
    }

    public void sortDesc(T value) {
        for (int i = 0; i < numbrs.length; i++) {
            if (value.equals(numbrs[i])) {
                sortDesc(1, i);
            }
        }
    }

    public void sortAsc() {
        sortAsc(1, numbrs.length - emptyCount());
    }

    public void sortAsc(int firstIndex, int lastIndex) {
        T temp;
        int size = numbrs.length - emptyCount();
        if (firstIndex > 0 && lastIndex <= size && lastIndex >= firstIndex) {
            firstIndex--;
            for (int i = lastIndex - 1; i >= firstIndex + 1; i--) {
                for (int j = firstIndex; j < i; j++) {
                    if (numbrs[j].compareTo(numbrs[j + 1]) > 0) {
                        temp = numbrs[j];
                        numbrs[j] = numbrs[j + 1];
                        numbrs[j + 1] = temp;
                    }
                }
            }
        }
    }

    public void sortAsc(T value) {
        for (int i = 0; i < numbrs.length; i++) {
            if (value.equals(numbrs[i])) {
                sortAsc(1, i);
            }
        }
    }

    public T get(int index) {
        int size = numbrs.length - emptyCount();
        if (index > 0 && index <= size) {
            return numbrs[index - 1];
        }
        return null;
    }

    public T getMax() {
        T max = numbrs[0];
        int size = numbrs.length - emptyCount();
        for (int i = 0; i < size; i++) {
            if (max.compareTo(numbrs[i]) < 0) {
                max = numbrs[i];
            }
        }
        return max;
    }

    public T getMin() {
        T min = numbrs[0];
        int size = numbrs.length - emptyCount();
        for (int i = 0; i < size; i++) {
            if (min.compareTo(numbrs[i]) > 0) {
                min = numbrs[i];
            }
        }
        return min;
    }

    public double getAverage() {

        double valueAverage = 0;
        if (numbrs == null || numbrs.length == 0) {
            return valueAverage;
        }
        try {
            for (T element : numbrs) {
                if (element != null) {
                    valueAverage += (Integer) element;
                }
            }
        } catch (ClassCastException classCastException) {
            for (T element : numbrs) {
                if (element != null) {
                    valueAverage += (Double) element;
                }
            }
        }
        return (double) valueAverage / (numbrs.length - emptyCount());
    }

    public double getMedian() {
        if (numbrs == null || numbrs.length == 0 || numbrs.length == emptyCount()) {
            return 0;
        }
        MathSet<T> copy = new MathSet<>(this);
        copy.sortAsc();
        int size = copy.numbrs.length - copy.emptyCount();
        try {
            if (size % 2 == 0) {
                double temp = (Double) copy.numbrs[size / 2] + (Double) copy.numbrs[size / 2 - 1];
                return (temp / 2);
            }
        } catch (ClassCastException classCastException) {
            if (size % 2 == 0) {
                double temp = (Integer) copy.numbrs[size / 2] + (Integer) copy.numbrs[size / 2 - 1];
                return (temp / 2);
            }
        }
        return (Double) copy.numbrs[size / 2];
    }

    public T[] toArray() {
        return toArray(0, lastIndex);
    }

    public T[] toArray(int firstIndex, int lastIndex) {
        int size = numbrs.length - emptyCount();
        if (firstIndex > 0 && lastIndex <= size && lastIndex >= firstIndex) {
            firstIndex--;
            T[] copy = (T[]) new Number[lastIndex - firstIndex];
            for (int i = 0; i < lastIndex - firstIndex; i++) {
                copy[i] = numbrs[firstIndex + i];
            }
            return copy;
        }
        return null;
    }

    public MathSet squash(int firstIndex, int lastIndex) {
        return new MathSet(toArray(firstIndex, lastIndex));
    }

    public void clear() {
        numbrs = (T[]) new Number[numbrs.length];
    }

    public void clear(Number[] numbers) {
        for (int i = 0; i < numbrs.length; i++) {
            for (Number number : numbers) {
                if (numbrs[i] != null && numbrs[i].equals(number)) {
                    numbrs[i] = null;
                }
            }
        }
    }


    public boolean contains(T n) {
        for (T element : numbrs) {
            if (element == n) {
                return true;
            }
        }
        return false;
    }

    private int emptyCount() {
        int count = 0;
        for (int i = 0; i < numbrs.length; i++) {
            if (numbrs[i] == null) {
                count++;
            }
        }
        return count;
    }

    public boolean isEmpty() {
        for (T element : numbrs) {
            if (element != null) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "MathSet{" +
                "elements=" + Arrays.toString(numbrs) +
                '}';
    }
}
