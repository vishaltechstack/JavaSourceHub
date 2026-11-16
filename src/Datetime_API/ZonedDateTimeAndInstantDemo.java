package Datetime_API;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZonedDateTimeAndInstantDemo {

    public static void main(String[] args) {

        // 1. Instant: Machine-readable UTC timestamp (Timezone-independent point on timeline)
        Instant utcNow = Instant.now();
        System.out.println("Current UTC Instant: " + utcNow); // Ends with 'Z' (Zulu / UTC)
        System.out.println("Epoch Seconds: " + utcNow.getEpochSecond());

        // 2. ZonedDateTime: Human-readable date/time tied to a specific geographical region
        ZoneId indiaZone = ZoneId.of("Asia/Kolkata");
        ZoneId newYorkZone = ZoneId.of("America/New_York");
        ZoneId londonZone = ZoneId.of("Europe/London");

        ZonedDateTime indiaTime = ZonedDateTime.now(indiaZone);

        // Converting the EXACT SAME instant in time across global timezones!
        ZonedDateTime newYorkTime = indiaTime.withZoneSameInstant(newYorkZone);
        ZonedDateTime londonTime = indiaTime.withZoneSameInstant(londonZone);

        System.out.println("\n--- Global Timezone Conversion ---");
        System.out.println("India (IST):    " + indiaTime);
        System.out.println("London (GMT):   " + londonTime);
        System.out.println("New York (EST): " + newYorkTime);

        // 3. Converting between Instant and ZonedDateTime
        ZonedDateTime fromInstant = utcNow.atZone(indiaZone);
        Instant backToInstant = fromInstant.toInstant();
        System.out.println("\nInstant converted to IST: " + fromInstant);
        System.out.println("Converted back to Instant: " + backToInstant);
    }
}