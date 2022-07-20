package singleton;

public class DoubleCheckLazy {
    private static volatile DoubleCheckLazy instance = null;

    private DoubleCheckLazy() {
        System.out.println("Double check initialization");
    }

    public static DoubleCheckLazy getInstance() {
        if(instance == null) { //optional but recmmended
            synchronized (DoubleCheckLazy.class) {
                if(instance == null) {
                    instance = new DoubleCheckLazy();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        new Thread(() -> {
            DoubleCheckLazy instance = DoubleCheckLazy.getInstance();
        }).start();
    }
}
