package QualifierDemo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class DependencyOne implements Dependency {

    @Override
    public void printMessage() {
        System.out.println("Dependency One");
    }
}
