
import java.util.Scanner;

public class TestValidation {

    public static void main(String[] args) {

        System.out.println("===== VALIDATOR TEST =====");

        System.out.println(
            "Valid Mobile: " +
            Validator.isValidMobile("9876543210")
        );

        System.out.println(
            "Invalid Mobile: " +
            Validator.isValidMobile("12345")
        );

        System.out.println(
            "Valid Email: " +
            Validator.isValidEmail("user@gmail.com")
        );

        System.out.println(
            "Invalid Email: " +
            Validator.isValidEmail("usergmail.com")
        );

        System.out.println(
            "Valid PAN: " +
            Validator.isValidPan("ABCDE1234F")
        );

        System.out.println(
            "Invalid PAN: " +
            Validator.isValidPan("ABC123")
        );

        System.out.println(
            "Valid IFSC: " +
            Validator.isValidIfsc("SBIN0001234")
        );

        System.out.println(
            "Invalid IFSC: " +
            Validator.isValidIfsc("123")
        );

        System.out.println("\n===== COMMAND PARSER TEST =====");

        Command command =
                CommandParser.parse("DEPOSIT AC0001 500");

        System.out.println("Type: " + command.type());
        System.out.println("Account: " + command.accountNumber());
        System.out.println("Amount: " + command.amount());

        System.out.println("\n===== STATEMENT TEST =====");

        Account account = new SavingsAccount("Rahul", 5000, 0);

        System.out.println(
            StatementFormatter.buildStatement(account)
        );
    }
}
