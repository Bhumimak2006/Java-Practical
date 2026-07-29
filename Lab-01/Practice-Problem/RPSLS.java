import java.util.Scanner;
import java.util.Random;
enum Move {
    ROCK, PAPER, SCISSORS, LIZARD, SPOCK
}
public class RPSLS {
    public static int winner(Move a, Move b) {
        if (a == b) {
            return 0;
        }
        return switch (a) {
            case ROCK ->
                (b == Move.SCISSORS || b == Move.LIZARD) ? 1 : -1;

            case PAPER ->
                (b == Move.ROCK || b == Move.SPOCK) ? 1 : -1;

            case SCISSORS ->
                (b == Move.PAPER || b == Move.LIZARD) ? 1 : -1;

            case LIZARD ->
                (b == Move.PAPER || b == Move.SPOCK) ? 1 : -1;

            case SPOCK ->
                (b == Move.ROCK || b == Move.SCISSORS) ? 1 : -1;
        };
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int playerScore = 0;
        int computerScore = 0;

        for (int i = 1; i <= 5; i++) {
            System.out.println("Round " + i);
            System.out.print("Enter your move (ROCK, PAPER, SCISSORS, LIZARD, SPOCK): ");

            Move player = Move.valueOf(sc.next().toUpperCase());
            Move computer = Move.values()[random.nextInt(5)];

            System.out.println("Your move : " + player);
            System.out.println("Computer move : " + computer);

            int result = winner(player, computer);

            if (result == 1) {
                System.out.println("You Win ");
                playerScore++;
            }
            else if (result == -1) {
                System.out.println("Computer Wins ");
                computerScore++;
            }
            else {
                System.out.println("Round Tie");
            }
        }
        System.out.println("\nFinal Score");
        System.out.println("You : " + playerScore);
        System.out.println("Computer : " + computerScore);

        if (playerScore > computerScore) {
            System.out.println("You Win " + playerScore + "-" + computerScore);
        }
        else if (computerScore > playerScore) {
            System.out.println("Computer Wins " + computerScore + "-" + playerScore);
        }
        else {
            System.out.println("Match Tie");
        }
        sc.close();
    }
}