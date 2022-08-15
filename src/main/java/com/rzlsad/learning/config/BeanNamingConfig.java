package com.rzlsad.learning.config;

import com.rzlsad.learning.imp.beanNaming.Foo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan(basePackages = {"com.rzlsad.learning.imp.beanNaming"})
@ImportResource("classpath:beanNaming.xml")
public class BeanNamingConfig {

    @Bean
    public Foo fooMethod(){
        return new Foo();
    }

    @Bean(value = {"fooValueConfig","fooValueAlie"})
    public Foo fooMethodValue(){
        return new Foo();
    }

    @Bean(name = {"fooNameConfig","fooNameAlie"})
    public Foo fooMethodName(){
        return new Foo();
    }
}
