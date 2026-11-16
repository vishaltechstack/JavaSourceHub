package Datetime_API;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;

public class LocalDateTimeDemo {

    public static void main(String[] args) {

        // --- 1. LocalDate (Date only: YYYY-MM-DD, no time, no timezone) ---
        LocalDate today = LocalDate.now();
        LocalDate independenceDay = LocalDate.of(1947, Month.AUGUST, 15);
        LocalDate parsedDate = LocalDate.parse("2026-11-14"); // Standard ISO-8601 format

        System.out.println("Today's Date: " + today);
        System.out.println("Independence Day: " + independenceDay + " (" + independenceDay.getDayOfWeek() + ")");
        System.out.println("Is 2026 a leap year? " + parsedDate.isLeapYear());

        // Immutability in action: .plusDays() returns a NEW LocalDate; 'today' never changes!
        LocalDate nextWeek = today.plusWeeks(1);
        LocalDate endOfMonth = today.with(TemporalAdjusters.lastDayOfMonth());
        LocalDate nextMonday = today.with(TemporalAdjusters.next(DayOfWeek.MONDAY));

        System.out.println("Next Week: " + nextWeek);
        System.out.println("Last Day of Current Month: " + endOfMonth);
        System.out.println("Next Monday: " + nextMonday);

        // --- 2. LocalTime (Time only: HH:mm:ss.nnn, no date, no timezone) ---
        LocalTime nowTime = LocalTime.now();
        LocalTime standupMeeting = LocalTime.of(10, 30, 0); // 10:30:00 AM

        System.out.println("\nCurrent Time: " + nowTime);
        System.out.println("Standup Meeting: " + standupMeeting);
        System.out.println("Is current time after 10:30 AM? " + nowTime.isAfter(standupMeeting));

        // --- 3. LocalDateTime (Combines Date + Time, still no timezone) ---
        LocalDateTime currentDateTime = LocalDateTime.now();
        LocalDateTime eventSchedule = LocalDateTime.of(2026, 12, 31, 23, 59, 59);

        System.out.println("\nCurrent LocalDateTime: " + currentDateTime);
        System.out.println("New Year Eve Countdown Target: " + eventSchedule);
    }
}