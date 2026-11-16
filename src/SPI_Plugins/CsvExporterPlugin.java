package SPI_Plugins;

public class CsvExporterPlugin implements DataExporterPlugin {

    @Override
    public String getFormatName() {
        return "CSV";
    }

    @Override
    public String export(String key, String value) {
        return key + "," + value;
    }
}