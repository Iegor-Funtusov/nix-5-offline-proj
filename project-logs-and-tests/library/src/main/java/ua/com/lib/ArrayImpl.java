package ua.com.lib;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayImpl {

    private static final int DEFAULT_CAPACITY = 2;
    private int size = 0;
    private Object[] array;
    private int pointer = 0;

    public ArrayImpl() {
        array = new Object[DEFAULT_CAPACITY];
    }

    public ArrayImpl(int size) {
        array = new Object[size];
    }

    public void add(Object element) {
        array[pointer] = element;
        pointer++;
        if (pointer == array.length - 1) {
            resize(array.length + 1);
        }
    }

    public void clear() {
        for (int i = 0; i < pointer; i++) {
            array[i] = null;
        }
        pointer = 0;
        size = 0;
    }

    public void set(int index, Object element) {
        if (index > pointer) {
            System.out.println("Index is not valid");
        } else {
            array[index] = element;
        }
    }

    public Object get(int index) {
        if (index > pointer) {
            return new NoSuchElementException();
        } else {
            return array[index];
        }
    }

    public int indexOf(Object element) {
        if (element != null) {
            for (int i = 0; i < size; i++) {
                if (element.equals(array[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    public void remove(int index) {
        if (index > pointer) {
            System.out.print("ArrayIndex\n");
        }
        Object[] temp = array;
        System.arraycopy(array, 0, temp, 0, index);
        int elementAfterIndex = array.length - index - 2;
        System.arraycopy(array, index + 1, temp, index, elementAfterIndex);
        pointer--;
    }

    public int size() {
        return pointer;
    }

    @Override
    public String toString() {
        if (!iterator().hasNext()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < size() - 1; i++) {
            sb.append(array[i]).append(", ");
        }
        sb.append(array[pointer - 1]);
        return sb.append(']').toString();
    }

    private void resize(int newArrayLength) {
        Object[] newArray = new Object[newArrayLength];
        System.arraycopy(array, 0, newArray, 0, size());
        array = newArray;
        this.size = array.length;
    }

    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<Object> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < size();
        }

        @Override
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return array[currentIndex++];
        }
    }

}
