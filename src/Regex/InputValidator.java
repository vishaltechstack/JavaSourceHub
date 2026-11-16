package Regex;

import java.util.regex.Pattern;

public class InputValidator {

    // Pre-compile static final Patterns once at class loading for optimal performance
    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$");

    // Optional +91 or 0 prefix, followed by a digit 6-9, followed by 9 digits
    private static final Pattern INDIAN_MOBILE_PATTERN =
            Pattern.compile("^(\\+91[-\\s]?|0)?[6-9]\\d{9}$");

    // Indian PAN format: 5 uppercase letters + 4 digits + 1 uppercase letter (e.g., ABCDE1234F)
    private static final Pattern PAN_PATTERN =
            Pattern.compile("^[A-Z]{5}[0-9]{4}[A-Z]$");

    // Strong Password using Positive Lookaheads (?=...):
    // - (?=.*[a-z])       At least one lowercase letter
    // - (?=.*[A-Z])       At least one uppercase letter
    // - (?=.*\\d)         At least one digit
    // - (?=.*[@$!%*?&])   At least one special character
    // - [A-Za-z\\d@$!%*?&]{8,20}  Total length 8 to 20 allowed characters
    private static final Pattern STRONG_PASSWORD_PATTERN =
            Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}$");

    public static boolean isValidEmail(String email) {
        return email != null && EMAIL_PATTERN.matcher(email).matches();
    }

    public static boolean isValidIndianMobile(String mobile) {
        return mobile != null && INDIAN_MOBILE_PATTERN.matcher(mobile).matches();
    }

    public static boolean isValidPAN(String pan) {
        return pan != null && PAN_PATTERN.matcher(pan).matches();
    }

    public static boolean isStrongPassword(String password) {
        return password != null && STRONG_PASSWORD_PATTERN.matcher(password).matches();
    }
}