package factory.food_without_factory;

// Problem: Hardcoded food types in 'order' and 'if' conditions make the code less scalable.
// Problem: Adding new food types requires modifying the main method, violating Open/Closed Principle.
// Problem: No error in code, but design is not flexible for extension.

interface Ifood {
    String prepareFood();
}

class Pizza implements Ifood {

    @Override
    public String prepareFood() {
        return "Pizza is getting prepared";
    }

}

class Burger implements Ifood {

    @Override
    public String prepareFood() {
        return "Burger is getting prepared";
    }

}

public class FoodApp {

    public static void main(String[] args) {

        String order = "PizzA"; // Problem: Hardcoded order string, should ideally come from user input or arguments
        Ifood food = null;

        // Problem: Hardcoded food type checks, not scalable for more food types
        if (order.equalsIgnoreCase("pizza")) {
            food = new Pizza();
        } else if (order.equalsIgnoreCase("Burger")) {
            food = new Burger();
        }

        if (food != null) {
            System.out.println(food.prepareFood());
        } else {
            System.out.println("Invalid order. Food not found.");
        }

    }

}

// No syntax errors, but design can be improved using Factory Pattern for scalability.
