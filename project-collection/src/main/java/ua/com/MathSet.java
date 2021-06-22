package ua.com;

public interface MathSet extends Iterable<Number> {

    void add(Number n);

    void add(Number... n);

    void join(MathSetImpl ms);

    void sortDesc();

    void sortDesc(int firstIndex, int lastIndex);

    void sortDesc(Number value);

    void sortAsc();

    void sortAsc(int firstIndex, int lastIndex);

    void sortAsc(Number value);

    Number get(int index);

    Number getMax();

    Number getMin();

    Number getAverage();

    Number getMedian();

    Number[] toArray();

    Number[] toArray(int firstIndex, int lastIndex);

    MathSetImpl squash(int firstIndex, int lastIndex);

    void clear();

    void clear(Number[] numbers);

}
