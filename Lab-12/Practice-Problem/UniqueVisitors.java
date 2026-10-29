import java.util.*;

public class UniqueVisitors {
    public static void main(String[] args) {

        List<String> logins = Arrays.asList(
            "Bhumi", "Riya", "Amit", "Bhumi",
            "Neha", "Riya", "Jay"
        );

        HashSet<String> users = new HashSet<>(logins);
        LinkedHashSet<String> orderedUsers =
                new LinkedHashSet<>(logins);
        System.out.println("Unique users count: " + users.size());

        System.out.println("First three distinct users:");

        int count = 0;
        for (String user : orderedUsers) {
            if (count == 3) {
                break;
            }

            System.out.println(user);
            count++;
        }
    }
}