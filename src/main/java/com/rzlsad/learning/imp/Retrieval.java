package com.rzlsad.learning.imp;

import com.rzlsad.learning.Retrievable;

public class Retrieval<T,R> {
    
    private Retrievable<T,R> function;

    public Retrieval(Retrievable<T, R> function) {
        this.function = function;
    }

    public void retrieve (Aim<T,R> aim){
        aim.setValue(function.retrieve(aim.getKeys()));
    }
    
    
    
    
}
