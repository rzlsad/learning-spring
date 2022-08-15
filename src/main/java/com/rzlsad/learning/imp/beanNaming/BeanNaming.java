package com.rzlsad.learning.imp.beanNaming;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class BeanNaming {

    public static void main(String... args){

        GenericApplicationContext context = new AnnotationConfigApplicationContext(com.rzlsad.learning.config.BeanNamingConfig.class);

        context.registerBean("beanAttribute",com.rzlsad.learning.imp.BeanAttributes.class);
        context.registerBean("environmentAttribute",com.rzlsad.learning.imp.EnvironmentAttributes.class);
        System.out.println(

                context.getBean("beanAttribute",com.rzlsad.learning.imp.BeanAttributes.class).getContextInfo()
                +context.getBean("environmentAttribute",com.rzlsad.learning.imp.EnvironmentAttributes.class).getEnvironmentInfo()

        );

        context.close();
    }

}
