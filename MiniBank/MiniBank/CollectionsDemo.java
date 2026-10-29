
import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.Queue;

public class CollectionsDemo {

    public static void main(String[] args) {

        // 1. List: Stores multiple customer names
        List<String> customers = new ArrayList<>();

        customers.add("Rahul");
        customers.add("Priya");
        customers.add("Amit");

        System.out.println("Customer List: " + customers);

        // 2. Set: Stores unique account types
        Set<String> accountTypes = new HashSet<>();

        accountTypes.add("Savings");
        accountTypes.add("Current");
        accountTypes.add("Savings");

        System.out.println("Account Types: " + accountTypes);

        // 3. Map: Stores account number and balance
        Map<String, Long> balances = new HashMap<>();

        balances.put("AC1001", 5000L);
        balances.put("AC1002", 8000L);
        balances.put("AC1003", 3000L);

        System.out.println("Account Balances: " + balances);
        System.out.println(
            "Balance of AC1001: " + balances.get("AC1001")
        );

        // 4. Queue: Stores pending transactions
        Queue<String> transactions = new LinkedList<>();

        transactions.offer("Deposit 1000");
        transactions.offer("Withdraw 500");
        transactions.offer("Transfer 200");

        System.out.println("Pending Transactions: " + transactions);

        String nextTransaction = transactions.poll();

        System.out.println("Processed Transaction: " + nextTransaction);
        System.out.println("Remaining Transactions: " + transactions);
    }
}
