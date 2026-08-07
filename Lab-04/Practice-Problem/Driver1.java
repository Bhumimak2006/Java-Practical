import java.util.Scanner;

public class Driver1 {

    public static void main(String[] args) {

        String[] logs = {
                "10:05 alice Hello there",
                "10:06 bob Good morning",
                "WrongLine",
                "10:08 charlie hello everyone"
        };

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter keyword : ");
        String keyword = sc.nextLine();

        System.out.println();
        System.out.println(ChatFilterhello.filterLogs(logs, keyword));

        sc.close();
    }
}