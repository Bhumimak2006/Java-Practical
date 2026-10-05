class SeatBooking {
    int seatsLeft = 5;
    int bookedSeats = 0;

    void bookWithoutSync(String name) {
        if (seatsLeft > 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            seatsLeft--;
            bookedSeats++;
            System.out.println(name + " booked a seat.");
        } else {
            System.out.println(name + " failed. No seats left.");
        }
    }
    synchronized void book(String name) {
        if (seatsLeft > 0) {
            seatsLeft--;
            bookedSeats++;
            System.out.println(name + " booked a seat.");
        } else {
            System.out.println(name + " failed. No seats left.");
        }
    }
}
class BookingThread extends Thread {
    SeatBooking booking;
    String name;
    boolean synchronizedMode;
    BookingThread(SeatBooking booking, String name, boolean synchronizedMode) {
        this.booking = booking;
        this.name = name;
        this.synchronizedMode = synchronizedMode;
    }
    public void run() {
        if (synchronizedMode) {
            booking.book(name);
        } else {
            booking.bookWithoutSync(name);
        }
    }
}

public class SeatBookingRace {
    public static void main(String[] args) throws InterruptedException {
        SeatBooking booking1 = new SeatBooking();
        Thread[] threads1 = new Thread[10];
        System.out.println("WITHOUT SYNCHRONIZATION:");
        for (int i = 0; i < 10; i++) {
            threads1[i] = new BookingThread(
                    booking1,
                    "Customer-" + (i + 1),
                    false
            );
            threads1[i].start();
        }
        for (int i = 0; i < 10; i++) {
            threads1[i].join();
        }
        System.out.println("Seats Left   : " + booking1.seatsLeft);
        System.out.println("Total Booked : " + booking1.bookedSeats);
        SeatBooking booking2 = new SeatBooking();
        Thread[] threads2 = new Thread[10];
        System.out.println("\nWITH SYNCHRONIZATION:");
        for (int i = 0; i < 10; i++) {
            threads2[i] = new BookingThread(
                    booking2,
                    "Customer-" + (i + 1),
                    true
            );
            threads2[i].start();
        }
        for (int i = 0; i < 10; i++) {
            threads2[i].join();
        }
        System.out.println("Seats Left   : " + booking2.seatsLeft);
        System.out.println("Total Booked : " + booking2.bookedSeats);
    }
}
