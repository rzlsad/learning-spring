package com.rzlsad.learning.imp.message;

import com.rzlsad.learning.MessageProvider;
import com.rzlsad.learning.MessageRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("renderer")
@DependsOn("provider")
@Primary
@Lazy
@Scope("prototype")
public class StandartOutMessageRenderer implements MessageRenderer {

    private MessageProvider provider;


    public MessageProvider getProvider() {
        return provider;
    }

    @Autowired
    public void setProvider(MessageProvider provider) {
        this.provider = provider;
    }

    @Override
    public void render() {
        System.out.println(provider.getMessage());
    }
}
