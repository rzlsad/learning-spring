package com.rzlsad.learning.imp;

import com.rzlsad.learning.Fibonacci;

import java.util.ArrayList;
import java.util.List;

public class IterativeCollector implements Fibonacci {

    private final List<Integer> values;

    public IterativeCollector() {
        values = new ArrayList<Integer>(0);
        //Seed
        values.addAll(List.of(1,1));
    }

    @Override
    public String toString() {
        return "ArrayLoop{" +
                "values=" + values +
                '}';
    }

    @Override
    public int fib(int n) {
        if(n> values.size()){
            for(int i=values.size();i<n;i++){
                values.add(values.get(i-2)+values.get(i-1));
            }
        }
        return values.get(n-1);
    }

    public static void main(String ... args){
        Fibonacci fibonacci = new IterativeCollector();
        int[] test = new int[] {1,2,3,4,5,6,9,10,11,7,8};
        for(int n:test){
            System.out.println(fibonacci.fib(n));
        }
        System.out.println(fibonacci);
    }
}
