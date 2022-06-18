package shape;

public class Main {
    public static void main(String[] args) {
        // for testing all class.
        Shape rectangle = new Rectangle(2,5);
        rectangle.printArea();
        Shape triangle = new Triangle(4, 3);
        triangle.printArea();
        Shape circle = new Circle(6);
        circle.printArea();
    }
}
