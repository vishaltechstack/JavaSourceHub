package SPI_Plugins;

// Service Provider Interface (SPI): The contract discovered by java.util.ServiceLoader
public interface DataExporterPlugin {

    // Identifies the format this plugin supports (e.g., "JSON", "CSV")
    String getFormatName();

    // Transforms raw key-value data into the plugin's target format
    String export(String key, String value);
}