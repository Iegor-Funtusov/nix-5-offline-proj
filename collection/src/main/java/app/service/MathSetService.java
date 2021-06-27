package app.service;

public class MathSetService<N extends Number> {

    private int capacity = 10;
    private Number[] number;
    private int lastIndex;
    private int size;

    public MathSetService() {
        number = new Number[capacity];
    }

    public MathSetService(int capacity){
        this.capacity = capacity;
        number = new Number[capacity];
    }

    public MathSetService(N[] mathSet) {
        number = new Number[mathSet.length];
        add(mathSet);
    }

    public MathSetService(N[]... mathSet) {
        number = new Number[mathSet.length * capacity];
        for (N[] m : mathSet) {
            add(m);
        }
    }

    public MathSetService(MathSetService<N> mathSetService) {
        this();
        join(mathSetService);
    }

    public MathSetService(MathSetService<N>... mathSetService) {
        this();
        for (MathSetService<N> m : mathSetService) {
            join(m);
        }
    }

    public void add(N n) {
        if (lastIndex > 1) {
            for (int i = 0; i < lastIndex; i++) {
                N value = (N) number[i];
                if (value.equals(n)) {
                    throw new IllegalArgumentException("the argument is already there");
                }
            }
        }
        number[lastIndex++] = n;
        if (lastIndex == capacity) {
            incCapacity();
        }
    }

    @SafeVarargs
    public final void add(N... n) {
        for (N temp : n) {
            add(temp);
        }
    }

    public void join(MathSetService<N> ms) {
        N[] msArray = ms.toArray();
        add(msArray);
    }

    @SafeVarargs
    public final void join(MathSetService<N>... ms) {
        for (MathSetService<N> m : ms) {
            join(m);
        }
    }

    public void sortDesc() {
        sortDesc(0, lastIndex);
    }

    public void sortDesc(int firstIndex, int lastIndex) {
        N[] tempArray = descSort(firstIndex, lastIndex);
        System.arraycopy(tempArray, 0, number, firstIndex, lastIndex - firstIndex);
    }

    public void sortDesc(N value){
        sortDesc(0, findIndex(value));
    }

    public void sortAsc() {
        sortAsc(0, lastIndex);
    }

    public void sortAsc(int firstIndex, int lastIndex) {
        N[] tempArray = ascSort(firstIndex, lastIndex);
        System.arraycopy(tempArray, 0, number, firstIndex, lastIndex - firstIndex);
    }

    public void sortAsc(N value)
    {
        sortAsc(0, findIndex(value));
    }

    public N get(int index) {
        if (index < 0 || index > lastIndex)
            throw new ArrayIndexOutOfBoundsException("Index out of bounds");
        return (N) number[index];
    }

    public N getMax() {
        N[] temp = ascSort(0, lastIndex);
        return temp[temp.length - 1];
    }

    public N getMin() {
        N[] temp = ascSort(0, lastIndex);
        return temp[0];
    }

    public Number getAverage() {
        double sum = 0;
        for (Number n : number) {
            sum += (int) n;
        }
        return sum / size;
    }

    public N getMedian() {
        N[] temp = ascSort(0, lastIndex);
        int middleIndex = temp.length / 2;
        if (temp.length % 2 == 0) {
            double sumValue = temp[middleIndex].doubleValue() + temp[middleIndex - 1].doubleValue();
            return (N) Double.valueOf(sumValue / 2d);
        }
        return temp[middleIndex];
    }

    public N[] toArray() {
        return toArray(0, lastIndex);
    }

    public N[] toArray(int firstIndex, int lastIndex) {
        N[] tempArray = (N[]) new Number[lastIndex - firstIndex];
        System.arraycopy(number, firstIndex, tempArray, 0, lastIndex - firstIndex);
        return tempArray;
    }

    public MathSetService<N> squash(int firstIndex, int lastIndex) {
        N[] tempArray = (N[]) new Number[lastIndex - firstIndex];
        System.arraycopy(number, firstIndex, tempArray, 0, lastIndex - firstIndex);
        clear(tempArray);
        return new MathSetService<>(tempArray);
    }

    public void clear() {
        number = new Number[capacity];
        size = 0;
    }

    public void clear(N[] nums) {
        N[] newArray = (N[]) new Number[capacity];
        int index = 0;
        {
            int i = 0;
            while (i < lastIndex) {
                for (N num : nums) {
                    if (number[i].equals(num)) {
                        number[i] = null;
                        break;
                    }
                }
                i++;
            }
        }
        for (int i = 0; i < lastIndex; i++) {
            if (number[i] != null) {
                newArray[index] = (N) number[i];
                index++;
            }
        }
        lastIndex = index;
        number = newArray;
    }

    private void incCapacity() {
        capacity = (capacity * 3) / 2 + 1;
        N[] newArray = (N[]) new Number[capacity];
        System.arraycopy(number, 0, newArray, 0, lastIndex);
        number = newArray;
    }

    private N[] ascSort(int firstIndex, int lastIndex) {
        N[] arr = (N[]) new Number[lastIndex - firstIndex];
        System.arraycopy(number, firstIndex, arr, 0, lastIndex - firstIndex);
        N tmp;
        for (int i = 0; i <= lastIndex - firstIndex; i++) {
            for (int j = 1; j < (lastIndex - firstIndex - i); j++) {
                if (arr[j - 1].longValue() > arr[j].longValue()) {
                    tmp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        return arr;
    }

    private N[] descSort(int firstIndex, int lastIndex) {
        N[] arr = (N[]) new Number[lastIndex - firstIndex];
        System.arraycopy(number, firstIndex, arr, 0, lastIndex - firstIndex);
        N tmp;
        for (int i = 0; i <= lastIndex - firstIndex; i++) {
            for (int j = 1; j < (lastIndex - firstIndex - i); j++) {
                if (arr[j - 1].longValue() < arr[j].longValue()) {
                    tmp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        return arr;
    }


    private int findIndex(N value) {
        for (int i = 0; i < lastIndex; i++) {
            if(value.equals(number[i]))
                return i;
        }
        throw new IllegalArgumentException("Incorrect value");
    }

}
