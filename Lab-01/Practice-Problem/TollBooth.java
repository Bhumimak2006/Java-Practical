import java.util.Scanner;
record Vehicle(String number, String type) {
}
public class TollBooth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int totalToll = 0;
        int bike = 0;
        int car = 0;
        int truck = 0;

        while (true) {

            System.out.print("Enter Vehicle Number or done: ");
            String number = sc.next();

            if (number.equalsIgnoreCase("done")) {
                break;
            }

            System.out.print("Enter Vehicle Type (bike/car/truck): ");
            String type = sc.next().toLowerCase();

            Vehicle v = new Vehicle(number, type);

            int toll = switch (v.type()) {
                case "bike" -> 20;
                case "car" -> 50;
                case "truck" -> 150;
                default -> 0;
            };
            totalToll = totalToll + toll;

            if (v.type().equals("bike")) {
                bike++;
            } else if (v.type().equals("car")) {
                car++;
            } else if (v.type().equals("truck")) {
                truck++;
            }
            System.out.println("Toll = " + toll);
            System.out.println("Total Toll = " + totalToll);
            System.out.println();
        }
        System.out.println("Total Toll = " + totalToll);

        if (bike >= car && bike >= truck) {
            System.out.println("Most Frequent : bike");
        } else if (car >= bike && car >= truck) {
            System.out.println("Most Frequent : car");
        } else {
            System.out.println("Most Frequent : truck");
        }

        sc.close();
    }
}



