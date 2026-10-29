import java.util.*;

public class WordFrequency {
    public static void main(String[] args) {

        String paragraph = "java is easy java is powerful java is popular";

        String[] words = paragraph.toLowerCase().split("\\s+");

        HashMap<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        List<Map.Entry<String, Integer>> list =
                new ArrayList<>(map.entrySet());

        list.sort(
            Comparator.comparing(
                Map.Entry<String, Integer>::getValue
            ).reversed()
        );

   
        System.out.println("Word Frequency:");

        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(
                entry.getKey() + " : " + entry.getValue()
            );
        }
    }
}