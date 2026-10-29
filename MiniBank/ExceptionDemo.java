
public class ExceptionDemo {

    public static void main(String[] args) {

        BankService bank = new BankService();

        Account account = bank.openAccount("Rahul", 5000);

        System.out.println("Account created successfully.");
        System.out.println(account);

        try {
            bank.withdrawSafely(
                account.getAccountNumber(), 100000
            );
        } catch (BankException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            bank.depositSafely(
                "AC9999", 1000
            );
        } catch (BankException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            bank.depositSafely(
                account.getAccountNumber(), -500
            );
        } catch (BankException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
