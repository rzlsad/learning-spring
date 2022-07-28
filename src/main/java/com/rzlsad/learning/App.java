package com.rzlsad.learning;

import com.rzlsad.learning.config.newHello;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App
{
    public Fibonacci fibonacci;
    public static void main( String[] args )
    {
        var file = new File("src\\main\\resource\\config.xml");
        String path = "";
        try{
            System.out.println(path=file.getCanonicalPath());

            List<String> lines = Files.readAllLines(Path.of(path));
            for(String line : lines){
                System.out.println(line);
            }



        }catch (IOException exception){
            exception.getStackTrace();
        }

      ApplicationContext ac = new AnnotationConfigApplicationContext(newHello.class);
      var hello = (Hello) ac.getBean("hello",com.rzlsad.learning.Hello.class);
      hello.sayHello();
        System.out.println( "Hello World!" );
        var fib = (Fibonacci) ac.getBean("fibonacci",com.rzlsad.learning.Fibonacci.class);

        System.out.println(fib.fib(11));


    }
}
