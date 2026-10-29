
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class BankFileStorage {
    private static final String FILE_NAME = "accounts.txt";

    // Save accounts into file
    public static void saveAccounts(List<Account> accounts)
            throws IOException {

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (Account account : accounts) {
                String name = account.getOwnerName();
                name = name.replace("|", " ");

                writer.write(name + "|" + account.getBalance());
                writer.newLine();
            }
        }

        System.out.println("Account data saved successfully.");
    }

    // Read accounts from file
    public static void readAccounts() throws IOException {
        try (BufferedReader reader =
                     new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            System.out.println("\n--- Saved Account Data ---");

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|", 2);

                if (parts.length == 2) {
                    System.out.println(
                        "Name: " + parts[0]
                        + ", Balance: " + parts[1]
                    );
                }
            }
        }
    }

    // Load saved accounts into BankService
    public static void loadAccounts(BankService bank)
            throws IOException {

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|", 2);

                if (parts.length == 2) {
                    try {
                        String name = parts[0];
                        long balance = Long.parseLong(parts[1]);

                        if (!name.isBlank() && balance >= 0) {
                            bank.openAccount(name, balance);
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println(
                            "Skipping invalid record: " + line
                        );
                    }
                }
            }
        }
    }
}
