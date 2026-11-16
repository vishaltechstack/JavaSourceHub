package Security_Crypto;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;

public class Sha256HashingService {

    // 1. Plain SHA-256 Hash (Used for file integrity checksums & digital fingerprints)
    public static String sha256Hex(String input) {
        try {
            // Request an instance of the SHA-256 algorithm
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // Convert String to UTF-8 bytes and compute the 32-byte (256-bit) hash
            byte[] hashBytes = digest.digest(input.getBytes(StandardCharsets.UTF_8));

            // Java 17+ HexFormat cleanly converts raw bytes into a 64-character lowercase hex string
            return HexFormat.of().formatHex(hashBytes);

        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-256 algorithm unavailable", e);
        }
    }

    // 2. Salted SHA-256 Hash (Mixes random salt bytes before hashing)
    public static String hashWithSalt(String plainPassword, byte[] salt) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // Feed the random salt into the digest FIRST
            digest.update(salt);

            // Then feed the password bytes and compute final hash
            byte[] hashedBytes = digest.digest(plainPassword.getBytes(StandardCharsets.UTF_8));
            return HexFormat.of().formatHex(hashedBytes);

        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-256 algorithm unavailable", e);
        }
    }

    // 3. Constant-time comparison prevents Timing Side-Channel Attacks
    public static boolean verifySaltedHash(String candidatePassword, byte[] storedSalt, String storedHexHash) {
        String candidateHash = hashWithSalt(candidatePassword, storedSalt);
        return MessageDigest.isEqual(
                candidateHash.getBytes(StandardCharsets.UTF_8),
                storedHexHash.getBytes(StandardCharsets.UTF_8)
        );
    }
}