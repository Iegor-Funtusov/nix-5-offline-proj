package nix.com.math_set;

public class MathSet <T>{

    private T[] elements = (T[]) new Object[10];
    private int pos = 0;

    public MathSet() {
        elements = (T[]) new Object[10];
    }

    public MathSet(int size) {
        elements = (T[]) new Object[size];
    }

    public MathSet(T[] numbers) {
        newArray(numbers.length);
        for (int i = 0; i < elements.length; i++) {
            if (checkElement(numbers[i])) {
                elements[i] = numbers[i];
            }
        }
        newArray(elements.length - countNull());
    }

    public MathSet(T[] ... numbers) {
        int size = 0;
        for (T[] number : numbers) {
            size += number.length;
        }
        newArray(size);
        for (T[] number : numbers) {
            for (int i = 0; i < number.length; i++) {
                if (checkElement(number[i])) {
                    elements[i] = number[i];
                }
            }
        }
        newArray(elements.length - countNull());
    }

    public MathSet(MathSet numbers) {
        int size = 0;
        T[] elementsNew = (T[]) numbers.toArray();
        for (T number : elementsNew) {
            size++;
        }
        newArray(size);
        for (int i = 0; i < elementsNew.length; i++) {
            if (checkElement(elementsNew[i])) {
                elements[i] = elementsNew[i];
            }
        }
        newArray(elements.length - countNull());
    }

    public MathSet(MathSet ... numbers) {
        int size = 0;
        for (MathSet number : numbers) {
            T[] elementsNew = (T[]) number.toArray();
            size += elementsNew.length;
        }
        newArray(size);
        for (MathSet number : numbers) {
            T[] elementsNew = (T[]) number.toArray();
            for (int i = 0; i < elementsNew.length; i++) {
                if (pos >= elements.length) {
                    break;
                }
                if (checkElement(elementsNew[i])) {
                    elements[pos] = elementsNew[i];
                    pos++;
                }
            }
        }
        newArray(elements.length - countNull());
    }

    public void add(T number) {
        if (elements.length <= pos) {
            newArray((int) (elements.length * 1.1));
        }
        if (checkElement(number)) {
            elements[pos] = number;
            pos++;
        }
    }

    public void add(T ... n) {
        if (elements.length <= pos) {
            newArray((int) (elements.length * 1.1));
        }
        for (T t : n) {
            if (checkElement(t)) {
                elements[pos] = t;
            }
            pos++;
        }
    }

    public void join(MathSet ms) {
        T[] elementsNew = (T[]) ms.toArray();
        newArray(((elements.length + elementsNew.length)));
        int j = 0;
        for (int i = pos; i < elements.length + elementsNew.length; i++) {
            if (elementsNew.length == j) {
                break;
            }
            if (checkElement(elementsNew[j])) {
                elements[i] = elementsNew[j];
            }
            j++;
        }
        newArray(elements.length - countNull());
    }

    public void join(MathSet ... ms) {
        int size = 0;
        for (MathSet number : ms) {
            T[] elementsNew = (T[]) number.toArray();
            size += elementsNew.length;
        }
        newArray(size);
        for (MathSet number : ms) {
            T[] elementsNew = (T[]) number.toArray();
            for (int i = 0; i < elementsNew.length; i++) {
                if (pos >= elements.length) {
                    break;
                }
                if (checkElement(elementsNew[i])) {
                    elements[pos] = elementsNew[i];
                    pos++;
                }
            }
        }
        newArray(elements.length - countNull());
    }

    public void sortAsc() {
        boolean isSorted = false;
        T buf;
        while(!isSorted) {
            isSorted = true;
            try {
                for (int i = 0; i < elements.length - 1 - countNull(); i++) {
                    if ((int) elements[i] > (int) elements[i + 1]) {
                        isSorted = false;

                        buf = elements[i];
                        elements[i] = elements[i + 1];
                        elements[i + 1] = buf;
                    }
                }
            } catch (ClassCastException ex) {
                for (int i = 0; i < elements.length - 1 - countNull(); i++) {
                    if ((double) elements[i] > (double) elements[i + 1]) {
                        isSorted = false;

                        buf = elements[i];
                        elements[i] = elements[i + 1];
                        elements[i + 1] = buf;
                    }
                }
            }
        }
    }

    public void sortAsc(int firstIndex, int lastIndex) {
        boolean isSorted = false;
        T buf;
        while(!isSorted) {
            isSorted = true;
            try {
                for (int i = firstIndex; i < lastIndex; i++) {
                    if ((int) elements[i] > (int) elements[i + 1]) {
                        isSorted = false;

                        buf = elements[i];
                        elements[i] = elements[i + 1];
                        elements[i + 1] = buf;
                    }
                }
            } catch (ClassCastException ex) {
                for (int i = firstIndex; i < lastIndex; i++) {
                    if ((double) elements[i] > (double) elements[i + 1]) {
                        isSorted = false;

                        buf = elements[i];
                        elements[i] = elements[i + 1];
                        elements[i + 1] = buf;
                    }
                }
            }
        }
    }

    public void sortAsc(int num) {
        boolean isSorted = false;
        T buf;
        while(!isSorted) {
            isSorted = true;
            try {
                for (int i = 0; i < num; i++) {
                    if ((int) elements[i] > (int) elements[i + 1]) {
                        isSorted = false;

                        buf = elements[i];
                        elements[i] = elements[i + 1];
                        elements[i + 1] = buf;
                    }
                }
            } catch (ClassCastException ex) {
                for (int i = 0; i < num; i++) {
                    if ((double) elements[i] > (double) elements[i + 1]) {
                        isSorted = false;

                        buf = elements[i];
                        elements[i] = elements[i + 1];
                        elements[i + 1] = buf;
                    }
                }
            }
        }
    }

    public void sortDesc() {
        sortAsc();
        reverseArr();
    }

    public void sortDesc(int firstIndex, int lastIndex) {
        sortAsc(firstIndex, lastIndex);
        reverseArr();
    }

    public void sortDesc(int num) {
        sortAsc(num);
        reverseArr();
    }

    public T get(int index) {
        return elements[index];
    }

    public T getMax() {
        T max = elements[0];
        newArray(elements.length - countNull());
        for (T element : elements) {
            try {
                if ((int) max < (int) element) {
                    max = element;
                }
            } catch(ClassCastException c) {
                if ((double) max < (double) element) {
                    max = element;
                }
            }
        }
        return max;
    }

    public T getMin() {
        T min = elements[0];
        newArray(elements.length - countNull());
        for (T element : elements) {
            try {
                if ((int) min > (int) element) {
                    min = element;
                }
            } catch(ClassCastException c) {
                if ((double) min > (double) element) {
                    min = element;
                }
            }
        }
        return min;
    }

    public T getAverage() {
        newArray(elements.length - countNull());
        T[] sumT = null;
        try {
            int sum = 0;
            for (T element : elements) {
                sum += (int) element;
            }
            MathSet<Integer> intSet = new MathSet<>();
            intSet.add(sum/elements.length);
            sumT = (T[]) intSet.toArray();
        } catch (ClassCastException classCastException) {
            double sum = 0;
            for (T element : elements) {
                sum += (double) element;
            }
            MathSet<Double> intSet = new MathSet<>();
            intSet.add(sum/elements.length);
            sumT = (T[]) intSet.toArray();
        }
        return sumT[0];
    }

    public T getMedian() {
        return elements[elements.length / 2];
    }

    public T[] toArray() {
        return elements;
    }

    public T[] toArray(int firstIndex, int lastIndex) {
        T[] elementsNew = (T[]) new Object[lastIndex - firstIndex];

        for (int i = firstIndex, j = 0; i < lastIndex; j++, i++) {
            elementsNew[j] = elements[i];
        }
        return elementsNew;
    }

    public MathSet squash(int firstIndex, int lastIndex) {
        T[] elementsNew = (T[]) new Object[lastIndex - firstIndex];

        for (int i = firstIndex, j = 0; i < lastIndex; j++, i++) {
            elementsNew[j] = elements[i];
        }
        return new MathSet(elementsNew);
    }
    
    public void clear() {
        for (int i = 0; i < elements.length; i++) {
            elements[i] = null;
        }
        newArray(elements.length - countNull());
    }

    public void clear(Number[] numbers) {
        for (Number number : numbers) {
            for (int i = 0; i < elements.length; i++) {
                if (number == elements[i]) {
                    elements[i] = null;
                }
            }
        }
    }
    private void reverseArr() {
        newArray(elements.length - countNull());
        for (int i = 0; i < elements.length / 2; i++) {
            T tmp = elements[i];
            elements[i] = elements[elements.length - i - 1];
            elements[elements.length - i - 1] = tmp;
        }
    }


    private void newArray(int size) {
        T[] elementsNew = (T[]) new Object[elements.length];
        int i = 0;
        for (T element : elements) {
            if (i >= elementsNew.length) {
                break;
            }
            elementsNew[i] = element;
            i++;
        }
        i = 0;
        elements = (T[]) new Object[size];
        for (T element : elementsNew) {
            if (i >= elements.length) {
                break;
            }
            elements[i] = element;
            i++;
        }
    }

    private boolean checkElement(T element) {
        for (T t : elements) {
            if (t == element) {
                return false;
            }
        }
        return true;
    }

    private int countNull() {
        int count = 0;
        for (T element : elements) {
            if (element == null){
                count++;
            }
        }
        return count;
    }
}
