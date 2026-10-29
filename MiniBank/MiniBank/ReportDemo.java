
import java.io.IOException;

public class ReportDemo {

    public static void main(String[] args) {

        BankService bank = new BankService();

        Account account = bank.openAccount("Rahul", 5000);

        BankLogger.log(
            "Account opened: " + account.getAccountNumber()
        );

        try {
            BankFileStorage.saveAccounts(bank.listAccounts());
            BankFileStorage.readAccounts();

        } catch (IOException e) {
            System.out.println(
                "File error: " + e.getMessage()
            );
        }
    }
}
