package ua.com.nix;

import java.util.Objects;

public class MathSet <E extends Number> implements MathSetInterface{

    private Number[] arr;
    private Integer capacity;

    public MathSet() {
        arr = new  Number[0];
    }

    public MathSet(int capacity){
        arr = new Number[capacity];
    }

    public MathSet(Number[] numbers){
        arr = new Number[numbers.length];
    }

//    public MathSet(Number[] ... numbers){
//        arr = (Number[]) new Number[numbers.length + 1];
//    }

    @Override
    public void add(Number n) {
        Number[] newArr = new Number[arr.length + 1];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        newArr[arr.length] = n;
        arr = newArr;
    }

    @Override
    public void add(Number ... n) {
        for(Number numbers : n) {
            add(numbers);
        }
    }

    @Override
    public void join(MathSet ms) {
        for (Number numbers : ms.toArray()) {
            add(numbers);
        }
    }

    @Override
    public Number[] toArray() {
        return toArray(0, arr.length - 1);
    }

    @Override
    public Number get(int index){
        return arr[index];
    }

    @Override
    public Number getMin() {
        Integer min = (Integer) arr[0];
        for (int i = 0; i < arr.length; i++) {
                if (min > (Integer) arr[i]) {
                    min = (Integer) arr[i];
                }
            }
        return min;
    }

    @Override
    public void join(MathSet ... ms) {
        for (MathSet mathSets : ms) {
            join(mathSets);
        }
    }

    @Override
    public void sortDesc() {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if ((Integer) arr[j] < (Integer) arr[j + 1]) {
                    Integer temp = (Integer) arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    @Override
    public void sortDesc(int firstIndex, int lastIndex) {
        if (firstIndex < lastIndex) {
            for (int i = firstIndex; i < lastIndex; i++) {
                for (int j = firstIndex; j < lastIndex; j++) {
                    if ((Integer) arr[j] < (Integer) arr[j + 1]) {
                        Integer temp = (Integer) arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }
        }
    }

    @Override
    public void sortDesc(Number value) {
        for (Number numbers : arr) {
            if (Objects.equals(value, arr[(Integer) numbers]))
                sortDesc(0, (Integer) arr[(Integer) numbers]);
        }
    }

    @Override
    public void sortAsc() {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if ((Integer) arr[j] > (Integer) arr[j + 1]) {
                    Number temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    @Override
    public void sortAsc(int firstIndex, int lastIndex) {
        if (lastIndex > firstIndex) {
            for (int i = firstIndex; i < lastIndex; i++) {
                for (int j = firstIndex; j < lastIndex - 1; j++) {
                    if ((Integer) arr[j] > (Integer) arr[j + 1]) {
                        Integer temp = (Integer) arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }
        }
    }

    @Override
    public void sortAsc(Number value) {
        for (Number numbers : arr) {
            if (value.equals(arr[(Integer) numbers]))
                sortAsc(0, (Integer) arr[(Integer) numbers]);
        }
    }

    @Override
    public Number getMax() {
        Integer max = (Integer) arr[0];
        for (int i = 0; i < arr.length; i++) {
                if (max < (Integer) arr[i]) {
                    max = (Integer) arr[i];
            }
        }
        return max;
    }

    @Override
    public Number getMedian() {
        sortAsc();
        if (arr.length % 2 == 0) {
            return (Integer) arr[arr.length / 2 - 1] + (Integer) arr[arr.length / 2];
        }
        else {
            return arr[(arr.length - 1) / 2];
        }
    }

    @Override
    public Number[] toArray(int firstIndex, int lastIndex) {
        if (firstIndex > lastIndex) {
            return new Number[capacity];
        }
        else {
            Number[] newArray = new Number[lastIndex - firstIndex];
            System.arraycopy(arr, firstIndex, newArray, 0, lastIndex - firstIndex);
            return newArray;
        }
    }

    @Override
    public MathSet squash(int firstIndex, int lastIndex) {
        Number[] newArr = new Number[lastIndex - firstIndex];
        System.arraycopy(arr, firstIndex, newArr, 0, lastIndex - firstIndex);
        return new MathSet<>(newArr);
    }

    @Override
    public void clear(Number[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[j].equals(numbers[i]))
                    arr[j] = 0;
            }
        }
    }

    @Override
    public Number getAverage() {
        int sum = 0;
        int amountOfElements = 0;

        for (int i = 0; i < arr.length; i++){
            sum += (Integer) arr[i];
            amountOfElements++;
        }
        return (double) (sum / amountOfElements);
    }

    @Override
    public void clear(){
        arr = new Number[0];
    }

    public int getSize() {
        return arr.length;
    }
}
