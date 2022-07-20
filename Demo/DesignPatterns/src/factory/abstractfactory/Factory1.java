package factory.abstractfactory;

public class Factory1 extends UIFactory{

    @Override
    public Button getButton() {
        return new BoxButton();
    }

    @Override
    public Input getInput() {
        return new TextInput();
    }
}
