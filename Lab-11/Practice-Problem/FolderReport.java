import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.FileTime;
import java.util.stream.Stream;

public class FolderReport {

    public static void main(String[] args) {

        Path folder = Paths.get("MyFolder");

        Path report = Paths.get("folder_report.txt");

        try {
            BufferedWriter writer = Files.newBufferedWriter(report);

            writer.write("===== FOLDER REPORT =====");
            writer.newLine();
            writer.newLine();

            try (Stream<Path> paths = Files.walk(folder)) {

                paths.filter(Files::isRegularFile)
                     .forEach(file -> {

                    try {
                        String name = file.getFileName().toString();

                        long size = Files.size(file);

                        FileTime modifiedTime =
                                Files.getLastModifiedTime(file);

                        writer.write("File Name: " + name);
                        writer.newLine();

                        writer.write("Size: " + size + " bytes");
                        writer.newLine();

                        writer.write("Modified Time: " + modifiedTime);
                        writer.newLine();

                        writer.newLine();

                    } catch (IOException e) {
                        System.out.println(
                            "Error reading: " + file
                        );
                    }
                });
            }

            writer.close();

            System.out.println(
                "Report created successfully: " + report
            );

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}