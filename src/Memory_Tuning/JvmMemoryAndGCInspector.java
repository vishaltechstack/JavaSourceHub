package Memory_Tuning;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.util.List;

public class JvmMemoryAndGCInspector {

    private static double bytesToMB(long bytes) {
        return bytes / (1024.0 * 1024.0);
    }

    public static void main(String[] args) {

        // 1. Inspect Available CPU Cores & Runtime Memory
        Runtime runtime = Runtime.getRuntime();
        System.out.println("=== 1. JVM Hardware & Runtime Heap ===");
        System.out.println("Available CPU Cores: " + runtime.availableProcessors());
        System.out.printf("Max Heap (-Xmx):     %.2f MB\n", bytesToMB(runtime.maxMemory()));
        System.out.printf("Allocated Heap:      %.2f MB\n", bytesToMB(runtime.totalMemory()));
        System.out.printf("Free in Allocated:   %.2f MB\n", bytesToMB(runtime.freeMemory()));

        // 2. Inspect Detailed Heap vs. Non-Heap (Metaspace) Usage via MemoryMXBean
        MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage heapUsage = memoryBean.getHeapMemoryUsage();
        MemoryUsage nonHeapUsage = memoryBean.getNonHeapMemoryUsage();

        System.out.println("\n=== 2. JMX Memory Breakdown ===");
        System.out.printf("Heap Used:           %.2f MB / %.2f MB\n",
                bytesToMB(heapUsage.getUsed()), bytesToMB(heapUsage.getMax()));
        System.out.printf("Non-Heap (Metaspace): %.2f MB\n", bytesToMB(nonHeapUsage.getUsed()));

        // 3. Inspect Active Garbage Collectors (e.g., G1 Young Generation / G1 Old Generation)
        System.out.println("\n=== 3. Active Garbage Collectors ===");
        List<GarbageCollectorMXBean> gcBeans = ManagementFactory.getGarbageCollectorMXBeans();
        for (GarbageCollectorMXBean gc : gcBeans) {
            System.out.println("GC Name: " + gc.getName() +
                    " | Collections: " + gc.getCollectionCount() +
                    " | Time Spent: " + gc.getCollectionTime() + " ms");
        }
    }
}