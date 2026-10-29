
class BalanceBox {

    private int balance = 0;

    public synchronized void withdraw(int amount)
            throws InterruptedException {

        while (balance < amount) {
            System.out.println(
                "Insufficient balance. Waiting for deposit..."
            );

            wait();
        }

        balance -= amount;

        System.out.println("Withdrawn: " + amount);
        System.out.println("Balance: " + balance);
    }

    public synchronized void deposit(int amount) {

        balance += amount;

        System.out.println("Deposited: " + amount);
        System.out.println("Balance: " + balance);

        notifyAll();
    }
}

public class WaitNotifyDemo {

    public static void main(String[] args) {

        BalanceBox box = new BalanceBox();

        Thread withdrawThread = new Thread(() -> {
            try {
                box.withdraw(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Withdrawal interrupted.");
            }
        });

        Thread depositThread = new Thread(() -> {
            try {
                Thread.sleep(1000);
                box.deposit(1500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        withdrawThread.start();
        depositThread.start();

        try {
            withdrawThread.join();
            depositThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Program completed.");
    }
}
