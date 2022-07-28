package com.rzlsad.learning.imp;

import com.rzlsad.learning.Fibonacci;

public class Branching implements Fibonacci {
    private static Branching instance;
    private Node<Integer> list;
    private int head;

    private Branching(){
        list = new Node<Integer>(1).next(1);
        head = 2;
    }

    public static Branching getInstance(){
        if(instance==null) return new Branching();
        else return instance;
    }

    public Node<Integer> getList(){
        return list;
    }

    @Override
    public int fib(int n) {
        if(n<=head){
            System.out.println(n +" is already in the list!");
            Node<Integer> pointer = list;
            int distance = head-n;
            for(int i=0;i<distance;i++) pointer=pointer.getPrev();
            return pointer.getValue();
        }else {
            return fibImp(n);
        }
    }

    private int fibImp(int n){
        System.out.println("new "+n+" is calculated!");
        for(int i=3;i<=n;i++){
            if(n<=head) break;
            int value = list.getValue()+list.getPrev().getValue();
            list=list.next(value);
            head++;
        }
        return list.getValue();
    }

    public static void main(String ... args){
        Fibonacci fibonacci = Branching.getInstance();
        int[] test = new int[] {11,4,7,2,12};
        for(int n:test){
            System.out.printf("%d : %d%n",n,fibonacci.fib(n));
        }
    }
}
