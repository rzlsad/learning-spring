package com.rzlsad.learning.imp;

import com.rzlsad.learning.Fibonacci;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RabitContainer implements Fibonacci {

    private final List<Rabit> rabits;
    private final Map<Integer,Integer> perCycle;
    private int cycles;

    public RabitContainer() {
        rabits = new ArrayList<Rabit>(0);
        perCycle = new HashMap<Integer, Integer>();
        cycles = 0;
    }

    public int cycle(){
        if(rabits.size()==0) rabits.add(new Rabit(null));
        else{
            List<Rabit> newBirths = rabits.stream()
                    .filter(Rabit::isAdult)
                    .map((rabit) -> rabit.giveBirth(rabit))
                    .collect(Collectors.toList());
            rabits.addAll(newBirths);
        }
        cycles++;
        perCycle.put(cycles,rabits.size());
        return cycles;
    }


    @Override
    public int fib(int n) {

        if(n<=cycles){
            return perCycle.get(n);
        }else {
            while (n>cycle()) {}
            return perCycle.get(n);
        }

    }


    public static void main(String ... args){
        Fibonacci fibonacci = new RabitContainer();
        int[] test = new int[] {1,2,3,4,5,6,7,8,9,10,11};
        for(int n:test){
            System.out.println(fibonacci.fib(n));
        }
    }
}
