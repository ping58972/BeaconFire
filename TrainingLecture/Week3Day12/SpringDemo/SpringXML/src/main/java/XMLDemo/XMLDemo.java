package XMLDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XMLDemo {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        DependencyConsumer dc = (DependencyConsumer) ac.getBean("dependencyConsumer");
//        DependencyConsumer dc = ac.getBean("dependencyConsumer", DependencyConsumer.class);

        DependencyOne dependencyOne = dc.getDependencyOne();
        DependencyTwo dependencyTwo = dc.getDependencyTwo();
        DependencyThree dependencyThree = dc.getDependencyThree();

        dependencyOne.printMessage();
        dependencyTwo.printMessage();
        dependencyThree.printMessage();

    }

}
