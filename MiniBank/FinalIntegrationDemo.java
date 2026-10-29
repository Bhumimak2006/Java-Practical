
import java.io.File;
import java.io.IOException;

public class FinalIntegrationDemo {

    public static void main(String[] args) {

        BankService bank = new BankService();
        File dataFile = new File("accounts.txt");

        try {
            // Load previous data if the file exists
            if (dataFile.exists()) {
                BankFileStorage.loadAccounts(bank);
                System.out.println("Previous data loaded.");
            }

            // Create a sample account on the first run
            if (bank.listAccounts().isEmpty()) {
                Account account = bank.openAccount("Rahul", 5000);

                System.out.println("Account created:");
                System.out.println(account);
            }

            // Demonstrate a deposit
            Account account = bank.listAccounts().get(0);

            bank.depositSafely(
                account.getAccountNumber(), 1000
            );

            BankLogger.log(
                "Deposit completed for "
                + account.getAccountNumber()
            );

            // Save data and generate report
            BankFileStorage.saveAccounts(bank.listAccounts());
            BankReport.generate(bank);

            System.out.println("\nFinal Accounts:");

            for (Account item : bank.listAccounts()) {
                System.out.println(item);
            }

        } catch (IOException | BankException e) {
            System.out.println("Error: " + e.getMessage());

        } catch (IllegalArgumentException e) {
            System.out.println("Invalid data: " + e.getMessage());
        }
    }
}
