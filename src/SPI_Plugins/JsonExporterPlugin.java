package SPI_Plugins;

public class JsonExporterPlugin implements DataExporterPlugin {

    @Override
    public String getFormatName() {
        return "JSON";
    }

    @Override
    public String export(String key, String value) {
        return "{ \"" + key + "\": \"" + value + "\" }";
    }
}