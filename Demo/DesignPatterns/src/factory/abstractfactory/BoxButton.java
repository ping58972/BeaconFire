package factory.abstractfactory;

public class BoxButton implements Button{
    @Override
    public void click() {
        System.out.println("Box button");
    }
}
