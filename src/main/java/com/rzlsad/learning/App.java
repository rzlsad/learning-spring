package com.rzlsad.learning;

import com.rzlsad.learning.config.MessageConfiguration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;



public class App
{
    public static void main( String[] args )
    {
      GenericApplicationContext gac = new AnnotationConfigApplicationContext(MessageConfiguration.class);
//      GenericApplicationContext gac = new GenericXmlApplicationContext("classpath:beans.xml");
      var renderer = (MessageRenderer) gac.getBean("renderer",com.rzlsad.learning.MessageRenderer.class);
      renderer.render();
      gac.registerBean("registeredBean",String.class,"It is a manually registered bean");
      gac.registerBean("beanAttributes",com.rzlsad.learning.imp.BeanAttributes.class);
        //print bean and environment attributes
      System.out.println(
              gac.getBean("beanAttributes",com.rzlsad.learning.imp.BeanAttributes.class).getContextInfo()
              +gac.getBean("environmentAttributes",com.rzlsad.learning.imp.EnvironmentAttributes.class).getEnvironmentInfo()
      );
      gac.close();
    }

}//class
