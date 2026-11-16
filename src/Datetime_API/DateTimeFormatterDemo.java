package Datetime_API;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public class DateTimeFormatterDemo {

    public static void main(String[] args) {

        LocalDateTime now = LocalDateTime.of(2026, 11, 14, 20, 50, 15);

        // 1. Defining Custom Format Patterns:
        // yyyy = 4-digit year | MM = 2-digit month | MMM = short month (Nov) | MMMM = full month (November)
        // dd = 2-digit day | EEEE = full weekday | HH = 24-hr clock | hh = 12-hr clock | a = AM/PM
        DateTimeFormatter indianDateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter readableBannerFormat = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy 'at' hh:mm:ss a", Locale.ENGLISH);

        System.out.println("=== 1. Formatting Date/Time Objects ===");
        System.out.println("Default ISO Format: " + now);
        System.out.println("Indian Format:      " + now.format(indianDateFormat));
        System.out.println("Readable Banner:    " + now.format(readableBannerFormat));

        // 2. Parsing Custom Strings back into LocalDate / LocalDateTime
        System.out.println("\n=== 2. Parsing Strings into Date Objects ===");
        String userInputDate = "25-12-2026";
        LocalDate parsedChristmas = LocalDate.parse(userInputDate, indianDateFormat);
        System.out.println("Parsed LocalDate: " + parsedChristmas + " | Day: " + parsedChristmas.getDayOfWeek());

        // 3. Handling Invalid Date Strings Safely
        try {
            LocalDate.parse("31-02-2026", indianDateFormat); // February 31st does not exist!
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date rejected by parser: " + e.getMessage());
        }
    }
}