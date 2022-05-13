import java.util.stream.IntStream;

/*
Author: (Ping) Danddank
email: ndanddank@gmail.com
Question 3. Create a Singleton Class. And write a code to test if your singleton class work in multithread
environment?
* */

// for thread safe and Lazy singleton counter class.
class ThreadSafeLazySingletonCounter {
    private static ThreadSafeLazySingletonCounter counterInstance;
    private int counter;
    private ThreadSafeLazySingletonCounter(){}
    public static ThreadSafeLazySingletonCounter instance(){
        if(counterInstance == null) {
            // create new instance only one time with synchronized block for thread safe.
            synchronized (ThreadInterferenceCounter.class){
                if(counterInstance == null){
                    counterInstance = new ThreadSafeLazySingletonCounter();
                }
            }
        }
        return counterInstance;
    }
    synchronized public void increase(){
        counter++;
    }
    synchronized public void decrease(){
        counter--;
    }
    synchronized public int getCounter(){
        return counter;
    }
}
class LazySingletonCounter {
    private static LazySingletonCounter counterInstance;
    private int counter;
    private LazySingletonCounter(){}
    public static LazySingletonCounter instance(){
        if(counterInstance == null) counterInstance = new LazySingletonCounter();
        return counterInstance;
    }
    public void increase(){ counter++;}
    public void decrease(){ counter--; }
    public int getCounter(){ return counter;}
}

public class SingletonCounterDriver{
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            IntStream.range(0, 100000).forEach(x->LazySingletonCounter.instance().increase());
        });
        Thread t2 = new Thread(()->{
            IntStream.range(0, 100000).forEach(x->LazySingletonCounter.instance().decrease());
        });
        // then let 2 thread run in the parallel multi-thread.
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        // Race condition still occur, and we still get the unexpected result.
        System.out.println(LazySingletonCounter.instance().getCounter());

        // let try on ThreadSafeLazySingletonCounter class.
        Thread t3 = new Thread(()->{
            IntStream.range(0, 100000).forEach(x->ThreadSafeLazySingletonCounter.instance().increase());
        });
        Thread t4 = new Thread(()->{
            IntStream.range(0, 100000).forEach(x->ThreadSafeLazySingletonCounter.instance().decrease());
        });
        // then let 2 thread run in the parallel multi-thread.
        t3.start();
        t4.start();
        t3.join();
        t4.join();

        // with thread sage Lazy singleton counter class.
        // Race condition not occur, and we get the expected result.
        System.out.println(ThreadSafeLazySingletonCounter.instance().getCounter());

    }
}
