
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BankReport {

    public static void generate(BankService bank)
            throws IOException {

        try (BufferedWriter writer =
                new BufferedWriter(new FileWriter("report.txt"))) {

            writer.write("========== MINIBANK REPORT ==========");
            writer.newLine();
            writer.write("Total Accounts: "
                    + bank.listAccounts().size());
            writer.newLine();
            writer.newLine();

            for (Account account : bank.listAccounts()) {
                writer.write(account.toString());
                writer.newLine();
            }

            writer.write("========== END OF REPORT ==========");
        }

        System.out.println("Report saved to report.txt");
    }
}
