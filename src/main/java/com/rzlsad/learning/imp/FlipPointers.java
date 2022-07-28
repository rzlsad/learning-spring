package com.rzlsad.learning.imp;

import com.rzlsad.learning.Fibonacci;

public class FlipPointers implements Fibonacci {


    @Override
    public int fib(int n) {
        //constraints: n>0
        if (n<=0) throw new IllegalArgumentException(
                "Invalid argument: "+n+" argument cannot be less than zero!");

        //two pointer one pionting odd other even
        int odd = 1;
        int even = 1;

        if(n==1||n==2) return 1;

        for (int i = 3; i<n;i++){
            //if n is odd then odd pointer will point nth value otherwise even
            if(i%2==1) odd+=even;
            else even+=odd;
        }

        return odd+even;
    }

    public static void main(String ... args){
        Fibonacci fibonacci = new FlipPointers();
        int[] test = new int[] {1,2,3,4,5,6,7,8,9,10,11};
        for(int n:test){
            System.out.println(fibonacci.fib(n));
        }
    }
}
