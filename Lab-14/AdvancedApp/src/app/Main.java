
package app;
import app.model.Item;
import app.service.ItemService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ItemService service = new ItemService();

        while (true) {
            System.out.println("\n--- Advanced Item App ---");
            System.out.println("1. Add Item");
            System.out.println("2. View Items");
            System.out.println("3. Save Items");
            System.out.println("4. Load Items");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();
            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter item name: ");
                        String name = sc.nextLine();
                        service.addItem(name);
                        System.out.println("Item added successfully!");
                        break;

                    case 2:
                        ArrayList<Item> items = service.getItems();

                        if (items.isEmpty()) {
                            System.out.println("No items found.");
                        } else {
                            for (Item item : items) {
                                System.out.println(item.getName());
                            }
                            System.out.println("Total items: " +
                                               service.getCount());
                        }
                        break;

                    case 3:
                        service.save("items.dat");
                        System.out.println("Items saved successfully!");
                        break;

                    case 4:
                        service.load("items.dat");
                        System.out.println("Items loaded successfully!");
                        break;

                    case 5:
                        System.out.println("Exiting application.");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("File error: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
