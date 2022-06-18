package CircularDependencyDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CircularDependencyDemo {
    public static void main(String[] args) {
        ApplicationContext ac =  new ClassPathXmlApplicationContext("bean.xml");

        A a = ac.getBean("a", A.class);
    }
}
