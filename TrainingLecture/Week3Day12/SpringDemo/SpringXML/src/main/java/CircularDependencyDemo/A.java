package CircularDependencyDemo;

public class A {
    private B b;

    A(B b){
        this.b = b;
    }
}
