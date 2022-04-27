package shape;


public class Rectangle extends Shape {

    public Rectangle(int height, int width) {
        this.height = height;
        this.width = width;
    }
    @Override
    public void printArea() {
        System.out.println("The area of Rectangle is: "+height*width);
    }

}
