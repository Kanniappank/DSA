/**
 * This code violates the Single Responsibility Principle (SRP) because the Employee class has more than one reason to change.
 * 
 * According to SRP, a class should have only one reason to change, meaning it should have only one responsibility.
 * 
 * In this example:
 * - The Employee class is responsible for both employee data and salary calculation (business logic).
 * - It is also responsible for generating reports (presentation logic).
 * 
 * Mixing these responsibilities makes the class harder to maintain and extend. 
 * Changes in report generation or salary calculation would require modifying the Employee class, 
 * leading to tightly coupled code and reduced flexibility.
 */
package solid.srp.srp_with_violation;

class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public double calculateSalary() {
        return this.salary * 1.2;
    }

    public void generateReport() {
        System.out.println("Generating report");
    }

}

public class SRP_with_Violation {

    public static void main(String[] args) {
        Employee emp = new Employee("Suriya", 450);
        System.out.println("Salary " + emp.calculateSalary());
        emp.generateReport();
    }
}

/*
 * 
 */