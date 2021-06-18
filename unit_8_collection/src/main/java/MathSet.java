public class MathSet<T> {
    private T[] elements = (T[]) new Object[10];

    MathSet() {
        elements = (T[]) new Object[10];
    }

    MathSet(int capacity) {
    }

    MathSet(T[] numbers) {
    }

    MathSet(T[]... numbers) {
    }

    MathSet(MathSet numbers) {
    }

    MathSet(MathSet... numbers) {
    }

    void add(T n) {
    }

    void add(T... n) {
    }

    void join(MathSet ms) {
    }

    void join(MathSet... ms) {
    }

    void sortDesc() {
    }

    void sortDesc(int firstIndex, int lastIndex) {
    }

    void sortDesc(T value) {
    }

    void sortAsc() {
    }

    void sortAsc(int firstIndex, int lastIndex) {
    }

    void sortAsc(T value) {
    }

    T get(int index) {
    }

    T getMax() {
    }

    T getMin() {
    }

    T getAverage() {
    }

    T getMedian() {
    }

    T[] toArray() {
    }

    T[] toArray(int firstIndex, int lastIndex) {
    }

    MathSet squash(int firstIndex, int lastIndex) {
    }

    void clear() {
    }

    void clear(T[] numbers) {
    }
}
