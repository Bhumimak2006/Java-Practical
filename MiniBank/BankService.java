
import java.util.ArrayList;
import java.util.List;

@BankFeature("Core banking operations")
public class BankService implements TransactionOperations {

    private final List<Account> accounts = new ArrayList<>();

    // Open a new account
    public Account openAccount(String name, long openingBalance) {

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "Name cannot be empty."
            );
        }

        if (openingBalance < 0) {
            throw new IllegalArgumentException(
                "Opening balance cannot be negative."
            );
        }

        Account account =
            new SavingsAccount(name, openingBalance, 0);

        accounts.add(account);

        return account;
    }

    // Find an account using account number
    public Account findAccount(String accountNumber) {

        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }

        return null;
    }

    // Normal deposit method
    @Override
    public boolean deposit(String accountNumber, long amount) {

        Account account = findAccount(accountNumber);

        if (account == null || amount <= 0) {
            return false;
        }

        account.deposit(amount);
        return true;
    }

    // Normal withdrawal method
    @Override
    public boolean withdraw(String accountNumber, long amount) {

        Account account = findAccount(accountNumber);

        if (account == null || amount <= 0) {
            return false;
        }

        return account.withdraw(amount);
    }

    // Normal transfer method
    @Override
    public boolean transfer(
            String fromAccount,
            String toAccount,
            long amount) {

        if (amount <= 0) {
            return false;
        }

        Account source = findAccount(fromAccount);
        Account destination = findAccount(toAccount);

        if (source == null || destination == null) {
            return false;
        }

        if (source == destination) {
            return false;
        }

        if (!source.withdraw(amount)) {
            return false;
        }

        try {
            destination.deposit(amount);
            return true;

        } catch (RuntimeException e) {
            source.deposit(amount);
            return false;
        }
    }

    // Return a copy of all accounts
    public List<Account> listAccounts() {
        return new ArrayList<>(accounts);
    }

    // Safe deposit with custom exceptions
    public void depositSafely(
            String accountNumber, long amount)
            throws BankException {

        if (amount <= 0) {
            throw new InvalidAmountException();
        }

        Account account = findAccount(accountNumber);

        if (account == null) {
            throw new AccountNotFoundException(accountNumber);
        }

        account.deposit(amount);
    }

    // Safe withdrawal with custom exceptions
    public void withdrawSafely(
            String accountNumber, long amount)
            throws BankException {

        if (amount <= 0) {
            throw new InvalidAmountException();
        }

        Account account = findAccount(accountNumber);

        if (account == null) {
            throw new AccountNotFoundException(accountNumber);
        }

        if (!account.withdraw(amount)) {
            throw new InsufficientBalanceException();
        }
    }

    // Safe transfer with custom exceptions
    public void transferSafely(
            String fromAccount,
            String toAccount,
            long amount) throws BankException {

        if (amount <= 0) {
            throw new InvalidAmountException();
        }

        Account source = findAccount(fromAccount);
        Account destination = findAccount(toAccount);

        if (source == null) {
            throw new AccountNotFoundException(fromAccount);
        }

        if (destination == null) {
            throw new AccountNotFoundException(toAccount);
        }

        if (source == destination) {
            throw new BankException(
                "Source and destination accounts must be different."
            );
        }

        if (!source.withdraw(amount)) {
            throw new InsufficientBalanceException();
        }

        try {
            destination.deposit(amount);

        } catch (RuntimeException e) {
            source.deposit(amount);

            throw new BankException(
                "Transfer failed. Amount was returned to source account."
            );
        }
    }
}
