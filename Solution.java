import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextLine()) return;
        String line = sc.nextLine();
        
        if (!sc.hasNextLine()) return;
        String keyword = sc.nextLine().trim();

        String[] rawWords = line.trim().split("\\s+");

        StringBuilder formattedSentence = new StringBuilder();
        StringBuilder acronym = new StringBuilder();

        String longestWord = "";
        int keywordCount = 0;

        for (int i = 0; i < rawWords.length; i++) {
            String word = rawWords[i];

            String titleCasedWord = Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase();

            formattedSentence.append(titleCasedWord);
            if (i < rawWords.length - 1) {
                formattedSentence.append(" ");
            }

            acronym.append(Character.toUpperCase(word.charAt(0)));

            if (titleCasedWord.length() > longestWord.length()) {
                longestWord = titleCasedWord;
            }

            if (word.equalsIgnoreCase(keyword)) {
                keywordCount++;
            }
        }

        System.out.println("Formatted: " + formattedSentence.toString());
        System.out.println("Words: " + rawWords.length);
        System.out.println("Longest word: " + longestWord);
        System.out.println("Keyword count: " + keywordCount);
        System.out.println("Acronym: " + acronym.toString());

        sc.close();
    }
}