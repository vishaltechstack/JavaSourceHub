package Datetime_API;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class PeriodAndDurationDemo {

    public static void main(String[] args) throws InterruptedException {

        // --- 1. Period: Date-based gap (Years, Months, Days) ---
        LocalDate startDate = LocalDate.of(2024, Month.JUNE, 1);
        LocalDate currentDate = LocalDate.of(2026, Month.NOVEMBER, 14);

        Period experience = Period.between(startDate, currentDate);
        System.out.println("=== 1. PERIOD (Calendar Gap) ===");
        System.out.printf("Gap: %d Years, %d Months, %d Days\n",
                experience.getYears(), experience.getMonths(), experience.getDays());

        // Total days between two dates using ChronoUnit
        long totalDays = ChronoUnit.DAYS.between(startDate, currentDate);
        System.out.println("Total exact days elapsed: " + totalDays + " days");

        // --- 2. Duration: Time-based gap (Hours, Minutes, Seconds, Millis) ---
        System.out.println("\n=== 2. DURATION (Time Gap) ===");
        LocalTime shiftStart = LocalTime.of(9, 15);
        LocalTime shiftEnd = LocalTime.of(17, 45);

        Duration shiftDuration = Duration.between(shiftStart, shiftEnd);
        System.out.println("Shift Duration: " + shiftDuration.toHours() + " hours (" +
                shiftDuration.toMinutes() + " total minutes)");

        // Measuring code execution time using Instant + Duration
        Instant t1 = Instant.now();
        Thread.sleep(250); // Simulate task
        Instant t2 = Instant.now();

        Duration elapsed = Duration.between(t1, t2);
        System.out.println("Task execution time: " + elapsed.toMillis() + " ms");
    }
}