package Packaging;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GreetingService {

    // Reads key-value pairs from src/resources/application.properties on the classpath
    public Properties loadAppProperties() {
        Properties props = new Properties();

        // Since 'resources' is a subfolder inside 'src', use "resources/application.properties"
        // (Or just "application.properties" if you marked 'resources' as a Resources Root)
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("resources/application.properties")) {
            if (input == null) {
                throw new RuntimeException("application.properties not found on classpath!");
            }
            props.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load properties: " + e.getMessage(), e);
        }
        return props;
    }

    // Builds formatted JSON using pure Java (no external Gson dependency required)
    public String buildJsonSummary() {
        Properties props = loadAppProperties();

        return """
                {
                  "application": "%s",
                  "version": "%s",
                  "author": "%s",
                  "javaRuntime": "%s"
                }
                """.formatted(
                props.getProperty("app.name"),
                props.getProperty("app.version"),
                props.getProperty("app.author"),
                System.getProperty("java.version")
        );
    }
}