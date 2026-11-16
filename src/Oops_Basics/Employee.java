package Oops_Basics;

public class Employee {

    // Instance variables (Unique to each employee object)
    int empId;
    String empName;

    // Static variable (Shared across ALL Employee objects in memory)
    static String companyName = "TechCore Solutions";
    static int employeeCount = 0;

    public Employee(int empId, String empName) {
        this.empId = empId;
        this.empName = empName;
        employeeCount++; // Increments shared counter every time a new Employee is created
    }

    // Instance method: Can access both instance and static variables
    public void showEmployee() {
        System.out.println("ID: " + empId + " | Name: " + empName + " | Company: " + companyName);
    }

    // Static method: Can be called directly using ClassName.methodName() without creating an object
    public static void showTotalEmployees() {
        System.out.println("Total Employees Hired at " + companyName + ": " + employeeCount);
    }
}
