package Security_Crypto;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;

public class AesGcmEncryptionService {

    private static final String TRANSFORMATION = "AES/GCM/NoPadding";
    private static final int AES_KEY_SIZE_BITS = 256; // Strong 256-bit AES key
    private static final int GCM_IV_LENGTH_BYTES = 12; // Recommended 96-bit IV for GCM
    private static final int GCM_TAG_LENGTH_BITS = 128; // 128-bit authentication tag

    // 1. Generates a brand-new 256-bit AES SecretKey
    public static SecretKey generateAESKey() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(AES_KEY_SIZE_BITS, new SecureRandom());
        return keyGen.generateKey();
    }

    // 2. Encrypts plaintext -> Returns Base64 string containing [12-byte IV + Ciphertext + Auth Tag]
    public static String encrypt(String plainText, SecretKey secretKey) throws Exception {
        // Every single encryption MUST use a fresh random IV!
        byte[] iv = new byte[GCM_IV_LENGTH_BYTES];
        new SecureRandom().nextBytes(iv);

        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        GCMParameterSpec parameterSpec = new GCMParameterSpec(GCM_TAG_LENGTH_BITS, iv);

        // Initialize Cipher in ENCRYPT_MODE with SecretKey and IV
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, parameterSpec);

        byte[] cipherText = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));

        // Prepend the 12-byte IV to the ciphertext so decrypt() knows which IV was used
        ByteBuffer byteBuffer = ByteBuffer.allocate(iv.length + cipherText.length);
        byteBuffer.put(iv);
        byteBuffer.put(cipherText);

        return Base64.getEncoder().encodeToString(byteBuffer.array());
    }

    // 3. Decrypts Base64 payload -> Extracts IV, verifies integrity tag, and returns original plaintext
    public static String decrypt(String base64Payload, SecretKey secretKey) throws Exception {
        byte[] decodedBytes = Base64.getDecoder().decode(base64Payload);

        // Extract the first 12 bytes as the IV, and the remainder as ciphertext
        ByteBuffer byteBuffer = ByteBuffer.wrap(decodedBytes);
        byte[] iv = new byte[GCM_IV_LENGTH_BYTES];
        byteBuffer.get(iv);

        byte[] cipherText = new byte[byteBuffer.remaining()];
        byteBuffer.get(cipherText);

        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        GCMParameterSpec parameterSpec = new GCMParameterSpec(GCM_TAG_LENGTH_BITS, iv);

        // Initialize Cipher in DECRYPT_MODE
        cipher.init(Cipher.DECRYPT_MODE, secretKey, parameterSpec);

        // If even 1 bit of ciphertext was tampered with, doFinal() throws AEADBadTagException!
        byte[] plainBytes = cipher.doFinal(cipherText);
        return new String(plainBytes, StandardCharsets.UTF_8);
    }
}