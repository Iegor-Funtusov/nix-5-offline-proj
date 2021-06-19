public class MathSet<T extends Number> {
    private Number[] array;

    MathSet() {
        array = new Number[0];
    }

    MathSet(int capacity) {
        array = new Number[capacity];
    }

    MathSet(Number[] numbers) {
        array = numbers;
    }

    MathSet(Number[] ... numbers) {
        array = new Number[0];
        for (Number[] number : numbers) {
            for (int j = 0; j < number.length; j++) {
                add(number[j]);
            }
        }
    }

    MathSet(MathSet numbers) {
        array = numbers.array;
    }

    MathSet(MathSet ... numbers) {
        array = new Number[0];
        for (MathSet number : numbers) {
            for (int j = 0; j < number.array.length; j++) { add(number.array[j]); }
        }
    }

    void add(Number n) {
        Number[] newArray = new Number[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[newArray.length - 1] = n;
        array = newArray;
    }

    void add(Number ... n) {
        for (Number number : n) { add(number); }
    }

    void join(MathSet ms) {
        Number[] newArray = new Number[array.length + ms.array.length];
        int i = 0;
        for (i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        for (int j = 0; j < ms.array.length; j++, i++) {
            newArray[i] = ms.array[j];
        }
        array = newArray;
    }

    void join(MathSet... ms) {
        for (MathSet m : ms) { join(m); }
    }

    void sortDesc() {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if ((int) array[j] < (int) array[j + 1]) {
                    Number tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }

    void sortDesc(int firstIndex, int lastIndex) {
        for (int i = firstIndex; i < lastIndex; i++) {
            for (int j = firstIndex; j < lastIndex - 1; j++) {
                if ((int) array[j] < (int) array[j + 1]) {
                    Number tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }

    void sortDesc(Number value) {
        for (int i = valueOf(value); i < array.length - 1; i++) {
            for (int j = valueOf(value); j < array.length - 1 - i; j++) {
                if ((int) array[j] < (int) array[j + 1]) {
                    Number tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }

    int valueOf(Number value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(value))
                return i;
        }
        return -1;
    }

    void sortAsc() {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if ((int) array[j] > (int) array[j + 1]) {
                    Number tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }

    void sortAsc(int firstIndex, int lastIndex) {
        for (int i = firstIndex; i < lastIndex; i++) {
            for (int j = firstIndex; j < lastIndex - 1; j++) {
                if ((int) array[j] > (int) array[j + 1]) {
                    Number tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }

    void sortAsc(Number value) {
        for (int i = valueOf(value); i < array.length - 1; i++) {
            for (int j = valueOf(value); j < array.length - 1 - i; j++) {
                if ((int) array[j] > (int) array[j + 1]) {
                    Number tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }

    Number get(int index) { return array[index]; }

    Number getMax() {
        Number max = array[0];
        for (Number number : array) {
            if (((int) max) < ((int) number))
                max = number;
        }
        return max;
    }

    Number getMin() {
        Number min = array[0];
        for (Number number : array) {
            if (((int) min) > ((int) number))
                min = number;
        }
        return min;
    }

    Number getAverage() {
        double average = 0;
        for (Number number : array) {
            average = average + (int) number;
        }
        return average / array.length;
    }

    Number getMedian() {
        sortAsc();
        int index = (array.length / 2);
        if (array.length % 2 == 0) {
            return ((int) array[index - 1] + (int) array[index]) / 2;
        } else {
            return array[index];
        }
    }

    Number[] toArray() {
        return array;
    }

    Number[] toArray(int firstIndex, int lastIndex) {
        MathSet<Number> mathSet = new MathSet<>();
        for (int i = firstIndex; i < lastIndex; i++) {
            mathSet.add(array[i]);
        }
        return mathSet.toArray();
    }

    MathSet squash(int firstIndex, int lastIndex) {
        MathSet mathSet = new MathSet<>();
        for (int i = firstIndex; i < lastIndex; i++) {
            mathSet.add(array[i]);
        }
        return mathSet;
    }

    void clear() {
        array = new Number[0];
    }

    void clear(Number[] numbers) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (array[i].equals(numbers[j])) {
                    delete(i);
                }
            }
        }
    }

    public void delete(int index) {
        Number[] newArray = new Number[array.length - 1];
        for (int i = index; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }
}
