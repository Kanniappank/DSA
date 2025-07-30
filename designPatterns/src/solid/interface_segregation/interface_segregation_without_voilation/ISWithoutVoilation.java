/**
 * Demonstrates adherence to the Interface Segregation Principle (ISP) from SOLID principles.
 *
 * <p>
 * The Interface Segregation Principle states that no client should be forced to depend on methods it does not use.
 * In this example, the {@code Worker} and {@code Eatable} interfaces are separated, so classes only implement the interfaces relevant to them.
 * </p>
 *
 * <p>
 * This design follows ISP because classes like {@code Robot} only implement {@code Worker} (since robots do not eat),
 * while {@code Human} implements both {@code Worker} and {@code Eatable}. This avoids forcing classes to implement unnecessary methods.
 * </p>
 */
package solid.interface_segregation.interface_segregation_without_voilation;



interface Worker {
    void work();
}

interface Eatable{
    void eat();
}

class Human implements Worker, Eatable{
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

}

public class ISWithoutVoilation {

    public static void main(String[] args) {
        Human human = new Human();
        human.work();
        human.eat();

        Robot robo = new Robot();
        robo.work();
        robo.eat();
    }
}
