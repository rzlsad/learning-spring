package com.rzlsad.learning.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;

import java.util.Map;

public class EnvironmentConfig implements ApplicationContextAware, InitializingBean {

    private ConfigurableEnvironment env;
    private Map<String,Object> source;
    private String name;


    public EnvironmentConfig(String name,Map<String, Object> source) {
        this.name=name;
        this.source = source;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        env = (ConfigurableEnvironment) applicationContext.getEnvironment();
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        env.getPropertySources().addLast(new MapPropertySource(name,source));
    }
}
