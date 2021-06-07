package nix.com.math_set;


public class MathSet <T>{

    private T[] elements;
    private int pos = 0;

    public MathSet() {
        elements = (T[]) new Object[10];
    }

    public MathSet(int size) {
        elements = (T[]) new Object[size];
    }

    public void add(T number) {
        if (elements.length <= pos) {
            newArray((int) (elements.length * 1.5));
        }
        elements[pos] = number;
        pos++;
    }

    public void join(MathSet ms) {
        T[] elementsNew = (T[]) ms.readAll();
        newArray((int) ((elements.length + elementsNew.length)));
        int j = 0;
        for (int i = pos; i < elements.length + elementsNew.length; i++) {
            if (elementsNew.length == j) {
                break;
            }
            elements[i] = elementsNew[j];
            j++;
        }
    }

    public void sortAsc() {
        boolean isSorted = false;
        T buf;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < elements.length - 1 - countNull(); i++) {
                if((int)elements[i] > (int)elements[i+1]){
                    isSorted = false;

                    buf = elements[i];
                    elements[i] = elements[i+1];
                    elements[i+1] = buf;
                }
            }
        }
    }

    public void sortAsc(int firstIndex, int lastIndex) {
        boolean isSorted = false;
        T buf;
        while(!isSorted) {
            isSorted = true;
            for (int i = firstIndex; i < lastIndex; i++) {
                if((int)elements[i] > (int)elements[i+1]){
                    isSorted = false;

                    buf = elements[i];
                    elements[i] = elements[i+1];
                    elements[i+1] = buf;
                }
            }
        }
    }

    public void sortAsc(int num) {
        boolean isSorted = false;
        T buf;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < num; i++) {
                if((int)elements[i] > (int)elements[i+1]){
                    isSorted = false;

                    buf = elements[i];
                    elements[i] = elements[i+1];
                    elements[i+1] = buf;
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

    private void reverseArr() {
        for (int i = 0; i < elements.length / 2; i++) {
            T tmp = elements[i];
            elements[i] = elements[elements.length - i - 1];
            elements[elements.length - i - 1] = tmp;
        }
    }

    public T[] readAll() {
        return elements;
    }

    private void newArray(int size) {
        T[] elementsNew = (T[]) new Object[elements.length];
        int i = 0;
        for (T element : elements) {
            elementsNew[i] = element;
            i++;
        }
        i = 0;
        elements = (T[]) new Object[size];
        for (T element : elementsNew) {
            elements[i] = element;
            i++;
        }
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
