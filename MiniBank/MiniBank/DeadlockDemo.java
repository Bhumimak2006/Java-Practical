
public class DeadlockDemo {

    private static final Object lockA = new Object();
    private static final Object lockB = new Object();

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            synchronized (lockA) {
                System.out.println("Thread 1 locked A");

                sleepBriefly();

                synchronized (lockB) {
                    System.out.println("Thread 1 locked B");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lockB) {
                System.out.println("Thread 2 locked B");

                sleepBriefly();

                synchronized (lockA) {
                    System.out.println("Thread 2 locked A");
                }
            }
        });

        t1.start();
        t2.start();
    }

    private static void sleepBriefly() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
