package Modern_Java_IO;

import java.util.Optional;

public class OptionalDemo {

    // Method returning Optional instead of raw String (signals that user might not exist)
    public static Optional<String> findUsernameById(int id) {
        if (id == 101) {
            return Optional.of("Vishal_Sharma"); // Wraps a guaranteed non-null value
        }
        return Optional.empty(); // Explicitly represents "no value found"
    }

    public static void main(String[] args) {

        // Case 1: Value is present
        Optional<String> user1 = findUsernameById(101);
        user1.ifPresent(name -> System.out.println("Found User: " + name));

        // Case 2: Value is missing (Safe fallback without NullPointerException!)
        Optional<String> user2 = findUsernameById(999);

        // orElse() provides a default value if Optional is empty
        String result = user2.orElse("Guest_User");
        System.out.println("Lookup ID 999 returned: " + result);

        // Transforming inside Optional safely using map()
        String upperName = findUsernameById(101)
                .map(String::toUpperCase)
                .orElse("UNKNOWN");
        System.out.println("Uppercase Name: " + upperName);
    }
}