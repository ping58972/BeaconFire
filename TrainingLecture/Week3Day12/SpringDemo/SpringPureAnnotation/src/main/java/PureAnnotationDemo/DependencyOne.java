package PureAnnotationDemo;

import org.springframework.stereotype.Component;

@Component
public class DependencyOne implements Dependency {

    @Override
    public void printMessage() {
        System.out.println("Dependency One");
    }
}
