package factory.factorymethod;

// delegate responsibility of creation to subclasses
public abstract class ShapeFactory {
    private final Shape shape = getShape();

    public void workWithShape() {
        shape.doSomething();
    }

    public abstract Shape getShape();
}
