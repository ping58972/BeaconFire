package shape;
/*
* @Author: Ping Danddank
* @email: ndanddank@gmail.com
 Provide Rectangle subclass that  extends the Class Shape.
*  only the method printArea() that prints the area of Shape.
 */

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
