package decorator.withDecorator;

public class MilkDecorator extends CoffeeDecorator {

    public MilkDecorator(ICoffee coffee) {
        super(coffee);
    }

    public String getDescription() {
        return coffee.getDescription() + ", Milk";
    }

    public double getCost() {
        return coffee.getCost() + 1.5;
    }

}
