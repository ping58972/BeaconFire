package QualifierDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class DependencyConsumer {

    // Match by type
    @Autowired
    private DependencyOne dependencyOne;

    // Match by qualifier
    @Autowired
    @Qualifier("dependencyTwo")
    private Dependency dependency;

    // Match by name
    @Autowired
    private Dependency dependencyThree;

    // Try to match qualifier and name
    @Autowired
    @Qualifier("dependencyOne")
    private Dependency dependencyTwo;

    // Use Primary
    @Autowired
    private Dependency dependency1;

    // Getters
    public DependencyOne getDependencyOne() {
        return dependencyOne;
    }

    public Dependency getDependency() {
        return dependency;
    }

    public Dependency getDependencyThree() {
        return dependencyThree;
    }

    public Dependency getDependencyTwo() {
        return dependencyTwo;
    }

    public Dependency getDependency1() {
        return dependency1;
    }
}
