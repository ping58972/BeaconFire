package XMLDemo;

public class DependencyOne implements Dependency {

    @Override
    public void printMessage() {
        System.out.println("Dependency One");
    }
}
