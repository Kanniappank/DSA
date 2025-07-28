/**
 * Demonstrates the Open/Closed Principle (OCP) from SOLID design principles.
 * 
 * <p>
 * This implementation does NOT violate the Open/Closed Principle because:
 * <ul>
 *   <li>The IShape interface defines a contract for shapes to calculate their area.</li>
 *   <li>Concrete shape classes (e.g., Circle, Rectangle) implement IShape and provide their own area calculation logic.</li>
 *   <li>The AreaCalculator class depends on the abstraction (IShape) and not on concrete implementations.</li>
 *   <li>To add new shapes, you simply create new classes implementing IShape, without modifying existing code.</li>
 * </ul>
 * Thus, the system is open for extension (new shapes) but closed for modification (existing code remains unchanged).
 */
package solid.open_close_principle.open_close_without_violation;

interface IShape {
    double calculateArea();
}

class Circle implements IShape {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

}

class Rectangle implements IShape {
    private double length;
    private double breath;

    public Rectangle(double length, double breath) {
        this.length = length;
        this.breath = breath;
    }

    @Override
    public double calculateArea() {
        return length * breath;
    }

}
class AreaCalculator{
    public double calculateArea(IShape shape){
        return shape.calculateArea();
    }
}

class OpenCloseWithoutViolation{
    public static void main(String[] args) {
        IShape circle = new Circle(5);
        IShape rectangle = new Rectangle(33.3,23.4);
        AreaCalculator calculator = new AreaCalculator();
        System.out.println("Circle Area "+calculator.calculateArea(circle));
        System.out.println("Rectangle Area "+calculator.calculateArea(rectangle));

    }

}