/*
Author: (Ping) Danddank
email: ndanddank@gmail.com
Question 2. Come up with a synchronization mechanism (other than using synchronized keyword) to
make the Counter work as expected.
* */
import java.util.stream.IntStream;

public class SynchronizedCounter {
    private int counter;
    // adding synchronized keyword into the front of each method for prevent more
    // than one thread access the resource in the same time
    synchronized public void increase(){
        counter++;
    }
    synchronized public void decrease() {
        counter--;
    }
    synchronized public int getCounter() {
        return counter;
    }
    public static void main(String[] args) throws InterruptedException {
        // initilize a instance object of the class.
        SynchronizedCounter counter = new SynchronizedCounter();
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
        // Race condition will not occur, and we will get the expected result.
        System.out.println(counter.getCounter());
    }
}
