package com.rzlsad.learning.config;

import com.rzlsad.learning.Fibonacci;
import com.rzlsad.learning.imp.Recursive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class FibConfig {

    @Autowired
    @Qualifier("loop")
    private Fibonacci fibonacci;

    @Bean
    @Qualifier("recursive")
    public Fibonacci fibonacci(){
        return new Recursive();
    }
}
