package com.rzlsad.learning;

public interface Retrievable<T,R> {
    R retrieve (T... keys);
}
