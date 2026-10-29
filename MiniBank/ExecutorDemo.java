
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorDemo {

    public static void main(String[] args)
            throws InterruptedException {

        Account account =
            new SavingsAccount("Rahul", 5000, 0);

        ExecutorService executor =
            Executors.newFixedThreadPool(3);

        System.out.println("Initial balance: "
                + account.getBalance());

        executor.submit(() -> account.deposit(1000));
        executor.submit(() -> account.withdraw(500));
        executor.submit(() -> account.deposit(200));

        executor.shutdown();

        if (executor.awaitTermination(10, TimeUnit.SECONDS)) {
            System.out.println("All tasks completed.");
            System.out.println("Final balance: "
                    + account.getBalance());
        } else {
            System.out.println("Tasks did not finish in time.");
            executor.shutdownNow();
        }
    }
}
