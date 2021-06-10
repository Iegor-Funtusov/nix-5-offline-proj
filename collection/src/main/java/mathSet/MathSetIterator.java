package mathSet;

import java.util.Iterator;

public class MathSetIterator<E extends Number> implements Iterator<E> {
    private int size=0;
    E[] values;

    MathSetIterator(E[] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        return size< values.length;
    }

    @Override
    public E next() {
        return values[size++];
    }

}
