package QualifierDemo;

import org.springframework.stereotype.Component;

@Component
public class DependencyThree implements Dependency {

    @Override
    public void printMessage() {
        System.out.println("Dependency Three");
    }
}
