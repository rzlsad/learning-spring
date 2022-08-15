package com.rzlsad.learning.imp;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertySource;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

public class EnvironmentAttributes implements ApplicationContextAware {
    private static final int INDENT = 60;
    private ConfigurableEnvironment env;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        env = (ConfigurableEnvironment) applicationContext.getEnvironment();
    }

    public String getEnvironmentInfo(){
        StringBuilder sb = new StringBuilder(0);

        sb.append(
                String.format("%"+INDENT+"s : %s%n","Active Profiles", Arrays.toString(env.getActiveProfiles()))
        ).append(
                String.format("%"+INDENT+"s : %s%n","Default Profiles", Arrays.toString(env.getDefaultProfiles()))
        ).append(
                String.format("%"+INDENT+"s : %s%n","System Environment", env.getSystemEnvironment())
        )
//                .append(
//                String.format("%"+INDENT+"s : %s%n","System Environment from System", System.getenv())
//        )
//                .append(
//                String.format("%"+INDENT+"s : %s%n","System Properties from System", System.getProperties())
//        )
                .append(
                String.format("%"+INDENT+"s : %s%n","System Properties", env.getSystemProperties()
//                                .entrySet()
//                                .stream()
//                                .filter(a->!a.getKey().contains("java")&&!a.getKey().contains("user"))
//                                .collect(Collectors.toList())
                )
        ).append(
                getPropertySourceInfo()
        );


        return sb.toString();
    }

    public String getClassPathRepo(){
        StringBuilder sb = new StringBuilder(0);

        String[] values = env.getProperty("java.class.path").split(";");
        for(String value : values){
            sb.append(
                    String.format("%"+INDENT+"s : %s%n","",Arrays.stream(value.split("repository\\\\"))
                            .filter(a->a.endsWith(".jar"))
                            .collect(Collectors.joining())
                            .replaceAll("\\\\",".")
                    )
            );
        }

        return sb.toString();
    }

    public String getPropertySourceInfo(){
        StringBuilder sb = new StringBuilder(0);
        for (PropertySource<?> property : env.getPropertySources()){
            if(property.getName()=="systemProperties"
                    ||property.getName()=="systemEnvironment") continue;
            if(property.getSource() instanceof Map<?,?>){
                sb.append(
                        String.format("%"+INDENT+"s : %s%n",property.getName(),((Map<?, ?>) property.getSource()).entrySet())
                );
            }

        }



        return sb.toString();
    }

}
