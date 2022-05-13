// Thread safe singleton class.
class ThreadSafeSingleton {
    private static volatile ThreadSafeSingleton obj;
    private ThreadSafeSingleton() {}
    public static ThreadSafeSingleton getinstance() {
        if (obj == null) {
            synchronized (ThreadSafeSingleton.class) {// not this
                if (obj == null) {
                    obj = new ThreadSafeSingleton();
                }
            }
        }
        return obj;
    }
}
       // Lazy singleton (not thread safe):
       class LazySingleton{
            private static LazySingleton obj;
            private LazySingleton(){};
            public static LazySingleton getinstance(){
                if(obj == null)  obj = new LazySingleton();
                return obj;
            }
        }



        //Eager singleton (not thread safe):
        class EagerSingleton{
            private static EagerSingleton obj = new EagerSingleton();
            private EagerSingleton(){};
            public static EagerSingleton getinstance(){ return obj;}
        }
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}