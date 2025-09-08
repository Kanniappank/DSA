package decorator.withoutDecorator;

public class SimpleCoffee implements ICoffee{

    @Override
    public String getDescription() {
        return "Simple coffee";
    }

    @Override
    public double getCost() {
        return 0.5;
    }
    
}
