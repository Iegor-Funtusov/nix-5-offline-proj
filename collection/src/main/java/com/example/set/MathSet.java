package com.example.set;

public class MathSet<E extends Number & Comparable<? super E>> {
    private Node head;
    private int size;

    public MathSet(){
        head = null;
        size = 0;
    }

    public MathSet(E[] numbers){
        for(E n : numbers){
            add(n);
        }
    }

    @SafeVarargs
    public MathSet(E[] ... numbers){
        for(E[] nArr : numbers){
            for(E n : nArr ){
                add(n);
            }
        }
    }

    public MathSet(MathSet<E> numbers){
        head = numbers.head;
        size = numbers.size();
    }

    @SafeVarargs
    public MathSet(MathSet<E> ... numbers){
        head = numbers[0].head;
        size = numbers[0].size;
        for (int i = 1; i < numbers.length; i++) {
            join(numbers[i]);
        }
    }

    @SafeVarargs
    public final void join(MathSet<E>... ms){
        for (int i = 0; i < ms.length - 1; i++) {
            ms[i].join(ms[i+1]);
        }
        join(ms[0]);
    }

    public void join(MathSet<E> ms){
        getNode(size - 1).next = ms.head;
        size += ms.size;
    }

    public MathSet<E> squash(int firstIndex, int lastIndex){
        MathSet<E> ms = new MathSet<>();
        Node node = head;
        for (int i = firstIndex; i < lastIndex+1; i++) {
            ms.add(node.element);
            node = node.next;
        }
        return ms;
    }

    @SafeVarargs
    public final void add(E ... elements) {
        for (E element : elements) {
            add(element);
        }
    }

    public void add(E element) {
        if (head == null) {
            head = new Node(element);
        } else if(!contains(element)) {
            Node node = getNode(size-1);
            node.next = new Node(element);
        } else {
            return;
        }
        size++;
    }

    public boolean contains(E target) {
        return indexOf(target) != -1;
    }

    public void sortAsc(){
        sortAsc(0, size);
    }

    public void sortAsc(E target){
        sortAsc(0, indexOf(target));
    }

    public void sortAsc(int firstIndex, int lastIndex){
        for (int i = firstIndex; i < lastIndex-1; i++) {
            for (int j = firstIndex; j < lastIndex-i-1; j++) {
                if(get(j).compareTo(get(j + 1)) > 0){
                    swap(j, j+1);
                }
            }
        }

    }

    public void sortDesc(){
        sortDesc(0, size);
    }

    public void sortDesc(E target){
        sortDesc(0, indexOf(target));
    }

    public void sortDesc(int firstIndex, int lastIndex){
        for (int i = firstIndex; i < lastIndex-1; i++) {
            for (int j = firstIndex; j < lastIndex-i-1; j++) {
                if(get(j).compareTo(get(j + 1)) < 0){
                    swap(j, j+1);
                }
            }
        }

    }

    public void clear(){
        head = null;
        size = 0;
    }

    public void clear(E[] numbers){
        for(E e : numbers){
            remove(e);
        }
    }

    public void remove(E target) {
        int index = indexOf(target);
        if (index == -1) {
            throw new IllegalArgumentException("Element isn't exists");
        }
        remove(index);
    }

    public void remove(int index) {
        if (index == 0) {
            head = head.next;
        } else {
            Node node = getNode(index-1);
            node.next = node.next.next;
        }
        size--;
    }

    public int indexOf(E target) {
        Node node = head;
        for (int i=0; i<size; i++) {
            if (equals(target, node.element)) {
                return i;
            }
            node = node.next;
        }
        return -1;
    }

    private void swap(int firstIndex, int secondIndex){
        E tmp = get(firstIndex);
        set(firstIndex, get(secondIndex));
        set(secondIndex, tmp);
    }

    private boolean equals(E target, E element){
        if(target == null){
            return element == null;
        } else {
            return target.equals(element);
        }
    }

    private void set(int index, E element){
        getNode(index).element = element;
    }

    public E getMax(){
        Node node = head;
        E max = node.element;
        for (int i = 0; i < size; i++) {
            if(node.next != null){
                if(max.compareTo(node.next.element) < 0){
                    max = node.next.element;
                }
            }
            node = node.next;
        }
        return max;
    }

    public E getMin(){
        Node node = head;
        E min = node.element;
        for (int i = 0; i < size-1; i++) {
            if(node.next != null){
                if(min.compareTo(node.next.element) > 0){
                    min = node.next.element;
                }
            }
            node = node.next;
        }
        return min;
    }

    public Number getAverage(){
        Node node = head;
        Integer sum = 0;
        for (int i = 0; i < size; i++) {
            sum += (Integer) node.element;
            node = node.next;
        }
        return sum / size;
    }

    public Number getMedian(){
        sortAsc();
        int mediumIndex = (size - 1)  / 2;
        if(size % 2 == 0){
            return ((Integer) get(mediumIndex) + (Integer) get(mediumIndex + 1)) / 2;
        } else {
            return get(mediumIndex);
        }
    }

    public E get(int index) {
        Node node = getNode(index);
        return node.element;
    }

    private Node getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node node = head;
        for (int i=0; i<index; i++) {
            node = node.next;
        }
        return node;
    }

    public Number[] toArray() {
        return toArray(0, size - 1);
    }

    public Number[] toArray(int firstIndex, int lastIndex){
        Number[] arr = new Number[lastIndex + 1];
        Node node = head;
        for (int i = firstIndex; i < lastIndex + 1; i++) {
            arr[i] = node.element;
            node = node.next;
        }
        return arr;
    }

    public int size(){
        return this.size;
    }

    private class Node {
        public E element;
        public Node next;

        public Node(E element) {
            this.element = element;
            this.next = null;
        }
    }

}
