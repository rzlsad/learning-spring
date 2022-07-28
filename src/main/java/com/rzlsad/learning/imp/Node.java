package com.rzlsad.learning.imp;

public class Node<T> implements Iterable<T>{
    private final Node<T> prev;
    private final T value;

    public Node(T value){
        this(null,value);
    }

    private Node(Node<T> prev,T value) {
        this.prev = prev;
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public Node<T> getPrev() {
        return prev;
    }

    public Node<T> next(T value){
        return new Node<T>(this,value);
    }

    @Override
    public Iterator iterator() {
        return new Iterator();
    }

    public class Iterator implements java.util.Iterator<T> {

        Node<T> pointer = new Node<>(prev,value);

        @Override
        public boolean hasNext() {
            return pointer==null?false:true;
        }

        @Override
        public T next() {
            T value = pointer.getValue();
            pointer=pointer.getPrev();
            return value;

        }
    }

    public static void main(String[] args) {
        Node<Integer> integers = new Node<>(1);
        Node<Integer> next = integers.next(2).next(3).next(4);


        for(Integer i:next){
            System.out.println(i);
        }

    }

}
