package AnnotationDemo;

import org.springframework.stereotype.Component;

@Component("two")
public class DependencyTwo implements Dependency {

    @Override
    public void printMessage() {
        System.out.println("Dependency Two");
    }
}
