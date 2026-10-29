
public interface TransactionOperations {

    boolean deposit(String accountNumber, long amount);

    boolean withdraw(String accountNumber, long amount);

    boolean transfer(String fromAccount, String toAccount, long amount);
}
