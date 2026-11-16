package Security_Crypto;

import javax.crypto.SecretKey;

public class SecurityCryptoRunner {

    public static void main(String[] args) throws Exception {

        // --- 1. SHA-256 Hashing & Avalanche Effect ---
        System.out.println("=== 1. SHA-256 HASHING (ONE-WAY) ===");
        String hash1 = Sha256HashingService.sha256Hex("CoreJava2026");
        String hash2 = Sha256HashingService.sha256Hex("CoreJava2027"); // Only 1 digit changed!
        System.out.println("Hash ('CoreJava2026'): " + hash1);
        System.out.println("Hash ('CoreJava2027'): " + hash2);

        // --- 2. Salted Password Hashing & Verification ---
        System.out.println("\n=== 2. SALTED PASSWORD HASHING ===");
        byte[] userSalt = SecureRandomDemo.generateSalt(16);
        String storedHash = Sha256HashingService.hashWithSalt("MySecretPass@99", userSalt);

        System.out.println("Stored Salted Hash: " + storedHash);
        System.out.println("Verify correct password: " +
                Sha256HashingService.verifySaltedHash("MySecretPass@99", userSalt, storedHash)); // true
        System.out.println("Verify wrong password:   " +
                Sha256HashingService.verifySaltedHash("WrongPass@99", userSalt, storedHash));    // false

        // --- 3. AES-256-GCM Encryption & Decryption (TWO-WAY) ---
        System.out.println("\n=== 3. AES-256-GCM SYMMETRIC ENCRYPTION ===");
        SecretKey aesKey = AesGcmEncryptionService.generateAESKey();
        String sensitiveData = "AccountNo: 9182736450 | Balance: Rs. 2,50,000";

        String encryptedBase64 = AesGcmEncryptionService.encrypt(sensitiveData, aesKey);
        System.out.println("Original Plaintext:  " + sensitiveData);
        System.out.println("Encrypted (Base64):  " + encryptedBase64);

        String decryptedText = AesGcmEncryptionService.decrypt(encryptedBase64, aesKey);
        System.out.println("Decrypted Plaintext: " + decryptedText);
    }
}