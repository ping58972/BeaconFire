package factory.abstractfactory;

public class TextInput implements Input{
    @Override
    public void inputData() {
        System.out.println("Text input");
    }
}
