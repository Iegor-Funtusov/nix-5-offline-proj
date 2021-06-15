package nix.com.math_set;

public class MathSetControler<T>{

    MathSet<T> mathSet = new MathSet<>();
    public void add(T number) {
        if (number == null) {
            throw new IllegalArgumentException();
        }
        mathSet.add(number);
    }

    public void add(T ... n) {
        if (n == null) {
            throw new IllegalArgumentException();
        }
        for (T t : n) {
            if (t == null){
                throw new IllegalArgumentException();
            }
        }
        mathSet.add(n);
    }

    public void join(MathSet ms) {
        if (ms == null) {
            throw new IllegalArgumentException();
        }
        mathSet.join(ms);
    }

    public void join(MathSet ... ms) {
        for (MathSet m : ms) {
            if (m == null) {
                throw new IllegalArgumentException();
            }
        }
        mathSet.join(ms);
    }

    public void sortAsc(int firstIndex, int lastIndex) {
        if (mathSet.toArray().length < firstIndex
                || lastIndex > mathSet.toArray().length) {
            throw new IllegalArgumentException();
        }
        mathSet.sortAsc(firstIndex, lastIndex);
    }

    public void sortAsc(int num) {
        if (mathSet.toArray().length < num) {
            throw new IllegalArgumentException();
        }
        mathSet.sortAsc(num);
    }

    public void sortDesc(int firstIndex, int lastIndex) {
        if (mathSet.toArray().length < firstIndex
                || lastIndex > mathSet.toArray().length) {
            throw new IllegalArgumentException();
        }
        mathSet.sortDesc(firstIndex, lastIndex);
    }

    public void sortDesc(int num) {
        if (mathSet.toArray().length < num) {
            throw new IllegalArgumentException();
        }
        mathSet.sortDesc(num);
    }

    public T get(int index) {
        if (mathSet.toArray().length < index || index < 0) {
            throw new IllegalArgumentException();
        }
        return mathSet.get(index);
    }

    public T getMax() {
        if (mathSet.toArray() == null) {
            throw new IllegalArgumentException();
        }
        return mathSet.getMax();
    }

    public T getMin() {
        if (mathSet.toArray() == null) {
            throw new IllegalArgumentException();
        }
        return mathSet.getMin();
    }

    public T getAverage() {
        if (mathSet.toArray() == null) {
            throw new IllegalArgumentException();
        }
        return mathSet.getAverage();
    }

    public T getMedian() {
        if (mathSet.toArray() == null) {
            throw new IllegalArgumentException();
        }
        return mathSet.getMedian();
    }

    public T[] toArray(int firstIndex, int lastIndex) {
        if (mathSet.toArray().length < firstIndex
                || lastIndex > mathSet.toArray().length) {
            throw new IllegalArgumentException();
        }
        return mathSet.toArray(firstIndex, lastIndex);
    }

    public MathSet squash(int firstIndex, int lastIndex) {
        if (mathSet.toArray().length < firstIndex
                || lastIndex > mathSet.toArray().length) {
            throw new IllegalArgumentException();
        }
        return mathSet.squash(firstIndex, lastIndex);
    }

    public void clear(Number[] numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException();
        }
        mathSet.clear(numbers);
    }
}
