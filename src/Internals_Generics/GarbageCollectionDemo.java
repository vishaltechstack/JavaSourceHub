package Internals_Generics;

class TemporaryResource {
    private String resourceName;

    public TemporaryResource(String resourceName) {
        this.resourceName = resourceName;
        System.out.println("Allocated on Heap: " + resourceName);
    }

    public String getResourceName() {
        return resourceName;
    }
}

public class GarbageCollectionDemo {

    public static void main(String[] args) {

        // Way 1: Nullifying a reference
        TemporaryResource r1 = new TemporaryResource("Cache-Buffer-1");
        r1 = null; // "Cache-Buffer-1" on Heap now has 0 references -> Eligible for GC!

        // Way 2: Reassigning a reference to another object
        TemporaryResource r2 = new TemporaryResource("Session-Token-A");
        TemporaryResource r3 = new TemporaryResource("Session-Token-B");
        r2 = r3; // "Session-Token-A" is now orphaned on Heap -> Eligible for GC!

        // Way 3: Objects created inside a method go out of scope once the method returns
        createLocalObject();

        // Requesting JVM to run Garbage Collection (Note: It is a suggestion, not a guarantee)
        System.gc();
        System.out.println("GC requested. Unreachable Heap objects will be reclaimed automatically.");
    }

    private static void createLocalObject() {
        TemporaryResource local = new TemporaryResource("Temp-Method-Object");
        System.out.println("Inside method using: " + local.getResourceName());
    } // 'local' Stack reference is destroyed here -> Heap object becomes eligible for GC
}