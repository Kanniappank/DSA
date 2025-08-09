package decorator.withDecorator;

public class SimpleCoffe implements ICoffee {

    @Override
    public String getDescription() {
        return "Simple Coffee";
    }

    @Override
    public double getCost() {
        return 5.0;
    }

}
