package AnnotationDemo;

import org.springframework.stereotype.Component;

// "dependencyThree"
@Component
public class DependencyThree implements Dependency {

    @Override
    public void printMessage() {
        System.out.println("Dependency Three");
    }
}
