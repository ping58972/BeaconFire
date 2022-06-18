package PureAnnotationDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope("prototype")
public class DependencyConsumer {

    private DependencyOne dependencyOne;
    private DependencyTwo dependencyTwo;

    @Autowired
    private DependencyThree dependencyThree;

    @Autowired
    DependencyConsumer(DependencyOne dependencyOne){
        this.dependencyOne = dependencyOne;
    }

    @Autowired
    public void setDependencyTwo(DependencyTwo dependencyTwo) {
        this.dependencyTwo = dependencyTwo;
    }

    public DependencyOne getDependencyOne() {
        return dependencyOne;
    }

    public DependencyTwo getDependencyTwo() {
        return dependencyTwo;
    }

    public DependencyThree getDependencyThree() {
        return dependencyThree;
    }
}
