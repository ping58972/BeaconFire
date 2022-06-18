package XMLDemo;

public class DependencyConsumer {

    private DependencyOne dependencyOne; // required
    private DependencyTwo dependencyTwo;
    private DependencyThree dependencyThree;


    DependencyConsumer(DependencyOne dependencyOne, DependencyThree dependencyThree){
        this.dependencyOne = dependencyOne;
        this.dependencyThree = dependencyThree;
    }

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
