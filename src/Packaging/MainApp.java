package Packaging;

public class MainApp {

    public static void main(String[] args) {
        System.out.println("=== Pure Java Packaging Demo Started ===");

        GreetingService service = new GreetingService();
        System.out.println(service.buildJsonSummary());
    }
}
