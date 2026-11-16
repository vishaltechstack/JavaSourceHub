package Structures;

public class StringsAndStringBuilder {

    public static void main(String[] args) {

        String language = "  Core Java Programming  ";

        // 1. Common Built-in String Methods
        System.out.println("Original: '" + language + "'");
        System.out.println("Trimmed: '" + language.trim() + "'");           // Removes leading/trailing spaces
        System.out.println("Length: " + language.trim().length());         // Number of characters (21)
        System.out.println("Uppercase: " + language.trim().toUpperCase()); // CORE JAVA PROGRAMMING
        System.out.println("Substring: " + language.trim().substring(5, 9)); // Extracts "Java" (index 5 to 8)
        System.out.println("Contains 'Java': " + language.contains("Java")); // true

        // 2. Comparing Strings properly
        // NEVER use '==' for String content (it compares memory addresses).
        // ALWAYS use .equals() or .equalsIgnoreCase().
        String s1 = "Java";
        String s2 = new String("java");
        System.out.println("Exact match: " + s1.equals(s2));               // false
        System.out.println("Case-insensitive match: " + s1.equalsIgnoreCase(s2)); // true

        // 3. String Immutability vs StringBuilder (Mutable)
        String str = "Hello";
        str.concat(" World"); // Creates "Hello World" in memory, but 'str' still points to "Hello"!
        System.out.println("String after concat without reassignment: " + str); // Still "Hello"

        // StringBuilder modifies the same object in memory (fast and memory-efficient)
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(" World");
        sb.insert(5, ","); // Inserts comma at index 5 -> "Hello, World"
        sb.reverse();      // Reverses in place -> "dlroW ,olleH"
        System.out.println("StringBuilder result: " + sb.toString());
    }
}
