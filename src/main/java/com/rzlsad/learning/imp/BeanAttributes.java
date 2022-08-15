package com.rzlsad.learning.imp;

import com.rzlsad.learning.MessageProvider;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.GenericApplicationContext;


import javax.print.DocFlavor;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BeanAttributes implements ApplicationContextAware {
    private static final int INDENT=60;

    private GenericApplicationContext context;

    private String getBeanFactoryInfo(String name){
        StringBuffer sb = new StringBuffer(0);

        sb.append(
                String.format("%"+INDENT+"s : %s%n","Aliases", Arrays.toString(context.getAliases(name)))
        ).append(
                String.format("%"+INDENT+"s : %s%n","Type", context.getType(name,false))
        ).append(
                String.format("%"+INDENT+"s : %s%n","Is Prototype?", context.isPrototype(name))
        ).append(
                String.format("%"+INDENT+"s : %s%n","Is Singleton?", context.isSingleton(name))
        );

        return sb.toString();
    }

    public String getContextInfo(){
        StringBuffer sb = new StringBuffer(0);
        List<String> springBeans = Arrays.stream(context.getBeanDefinitionNames())
                                    .filter(a->a.contains("org.springframework"))
                                    .collect(Collectors.toList());
        List<String> definedBeans = Arrays.stream(context.getBeanDefinitionNames())
                                    .filter((a)->!a.contains("org.springframework"))
                                    .collect(Collectors.toList());
        Set<Class<?>> types = definedBeans.stream()
                                    .map(a->context.getType(a,false))
                                    .collect(Collectors.toSet());

        sb.append(
                String.format("%"+INDENT+"s : %s%n","Total Number of Definitions", context.getBeanDefinitionCount())
        ).append(
                String.format("%"+INDENT+"s : %s%n","Number of Our Definitions", definedBeans.size())
        ).append(
                String.format("%"+INDENT+"s : %s%n","Names of Spring Beans", springBeans)
        ).append(
                String.format("%"+INDENT+"s : %s%n","Names of Defined Beans", definedBeans)
        ).append(
                String.format("%n")
        );
        for(Class<?> type : types){
            sb.append(
                String.format("%"+INDENT+"s : %s%n",type.getSimpleName(), Arrays.toString(context.getBeanNamesForType(type)))
            );
        }
        for(String bean : definedBeans)
            sb.append(
                String.format("%n%"+INDENT+"s : %s%n%s","Bean Name",bean, getBeanFactoryInfo(bean))
            ).append(
                String.format("%n%"+INDENT+"s : %s%n%s","Bean Definition",bean, getBeanDefinitionInfo(bean))
            );

        return sb.toString();
    }

    public String getBeanDefinitionInfo(String name){
        StringBuffer sb = new StringBuffer(0);
        BeanDefinition bd = context.getBeanDefinition(name);
        sb.append(
                String.format("%"+INDENT+"s : %s%n","Class Name", bd.getBeanClassName())
        ).append(
                String.format("%"+INDENT+"s : %s%n","Factory Bean Name", bd.getFactoryBeanName())
        ).append(
                String.format("%"+INDENT+"s : %s%n","Factory Method Name", bd.getFactoryMethodName())
        ).append(
                String.format("%"+INDENT+"s : %s%n","Description", bd.getDescription())
        ).append(
                String.format("%"+INDENT+"s : %s%n","Initialization Method Name", bd.getInitMethodName())
        ).append(
                String.format("%"+INDENT+"s : %s%n","Destroy Method Name", bd.getDestroyMethodName())
        ).append(
                String.format("%"+INDENT+"s : %s%n","Parent Name", bd.getParentName())
        ).append(
                String.format("%"+INDENT+"s : %s%n","Resource Description", bd.getResourceDescription())
        ).append(
                String.format("%"+INDENT+"s : %s%n","Role", bd.getRole())
        ).append(
                String.format("%"+INDENT+"s : %s%n","Scope", bd.getScope())
        ).append(
                String.format("%"+INDENT+"s : %s%n","Has Constructor Argument?", bd.hasConstructorArgumentValues())
        ).append(
                String.format("%"+INDENT+"s : %s%n","Constructor Arguments", bd.getConstructorArgumentValues()
                                                                                .getGenericArgumentValues()
                                                                                .stream()
                                                                                .map(a->a.getValue())
                                                                                .collect(Collectors.toList()))
        ).append(
                String.format("%"+INDENT+"s : %s%n","Has Property Values?", bd.hasPropertyValues())
        ).append(
                String.format("%"+INDENT+"s : %s%n","Property Values", bd.getPropertyValues()
                                                                                .getPropertyValueList()
                                                                                .stream()
                                                                                .map(a->a.getValue())
                                                                                .collect(Collectors.toList()))
        ).append(
                String.format("%"+INDENT+"s : %s%n","Is Abstract?", bd.isAbstract())
        ).append(
                String.format("%"+INDENT+"s : %s%n","Is Autowire Candidate?", bd.isAutowireCandidate())
        ).append(
                String.format("%"+INDENT+"s : %s%n","Is Lazy Initialize?", bd.isLazyInit())
        ).append(
                String.format("%"+INDENT+"s : %s%n","Is Primary?", bd.isPrimary())
        ).append(
                String.format("%"+INDENT+"s : %s%n","Is Prototype?", bd.isPrototype())
        ).append(
                String.format("%"+INDENT+"s : %s%n","Is Singleton", bd.isSingleton())
        ).append(
                String.format("%"+INDENT+"s : %s%n","Property Values", bd.getPropertyValues().getPropertyValueList())
        ).append(
                String.format("%"+INDENT+"s : %n%s","Dependence Tree",getTree(4,name))
        );

        return sb.toString();
    }

    private String getTree(int ind,String name){
        StringBuffer sb = new StringBuffer(0);
        String[] beans=context.getBeanDefinition(name).getDependsOn();
        sb.append(
                String.format("%"+(ind+INDENT)+"s%s%n","-",name )
        );
        if(beans!=null){
            ind+=2;
            for(String bean : beans){
                sb.append(
                        getTree(ind,bean)
                );
            }
        }
        return sb.toString();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context= (GenericApplicationContext) applicationContext;
    }
}
