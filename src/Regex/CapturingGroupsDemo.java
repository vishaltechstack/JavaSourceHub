package Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CapturingGroupsDemo {

    public static void main(String[] args) {

        String serverLogs = """
                [2026-11-14 10:15:22] ERROR User:vishal_01 Code:503
                [2026-11-14 10:18:45] INFO  User:ananya99 Code:200
                """;

        // 1. Named Capturing Groups: (?<groupName>pattern)
        String logRegex = "\\[(?<date>\\d{4}-\\d{2}-\\d{2})\\s+(?<time>\\d{2}:\\d{2}:\\d{2})\\]\\s+" +
                "(?<level>[A-Z]+)\\s+User:(?<user>\\w+)\\s+Code:(?<status>\\d{3})";

        Pattern pattern = Pattern.compile(logRegex);
        Matcher matcher = pattern.matcher(serverLogs);

        System.out.println("=== Parsing Structured Server Logs ===");
        while (matcher.find()) {
            // Group 0 is always the ENTIRE matched string
            // Named groups are retrieved cleanly using matcher.group("name")
            String date = matcher.group("date");
            String level = matcher.group("level");
            String user = matcher.group("user");
            String status = matcher.group("status");

            System.out.printf("Date: %s | Level: %-5s | User: %-10s | HTTP Status: %s\n",
                    date, level, user, status);
        }

        // 2. Numbered Groups & Backreferences (Detecting repeated consecutive words)
        // \\1 refers back to whatever text Group 1 (\\b\\w+\\b) matched!
        String duplicateText = "Java is is very very powerful.";
        Pattern duplicateWordPattern = Pattern.compile("\\b(\\w+)\\s+\\1\\b", Pattern.CASE_INSENSITIVE);

        // Replace repeated words with a single occurrence ($1 refers to Group 1 in replacement)
        String cleanedText = duplicateWordPattern.matcher(duplicateText).replaceAll("$1");
        System.out.println("\nOriginal: " + duplicateText);
        System.out.println("Cleaned:  " + cleanedText);
    }
}