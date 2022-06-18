package QualifierDemo;

import org.springframework.stereotype.Component;

@Component
public class DependencyTwo implements Dependency {

    @Override
    public void printMessage() {
        System.out.println("Dependency Two");
    }
}
