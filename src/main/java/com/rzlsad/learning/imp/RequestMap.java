package com.rzlsad.learning.imp;

import com.rzlsad.learning.Fibonacci;

import java.util.HashMap;
import java.util.Map;

public class RequestMap implements Fibonacci {

    private final Map<Integer,Integer> requests;


    public RequestMap() {
        requests = new HashMap<Integer, Integer>();
    }


    @Override
    public int fib(int n) {
        if(!requests.containsKey(n)){
            System.out.println(n+" is new request");
            if(n==1||n==2) requests.put(n,1);
            else requests.put(n,fib(n-1)+fib(n-2));
        }
        return requests.get(n);
    }

    @Override
    public String toString() {
        return "MapRecursive{" +
                "requests=" + requests +
                '}';
    }

    public static void main(String ... args){
        Fibonacci fibonacci = new RequestMap();
        int[] test = new int[] {1,2,3,4,5,6,7,8,9,10,11};
        for(int n:test){
            System.out.println(fibonacci.fib(n));
        }
        System.out.println(fibonacci);
    }
}
