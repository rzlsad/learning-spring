package com.rzlsad.learning.imp;

import com.rzlsad.learning.Fibonacci;

import java.util.ArrayDeque;
import java.util.Deque;

public class FirstInLastOut implements Fibonacci {


    @Override
    public int fib(int n) {
        //constraints: n>0
        if (n<=0) throw new IllegalArgumentException(
                "Invalid argument: "+n+" argument cannot be less than zero!");
        if (n==1||n==2) return 1;
        Deque<Integer> queue = new ArrayDeque<Integer>(2);
        queue.push(1);
        queue.push(1);
        for(int i = 3;i<=n;i++){
            int value = queue.pollLast()+queue.peek();
            queue.push(value);
        }
        return queue.pollFirst();
    }
    public static void main(String ... args){
        Fibonacci fibonacci = new FirstInLastOut();
        int[] test = new int[] {1,2,3,4,5,6,7,8,9,10,11};
        for(int n:test){
            System.out.println(fibonacci.fib(n));
        }
    }
}
