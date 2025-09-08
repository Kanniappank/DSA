package solid.open_close_principle.open_close_with_violation;

// This implementation violates the Open/Closed Principle because
// every time a new shape is added, the AreaCalculator class must be modified.
// The class is not closed for modification and open for extension.

class AreaCalculator {
    public double calculateArea(String shape, double radius, double length, double breath) {
        if (shape.equals("Circle")) {
            return Math.PI * radius * radius;
        } else if (shape.equals("Rectangle")) {
            return length * breath;
        } else {
            return 0;
        }

    }
}

public class OpenCloseWithViolation {
    public static void main(String[] args) {
        AreaCalculator calculator = new AreaCalculator();

        System.out.println("Area " + calculator.calculateArea("Circle", 25.5, 0, 0));
    }
}
