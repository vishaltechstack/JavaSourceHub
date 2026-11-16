package Reflection_Serialization;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

// Target class to inspect at runtime
class PaymentService {

    // Private field with no public setter
    private String apiKey = "SECRET_KEY_123";

    @LogExecution(tag = "BILLING", priority = 10)
    public void processInvoice() {
        System.out.println("Executing processInvoice() using key: " + apiKey);
    }

    @LogExecution(tag = "AUDIT")
    public void generateReport() {
        System.out.println("Executing generateReport()...");
    }

    // Method WITHOUT @LogExecution annotation
    public void helperMethod() {
        System.out.println("Helper method (should be skipped by annotation runner).");
    }
}

public class ReflectionDemo {

    public static void main(String[] args) throws Exception {

        PaymentService service = new PaymentService();

        // 1. Obtain the Class metadata object representing PaymentService
        Class<?> clazz = service.getClass();
        System.out.println("Inspecting Class: " + clazz.getName());

        // 2. Accessing and modifying a PRIVATE field at runtime via Reflection
        Field privateField = clazz.getDeclaredField("apiKey");
        privateField.setAccessible(true); // Bypasses Java's private access check!
        System.out.println("Original private apiKey: " + privateField.get(service));

        privateField.set(service, "UPDATED_KEY_999"); // Mutates private field directly

        // 3. Scanning all methods and invoking ONLY those annotated with @LogExecution
        System.out.println("\n--- Running @LogExecution Annotated Methods ---");
        for (Method method : clazz.getDeclaredMethods()) {

            // Check if our custom annotation is present on this method
            if (method.isAnnotationPresent(LogExecution.class)) {

                // Extract the annotation instance to read its metadata values
                LogExecution annotation = method.getAnnotation(LogExecution.class);
                System.out.println("[Tag: " + annotation.tag() + " | Priority: " + annotation.priority() + "]");

                // Dynamically invoke the method on the 'service' object
                method.invoke(service);
            }
        }
    }
}