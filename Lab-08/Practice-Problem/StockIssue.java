import java.util.*;

class OutOfStockException extends Exception {
    private int shortfall;

    public OutOfStockException(String message, int shortfall) {
        super(message);
        this.shortfall = shortfall;
    }

    public int getShortfall() {
        return shortfall;
    }
}

class InvalidQuantityException extends Exception {
    public InvalidQuantityException(String message) {
        super(message);
    }
}

class Warehouse {
    private Map<String, Integer> stock = new HashMap<>();

    public Warehouse() {
        stock.put("Laptop", 10);
        stock.put("Mouse", 25);
        stock.put("Keyboard", 15);
    }

    public void issue(String item, int qty)
            throws OutOfStockException, InvalidQuantityException {

        if (qty <= 0) {
            throw new InvalidQuantityException(
                "Quantity must be greater than 0"
            );
        }
        if (!stock.containsKey(item)) {
            throw new OutOfStockException(
                "Item '" + item + "' is not available.", qty
            );
        }

        int available = stock.get(item);
        if (qty > available) {
            int shortfall = qty - available;

            throw new OutOfStockException(
                "Not enough stock for " + item +
                ". Available: " + available,
                shortfall
            );
        }
        stock.put(item, available - qty);

        System.out.println(
            "Issued " + qty + " " + item +
            "(s). Remaining stock: " + (available - qty)
        );
    }
}

public class StockIssue {

    public static void main(String[] args) {

        Warehouse warehouse = new Warehouse();
        String[][] requests = {
            {"Laptop", "3"},
            {"Mouse", "30"},
            {"Keyboard", "0"},
            {"Keyboard", "5"},
            {"Monitor", "2"},
            {"Laptop", "4"}
        };

        System.out.println(" STOCK ISSUE PROCESS ");

        for (String[] request : requests) {

            String item = request[0];
            int qty = Integer.parseInt(request[1]);

            System.out.println(
                "\nRequest: " + item + " - Quantity: " + qty
            );

            try {
                warehouse.issue(item, qty);

            } catch (OutOfStockException e) {
                System.out.println("Out of Stock: " + e.getMessage());
                System.out.println(
                    "Shortfall: " + e.getShortfall() + " unit(s)"
                );

            } catch (InvalidQuantityException e) {
                System.out.println(
                    "Invalid Quantity: " + e.getMessage()
                );
            }
        }

        System.out.println("\n ALL REQUESTS PROCESSED");
    }
}

