package Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexBasicsDemo {

    public static void main(String[] args) {

        String logText = "Order #4092 placed on 2026-11-14 for Rs. 1499. Backup Order #8810 queued.";

        // 1. Common Regex Tokens:
        // \\d   = Any digit (0-9)
        // \\w   = Any word character (a-z, A-Z, 0-9, _)
        // \\s   = Any whitespace (space, tab, newline)
        // +     = 1 or more times
        // *     = 0 or more times
        // ?     = 0 or 1 time (optional)
        // {n}   = Exactly n times | {n,m} = Between n and m times

        // Compile pattern to match '#' followed by exactly 4 digits
        Pattern orderIdPattern = Pattern.compile("#\\d{4}");

        // Create a Matcher bound to our target text
        Matcher matcher = orderIdPattern.matcher(logText);

        System.out.println("=== Finding All Order IDs ===");
        // .find() scans forward through the string for the next matching substring
        while (matcher.find()) {
            System.out.println("Matched: " + matcher.group() +
                    " (Start Index: " + matcher.start() +
                    ", End Index: " + matcher.end() + ")");
        }

        // 2. matches() vs find():
        // matcher.matches() checks if the ENTIRE string matches the pattern from start to end
        Pattern digitsOnly = Pattern.compile("^\\d+$"); // '^' = start of string, '$' = end of string
        System.out.println("\nIs '98765' strictly digits? " + digitsOnly.matcher("98765").matches());   // true
        System.out.println("Is '98a65' strictly digits? " + digitsOnly.matcher("98a65").matches());   // false
    }
}