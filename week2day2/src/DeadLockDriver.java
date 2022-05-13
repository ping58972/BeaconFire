public class DeadLockDriver {
    public static void main(String[] args) {
        Object key1 = new Object();
        Object key2 = new Object();
        Thread t8 = new Thread( () -> {
            synchronized (key1) {
                System.out.println("t8 has key 1.");
//                try {
//                    Thread.sleep(5000);
//                } catch (InterruptedException e){
//                    e.printStackTrace();
//                }
                synchronized (key2) {
                    System.out.println("t8 has key 2");
                }
            }
        });
        Thread t9 = new Thread( () -> {
            // I solved this problem by put t8.join() here.
            // that means waiting util t8 complete then t9 continue
            try {
                t8.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            ///////////////////////
            synchronized (key2) {
                System.out.println("t9 has key 2.");
                synchronized (key1) {
                    System.out.println("t9 has key 1");
                }
            }
        });
        t8.start();
        t9.start();
    }
}
