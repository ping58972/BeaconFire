package LifeCycleDemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LifeCycleDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);

        SampleBean sampleBean = ac.getBean("sampleBean", SampleBean.class);

        ac.close();
    }
}
