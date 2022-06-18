package AnnotationDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class DependencyConsumer {

    private DependencyOne dependencyOne;
    private DependencyTwo dependencyTwo;

    @Autowired // field
    private DependencyThree dependencyThree;

    @Autowired // constructor
    DependencyConsumer(DependencyOne dependencyOne){
        this.dependencyOne = dependencyOne;
    }

    @Autowired // setter
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

