/*
Author: (Ping) Danddank
email: ndanddank@gmail.com
Question 1. Create a program to reproduce the Counter Thread interference issue, run several times and
explain the result.
* */
import java.util.stream.IntStream;

public class ThreadInterferenceCounter {
    private int counter;
    public void increase(){
        counter++;
    }
    public void decrease() {
        counter--;
    }
    public int getCounter() {
        return counter;
    }
    public static void main(String[] args) throws InterruptedException {
        // initilize a instance object of the class.
        ThreadInterferenceCounter counter = new ThreadInterferenceCounter();
        // create thread 1 to increasing the counter available.
        Thread t1 = new Thread(()->{
            IntStream.range(0, 10000).forEach(x->counter.increase());
        });
        // create another thread 2 to decreasing the counter.
        Thread t2 = new Thread(()->{
            IntStream.range(0, 10000).forEach(x->counter.decrease());
        });
        // then let 2 thread run in the parallel multi-thread.
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        // Race condition will occur, we will get unexpect result.
        System.out.println(counter.getCounter());
    }
}
