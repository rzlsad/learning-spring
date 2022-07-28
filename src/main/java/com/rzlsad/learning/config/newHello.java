package com.rzlsad.learning.config;

import com.rzlsad.learning.Fibonacci;
import com.rzlsad.learning.Hello;
import com.rzlsad.learning.imp.Recursive;
import org.springframework.context.annotation.*;


@Configuration
public class newHello {

    @Bean
    public Hello hello(){
        return new Hello();
    }

    @Bean
    public Fibonacci fibonacci(){
        return new Recursive();
    }

}