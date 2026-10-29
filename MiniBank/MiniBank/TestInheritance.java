
public class TestInheritance {

    public static void main(String[] args) {

        Account[] accounts = {
            new SavingsAccount("Rahul", 10000, 2000),
            new CurrentAccount("Priya", 5000, 3000),
            new FixedDepositAccount("Amit", 20000)
        };

        for (Account account : accounts) {
            System.out.println(account);
            System.out.println(
                "Interest Rate: " + account.interestRate() + "%"
            );

            if (account instanceof SavingsAccount savings) {
                System.out.println(
                    "Minimum Balance: Rs. " + savings.getMinBalance()
                );
            }

            System.out.println("-----------------------------");
        }

        System.out.println("===== WITHDRAWAL TEST =====");

        Account savings = accounts[0];

        System.out.println(
            "Withdraw Rs. 9000 from savings: "
            + savings.withdraw(9000)
        );

        Account current = accounts[1];

        System.out.println(
            "Withdraw Rs. 7000 from current: "
            + current.withdraw(7000)
        );

        Account fixedDeposit = accounts[2];

        System.out.println(
            "Withdraw from fixed deposit: "
            + fixedDeposit.withdraw(1000)
        );
    }
}
