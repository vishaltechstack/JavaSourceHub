package SPI_Plugins;

import java.util.ServiceLoader;

public class PluginPlatformRunner {

    public static void main(String[] args) {

        System.out.println("=== Discovering DataExporterPlugin Providers via ServiceLoader ===");

        // 1. ServiceLoader scans META-INF/services/step25_spi_plugins.DataExporterPlugin on the classpath
        ServiceLoader<DataExporterPlugin> loader = ServiceLoader.load(DataExporterPlugin.class);

        int count = 0;

        // 2. Lazily instantiates and iterates through every registered plugin implementation
        for (DataExporterPlugin plugin : loader) {
            count++;
            System.out.println("\nDiscovered Plugin #" + count + ": " + plugin.getClass().getName());
            System.out.println("Format: " + plugin.getFormatName());
            System.out.println("Output: " + plugin.export("language", "Core Java 21"));
        }

        if (count == 0) {
            System.out.println("No plugins found! Check META-INF/services configuration path.");
        }
    }
}