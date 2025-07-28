
package solid.srp.srp_without_violation;

/**
 * Demonstrates adherence to the Single Responsibility Principle (SRP) from SOLID design principles.
 *
 * <p>
 * In this example:
 * <ul>
 *   <li>The {@link Employee} class is responsible only for holding employee data (name and salary).</li>
 *   <li>The {@link SalaryCalculator} class is responsible only for calculating the salary of an employee.</li>
 *   <li>The {@link ReportGenerator} class is responsible only for generating reports.</li>
 * </ul>
 * Each class has a single, well-defined responsibility, and their functionalities are separated.
 * This separation ensures that changes in one responsibility (e.g., salary calculation logic)
 * do not affect others (e.g., report generation or employee data management), thus not violating the Single Responsibility Principle.
 */

class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return this.name;
    }

    public double getSalary() {
        return this.salary;
    }

}

class SalaryCalculator {
    public double calculateSalary(Employee employee) {
        return employee.getSalary() * 1.2;
    }
}

class ReportGenerator {
    public void generateReport() {
        System.out.println("Generating report");
    }
}

public class SRP_without_Violation {


    public static void main(String[] args) {
        Employee emp = new Employee("Suriya", 483);
        SalaryCalculator calculator = new SalaryCalculator();
        System.out.println("Salary of " + emp.getName() + " is " + calculator.calculateSalary(emp));
        ReportGenerator generator = new ReportGenerator();
        generator.generateReport();
    }

}
