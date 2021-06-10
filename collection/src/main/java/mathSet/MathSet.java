package mathSet;

import java.util.Iterator;

public class MathSet<E extends Number & Comparable<E>> implements Simple<E> {

    private int capacity = 16;
    private E[] values;
    private int size = 0;


    MathSet() {
        values = (E[]) new Number[16];
    }

    MathSet(int capacity) {
        values = (E[]) new Number[capacity];
    }

     MathSet(Number[] numbers) {
        values = (E[]) new Number[numbers.length];
        add(numbers);
    }

    @Override
    public void add(Number n) {
        if(size == values.length) {
            growSize();
        }
        if (!contains((E) n)) {
            values[size] = (E) n;
            size++;
        }
    }

    @Override
    public void add(Number... n) {
        for (Number value : n) {
                add(value);
        }
    }

    @Override
    public void join(MathSet ms) {
        for (Object number : ms.toArray()) {
            add((E) number);
        }
    }

    private E[] readAll() {
        return values;
    }

    @Override
    public void join(MathSet... ms) {
        for (MathSet<E> mathSet : ms) {
            join(mathSet);
        }
    }

    @Override
    public void sortDesc() {
        sortDesc(0,size);
    }

    @Override
    public void sortDesc(int firstIndex, int lastIndex) {
        E[] tempArr = readAll();
        System.arraycopy(values, firstIndex, tempArr, 0, lastIndex - firstIndex);
        E temp;
        for (int i = 0; i <= lastIndex - firstIndex; i++) {
            for (int j = 1; j < lastIndex - firstIndex; j++) {
                if (tempArr[j] == null) {
                    j++;
                }
                else if(tempArr[j - 1].compareTo(tempArr[j]) < 0) {
                    temp = tempArr[j - 1];
                    tempArr[j - 1] = tempArr[j];
                    tempArr[j] = temp;
                }
            }
        }
        System.arraycopy(tempArr, firstIndex, values, 0, tempArr.length);
    }

    @Override
    public void sortDesc(Number value) {
        E[] tempArr = readAll();
        for (int i = 0; i < tempArr.length; i++) {
            if(value.equals(tempArr[i]))
            {
                sortDesc(0,i);
            }
        }
    }

    @Override
    public void sortAsc() {
        sortAsc(0,size);
    }

    @Override
    public void sortAsc(int firstIndex, int lastIndex) {
        E[] tempArr = readAll();
        System.arraycopy(values, firstIndex, tempArr, 0, lastIndex - firstIndex);
        E temp;
        for (int i = 0; i <= lastIndex - firstIndex; i++) {
            for (int j = 1; j < lastIndex - firstIndex; j++) {
                if (tempArr[j] == null) {
                    j++;
                }
                else if(tempArr[j - 1].compareTo(tempArr[j]) > 0) {
                    temp = tempArr[j - 1];
                    tempArr[j - 1] = tempArr[j];
                    tempArr[j] = temp;
                }
            }
        }
        System.arraycopy(tempArr, firstIndex, values, 0, tempArr.length);
    }

    @Override
    public void sortAsc(Number value) {
        E[] tempArr = readAll();
        for (int i = 0; i < tempArr.length; i++) {
            if(value.equals(tempArr[i]))
            {
                sortAsc(0,i);
            }
        }
    }

    @Override
    public Number get(int index) {
        return values[index];
    }

    @Override
    public boolean contains(Number n) {
        for (int i = 0; i < size; i++) {
            E value = values[i];
            if (value.equals(n))
                return true;
        }

        return false;
    }


    @Override
    public int getSize() {
        return values.length;
    }

    @Override
    public Number getMax() {
    E[] temp = readAll();
    E max = temp[0];
        for (int i = 0; i < temp.length; i++) {
            if(temp[i]==null)
            {
                break;
            }
            if(max.compareTo(temp[i])<0)
            {
                max = temp[i];
            }
        }
        return max;
    }

    @Override
    public Number getMin() {
        E[] temp = readAll();
        E min = temp[0];
        for (int i = 0; i < temp.length; i++) {
            if(temp[i]==null)
            {
                break;
            }
            if(min.compareTo(temp[i])>0)
            {
                min = temp[i];
            }
        }
        return min;
    }

    @Override
    public Number getAverage() {
        E[] temp = readAll();
        int length = 0;
        int sum = 0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == null) {
                break;
            }
            else {
                sum+=(Integer)temp[i];
                length++;
            }
        }
        double avarage = ((double) sum/(double)length);

     return avarage;
    }

    @Override
    public Number getMedian() {
        return null;
    }

    @Override
    public Number[] toArray() {
        return toArray(0, size - 1);
    }

    @Override
    public Number[] toArray(int firstIndex, int lastIndex) {
        if (firstIndex > lastIndex) {
            return new Number[]{};
        }
        Number[] copy = new Number[lastIndex - firstIndex + 1];
        System.arraycopy(values, firstIndex, copy, 0, lastIndex - firstIndex + 1);
        return copy;
    }

    @Override
    public MathSet squash(int firstIndex, int lastIndex) {
        return null;
    }

    @Override
    public void clear() {
        values = (E[]) new Number[capacity];
        size = 0;
    }

    @Override
    public void clear(Number[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < values.length; j++) {
                if(values[j]==null)
                {
                    continue;
                }
                if(values[j].equals(numbers[i]))
                {
                    values[j] = null;

                }
            }
        }
    }

    private void growSize() {
            capacity = (capacity * 3) / 2 + 1;
            E[] newArray = (E[]) new Number[capacity];
            System.arraycopy(values, 0, newArray, 0, size);
            values = newArray;
    }

    @Override
    public Iterator<E> iterator() {
        return new MathSetIterator<>(values);
    }
}
