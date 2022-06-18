package PureAnnotationDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PureAnnotationDemo {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(DependencyConfig.class);

        DependencyConsumer dc = ac.getBean("dependencyConsumer", DependencyConsumer.class);
        DependencyOne dependencyOne = dc.getDependencyOne();
        DependencyTwo dependencyTwo = dc.getDependencyTwo();
        DependencyThree dependencyThree = dc.getDependencyThree();

        dependencyOne.printMessage();
        dependencyTwo.printMessage();
        dependencyThree.printMessage();
    }
}
