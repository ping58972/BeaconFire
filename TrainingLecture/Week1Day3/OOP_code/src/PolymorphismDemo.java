public class PolymorphismDemo {
    public static void main(String[] args) {
        Action action = new Action();
        action.sleep(); //sleep
        action.sleep(5); //sleep 5 hours

        Cat cat = new Cat();
        cat.sleep(); // nap

    }
}

class Action {
    public void sleep() {
        System.out.println("sleep");
    }

    // overloading
    public void sleep(int hours) {
        System.out.println("sleep " + hours + " hours");
    }
}

class Cat extends Action {
    @Override
    public void sleep() {
        System.out.println("nap");
    }
}