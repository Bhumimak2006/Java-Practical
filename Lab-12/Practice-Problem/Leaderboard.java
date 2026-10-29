import java.util.*;

public class Leaderboard {
    public static void main(String[] args) {

        Map<String, Integer> scores = new HashMap<>();

        scores.put("Riya", 95);
        scores.put("Bhumi", 98);
        scores.put("Amit", 90);
        scores.put("Neha", 95);
        scores.put("Jay", 85);

        List<Map.Entry<String, Integer>> players =
                new ArrayList<>(scores.entrySet());

        players.sort(
            Comparator
                .<Map.Entry<String, Integer>>
                    comparingInt(Map.Entry::getValue)
                .reversed()
                .thenComparing(Map.Entry::getKey)
        );

        int topN = 3;

        System.out.println("Top " + topN + " Players:");

        for (int i = 0; i < topN && i < players.size(); i++) {
            Map.Entry<String, Integer> player = players.get(i);

            System.out.println(
                player.getKey() + " : " + player.getValue()
            );
        }
    }
}