package factory.simplefactory;

public class ShapeFactory {
    public Shape getShape(String shape) {
        switch (shape) {
            case "rectangle":
                return new Rectangle();
            case "circle":
                return new Circle();
            default:
                return null;
        }
    }

    public static void main(String[] args) {
        // get some input string via Scanner or file read etc
        String s = "rectangle";
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shape = shapeFactory.getShape(s);
    }
}
