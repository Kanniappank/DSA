
/**
 * This implementation demonstrates the Complete Factory design pattern for food preparation.
 * 
 * Problems solved compared to previous code:
 * 1. **Decoupling Object Creation:** The client code (main method) does not instantiate concrete food objects directly.
 *    Instead, it relies on factory classes, promoting loose coupling and adherence to the Dependency Inversion Principle.
 * 2. **Single Responsibility Principle:** Each factory class is responsible for creating a specific type of food,
 *    making the code easier to maintain and extend.
 * 3. **Scalability:** Adding new food types only requires creating new food and factory classes,
 *    without modifying existing code, thus following the Open/Closed Principle.
 * 4. **Encapsulation of Creation Logic:** The creation logic for each food type is encapsulated within its respective factory,
 *    hiding the details from the client and simplifying object management.
 */
package factory.complete_factory;

interface Ifood{
    String prepare();
}

class Pizza implements Ifood{
    public String prepare(){
        return "Pizza being prepared";
    }
}

class Burger implements Ifood{
    public String prepare(){
        return "Burger is being prepared";
    }
}

abstract class FoodFactory{
    abstract Ifood getFood();
}

class PizzaFactory extends FoodFactory{
    public Ifood getFood(){
        return new Pizza();
    }
}

class BurgerFactory extends FoodFactory{
    public Ifood getFood(){
        return new Burger();
    }
}

public class FoodApp {
    
    public static void main(String[] args) {
        FoodFactory factory = new PizzaFactory();
        Ifood food = factory.getFood();
        System.out.println(food.prepare());

        factory = new BurgerFactory();
        food = factory.getFood();
        System.out.println(food.prepare());
    }
}
