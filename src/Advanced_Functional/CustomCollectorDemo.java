package Advanced_Functional;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collector;

public class CustomCollectorDemo {

    public static void main(String[] args) {

        List<String> skills = Arrays.asList("Java", "SQL", "Concurrency", "Streams");

        // 1. Custom Collector that formats a Stream<String> into "[Java | SQL | Concurrency | Streams]"
        Collector<String, StringJoiner, String> bracketJoinerCollector = Collector.of(
                // Supplier: Creates a new mutable accumulator container
                () -> new StringJoiner(" | ", "[", "]"),

                // Accumulator: Adds a single stream element into the container
                (joiner, element) -> joiner.add(element.toUpperCase()),

                // Combiner: Merges two containers (used when running in parallel streams!)
                (joiner1, joiner2) -> joiner1.merge(joiner2),

                // Finisher: Converts the accumulator container into the final return type
                StringJoiner::toString
        );

        String formattedOutput = skills.stream().collect(bracketJoinerCollector);
        System.out.println("Custom Bracket Collector Output: " + formattedOutput);

        // 2. Custom Collector calculating Average of Doubles in a single pass
        // Accumulator: double[2] where index 0 = running sum, index 1 = element count
        List<Double> scores = Arrays.asList(88.5, 92.0, 79.5, 96.0);

        Collector<Double, double[], Double> customAverageCollector = Collector.of(
                () -> new double[2],                              // Supplier
                (acc, val) -> { acc[0] += val; acc[1] += 1; },    // Accumulator
                (acc1, acc2) -> {                                 // Combiner
                    acc1[0] += acc2[0];
                    acc1[1] += acc2[1];
                    return acc1;
                },
                acc -> acc[1] == 0 ? 0.0 : acc[0] / acc[1]        // Finisher
        );

        double average = scores.stream().collect(customAverageCollector);
        System.out.println("Custom Average Collector Output: " + average);
    }
}