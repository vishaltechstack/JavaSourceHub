package Advanced_Functional;

import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionCompositionAndCurrying {

    public static void main(String[] args) {

        // 1. Function Composition: andThen() vs compose()
        Function<Integer, Integer> multiplyBy2 = x -> x * 2;
        Function<Integer, Integer> add10 = x -> x + 10;

        // andThen: Executes multiplyBy2 FIRST, then passes result to add10 -> (5 * 2) + 10 = 20
        Function<Integer, Integer> multiplyThenAdd = multiplyBy2.andThen(add10);

        // compose: Executes add10 FIRST, then passes result to multiplyBy2 -> (5 + 10) * 2 = 30
        Function<Integer, Integer> addThenMultiply = multiplyBy2.compose(add10);

        System.out.println("andThen(5): " + multiplyThenAdd.apply(5)); // 20
        System.out.println("compose(5): " + addThenMultiply.apply(5)); // 30

        // 2. Predicate Composition (Combining boolean rules declaratively)
        Predicate<String> notNull = s -> s != null;
        Predicate<String> minLength5 = s -> s.length() >= 5;
        Predicate<String> startsWithJ = s -> s.startsWith("J");

        Predicate<String> validJavaToken = notNull.and(minLength5).and(startsWithJ);

        System.out.println("\nIs 'Java21' valid? " + validJavaToken.test("Java21")); // true
        System.out.println("Is 'Java' valid?   " + validJavaToken.test("Java"));   // false (length 4)

        // 3. Currying (Partial Application of Arguments)
        // A function taking taxRate and returning ANOTHER function that takes basePrice
        Function<Double, Function<Double, Double>> taxCalculator =
                taxRate -> price -> price + (price * taxRate);

        // Specialize reusable functions for different tax slabs
        Function<Double, Double> applyGST18 = taxCalculator.apply(0.18);
        Function<Double, Double> applyGST5  = taxCalculator.apply(0.05);

        System.out.println("\nRs. 1000 with 18% GST: Rs. " + applyGST18.apply(1000.0));
        System.out.println("Rs. 1000 with 5% GST:  Rs. " + applyGST5.apply(1000.0));
    }
}