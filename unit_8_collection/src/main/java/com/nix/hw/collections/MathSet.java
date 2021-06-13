package com.nix.hw.collections;

public class MathSet {

    private Number[] values;
    private int capacity;
    private int numbersAmount;

    public MathSet() {
        capacity = 10;
        values = new Number[capacity];
        numbersAmount = 0;
    }

    public MathSet(int capacity) {
        this.capacity = capacity;
        values = new Number[capacity];
        numbersAmount = 0;
    }

    public MathSet(Number[] numbers) {
        capacity = numbers.length;
        numbersAmount = 0;
        values = new Number[capacity];
        add(numbers);
    }

    public MathSet(Number[]... numbers) {
        capacity = numbers.length;
        numbersAmount = 0;
        values = new Number[capacity];
        for (Number[] n : numbers)
            add(n);
    }

    public MathSet(MathSet numbers) {
        Number[] arr = numbers.toArray();
        capacity = arr.length;
        numbersAmount = 0;
        values = new Number[capacity];
        add(arr);
    }

    public MathSet(MathSet... numbers) {
        capacity = numbers[0].toArray().length;
        numbersAmount = 0;
        values = new Number[capacity];
        for (MathSet n : numbers) {
            add(n.toArray());
        }
    }

    public void add(Number n) {
        if (numbersAmount == values.length)
            increaseCapacity();

        if (contains(n))
            return;
        values[numbersAmount] = n;
        numbersAmount++;
    }

    public void add(Number... n) {
        for (Number number : n) {
            add(number);
        }
    }

    public void join(MathSet ms) {
        add(ms.toArray());
    }

    public void join(MathSet... ms) {
        for (MathSet mathSet : ms)
            join(mathSet);
    }

    public void sortDesc() {
        sortDesc(0, numbersAmount);
    }

    public void sortDesc(int firstIndex, int lastIndex) {
        lastIndex = numbersAmount > lastIndex ? lastIndex : numbersAmount;
        for (int i = firstIndex; i < lastIndex; i++)
            for (int j = firstIndex; j < lastIndex-1; j++)
                if (values[j].doubleValue() < values[j + 1].doubleValue()) {
                    Number temp = values[j + 1];
                    values[j + 1] = values[j];
                    values[j] = temp;
                }
    }

    public void sortDesc(Number value) {
        if (contains(value))
            sortDesc(0, getIndexOf(value));
    }

    public void sortAsc() {
        sortAsc(0, numbersAmount);
    }

    public void sortAsc(int firstIndex, int lastIndex) {
        lastIndex = numbersAmount > lastIndex ? lastIndex : numbersAmount;
        for (int i = firstIndex; i < lastIndex; i++)
            for (int j = firstIndex; j < lastIndex-1; j++)
                if (values[j].doubleValue() > values[j + 1].doubleValue()) {
                    Number temp = values[j + 1];
                    values[j + 1] = values[j];
                    values[j] = temp;
                }
    }

    public void sortAsc(Number value) {
        if (contains(value))
            sortAsc(0, getIndexOf(value));
    }

    public Number get(int index) {
        return values[index];
    }

    public Number getMax() {
        Number max = values[0];
        for (int i = 0; i < numbersAmount; i++) {
            if (values[i].doubleValue() > max.doubleValue()) {
                max = values[i];
            }
        }
        return max;
    }

    public Number getMin() {
        Number min = values[0];
        for (int i = 0; i < numbersAmount; i++) {
            if (values[i].doubleValue() < min.doubleValue()) {
                min = values[i];
            }
        }
        return min;
    }

    public Number getAverage() {
        double sum = 0;
        for (int i = 0; i < numbersAmount; i++) {
            sum += values[i].doubleValue();
        }
        return sum/numbersAmount;
    }

    public Number getMedian() {
        return numbersAmount%2 != 0 ? values[numbersAmount/2] :
                ((values[numbersAmount/2].doubleValue() +
                  values[numbersAmount/2 - 1].doubleValue())/2);
    }

    public Number[] toArray(){
        Number[] arr = new Number[numbersAmount];
        for (int i = 0; i < numbersAmount; i++)
            arr[i] = values[i];
        return arr;
    }

    public Number[] toArray(int firstIndex, int lastIndex) {
        if (firstIndex >= 0 && lastIndex > 0 && lastIndex > firstIndex) {
            Number[] arr = new Number[lastIndex - firstIndex];
            int arrIterator = 0;
            for (int i = firstIndex; i < lastIndex; i++)
                arr[arrIterator++] = values[i];
            return arr;
        }
        throw new IndexOutOfBoundsException();
    }

    public MathSet squash(int firstIndex, int lastIndex) {
        MathSet temp = new MathSet();
        for (int i = firstIndex; i < lastIndex; i++)
            temp.add(values[i]);
        return temp;
    }

    public void clear() {
        numbersAmount = 0;
        values = new Number[capacity];
    }

    public void clear(Number[] numbers) {
        for (int i = 0; i < numbers.length; i++)
            if (contains(numbers[i])) {
                values[getIndexOf(numbers[i])] = values[numbersAmount - 1];
                values[numbersAmount-1] = null;
                numbersAmount--;
            }
    }

    private void increaseCapacity() {
        capacity = (capacity * 3) / 2 + 1;
        Number[] tempArr = new Number[capacity];
        for (int i = 0; i < values.length; i++)
            tempArr[i] = values[i];
        values = tempArr;
    }

    private boolean contains(Number number) {
        for (int i = 0; i < numbersAmount; i++)
            if (number.doubleValue() == values[i].doubleValue())
                return true;
        return false;
    }

    private int getIndexOf(Number value) {
        for (int i = 0; i < numbersAmount; i++)
            if (value.doubleValue() == values[i].doubleValue())
                return i;

        throw new IllegalArgumentException();
    }

}
