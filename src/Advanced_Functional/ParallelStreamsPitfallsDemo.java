package Advanced_Functional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream; // Add this import
import java.util.stream.LongStream;

public class ParallelStreamsPitfallsDemo {

    public static void main(String[] args) {

        // --- 1. SAFE & FAST: Pure Stateless CPU-Bound Reduction ---
        long limit = 20_000_000L;

        long startSeq = System.currentTimeMillis();
        long seqSum = LongStream.rangeClosed(1, limit)
                .filter(n -> n % 2 == 0)
                .sum();
        long endSeq = System.currentTimeMillis();

        long startPar = System.currentTimeMillis();
        long parSum = LongStream.rangeClosed(1, limit)
                .parallel()
                .filter(n -> n % 2 == 0)
                .sum();
        long endPar = System.currentTimeMillis();

        System.out.println("Sequential Sum: " + seqSum + " (" + (endSeq - startSeq) + " ms)");
        System.out.println("Parallel Sum:   " + parSum + " (" + (endPar - startPar) + " ms)");

        // --- 2. PITFALL TO AVOID: Mutating an unsynchronized ArrayList inside parallelStream() ---
        // Fixed: Using IntStream so .boxed() returns Stream<Integer> matching List<Integer>
        List<Integer> source = IntStream.rangeClosed(1, 1000)
                .boxed()
                .collect(Collectors.toList());

        List<Integer> unsafeList = new ArrayList<>();
        source.parallelStream().forEach(unsafeList::add);
        System.out.println("\nUnsafe parallel add size (expected 1000): " + unsafeList.size());

        List<Integer> safeList = source.parallelStream()
                .map(n -> n * 2)
                .collect(Collectors.toList());
        System.out.println("Safe parallel collect size: " + safeList.size());
    }
}