
public class TestAccount {

    public static void main(String[] args) {

        Account[] accounts = {
            new SavingsAccount("Rahul", 5000, 0),
            new SavingsAccount("Priya", 3000, 0),
            new SavingsAccount("Amit", 0, 0)
        };

        accounts[0].deposit(1000);
        accounts[1].deposit(500);

        accounts[0].withdraw(200);
        accounts[1].withdraw(100);

        for (Account account : accounts) {
            System.out.println(account);
        }

        System.out.println("\n===== EQUALS TEST =====");

        Account a1 = new SavingsAccount("Test", 1000, 0);
        Account a2 = a1;

        System.out.println(a1.equals(a2));

        System.out.println("\n===== INSTANCEOF TEST =====");

        Object obj = accounts[0];

        if (obj instanceof Account) {
            System.out.println("Object is an Account.");
        }
    }
}
