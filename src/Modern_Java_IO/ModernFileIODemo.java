package Modern_Java_IO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

public class ModernFileIODemo {

    public static void main(String[] args) {

        // 1. Define a Path object (Creates 'java_notes.txt' in your project root folder)
        Path filePath = Paths.get("java_notes.txt");

        List<String> linesToWrite = Arrays.asList(
                "Day 1: Java Basics & Loops",
                "Day 2: OOP Pillars",
                "Day 3: Collections & Streams"
        );

        try {
            // 2. Writing lines to a file (Creates file if missing, overwrites if it exists)
            Files.write(filePath, linesToWrite);
            System.out.println("File written successfully at: " + filePath.toAbsolutePath());

            // 3. Appending extra text to the existing file without deleting old content
            Files.writeString(filePath, "Day 4: Modern File I/O\n", StandardOpenOption.APPEND);

            // 4. Reading all lines back from the file into a List<String>
            System.out.println("\n--- Reading File Content ---");
            List<String> readLines = Files.readAllLines(filePath);
            for (String line : readLines) {
                System.out.println(line);
            }

        } catch (IOException e) {
            // File I/O operations throw checked IOException (e.g., permission denied, disk error)
            System.out.println("File operation failed: " + e.getMessage());
        }
    }
}