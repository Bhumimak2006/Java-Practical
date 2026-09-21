import java.util.*;

interface DiscountRule {
    double apply(double price);
}

public class DiscountDemo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Double> prices = Arrays.asList(
            1000.0,
            2000.0,
            500.0,
            3000.0
        );

        System.out.println("Discount Options:");
        System.out.println("1. 10% Discount");
        System.out.println("2. 20% Discount");
        System.out.println("3. No Discount");

        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        DiscountRule rule;

        if (choice == 1) {

            rule = price -> price - (price * 0.10);

        } else if (choice == 2) {

            rule = price -> price - (price * 0.20);

        } else {

            rule = price -> price;
        }

        System.out.println("\nOriginal Price -> Final Price");

        for (double price : prices) {

            double finalPrice = rule.apply(price);

            System.out.println(
                price + " -> " + finalPrice
            );
        }

        sc.close();
    }
}