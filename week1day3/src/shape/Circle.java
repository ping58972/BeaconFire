package shape;
/*
* @Author: Ping Danddank
* @email: ndanddank@gmail.com
 Provide Circle subclass that  extends the Class Shape.
*  only the method printArea() that prints the area of Shape.
 */


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
