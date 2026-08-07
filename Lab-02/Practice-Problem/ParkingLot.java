public class ParkingLot {

    private int twoWheelers = 0;
    private int fourWheelers = 0;

    private final int twoCap;
    private final int fourCap;

    private static long revenue = 0;

    public ParkingLot(int twoCap, int fourCap) {
        this.twoCap = twoCap;
        this.fourCap = fourCap;
    }

    public void park(String type) {

        if (type.equals("two")) {

            if (twoWheelers < twoCap) {
                twoWheelers++;
                revenue += 20;
                System.out.println("Two Wheeler Parked");
            } else {
                System.out.println("Two Wheeler Section Full");
            }

        } else if (type.equals("four")) {

            if (fourWheelers < fourCap) {
                fourWheelers++;
                revenue += 40;
                System.out.println("Four Wheeler Parked");
            } else {
                System.out.println("Four Wheeler Section Full");
            }
        }
    }

    public void leave(String type) {

        if (type.equals("two")) {

            if (twoWheelers > 0) {
                twoWheelers--;
                System.out.println("Two Wheeler Left");
            }

        } else if (type.equals("four")) {

            if (fourWheelers > 0) {
                fourWheelers--;
                System.out.println("Four Wheeler Left");
            }
        }
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
        p.leave("four");

        System.out.println("\nFinal Two Wheelers : " + p.twoWheelers);
        System.out.println("Final Four Wheelers : " + p.fourWheelers);
        System.out.println("Revenue : " + revenue);
    }
}