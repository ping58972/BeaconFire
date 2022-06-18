
public class Inheritance {

    public static void main(String[] args) {
        Child c = new Child("hi");
        System.out.println("-----------------");
        Child2 c2 = new Child2("hello");
    }

}

class GrandParent{
    public GrandParent() {
        System.out.println("Grand Parent");
    }
//    public GrandParent(String msg) {
//        System.out.println("Grand Parent: " + msg);
//    }

}

// single inheritance
class Parent extends GrandParent {
    public Parent() {
        System.out.println("Parent");
    }
    public Parent(String msg) {
//        super(msg);
        System.out.println("Parent: " + msg);
    }
}

// multi-level inheritance
class Child extends Parent {
    public Child() {
        System.out.println("Child");
    }
    public Child(String msg) {
        super(msg);
        System.out.println("Child: " + msg);
    }
}

// hierarchy inheritance
class Child2 extends Parent{
    public Child2() {
        System.out.println("Child2");
    }
    public Child2(String msg) {
        super(msg);
        System.out.println("Child2: "+msg);
    }
}
