package PureAnnotationDemo;

public class DependencyTwo implements Dependency {

    @Override
    public void printMessage() {
        System.out.println("Dependency Two");
    }
}
