package Memory_Tuning;

public class StringInterningAndPoolingDemo {

    public static void main(String[] args) {

        // 1. String literal is automatically placed in the String Constant Pool
        String pooledLiteral = "PRODUCTION_ENV";

        // 2. Simulating Strings read dynamically from disk/network (allocated separately on Heap)
        String dynamicHeapStr1 = new String("PRODUCTION_ENV");
        String dynamicHeapStr2 = new String("PRODUCTION_ENV");

        // Different memory addresses on the Heap!
        System.out.println("dynamicHeapStr1 == dynamicHeapStr2: " + (dynamicHeapStr1 == dynamicHeapStr2)); // false
        System.out.println("dynamicHeapStr1 == pooledLiteral:   " + (dynamicHeapStr1 == pooledLiteral));   // false

        // 3. Interning: Deduplicates dynamic Heap strings by mapping to the canonical Pool instance
        String interned1 = dynamicHeapStr1.intern();
        String interned2 = dynamicHeapStr2.intern();

        // Now all three variables point to the EXACT SAME single object in memory!
        System.out.println("\nAfter .intern():");
        System.out.println("interned1 == pooledLiteral: " + (interned1 == pooledLiteral)); // true
        System.out.println("interned1 == interned2:     " + (interned1 == interned2));     // true

        // Performance Rule of Thumb:
        // - Use .intern() ONLY for bounded, high-repetition values (country codes, status enums, config keys).
        // - NEVER .intern() unbounded user input (like UUIDs or search queries), as it bloats the String Pool!
    }
}
