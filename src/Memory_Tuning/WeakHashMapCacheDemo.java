package Memory_Tuning;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

class SessionKey {
    private final String sessionId;

    public SessionKey(String sessionId) {
        this.sessionId = sessionId;
    }

    @Override
    public String toString() {
        return "SessionKey[" + sessionId + "]";
    }
}

public class WeakHashMapCacheDemo {

    public static void main(String[] args) throws InterruptedException {

        // 1. Standard HashMap (Holds Strong References to keys -> Potential Memory Leak)
        Map<SessionKey, String> strongMap = new HashMap<>();
        SessionKey key1 = new SessionKey("S-101");
        strongMap.put(key1, "User Vishal Profile");

        // 2. WeakHashMap (Holds Weak References to keys -> Auto-evicts unused keys on GC)
        Map<SessionKey, String> weakMap = new WeakHashMap<>();
        SessionKey key2 = new SessionKey("S-202");
        weakMap.put(key2, "User Rohan Profile");

        // Nullify both external strong references
        key1 = null;
        key2 = null;

        // Trigger Garbage Collection
        System.gc();
        Thread.sleep(100); // Give background GC thread a brief moment to clean up

        // Standard HashMap STILL retains S-101 in memory!
        System.out.println("Standard HashMap size after key=null & GC: " + strongMap.size()); // 1

        // WeakHashMap automatically evicted S-202 once external strong reference disappeared!
        System.out.println("WeakHashMap size after key=null & GC:      " + weakMap.size());   // 0
    }
}