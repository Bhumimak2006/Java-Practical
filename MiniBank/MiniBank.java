import java.util.Scanner;

enum MenuOption {

    OPEN_ACCOUNT,
    DEPOSIT,
    WITHDRAW,
    TRANSFER,
    EXIT

}
record BankInfo(String name, String branch) {}


public class MiniBank {
   public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BankInfo bank = new BankInfo("MiniBank","Anand Branch");
        System.out.println(bank);
        int choice = 0;
        
        while(choice != 5){
            

            System.out.println("1. Open Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Exit");

            System.out.print("Enter Choice : ");

            choice = sc.nextInt();

            switch(choice){
                case 1 ->
                    System.out.println("Open Account - To be implemented later");

                case 2 ->
                    System.out.println("Deposit - To be implemented later");

                case 3 ->
                    System.out.println("Withdraw - To be implemented later");

                case 4 ->
                    System.out.println("Transfer - To be implemented later");

                case 5 ->
                    System.out.println("Thank You");

                default ->
                    System.out.println("Invalid Choice");
            }
        }

        System.out.println("Thank you for using MiniBank!");
        
   } 
}

