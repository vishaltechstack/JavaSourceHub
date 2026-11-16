package Modern_Java17_21;

public class PatternMatchingDemo {

    // 1. Pattern Matching for 'instanceof' (Java 16+)
    public static void inspectObject(Object obj) {
        // Old way: if (obj instanceof String) { String s = (String) obj; ... }
        // Modern way: Type check AND variable binding ('str') happen in one step!
        if (obj instanceof String str && str.length() > 3) {
            System.out.println("Long String in uppercase: " + str.toUpperCase());
        } else if (obj instanceof Integer num) {
            System.out.println("Integer squared: " + (num * num));
        } else {
            System.out.println("Other object: " + obj);
        }
    }

    // 2. Pattern Matching for 'switch' + Record Patterns (Java 21 LTS!)
    public static String processPayment(PaymentMethod method) {
        // Because PaymentMethod is 'sealed', the compiler knows ALL possible subtypes.
        // We can also unpack record fields directly inside the case pattern!
        return switch (method) {
            case CreditCard(String cardNum, double limit) ->
                    "Paid via Credit Card ending in " + cardNum.substring(cardNum.length() - 4) +
                            " (Limit: Rs. " + limit + ")";

            case DebitCard(String bank, double bal) when bal >= 500 -> // Guarded pattern ('when')
                    "Paid via " + bank + " Debit Card (Sufficient Balance: Rs. " + bal + ")";

            case DebitCard(String bank, double bal) ->
                    "Declined " + bank + " Debit Card: Low balance (Rs. " + bal + ")";

            case Cash(double amount) ->
                    "Accepted Cash payment of Rs. " + amount;
            // Notice: NO 'default' branch required! Exhaustiveness is verified at compile time.
        };
    }

    public static void main(String[] args) {

        // Testing Pattern Matching for instanceof
        System.out.println("=== 1. PATTERN MATCHING FOR INSTANCEOF ===");
        inspectObject("ModernJava");
        inspectObject(12);

        // Testing Pattern Matching for switch with Sealed Records
        System.out.println("\n=== 2. PATTERN MATCHING FOR SWITCH & RECORD PATTERNS ===");
        PaymentMethod p1 = new CreditCard("4111222233339876", 150000.0);
        PaymentMethod p2 = new DebitCard("HDFC", 250.0);
        PaymentMethod p3 = new Cash(2000.0);

        System.out.println(processPayment(p1));
        System.out.println(processPayment(p2));
        System.out.println(processPayment(p3));
    }
}
