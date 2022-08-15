package com.rzlsad.learning.config;

import com.rzlsad.learning.MessageProvider;
import com.rzlsad.learning.MessageRenderer;
import com.rzlsad.learning.imp.message.StandartOutMessageRenderer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

@Configuration
@ImportResource("classpath:beans.xml")
//@ComponentScan(basePackages = "com.rzlsad.learning.imp.message")
public class MessageConfiguration {

//    @Bean
////    @Qualifier("msg")
//    public String message(){
//        return "Hello via Config";
//    }
//
//    @Bean
////    @Qualifier("alert")
//    public String alert(){
//        return "Caution!";
//    }
//
//    @Bean
//    public MessageProvider strickProvider(){
//        return new MessageProvider() {
//            @Override
//            public String getMessage() {
//                return "Strickly messaged!";
//            }
//        };
//    }
//
//    @Bean
//    public MessageRenderer renderer2(){
//        MessageRenderer messageRenderer = new StandartOutMessageRenderer();
//        messageRenderer.setProvider(strickProvider());
//        return messageRenderer;
//
//    }

}
