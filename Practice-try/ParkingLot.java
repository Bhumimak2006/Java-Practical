public class ParkingLot {

    private int twoWheelers;
    private int fourWheelers;

    private final int twoCap;
    private final int fourCap;

    private static long revenue = 0;

    public ParkingLot(int twoCap, int fourCap) {
        this.twoCap = twoCap;
        this.fourCap = fourCap;
    }

    public void park(String type) {

        if (type.equalsIgnoreCase("two")) {

            if (twoWheelers < twoCap) {
                twoWheelers++;
                revenue += 20;
                System.out.println("Two-wheeler parked");
            } else {
                System.out.println("Two-wheeler section Full");
            }

        } else if (type.equalsIgnoreCase("four")) {

            if (fourWheelers < fourCap) {
                fourWheelers++;
                revenue += 40;
                System.out.println("Four-wheeler parked");
            } else {
                System.out.println("Four-wheeler section Full");
            }

        }
    }

    public void leave(String type) {

        if (type.equalsIgnoreCase("two")) {
            if (twoWheelers > 0)
                twoWheelers--;
        } else if (type.equalsIgnoreCase("four")) {
            if (fourWheelers > 0)
                fourWheelers--;
        }
    }

    public int getTwoWheelers() {
        return twoWheelers;
    }

    public int getFourWheelers() {
        return fourWheelers;
    }

    public static long getRevenue() {
        return revenue;
    }

    public static void main(String[] args) {

        ParkingLot p = new ParkingLot(2, 2);

        p.park("two");
        p.park("two");
        p.park("two");

        p.park("four");
        p.park("four");
        p.park("four");

        p.leave("two");

        p.park("two");

        System.out.println("\nFinal Occupancy");
        System.out.println("Two Wheelers : " + p.getTwoWheelers());
        System.out.println("Four Wheelers : " + p.getFourWheelers());

        System.out.println("Revenue : ₹" + ParkingLot.getRevenue());
    }
}