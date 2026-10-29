
public class CurrentAccount extends Account {

    private long overdraftLimit;

    public CurrentAccount(
            String ownerName,
            long openingBalance,
            long overdraftLimit) {

        super(ownerName, openingBalance);

        if (overdraftLimit < 0) {
            throw new IllegalArgumentException(
                "Overdraft limit cannot be negative."
            );
        }

        this.overdraftLimit = overdraftLimit;
    }

    public CurrentAccount(String ownerName, long openingBalance) {
        this(ownerName, openingBalance, 0);
    }

    @Override
    public double interestRate() {
        return 0.0;
    }

    @Override
    public boolean canWithdraw(long amount) {
        if (amount <= 0) {
            return false;
        }

        long balance = getBalance();

        if (balance < -overdraftLimit) {
            return false;
        }

        return amount <= balance + overdraftLimit;
    }

    public long getOverdraftLimit() {
        return overdraftLimit;
    }
}
