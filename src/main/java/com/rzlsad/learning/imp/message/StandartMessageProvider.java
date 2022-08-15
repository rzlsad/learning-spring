package com.rzlsad.learning.imp.message;

import com.rzlsad.learning.MessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("provider")
@DependsOn("strickProvider")
public class StandartMessageProvider implements MessageProvider {


    //    @Value("Hello again via Spring @Value")
    @Autowired(required = false)
//    @Qualifier("msg")
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
