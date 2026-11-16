package Design_Patterns;

// 1. Strategy Interface: Defines the algorithm contract
interface DiscountStrategy {
    double applyDiscount(double totalAmount);
}

// 2. Concrete Strategy A: No Discount
class RegularCustomerDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double totalAmount) {
        return totalAmount; // 0% off
    }
}

// 3. Concrete Strategy B: 10% Seasonal Discount
class SeasonalDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double totalAmount) {
        return totalAmount * 0.90; // 10% off
    }
}

// 4. Concrete Strategy C: Flat Rs. 500 Festival Discount
class FestivalFlatDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double totalAmount) {
        return Math.max(0, totalAmount - 500);
    }
}

// 5. Context Class: Uses whichever DiscountStrategy is injected into it
public class DiscountContext {

    private DiscountStrategy strategy;

    public DiscountContext(DiscountStrategy strategy) {
        this.strategy = strategy;
    }

    // Allows switching algorithms dynamically at runtime!
    public void setStrategy(DiscountStrategy strategy) {
        this.strategy = strategy;
    }

    public double calculateFinalPrice(double amount) {
        return strategy.applyDiscount(amount);
    }
}