package Reflection_Serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationDemo {

    public static void main(String[] args) {

        String fileName = "user_session.ser";

        // 1. Create a live object in Heap memory
        UserSession originalSession = new UserSession("Vishal_Sharma", "ADMIN", "SuperSecret@2026");
        System.out.println("Before Serialization: " + originalSession);

        // 2. SERIALIZATION (Object -> Byte Stream saved to file)
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(originalSession);
            System.out.println("Object serialized successfully to " + fileName);
        } catch (IOException e) {
            System.out.println("Serialization error: " + e.getMessage());
        }

        // 3. DESERIALIZATION (Byte Stream -> Reconstructed Object in Heap)
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            // readObject() returns Object, so we cast it back to UserSession
            UserSession restoredSession = (UserSession) in.readObject();

            System.out.println("\nAfter Deserialization: " + restoredSession);
            // Notice 'sessionPassword' is now 'null' because it was marked 'transient'!
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Deserialization error: " + e.getMessage());
        }
    }
}