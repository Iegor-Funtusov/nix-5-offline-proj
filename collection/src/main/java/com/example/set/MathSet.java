package com.example.set;

public class MathSet<E extends Number & Comparable<? super E>> {
    private Node head;
    private int size;

    public MathSet(){
        head = null;
        size = 0;
    }

    public MathSet(Number[] numbers){

    }

    public MathSet(Number[] ... numbers){

    }

    public MathSet(MathSet numbers){

    }

    public MathSet(MathSet ... numbers){

    }

    @SafeVarargs
    public final void add(E... elements) {
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
//        public Node(E element, Node next) {
//            this.element = element;
//            this.next = next;
//        }
    }

}
