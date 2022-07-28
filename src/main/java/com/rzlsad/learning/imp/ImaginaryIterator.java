package com.rzlsad.learning.imp;

import com.rzlsad.learning.Fibonacci;

public class ImaginaryIterator implements Fibonacci {

    private int nextNewBorn;
    private int total;
    private int cycle;

    public ImaginaryIterator() {
        nextNewBorn = 1;
        total = 1;
        cycle = 0;
    }


    @Override
    public int fib(int n) {
        if(n==1||n==2) return 1;
        if(n-2<cycle){
            cycle=0;
            nextNewBorn=1;
            total=1;
        }
        for(int i=cycle+2;i<n;i++){
            int register = nextNewBorn+total;
            nextNewBorn = total;
            total = register;
            cycle++;
        }
        return total;
    }

    @Override
    public String toString() {
        return "FibIterator{" +
                "nextNewBorn=" + nextNewBorn +
                ", total=" + total +
                '}';
    }

    public static void main(String ... args){
        Fibonacci fibonacci = new ImaginaryIterator();
        int[] test = new int[] {1,2,3,4,12,13,5,6,7,8,9,10,11};
        for(int n:test){
            System.out.println(fibonacci.fib(n));
        }
    }
}
