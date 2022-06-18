public class AbstractDemo {
    public static void main(String[] args) {
        Shape circle = new Circle();
        circle.draw();
    }
}

abstract class Shape {
    public Shape() {
        System.out.println("Constructor of abstract class Shape");
    }

    // method with no provided implementation
    abstract void draw();

    int getArea() {
        return 0;
    }
}

class Circle extends Shape {
    public Circle() {
        System.out.println("Constructor of class Circle");
    }

    @Override
    void draw() {
        System.out.println("Draw a circle");
    }
}

