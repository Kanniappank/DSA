package decorator.withoutDecorator;

public class ColdCoffee implements ICoffee{

    @Override
    public String getDescription() {
        return "Cold Coffee";
    }

    @Override
    public double getCost() {
        return 10.0;
    }
    
}
