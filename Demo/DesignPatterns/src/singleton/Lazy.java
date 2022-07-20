package singleton;

public class Lazy {
    private static Lazy instance = null;


    private Lazy() {
        System.out.println("Lazy initialization");
    }

    public static Lazy getInstance() {
        if(instance == null) {
            instance = new Lazy();
        }
        return instance;
    }


    // protection against cloning
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
