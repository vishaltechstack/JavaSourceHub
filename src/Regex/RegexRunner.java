package Regex;

public class RegexRunner {

    public static void main(String[] args) {

        System.out.println("=== 1. Real-World Input Validation ===");
        System.out.println("Email 'vishal.dev@gmail.com' valid? " +
                InputValidator.isValidEmail("vishal.dev@gmail.com")); // true
        System.out.println("Email 'vishal@.com' valid?          " +
                InputValidator.isValidEmail("vishal@.com"));          // false

        System.out.println("\nMobile '+91-9876543210' valid?      " +
                InputValidator.isValidIndianMobile("+91-9876543210")); // true
        System.out.println("Mobile '1234567890' valid?          " +
                InputValidator.isValidIndianMobile("1234567890"));     // false (starts with 1)

        System.out.println("\nPAN 'ABCDE1234F' valid?             " +
                InputValidator.isValidPAN("ABCDE1234F")); // true
        System.out.println("PAN 'abcde1234f' valid?             " +
                InputValidator.isValidPAN("abcde1234f")); // false (lowercase)

        System.out.println("\nPassword 'Java@2026' strong?        " +
                InputValidator.isStrongPassword("Java@2026")); // true
        System.out.println("Password 'java2026' strong?         " +
                InputValidator.isStrongPassword("java2026"));  // false (no uppercase or special char)

        // 2. Masking Sensitive Data (Keeping only last 4 digits of a card number)
        System.out.println("\n=== 2. Data Masking with Regex ===");
        String rawCard = "Card Number: 4532-8910-4421-9876";
        String maskedCard = rawCard.replaceAll("\\d{4}-\\d{4}-\\d{4}-(\\d{4})", "XXXX-XXXX-XXXX-$1");
        System.out.println(maskedCard); // Card Number: XXXX-XXXX-XXXX-9876
    }
}
