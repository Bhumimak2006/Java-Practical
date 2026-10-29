
public class TransactionTask implements Runnable {

    private final Account account;
    private final long amount;
    private final boolean isDeposit;

    public TransactionTask(
            Account account,
            long amount,
            boolean isDeposit) {

        this.account = account;
        this.amount = amount;
        this.isDeposit = isDeposit;
    }

    @Override
    public void run() {

        if (isDeposit) {
            account.deposit(amount);

            System.out.println(
                Thread.currentThread().getName()
                + " deposited " + amount
            );

        } else {
            boolean success = account.withdraw(amount);

            if (success) {
                System.out.println(
                    Thread.currentThread().getName()
                    + " withdrew " + amount
                );
            } else {
                System.out.println(
                    Thread.currentThread().getName()
                    + " withdrawal failed"
                );
            }
        }
    }
}
