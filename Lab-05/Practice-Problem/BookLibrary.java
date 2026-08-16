abstract class Book {
    String title;
    int lateDays;
    Book(String title, int lateDays) {
        this.title = title;
        this.lateDays = lateDays;
    }
    abstract double lateFee();
}
class JavaBook extends Book {
    JavaBook(String title, int lateDays) {
        super(title, lateDays);
    }
    double lateFee() {
        return lateDays * 2;
    }
}
class NetworkingBook extends Book {
    NetworkingBook(String title, int lateDays) {
        super(title, lateDays);
    }
    double lateFee() {
        return lateDays * 3;
    }
}
class DSABook extends Book {
    DSABook(String title, int lateDays) {
        super(title, lateDays);
    }
    double lateFee() {
        return lateDays * 4;
    }
}
public class BookLibrary {
    public static void main(String[] args) {
        Book[] books = {
            new JavaBook("Java Programming", 3),
            new NetworkingBook("Computer Networking", 2),
            new DSABook("Data Structures and Algorithms", 4)
        };
        double totalFee = 0;
        for (Book b : books) {
            double fee = b.lateFee();
            System.out.println(b.title + " Late Fee = Rs. " + fee);
            totalFee = totalFee + fee;
        }
        System.out.println("Total Late Fee = Rs. " + totalFee);
    }
}

