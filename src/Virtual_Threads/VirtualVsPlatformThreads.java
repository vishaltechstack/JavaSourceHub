package Virtual_Threads;

public class VirtualVsPlatformThreads {

    public static void main(String[] args) throws InterruptedException {

        // 1. Traditional Platform Thread (OS-backed, heavy stack)
        Thread platformThread = Thread.ofPlatform()
                .name("My-Platform-Thread")
                .start(() -> {
                    System.out.println("Running on: " + Thread.currentThread());
                    System.out.println("Is Virtual? " + Thread.currentThread().isVirtual()); // false
                });
        platformThread.join();

        System.out.println("--------------------------------------------------");

        // 2. Java 21 Virtual Thread (JVM-managed, ultra-lightweight)
        // Note: Virtual threads are ALWAYS daemon threads by default!
        Thread virtualThread = Thread.ofVirtual()
                .name("My-Virtual-Thread")
                .start(() -> {
                    // Prints: VirtualThread[#22,My-Virtual-Thread]/runnable@ForkJoinPool-1-worker-1
                    // Notice the carrier OS thread ('ForkJoinPool-1-worker-1') carrying it!
                    System.out.println("Running on: " + Thread.currentThread());
                    System.out.println("Is Virtual? " + Thread.currentThread().isVirtual()); // true
                });

        // Must call .join() on virtual threads so main() doesn't exit early (since they are daemon threads)
        virtualThread.join();

        // 3. Quick One-Liner Shorthand to launch an unnamed Virtual Thread
        Thread quickVT = Thread.startVirtualThread(() ->
                System.out.println("Quick Virtual Thread executed! Is Virtual: " + Thread.currentThread().isVirtual())
        );
        quickVT.join();
    }
}