package com.rzlsad.learning.imp;

import com.rzlsad.learning.PrimeNumber;

import java.time.Duration;
import java.time.Instant;

public class SectingPrimeNumber implements PrimeNumber {

    private long higherBound;
    private static int loop=0;


    public SectingPrimeNumber(){
        higherBound=0;
    }

    @Override
    public boolean isPrime(long n) {
        if(n<1) throw new IllegalArgumentException();
        if(n==1) return false;
        if(n==2) return true;
        higherBound=n;

        for(int i=3;i<higherBound;i+=2){
            loop++;
            if (n%i==0){
                return false;
            }
            higherBound=n/i+n%i;
        }
        return true;
    }

    public static void main(String[] args) {
        SectingPrimeNumber number = new SectingPrimeNumber();
        long[] test = new long[] {47234567455721L};
        Instant start = Instant.now();
        for(long n: test){
            System.out.println(number.isPrime(n));
        }
        Instant end = Instant.now();
        System.out.printf("%d number of times looped and %d nano second passed",number.loop, Duration.between(start,end).getNano());

    }

}