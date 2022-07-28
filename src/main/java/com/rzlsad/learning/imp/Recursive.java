package com.rzlsad.learning.imp;

import com.rzlsad.learning.Fibonacci;

public class Recursive implements Fibonacci {


    @Override
    public int fib(int n) {
        System.out.println("Recursively");
        //constraints: n>0
        if(n<=0) throw new IllegalArgumentException("Invalid argument: "+n+" argument cannot be less than zero!");
        //base condition
        if(n==1||n==2) return 1;
        //next condition
        else return fib(n-1)+fib(n-2);
    }

    public static void main(String ... args){
        Fibonacci fibonacci = new Recursive();
        int[] test = new int[] {1,2,3,4,5,6,7,8,9,10,11};
        for(int n:test){
            System.out.println(fibonacci.fib(n));
        }
    }
}
