package ua.com.alevel.mathset;

public class MathSet <T extends Number>{
    private Number[] number;
    private int SIZE = 0;
    private int counter = -1;

    public MathSet(){
        number = new Number[SIZE];
    }

    MathSet(int capacity){
        if (capacity>0)
            number = new Number[capacity];
        else throw new IllegalArgumentException("Capacity can`t be < 0!");
    }

    public MathSet(Number[] numbers){
        if (numbers.length <= 0) {
            throw new IllegalArgumentException("Capacity can`t be < 0!");
        }
        number = numbers;
    }
    MathSet(Number[] ... numbers){
        if (numbers.length <= 0) {
            throw new IllegalArgumentException("Capacity can`t be < 0!");
        }
        number = new Number[numbers.length];
        for (Number[] num : numbers) {
            add(num);
        }
    }

    MathSet(MathSet<T> numbers){
        this();
        join(numbers);
    }


    MathSet(MathSet<T> ... numbers){
        this();
        for(MathSet mathSet:numbers){
            join(numbers);
        }
    }

    public void add(Number n){
        Number[] newArray = new Number[number.length + 1];
        System.arraycopy(number, 0, newArray, 0, number.length);
        newArray[newArray.length - 1] = n;
        number = newArray;
    }

    public void add(Number ... n){
        boolean flag = false;
        for(Number k: n){
            for(int i = 0; i <= counter; i++){
                if(number[i] == k)
                {
                    flag = true;
                    break;
                }
            }
            if(flag == false)
                add(k);
            flag = false;
        }
    }

    public void join(MathSet ms){
        Number[] newArray = new Number[number.length + ms.number.length];
        int i = 0;
        for (i = 0; i < number.length; i++) {
            newArray[i] = number[i];
        }
        for (int j = 0; j < ms.number.length; j++, i++) {
            newArray[i] = ms.number[j];
        }
        number = newArray;
    }

    public void join(MathSet ... ms){
        for(MathSet mathSet: ms){
            join(mathSet);
        }
    }

    public void sortDesc(){
        for (int i = 0; i < number.length - 1; i++) {
            for (int j = 0; j < number.length - 1 - i; j++) {
                if ((int) number[j] < (int) number[j + 1]) {
                    Number tmp = number[j];
                    number[j] = number[j + 1];
                    number[j + 1] = tmp;
                }
            }
        }
    }

    public void sortDesc(int firstIndex, int lastIndex){
        for (int i = firstIndex; i < lastIndex; i++) {
            for (int j = firstIndex; j < lastIndex - 1; j++) {
                if ((int) number[j] < (int) number[j + 1]) {
                    Number tmp = number[j];
                    number[j] = number[j + 1];
                    number[j + 1] = tmp;
                }
            }
        }
    }

    public void sortDesc(Number value){
        for (int i = valueOf(value); i < number.length - 1; i++) {
            for (int j = valueOf(value); j < number.length - 1 - i; j++) {
                if ((int) number[j] < (int) number[j + 1]) {
                    Number tmp = number[j];
                    number[j] = number[j + 1];
                    number[j + 1] = tmp;
                }
            }
        }
    }

    public void sortAsc(){
        for (int i = 0; i < number.length - 1; i++) {
            for (int j = 0; j < number.length - 1 - i; j++) {
                if ((int) number[j] > (int) number[j + 1]) {
                    Number tmp = number[j];
                    number[j] = number[j + 1];
                    number[j + 1] = tmp;
                }
            }
        }
    }

    public void sortAsc(int firstIndex, int lastIndex){
        for (int i = firstIndex; i < lastIndex; i++) {
            for (int j = firstIndex; j < lastIndex - 1; j++) {
                if ((int) number[j] > (int) number[j + 1]) {
                    Number tmp = number[j];
                    number[j] = number[j + 1];
                    number[j + 1] = tmp;
                }
            }
        }
    }

    public void sortAsc(Number value){
        for (int i = valueOf(value); i < number.length - 1; i++) {
            for (int j = valueOf(value); j < number.length - 1 - i; j++) {
                if ((int) number[j] > (int) number[j + 1]) {
                    Number tmp = number[j];
                    number[j] = number[j + 1];
                    number[j + 1] = tmp;
                }
            }
        }
    }
    public Number get(int index){
        return (Number) number[index];
    }
    public Number getMax(){
        Number max = number[0];
        for (Number num : number) {
            if (((int) max) < ((int) num))
                max = num;
        }
        return max;
    }

    public Number getMin(){
        Number min = number[0];
        for (Number num : number) {
            if (((int) min) > ((int) num))
                min = num;
        }
        return min;
    }
    public Number getAverage(){
        double average = 0;
        for (Number number : number) {
            average = average + (int) number;
        }
        return average / number.length;
    }
    public Number getMedian(){
        sortAsc();
        int index = (number.length / 2);
        if (number.length % 2 == 0) {
            return ((int) number[index - 1] + (int) number[index]) / 2;
        } else {
            return number[index];
        }
    }
    public Number[] toArray(){
        return number;
    }

    public Number[] toArray(int firstIndex, int lastIndex){
        Number[] numbers = new Number[lastIndex-firstIndex];
        int k = 0;
        for (int i = firstIndex; i < lastIndex; i++) {
            numbers[k] = number[i];
            k++;
        }
        return numbers;
    }

    public MathSet squash(int firstIndex, int lastIndex){
        MathSet mathSet = new MathSet<>();
        for (int i = firstIndex; i < lastIndex; i++) {
            mathSet.add(number[i]);
        }
        return mathSet;
    }
    public void clear(){
        number = new Number[0];
        counter = -1;
    }

    public void clear(Number[] numbers){
        for (int i = 0; i < number.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (number[i].equals(numbers[j])) {
                    delete(i);
                }
            }
        }
    }



    int valueOf(Number value) {
        for (int i = 0; i < number.length; i++) {
            if (number[i].equals(value))
                return i;
        }
        return -1;
    }



    public void delete(int index) {
        Number[] newArray = new Number[number.length - 1];
        for (int i = index; i < number.length - 1; i++) {
            number[i] = number[i + 1];
        }
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = number[i];
        }
        number = newArray;
    }
}