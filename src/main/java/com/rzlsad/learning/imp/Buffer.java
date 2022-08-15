package com.rzlsad.learning.imp;

import java.util.ArrayList;
import java.util.List;

public class Buffer<T> {

    private List<T> buffer;
    private int capacity;
    private int limit;
    private int position;

    public Buffer(int capacity,int limit, int position){
        buffer = new ArrayList<T>(capacity+1);
        this.capacity = capacity;
        if(limit<0||limit>capacity) throw new IllegalArgumentException("limit is not in the range");
        this.limit = limit;
        if(limit<0||position>limit) throw new IllegalArgumentException("position is not in the range");
        this.position = position;

    }
    public Buffer(int capacity){
        this(capacity,capacity,0);
    }

    public Buffer<T> limit(int limit){
        if(limit<0||limit>capacity) throw new IllegalArgumentException("");
        this.limit=limit;
        return this;
    }

    public int limit(){
        return limit;
    }

    public Buffer<T> position(int position){
        if(limit<0||position>limit) throw new IllegalArgumentException("");
        this.position=position;
        return this;
    }

    public int position(){
        return position;
    }

    public int capacity(){
        return capacity;
    }

    public boolean hasRemaining(){
        return (limit-position)==0?false:true;
    }

    public T get(){
        if(position>=limit) throw new IndexOutOfBoundsException("Out of the limit");
        T result = buffer.get(position);
        position++;
        return result;
    }

    public Buffer<T> put(T value){
        if(position>=limit) throw new IndexOutOfBoundsException("Out of the limit");
        buffer.add(position,value);
        position++;
        return this;
    }

    public Buffer<T> reset(){

        position=0;
        limit=capacity;
        return this;
    }

    @Override
    public String toString() {
        return "Buffer{" +
                "buffer=" + buffer +
                ", capacity=" + capacity +
                ", limit=" + limit +
                ", position=" + position +
                '}';
    }


    public static void main(String[] args) {
        Buffer<Integer> integerBuffer = new Buffer<Integer>(8);

        while(integerBuffer.hasRemaining()){
            integerBuffer.put(10);
        }
        System.out.println(integerBuffer);
        integerBuffer.reset();
        System.out.println(integerBuffer);

        while (integerBuffer.hasRemaining()){
            System.out.println(integerBuffer.get());
        }
        System.out.println(integerBuffer);

    }


}
