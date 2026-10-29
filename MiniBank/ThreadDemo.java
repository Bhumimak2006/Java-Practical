
public class ThreadDemo {

    public static void main(String[] args)
            throws InterruptedException {

        Account account =
            new SavingsAccount("Rahul", 5000, 0);

        System.out.println("Initial balance: "
                + account.getBalance());

        Thread t1 = new Thread(
            new TransactionTask(account, 1000, true),
            "Thread-1"
        );

        Thread t2 = new Thread(
            new TransactionTask(account, 2000, false),
            "Thread-2"
        );

        Thread t3 = new Thread(
            new TransactionTask(account, 500, true),
            "Thread-3"
        );

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("Final balance: "
                + account.getBalance());
    }
}
