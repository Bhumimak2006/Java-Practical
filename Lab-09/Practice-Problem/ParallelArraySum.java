import java.util.concurrent.atomic.AtomicLong;
public class ParallelArraySum {
    static final int SIZE = 1_000_000;
    static final int THREADS = 10;

    static long wrongTotal = 0;
    static long synchronizedTotal = 0;
    static AtomicLong atomicTotal = new AtomicLong(0);
    static class UnsynchronizedTask extends Thread {
        int[] array;
        int start;
        int end;
        UnsynchronizedTask(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }
        public void run() {
            long localSum = 0;
            for (int i = start; i < end; i++) {
                localSum += array[i];
            }
            wrongTotal += localSum;
        }
    }
    static class SynchronizedTask extends Thread {
        int[] array;
        int start;
        int end;
        SynchronizedTask(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }
        public void run() {
            long localSum = 0;
            for (int i = start; i < end; i++) {
                localSum += array[i];
            }
            addSynchronized(localSum);
        }
    }
    synchronized static void addSynchronized(long value) {
        synchronizedTotal += value;
    }
    static class AtomicTask extends Thread {
        int[] array;
        int start;
        int end;
        AtomicTask(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }
        public void run() {
            long localSum = 0;
            for (int i = start; i < end; i++) {
                localSum += array[i];
            }
            atomicTotal.addAndGet(localSum);
        }
    }
    public static void main(String[] args) throws InterruptedException {
        int[] numbers = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            numbers[i] = (i % 100) + 1;
        }
        long correctTotal = 0;
        for (int number : numbers) {
            correctTotal += number;
        }
        System.out.println("Correct Total = " + correctTotal);
        System.out.println("--------------------------------");
        wrongTotal = 0;
        Thread[] threads1 = new Thread[THREADS];
        long startTime = System.nanoTime();
        int part = SIZE / THREADS;
        for (int i = 0; i < THREADS; i++) {
            int start = i * part;
            int end = (i == THREADS - 1) ? SIZE : start + part;
            threads1[i] = new UnsynchronizedTask(
                    numbers, start, end
            );
            threads1[i].start();
        }
        for (Thread thread : threads1) {
            thread.join();
        }
        long endTime = System.nanoTime();
        System.out.println("WITHOUT SYNCHRONIZATION");
        System.out.println("Total = " + wrongTotal);
        System.out.println("Time  = "
                + (endTime - startTime) / 1_000_000.0
                + " ms");
        synchronizedTotal = 0;
        Thread[] threads2 = new Thread[THREADS];
        startTime = System.nanoTime();
        for (int i = 0; i < THREADS; i++) {
            int start = i * part;
            int end = (i == THREADS - 1) ? SIZE : start + part;
            threads2[i] = new SynchronizedTask(
                    numbers, start, end
            );
            threads2[i].start();
        }
        for (Thread thread : threads2) {
            thread.join();
        }
        endTime = System.nanoTime();
        System.out.println("\nWITH SYNCHRONIZED");
        System.out.println("Total = " + synchronizedTotal);
        System.out.println("Time  = "
                + (endTime - startTime) / 1_000_000.0
                + " ms");
        atomicTotal.set(0);
        Thread[] threads3 = new Thread[THREADS];
        startTime = System.nanoTime();
        for (int i = 0; i < THREADS; i++) {
            int start = i * part;
            int end = (i == THREADS - 1) ? SIZE : start + part;
            threads3[i] = new AtomicTask(
                    numbers, start, end
            );
            threads3[i].start();
        }
        for (Thread thread : threads3) {
            thread.join();
        }
        endTime = System.nanoTime();
        System.out.println("\nWITH ATOMICLONG");
        System.out.println("Total = " + atomicTotal.get());
        System.out.println("Time  = "
                + (endTime - startTime) / 1_000_000.0
                + " ms");
    }
}