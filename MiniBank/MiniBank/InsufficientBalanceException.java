
public class InsufficientBalanceException extends BankException {

    public InsufficientBalanceException() {
        super("Insufficient balance or withdrawal not allowed.");
    }
}
