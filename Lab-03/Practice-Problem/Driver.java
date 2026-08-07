public class Driver {
    public static void main(String[] args) {
         Card[] incomming = {
                new Card("Ace", "Spades"),
                new Card("King", "Hearts"),
                new Card("Queen", "Diamonds"),
                new Card("Ace", "Spades"),
                new Card("Ten", "Clubs")
        };
    
        

        for (int i = 0; i < incomming.length; i++) {

            for (int j = 0; j < i; j++) {

                if (incomming[i].equals(incomming[j])) {
                    System.out.println("Duplicate found: " + incomming[i]);
                    return;
                }
            }

        }
    }


}
