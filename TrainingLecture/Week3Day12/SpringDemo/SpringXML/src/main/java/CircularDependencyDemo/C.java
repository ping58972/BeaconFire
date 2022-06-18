package CircularDependencyDemo;

public class C {
    private A a;

    C(A a){
        this.a = a;
    }
}
