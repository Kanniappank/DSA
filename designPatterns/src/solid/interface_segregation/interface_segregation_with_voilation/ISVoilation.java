/**
 * Demonstrates a violation of the Interface Segregation Principle (ISP) from SOLID principles.
 *
 * <p>
 * The Interface Segregation Principle states that no client should be forced to depend on methods it does not use.
 * In this example, the {@code Worker} interface forces all implementers to provide both {@code work()} and {@code eat()} methods.
 * This leads to a problem for the {@code Robot} class, which does not need to implement {@code eat()}, resulting in an unsupported operation.
 * </p>
 *
 * <p>
 * This design violates ISP because it forces unrelated classes (like robots) to implement methods that are not relevant to them.
 * A better design would be to split the interface into smaller, more specific interfaces.
 * </p>
 */
package solid.interface_segregation.interface_segregation_with_voilation;



interface Worker {
    void work();

    void eat();
}

class Human implements Worker {
    public void work() {
        System.out.println("Working");
    }

    @Override
    public void eat() {
        System.out.println("Eating");
    }
}

class Robot implements Worker {

    @Override
    public void work() {
        System.out.println("Working");
    }

    @Override
    public void eat() {
        throw new UnsupportedOperationException("Robots do not eat");
    }

}

public class ISVoilation {

    public static void main(String[] args) {
        Human human = new Human();
        human.work();
        human.eat();

        Robot robo = new Robot();
        robo.work();
        robo.eat();
    }
}
