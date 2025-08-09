package decorator.withoutDecorator;

public class MilkCoffee implements ICoffee {

    @Override
    public String getDescription() {
        return "Simple Coffee + Milk";
    }

    @Override
    public double getCost() {
        return 5.0 + 1.5;
    }

}
