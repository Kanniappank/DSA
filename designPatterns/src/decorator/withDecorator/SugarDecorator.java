package decorator.withDecorator;

public class SugarDecorator extends CoffeeDecorator {

    public SugarDecorator(ICoffee coffee) {
        super(coffee);
    }

    public String getDescription() {
        return coffee.getDescription() + ", Sugar";
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 1.5;
    }

}
