package Modern_Java17_21;

// 1. Sealed Interface: ONLY CreditCard, DebitCard, and Cash are permitted to implement it!
// Any unauthorized class trying 'implements PaymentMethod' gets a compile-time error.
public sealed interface PaymentMethod permits CreditCard, DebitCard, Cash {
}

// 2. Permitted subclasses MUST explicitly declare one of three modifiers:
// 'final' (cannot be extended further), 'sealed' (further restricted), or 'non-sealed' (open again)

// Using Records as 'final' implementations of our sealed interface!
record CreditCard(String cardNumber, double limit) implements PaymentMethod {}

record DebitCard(String bankName, double balance) implements PaymentMethod {}

record Cash(double amountTendered) implements PaymentMethod {}