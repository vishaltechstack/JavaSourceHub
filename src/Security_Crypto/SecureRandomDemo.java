package Security_Crypto;

import java.security.SecureRandom;
import java.util.Base64;

public class SecureRandomDemo {

    // Creates a single reusable SecureRandom instance (thread-safe in modern Java)
    private static final SecureRandom SECURE_RANDOM = new SecureRandom();

    // 1. Generate a random cryptographic salt (16 bytes = 128 bits)
    public static byte[] generateSalt(int numBytes) {
        byte[] salt = new byte[numBytes];
        SECURE_RANDOM.nextBytes(salt); // Fills byte array with cryptographically strong random bytes
        return salt;
    }

    // 2. Generate a URL-safe random API/Session Token
    public static String generateSecureToken(int byteLength) {
        byte[] randomBytes = new byte[byteLength];
        SECURE_RANDOM.nextBytes(randomBytes);
        // Base64 URL encoder converts raw binary bytes into clean URL-safe ASCII characters
        return Base64.getUrlEncoder().withoutPadding().encodeToString(randomBytes);
    }

    // 3. Generate a 6-digit numeric OTP safely
    public static String generateNumericOTP() {
        int otp = 100_000 + SECURE_RANDOM.nextInt(900_000); // Range: 100000 to 999999
        return String.valueOf(otp);
    }

    public static void main(String[] args) {
        byte[] salt = generateSalt(16);
        System.out.println("16-Byte Salt (Base64): " + Base64.getEncoder().encodeToString(salt));
        System.out.println("32-Byte API Token:     " + generateSecureToken(32));
        System.out.println("6-Digit Secure OTP:    " + generateNumericOTP());
    }
}