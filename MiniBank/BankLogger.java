
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class BankLogger {

    public static void log(String message) {

        try (FileWriter writer =
                new FileWriter("bank.log", true)) {

            writer.write(
                LocalDateTime.now() + " - " + message
                + System.lineSeparator()
            );

        } catch (IOException e) {
            System.out.println(
                "Unable to write log: " + e.getMessage()
            );
        }
    }
}
