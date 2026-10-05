class Counter {
    int count = 0;
    void incrementWithoutSync() {
        count++;
    }
    synchronized void incrementWithSync() {
        count++;
    }
}
class CounterThread extends Thread {
    Counter counter;
    int times;
    boolean synchronizedMode;
    CounterThread(Counter counter, int times, boolean synchronizedMode) {
        this.counter = counter;
        this.times = times;
        this.synchronizedMode = synchronizedMode;
    }
    public void run() {
        for (int i = 0; i < times; i++) {
            if (synchronizedMode) {
                counter.incrementWithSync();
            } else {
                counter.incrementWithoutSync();
            }
        }
    }
}
public class CounterRace {
    public static void main(String[] args) throws InterruptedException {
        int numberOfThreads = 10;
        int incrementsPerThread = 100000;
        Counter counter1 = new Counter();
        CounterThread[] threads1 = new CounterThread[numberOfThreads];
        for (int i = 0; i < numberOfThreads; i++) {
            threads1[i] = new CounterThread(
                    counter1,
                    incrementsPerThread,
                    false
            );
            threads1[i].start();
        }

        for (int i = 0; i < numberOfThreads; i++) {
            threads1[i].join();
        }

        int expected = numberOfThreads * incrementsPerThread;

        System.out.println("Without Synchronization:");
        System.out.println("Expected Count : " + expected);
        System.out.println("Actual Count   : " + counter1.count);
        Counter counter2 = new Counter();

        CounterThread[] threads2 = new CounterThread[numberOfThreads];
        for (int i = 0; i < numberOfThreads; i++) {
            threads2[i] = new CounterThread(
                    counter2,
                    incrementsPerThread,
                    true
            );
            threads2[i].start();
        }
        for (int i = 0; i < numberOfThreads; i++) {
            threads2[i].join();
        }
        System.out.println("\nWith Synchronization:");
        System.out.println("Expected Count : " + expected);
        System.out.println("Actual Count   : " + counter2.count);
    }
}