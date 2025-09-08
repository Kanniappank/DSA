/**
 * This implementation demonstrates the Factory Design Pattern for food preparation.
 * 
 * Problems solved compared to the previous program:
 * 1. Decouples object creation from client code: The FoodFactory class handles the instantiation of food objects,
 *    so the client does not need to know the concrete classes (Pizza, Burger).
 * 2. Improves scalability: New food types can be added easily by introducing new classes implementing Ifood
 *    and updating the factory logic, without modifying client code.
 * 3. Enhances maintainability: Centralizes the creation logic, making it easier to manage and update.
 * 4. Promotes abstraction: The client interacts with the Ifood interface, not the concrete implementations.
 *
 * Problems still present in this program:
 * 1. Factory logic uses hardcoded if-else statements: Adding new food types requires modifying the factory method,
 *    which violates the Open/Closed Principle.
 * 2. No error handling for unknown orders: If an invalid food name is provided, the factory returns null,
 *    which can lead to NullPointerExceptions.
 * 3. Tight coupling between factory and concrete classes: The factory must be updated for every new food type.
 * 4. No use of reflection or registration for dynamic food creation: The factory cannot create food types dynamically.
 */
package factory.food_with_factory;


interface Ifood {
    String prepare();
}

class Pizza implements Ifood {
    public String prepare() {
        return "Pizza is getting prepared";
    }
}

class Burger implements Ifood {
    public String prepare() {
        return "Burger is being prepared";
    }
}

class FoodFactory {

    Ifood food = null;

    public Ifood getFood(String order) {

        if (order.equalsIgnoreCase("Pizza")) {
            food = new Pizza();
        } else if (order.equalsIgnoreCase("Burger")) {
            food = new Burger();
        }
        else{
            throw new IllegalArgumentException("we dont serve that");
        }
        return food;
    }

}

public class FoodApp {

    public static void main(String[] args) {
        String order = "pizza";
        FoodFactory factory = new FoodFactory();
        Ifood food = factory.getFood(order);
        System.out.println(food.prepare());
    }

}
