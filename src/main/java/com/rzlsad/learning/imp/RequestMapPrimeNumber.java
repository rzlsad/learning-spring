package com.rzlsad.learning.imp;

import com.rzlsad.learning.PrimeNumber;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class RequestMapPrimeNumber implements PrimeNumber {

    private Map<Long,Boolean> requests;
    int base = 0;
    int recursive=0;

    public RequestMapPrimeNumber() {
        requests = new HashMap<Long, Boolean>();
        requests.put(2L,true);
    }

    public Map<Long, Boolean> getRequests() {
        return requests;
    }

    public int getIndex(){
        return (int) requests.values()
                .stream()
                .filter((e)->e)
                .count();
    }

    @Override
    public boolean isPrime(long n) {
        if (n<2) throw new IllegalArgumentException("Argument must be greater than 1!");
        if(requests.containsKey(n)){
            base++;
            return requests.get(n);
        }
        recursive++;
        for(int i=2;i<n;i++){
            if(isPrime(i)&&n%i==0){
                requests.put(n,false);
                return false;
            }
        }
        requests.put(n,true);
        return true;

    }

    public static void main(String[] args) {
        RequestMapPrimeNumber number = new RequestMapPrimeNumber();
        long[] test = new long[] {8669};
        Instant start = Instant.now();
        for(long n: test){
            System.out.println(number.isPrime(n));
        }
        Instant end = Instant.now();
        System.out.println(number.requests);
        System.out.printf("Found in the map: %d%nRecursive steps: %d%n",number.base,number.recursive);
        System.out.println("The index of the biggest prime  is: "+number.getIndex());
        System.out.printf("%d nano second passed",Duration.between(start,end).getNano());

    }

}//class
