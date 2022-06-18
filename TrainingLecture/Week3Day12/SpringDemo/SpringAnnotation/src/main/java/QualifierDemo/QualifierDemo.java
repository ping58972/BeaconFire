package QualifierDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class QualifierDemo {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean2.xml");

        DependencyConsumer dc = ac.getBean("dependencyConsumer", DependencyConsumer.class);

        Dependency dependencyOne = dc.getDependencyOne();
        Dependency dependency = dc.getDependency();
        Dependency dependencyThree = dc.getDependencyThree();
        Dependency dependencyTwo = dc.getDependencyTwo();
        Dependency dependency1 = dc.getDependency1();

        dependencyOne.printMessage(); // d one
        dependency.printMessage(); // d Two
        dependencyThree.printMessage(); // d three
        dependencyTwo.printMessage(); // d one
        dependency1.printMessage();
    }
}
