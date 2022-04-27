package shape;

import shape.Shape;

public class Circle extends Shape {
    public Circle(int radius){
        this.radius = radius;
    }
    @Override
    public void printArea() {
        System.out.println(String.format("The area of Circle is: %.2f",
                radius*radius*Math.PI));
    }

}
