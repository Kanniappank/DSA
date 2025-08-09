package decorator.withoutDecorator;

public class MilkSugarCoffee implements ICoffee {

    @Override
    public String getDescription() {
        return "Simple Coffee + Milk + Sugar";
    }

    @Override
    public double getCost() {
        return 5.0 + 1.5 + 0.5;
    }

}
