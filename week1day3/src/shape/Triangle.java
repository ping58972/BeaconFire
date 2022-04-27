package shape;


public class Triangle extends Shape {

    public Triangle(int height, int base) {
        this.height = height;
        this.width = base;
    }
    @Override
    public void printArea() {
        System.out.println(String.format("The area of Triangle is: %.2f",
                1.0*height*width/2));
    }

}
