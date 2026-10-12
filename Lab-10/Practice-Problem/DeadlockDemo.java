
public class DeadlockDemo {
    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();

        Runnable task = () -> {
            synchronized (lock1) {
                System.out.println(
                    Thread.currentThread().getName() + " locked lock1");

                synchronized (lock2) {
                    System.out.println(
                        Thread.currentThread().getName() + " locked lock2");
                }
            }
        };

        Thread t1 = new Thread(task, "Thread 1");
        Thread t2 = new Thread(task, "Thread 2");

        t1.start();
        t2.start();
    }
}
