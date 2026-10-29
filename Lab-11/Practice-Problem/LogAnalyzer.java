import java.io.*;
import java.nio.file.*;
import java.util.*;
public class LogAnalyzer {
    public static void main(String[] args) {

        try {
            Files.write(Paths.get("log1.txt"), Arrays.asList(
                "INFO: Server started",
                "ERROR: Database connection failed",
                "INFO: User logged in"
            ));

            Files.write(Paths.get("log2.txt"), Arrays.asList(
                "INFO: File uploaded",
                "ERROR: File not found",
                "INFO: Server running",
                "ERROR: Network error"
            ));

            Files.write(Paths.get("log3.txt"), Arrays.asList(
                "INFO: Login successful",
                "INFO: Data saved",
                "WARNING: Low memory"
            ));

            Path[] files = {
                Paths.get("log1.txt"),
                Paths.get("log2.txt"),
                Paths.get("log3.txt")
            };

            String keyword = "ERROR";

            int totalLines = 0;
            int totalKeywordLines = 0;

            for (Path file : files) {

                int fileLines = 0;
                int fileKeywordLines = 0;

                System.out.println("File: " + file);

                try (BufferedReader reader = Files.newBufferedReader(file)) {

                    String line;

                    while ((line = reader.readLine()) != null) {

                        fileLines++;
                        totalLines++;

                        if (line.contains(keyword)) {
                            fileKeywordLines++;
                            totalKeywordLines++;
                        }
                    }
                }

                long size = Files.size(file);

                System.out.println("Lines: " + fileLines);
                System.out.println("Keyword lines: " + fileKeywordLines);
                System.out.println("File size: " + size + " bytes");
                System.out.println();
            }

            System.out.println("===== SUMMARY =====");
            System.out.println("Total lines: " + totalLines);
            System.out.println("Total lines containing \"" 
                               + keyword + "\": " + totalKeywordLines);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}