package Memory_Tuning;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

class LargePayload {
    private final String id;
    private final byte[] buffer = new byte[1024 * 1024]; // 1 MB simulated payload

    public LargePayload(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}

public class ReferenceTypesDemo {

    public static void main(String[] args) {

        // --- 1. STRONG REFERENCE (Default) ---
        LargePayload strongRef = new LargePayload("Strong-Data");
        System.gc();
        // Still alive because 'strongRef' strongly points to it
        System.out.println("1. Strong Ref after GC: " + (strongRef != null ? strongRef.getId() : "Cleared"));

        // --- 2. SOFT REFERENCE (Memory-Sensitive Cache) ---
        LargePayload tempForSoft = new LargePayload("Soft-Cached-Data");
        SoftReference<LargePayload> softRef = new SoftReference<>(tempForSoft);
        tempForSoft = null; // Remove strong reference; ONLY softRef remains

        System.gc();
        // Since Heap still has plenty of free RAM, GC keeps SoftReference alive!
        LargePayload retrievedSoft = softRef.get();
        System.out.println("2. Soft Ref after normal GC: " +
                (retrievedSoft != null ? retrievedSoft.getId() + " (Retained in cache)" : "Cleared"));

        // --- 3. WEAK REFERENCE (Eagerly Reclaimed on Next GC) ---
        LargePayload tempForWeak = new LargePayload("Weak-Metadata");
        WeakReference<LargePayload> weakRef = new WeakReference<>(tempForWeak);
        tempForWeak = null; // Remove strong reference; ONLY weakRef remains

        System.out.println("3a. Weak Ref BEFORE GC: " +
                (weakRef.get() != null ? weakRef.get().getId() : "Cleared"));

        System.gc(); // Triggers GC; WeakReference is reclaimed immediately!

        System.out.println("3b. Weak Ref AFTER GC:  " +
                (weakRef.get() != null ? weakRef.get().getId() : "Cleared by GC (null)"));
    }
}