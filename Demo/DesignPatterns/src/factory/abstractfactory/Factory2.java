package factory.abstractfactory;

public class Factory2 extends UIFactory{
    @Override
    public Button getButton() {
        return new RoundButton();
    }

    @Override
    public Input getInput() {
        return new DateInput();
    }
}
