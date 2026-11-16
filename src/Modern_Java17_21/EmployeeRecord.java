package Modern_Java17_21;

// 1. Defining a Record:
// Automatically generates:
// - private final fields (id, name, salary)
// - Canonical constructor: EmployeeRecord(int id, String name, double salary)
// - Accessor methods: id(), name(), salary() (Notice: NO 'get' prefix!)
// - equals(), hashCode(), and toString()
public record EmployeeRecord(int id, String name, double salary) {

    // 2. Compact Constructor (Optional): Used for validation without rewriting parameter list
    public EmployeeRecord {
        if (salary < 0) {
            throw new IllegalArgumentException("Salary cannot be negative!");
        }
        // Automatically assigns this.id = id, this.name = name, this.salary = salary at the end
    }

    // 3. You can still add custom instance methods inside a record
    public double annualPackage() {
        return salary * 12;
    }
}