package singleton;

public class Eager {
    private static final Eager instance = new Eager();

    private Eager() {
        System.out.println("Eager initialization");
    }

    public static Eager getInstance() {
        return instance;
    }
}