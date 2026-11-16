package Modern_Java17_21;

public class TextBlocksAndRunner {

    public static void main(String[] args) {

        // --- 1. Testing EmployeeRecord ---
        System.out.println("=== 1. JAVA RECORDS ===");
        EmployeeRecord emp1 = new EmployeeRecord(101, "Vishal Sharma", 85000.0);
        EmployeeRecord emp2 = new EmployeeRecord(101, "Vishal Sharma", 85000.0);

        // Built-in accessor methods (no 'get' prefix)
        System.out.println("Name: " + emp1.name());
        System.out.println("Annual CTC: Rs. " + emp1.annualPackage());

        // Built-in toString() & value-based equals()
        System.out.println("Record toString(): " + emp1);
        System.out.println("Value equality (emp1.equals(emp2)): " + emp1.equals(emp2)); // true!

        // --- 2. Java Text Blocks (Multi-line Strings) ---
        System.out.println("\n=== 2. TEXT BLOCKS ===");

        // Closing """ controls indentation automatically!
        String jsonPayload = """
                {
                    "employeeId": %d,
                    "name": "%s",
                    "monthlySalary": %.2f,
                    "active": true
                }
                """.formatted(emp1.id(), emp1.name(), emp1.salary());

        System.out.println("Formatted JSON Payload:\n" + jsonPayload);

        String multiLineSQL = """
                SELECT id, name, salary
                FROM employees
                WHERE salary > 50000
                ORDER BY name ASC;
                """;

        System.out.println("Clean SQL Query:\n" + multiLineSQL);
    }
}
