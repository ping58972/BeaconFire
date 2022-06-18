package AnnotationDemo;

import org.springframework.stereotype.Component;

@Component("dependencyOne")
public class DependencyOne implements Dependency {

    @Override
    public void printMessage() {
        System.out.println("Dependency One");
    }
}
