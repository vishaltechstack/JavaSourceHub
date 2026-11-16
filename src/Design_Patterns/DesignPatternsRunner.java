package Design_Patterns;

public class DesignPatternsRunner {

    public static void main(String[] args) {

        // --- 1. SINGLETON PATTERN ---
        System.out.println("=== 1. SINGLETON PATTERN ===");
        AppConfigSingleton config1 = AppConfigSingleton.getInstance();
        AppConfigSingleton config2 = AppConfigSingleton.getInstance();
        System.out.println("Environment: " + config1.getEnvironment());
        // Proves both variables point to the exact same object in Heap memory
        System.out.println("Are config1 and config2 the exact same instance? " + (config1 == config2));

        // --- 2. FACTORY PATTERN ---
        System.out.println("\n=== 2. FACTORY PATTERN ===");
        Notification n1 = NotificationFactory.createNotification("EMAIL");
        Notification n2 = NotificationFactory.createNotification("SMS");
        n1.send("Your order has shipped!");
        n2.send("Your OTP is 482910.");

        // --- 3. BUILDER PATTERN ---
        System.out.println("\n=== 3. BUILDER PATTERN ===");
        UserProfile fullUser = new UserProfile.UserBuilder("vishal_dev", "vishal@example.com")
                .city("Bengaluru")
                .phone("+91-9876543210")
                .verified(true)
                .build();

        UserProfile minimalUser = new UserProfile.UserBuilder("guest_user", "guest@example.com")
                .build();

        System.out.println(fullUser);
        System.out.println(minimalUser);

        // --- 4. STRATEGY PATTERN ---
        System.out.println("\n=== 4. STRATEGY PATTERN ===");
        double cartTotal = 3000.0;

        DiscountContext checkout = new DiscountContext(new RegularCustomerDiscount());
        System.out.println("Regular Price: Rs. " + checkout.calculateFinalPrice(cartTotal));

        // Swapping strategy dynamically at runtime without changing DiscountContext code
        checkout.setStrategy(new SeasonalDiscount());
        System.out.println("Seasonal (10% off) Price: Rs. " + checkout.calculateFinalPrice(cartTotal));

        checkout.setStrategy(new FestivalFlatDiscount());
        System.out.println("Festival (Rs. 500 off) Price: Rs. " + checkout.calculateFinalPrice(cartTotal));
    }
}