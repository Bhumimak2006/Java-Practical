
public class SavingsAccount extends Account {

    private long minBalance;
    public SavingsAccount(
            String ownerName,
            long openingBalance,
            long minBalance) {

        super(ownerName, openingBalance);

        if (minBalance < 0 || minBalance > openingBalance) {
            throw new IllegalArgumentException(
                "Minimum balance must be between 0 and opening balance."
            );
        }
        this.minBalance = minBalance;
    }
    public SavingsAccount(String ownerName, long openingBalance) {
        this(ownerName, openingBalance, 0);
    }

    @Override
    public double interestRate() {
        return 4.0;
    }
    @Override
    public boolean canWithdraw(long amount) {
        return amount > 0
                && getBalance() >= minBalance
                && amount <= getBalance() - minBalance;
    }
    public long getMinBalance() {
        return minBalance;
    }
}
