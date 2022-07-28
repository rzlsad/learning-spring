package com.rzlsad.learning.imp;

import com.rzlsad.learning.Fibonacci;

import java.util.ArrayList;
import java.util.List;

public class NodeRecursive implements Fibonacci {
    private static NodeRecursive instance;
    private Node<Integer> list;
    private List<Aim<Integer,Integer>> aims;
    private int index;

    private NodeRecursive(){
        list = new Node<Integer>(1).next(1);
        aims = new ArrayList<Aim<Integer,Integer>>(0);
        index = 2;
    }

    public static NodeRecursive getInstance(){
        if(instance==null) return new NodeRecursive();
        else return instance;
    }

    public Node<Integer> getList(){
        return list;
    }

    @Override
    public int fib(int n) {
        if(n<=index){
            System.out.println(n +" is already in the list!");
            Node<Integer> pointer = list;
            int distance = index-n;
            for(int i=0;i<distance;i++) pointer=pointer.getPrev();
            return pointer.getValue();
        }else {
            Aim<Integer,Integer> newAim = new Aim<Integer,Integer>(n);
            if(aims.contains(newAim)){
                for(Aim<Integer,Integer> aim:aims){
                    if(aim.equals(newAim)) return aim.getValue();
                }
            }else {
                aims.add(newAim);
                new Retrieval<Integer,Integer>((x)->fib(n-2)+fib(n-1)).retrieve(newAim);
                return newAim.getValue();
            }
        }
        return -1;
    }

    public static void main(String ... args){
        Fibonacci fibonacci = NodeRecursive.getInstance();
        int[] test = new int[] {11,4,7,2,12};
        for(int n:test){
            System.out.printf("%d : %d%n",n,fibonacci.fib(n));
        }
    }



}
