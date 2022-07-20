import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Supplier;

public class MyExecutorService {
    public static void main(String[] args) throws Exception{
        //demo1();
//        demo2();
//        demo3();
//        demo4();
//        demo5();
        demo6();
    }
    public static void demo1(){
        // submit runnable interface.
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.submit(()-> System.out.println("Hello World! 1" + Thread.currentThread().getName()));
        executorService.submit(()-> System.out.println("Hello World! 2" + Thread.currentThread().getName()));
        executorService.submit(()-> System.out.println("Hello World! 3"+ Thread.currentThread().getName()));
        executorService.submit(()-> System.out.println("Hello World! 4"+ Thread.currentThread().getName()));
        executorService.shutdown();
    }
    public static void demo2() throws Exception{
        // submit callable interface.
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Future<String> fstr1 = executorService.submit(()-> "Hello World! 1" + Thread.currentThread().getName());
        System.out.println(fstr1.get());
        Future<String> fstr2 = executorService.submit(()-> "Hello World! 2" + Thread.currentThread().getName());
        System.out.println(fstr2.get());
        Future<String> fstr3 = executorService.submit(()-> "Hello World! 3" + Thread.currentThread().getName());
        System.out.println(fstr3.get());
        Future<String> fstr4 = executorService.submit(()-> "Hello World! 4" + Thread.currentThread().getName());
        System.out.println(fstr4.get());

        executorService.shutdown();
    }
    public static void demo3() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        List<Callable<String>> list = Arrays.asList(
                ()->{
                    Thread.sleep(2000);
                     return "Hello World!" + Thread.currentThread().getName();},
                ()->"Hello World!" + Thread.currentThread().getName(),
                ()-> "Hello World!" + Thread.currentThread().getName()
        );
//        List<Future<String>> futureList = executorService.invokeAll(list);
//        for(Future<String> f: futureList){
//            System.out.println(f.get());
//        }
        String future = executorService.invokeAny(list);
        System.out.println(future);
        executorService.shutdown();
    }
    public static void demo4() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        List<Runnable> list = Arrays.asList(
                ()->{
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println( "Hello World!" + Thread.currentThread().getName());},
                ()->System.out.println("Hello World!" + Thread.currentThread().getName()),
                ()-> System.out.println("Hello World!" + Thread.currentThread().getName())
        );
        for(Runnable runnable: list){
            CompletableFuture.runAsync(runnable, executorService);
        }
        executorService.shutdown();
    }
     private static void demo5() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Supplier<String> task1 = ()-> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Task 1" + Thread.currentThread().getName();
        };
         Supplier<String> task2 = ()-> {
             try {
                 Thread.sleep(3000);
             } catch (InterruptedException e) {
                 throw new RuntimeException(e);
             }
             return "Task 2" + Thread.currentThread().getName();
         };
         Supplier<String> task3 = ()-> {
             try {
                 Thread.sleep(3000);
             } catch (InterruptedException e) {
                 throw new RuntimeException(e);
             }
             return "Task 3 " + Thread.currentThread().getName();
         };
         CompletableFuture<String> future1 = CompletableFuture.supplyAsync(task1, executorService);
         CompletableFuture<String> future2 = CompletableFuture.supplyAsync(task2, executorService);
         CompletableFuture<String> future3 = CompletableFuture.supplyAsync(task3, executorService);
         CompletableFuture<Void> allFuture = CompletableFuture.allOf(future1, future2, future3);
         CompletableFuture<String> combine = allFuture.thenApply((placeHolder)-> future1.join() + " "+
                 future2.join() + " "+ future3.join());
         System.out.println(combine.join());
         executorService.shutdown();
    }
    private static void demo6() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        CompletionService<String> completionService = new ExecutorCompletionService<>(executorService);
        List<Callable<String>> list = Arrays.asList(
                ()->{
                    Thread.sleep(2000);
                    return "Hello World!" + Thread.currentThread().getName();},
                ()->"Hello World!" + Thread.currentThread().getName(),
                ()-> "Hello World!" + Thread.currentThread().getName()
        );
        for(Callable<String> call: list){
            completionService.submit(call);
        }
        Future<String> future1 = completionService.take();
        Future<String> future2 = completionService.take();
        System.out.println(future1.get());
        System.out.println(future2.get());
        executorService.shutdown();
    }
}
