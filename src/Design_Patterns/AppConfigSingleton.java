package Design_Patterns;

// Thread-Safe Double-Checked Locking Singleton
public class AppConfigSingleton {

    // 1. 'volatile' ensures all threads immediately see the fully initialized instance in memory
    private static volatile AppConfigSingleton instance;

    private String environment;
    private int maxConnections;

    // 2. PRIVATE constructor prevents anyone from calling 'new AppConfigSingleton()' outside this class
    private AppConfigSingleton() {
        this.environment = "PRODUCTION";
        this.maxConnections = 50;
        System.out.println("AppConfigSingleton initialized ONCE.");
    }

    // 3. Public static method providing the single global access point
    public static AppConfigSingleton getInstance() {
        if (instance == null) { // First check (fast, avoids locking once initialized)
            synchronized (AppConfigSingleton.class) { // Thread-safe lock
                if (instance == null) { // Second check inside lock
                    instance = new AppConfigSingleton();
                }
            }
        }
        return instance;
    }

    public String getEnvironment() {
        return environment;
    }

    public int getMaxConnections() {
        return maxConnections;
    }
}