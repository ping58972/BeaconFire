package com.beaconfire.asynchronous.ExecutorServiceDemo;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Function;
import java.util.function.Supplier;

public class Driver {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        demo1();
//        demo2();
//        demo3();
//        demo4();
        demo5();
//        demo6();
    }

    private static void demo1(){
        // submit runnable task to executor service
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(
                ()-> {
                    System.out.println("Current Thread: " + Thread.currentThread().getName());
                }
        );
        executorService.submit(
                () -> {
                    System.out.println("Current Thread: " + Thread.currentThread().getName());
                }
        );

        executorService.shutdown();
    }

    private static void demo2() throws ExecutionException, InterruptedException {
        // submit callable task to executor service
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<String> future = executorService.submit(
                () -> {
                   return "Current Thread: " + Thread.currentThread().getName();
                }
        );

        System.out.println(future.get());
        executorService.shutdown();
    }

    private static void demo3() throws InterruptedException, ExecutionException {
        // submit a list of callable tasks to executor service
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        List<Callable<String>> taskList = Arrays.asList(
                () -> {
                    Thread.sleep(3000);
                    return "Task 1 finished running on: " + Thread.currentThread().getName();
                },
                () -> {
                    Thread.sleep(2000);
                    return "Task 2 finished running on: " + Thread.currentThread().getName();
                },
                () -> {
                    Thread.sleep(3000);
                    return "Task 3 finished running on: " + Thread.currentThread().getName();
                },
                () -> {
                    Thread.sleep(4000);
                    return "Task 4 finished running on: " + Thread.currentThread().getName();
                }
        );

        // invokeAll - Executes the given tasks, returns a list of Future objects that hold the status and results
        List<Future<String>> resultList = executorService.invokeAll(taskList);
//
//        for (Future<String> future : resultList){
//            System.out.println(future.get());
//        }

        System.out.println("Something else we need to do");

        // invokeAny - Executes the given tasks, returns the result of one successfully executed task
//        String result = executorService.invokeAny(taskList);
//        System.out.println(result);

        executorService.shutdown();
    }

    private static void demo4(){
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        List<Runnable> taskList = Arrays.asList(
                () -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Task 1 is finished running on: " + Thread.currentThread().getName());
                },
                () -> {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Task 2 is finished running on: " + Thread.currentThread().getName());
                },
                () -> {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Task 3 is finished running on: " + Thread.currentThread().getName());
                }
        );

        for (Runnable task : taskList){
            CompletableFuture.runAsync(task, executorService);
        }
        System.out.println("Something else we need to do");

        executorService.shutdown();
    }

    private static void demo5() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);


        Supplier<String> task1 = () -> {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Task 1 is finished running on: " + Thread.currentThread().getName();
        };

        Supplier<Integer> task2 = () -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1;
        };

        Supplier<Boolean> task3 = () -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return false;
        };

        CompletableFuture<String> task1Future = CompletableFuture.supplyAsync(task1, executorService);
        CompletableFuture<Integer> task2Future = CompletableFuture.supplyAsync(task2, executorService);
        CompletableFuture<Boolean> task3Future = CompletableFuture.supplyAsync(task3, executorService);

        // join vs get
//        System.out.println(task1Future.join());
//        System.out.println(task1Future.get());

        // anyOf
//        CompletableFuture<Object> firstResult = CompletableFuture.anyOf(task1Future, task2Future, task3Future);
//        System.out.println(firstResult.join());

        // allOf
        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(
                task1Future,
                task2Future,
                task3Future);
//        combinedFuture.join();
//        System.out.println(combinedFuture.isDone());

        // thenApply
//        CompletableFuture<String> task1FutureExtended = task1Future.thenApply(
//                (result) -> {
//                    return result + ", something else we need to do";
//                }
//        );
//        System.out.println(task1FutureExtended.join());

        CompletableFuture<String> combinedResultFuture = combinedFuture.thenApply(
                (placeHolder) -> {
            return task1Future.join() + " " + task2Future.join() + " " + task3Future.join();
        } );

        System.out.println(combinedResultFuture.join());

        executorService.shutdown();

    }

    public static void demo6() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        CompletionService<String> completionService = new ExecutorCompletionService<>(executorService);

        List<Callable<String>> taskList = Arrays.asList(
                () -> {
                    Thread.sleep(1000);
                    return "Task 1 finished running on: " + Thread.currentThread().getName();
                },
                () -> {
                    Thread.sleep(2000);
                    return "Task 2 finished running on: " + Thread.currentThread().getName();
                },
                () -> {
                    Thread.sleep(3000);
                    return "Task 3 finished running on: " + Thread.currentThread().getName();
                }
        );

        for (Callable<String> task : taskList){
            completionService.submit(task);
        }

        Future<String> firstFuture = completionService.take();
        Future<String> secondFuture = completionService.take();

        System.out.println(firstFuture.get());
        System.out.println(secondFuture.get());

        executorService.shutdown();

    }


}
