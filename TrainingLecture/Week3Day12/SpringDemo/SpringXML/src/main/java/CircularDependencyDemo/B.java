package CircularDependencyDemo;

public class B {
    private C c;

    B(C c){
        this.c = c;
    }
}
