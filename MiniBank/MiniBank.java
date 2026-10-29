
import java.util.Scanner;

public class MiniBank {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BankService bankService = new BankService();

        BankInfo bank = new BankInfo(
            "MiniBank",
            "Anand Branch"
        );

        System.out.println("================================");
        System.out.println("       " + bank.name());
        System.out.println("       " + bank.branch());
        System.out.println("================================");

        boolean running = true;

        while (running) {
            try {
                System.out.println("\n===== MAIN MENU =====");
                System.out.println("1. Open Account");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Transfer");
                System.out.println("5. List Accounts");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");

                if (!sc.hasNextInt()) {
                    System.out.println("Please enter a valid number.");
                    sc.nextLine();
                    continue;
                }

                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter customer name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter opening balance: ");
                        long amount = sc.nextLong();
                        sc.nextLine();

                        Account account =
                                bankService.openAccount(name, amount);

                        System.out.println("Account created successfully!");
                        System.out.println(account);
                    }

                    case 2 -> {
                        System.out.print("Enter account number: ");
                        String number = sc.nextLine();

                        System.out.print("Enter deposit amount: ");
                        long amount = sc.nextLong();
                        sc.nextLine();

                        bankService.deposit(number, amount);
                        System.out.println("Deposit successful!");
                    }

                    case 3 -> {
                        System.out.print("Enter account number: ");
                        String number = sc.nextLine();

                        System.out.print("Enter withdrawal amount: ");
                        long amount = sc.nextLong();
                        sc.nextLine();

                        bankService.withdraw(number, amount);
                        System.out.println("Withdrawal successful!");
                    }

                    case 4 -> {
                        System.out.print("Enter sender account number: ");
                        String from = sc.nextLine();

                        System.out.print("Enter receiver account number: ");
                        String to = sc.nextLine();

                        System.out.print("Enter transfer amount: ");
                        long amount = sc.nextLong();
                        sc.nextLine();

                        bankService.transfer(from, to, amount);
                        System.out.println("Transfer successful!");
                    }

                    case 5 -> bankService.listAccounts();

                    case 6 -> {
                        System.out.println(
                            "Thank you for using MiniBank!"
                        );
                        running = false;
                    }

                    default -> System.out.println(
                        "Invalid choice. Please try again."
                    );
                }

            } catch (IllegalArgumentException |
                     IllegalStateException e) {
                System.out.println("Error: " + e.getMessage());

            } catch (ArithmeticException e) {
                System.out.println("Error: Amount is too large.");

            } catch (java.util.InputMismatchException e) {
                System.out.println("Error: Please enter a valid amount.");
                sc.nextLine();
            }
        }

        sc.close();
    }
}
