public class CinemaShow {

    private String title;
    private int seatsAvailable;
    private final int capacity;
    private static int totalBooked = 0;

    // Constructor
    public CinemaShow(String title, int capacity) {
        this.title = title;
        this.capacity = capacity;
        this.seatsAvailable = capacity;
    }

    // Constructor Chaining
    public CinemaShow(String title) {
        this(title, 100);
    }

    // Book Seats
    public boolean book(int n) {
        if (n <= seatsAvailable) {
            seatsAvailable -= n;
            totalBooked += n;
            return true;
        } else {
            return false;
        }
    }

    // Cancel Seats
    public void cancel(int n) {
        seatsAvailable += n;

        if (seatsAvailable > capacity) {
            seatsAvailable = capacity;
        }
    }

    // Getter
    public int getSeatsAvailable() {
        return seatsAvailable;
    }

    // Static Getter
    public static int getTotalBooked() {
        return totalBooked;
    }

    // Main Method
    public static void main(String[] args) {

        CinemaShow show = new CinemaShow("Avengers", 100);

        System.out.println("Book 20 : " + show.book(20));
        System.out.println("Seats Left : " + show.getSeatsAvailable());

        System.out.println();

        System.out.println("Book 50 : " + show.book(50));
        System.out.println("Seats Left : " + show.getSeatsAvailable());

        System.out.println();

        System.out.println("Book 40 : " + show.book(40));
        System.out.println("Seats Left : " + show.getSeatsAvailable());

        System.out.println();

        show.cancel(10);
        System.out.println("After Cancel : " + show.getSeatsAvailable());

        System.out.println();

        System.out.println("Total Booked : " + CinemaShow.getTotalBooked());
    }
}
