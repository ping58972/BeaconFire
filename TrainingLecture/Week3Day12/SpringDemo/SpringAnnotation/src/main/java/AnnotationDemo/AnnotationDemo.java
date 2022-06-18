package AnnotationDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemo {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean1.xml");

        DependencyConsumer dc = ac.getBean("dependencyConsumer", DependencyConsumer.class);

        DependencyOne dependencyOne = dc.getDependencyOne();
        DependencyTwo dependencyTwo = dc.getDependencyTwo();
        DependencyThree dependencyThree = dc.getDependencyThree();

        dependencyOne.printMessage();
        dependencyTwo.printMessage();
        dependencyThree.printMessage();

    }

}
