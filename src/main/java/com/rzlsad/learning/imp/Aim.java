package com.rzlsad.learning.imp;

import com.rzlsad.learning.Retrievable;

import java.util.Arrays;

public class Aim<T,R> {
    private final T[] keys;
    private R value;

    public Aim(T... keys) {
        this.keys = keys;
        value=null;
    }

    public T[] getKeys() {
        return keys;
    }

    public R getValue() {
        if (value==null) throw new IllegalStateException();
        return value;
    }

    public void setValue(R value) {
        this.value = value;
    }

    public boolean hasValue(){
        return value==null?false:true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aim<?,?> aim = (Aim<?,?>) o;
        return Arrays.equals(keys, aim.keys);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(keys);
    }
}
