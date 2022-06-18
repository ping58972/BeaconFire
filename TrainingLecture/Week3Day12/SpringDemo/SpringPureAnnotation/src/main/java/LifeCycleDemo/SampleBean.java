package LifeCycleDemo;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


@Component
public class SampleBean {
    public SampleBean(){
        System.out.println("In Constructor");
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("In post construction method");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("In pre destroy method");
    }
}
