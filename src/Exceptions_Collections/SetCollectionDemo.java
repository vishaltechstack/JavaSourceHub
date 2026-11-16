package Exceptions_Collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetCollectionDemo {

    public static void main(String[] args) {

        // 1. HashSet: Stores ONLY unique elements; order is NOT guaranteed (uses hashing)
        Set<String> cities = new HashSet<>();
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Bengaluru");
        cities.add("Delhi"); // Duplicate ignored silently!

        System.out.println("HashSet (Unique, Unordered): " + cities);
        System.out.println("Contains Mumbai? " + cities.contains("Mumbai")); // Very fast O(1) lookup

        // 2. LinkedHashSet: Stores unique elements AND preserves insertion order
        Set<Integer> uniqueIds = new LinkedHashSet<>();
        uniqueIds.add(105);
        uniqueIds.add(101);
        uniqueIds.add(109);
        uniqueIds.add(101); // Duplicate ignored

        System.out.println("LinkedHashSet (Unique, Ordered): " + uniqueIds);
    }
}