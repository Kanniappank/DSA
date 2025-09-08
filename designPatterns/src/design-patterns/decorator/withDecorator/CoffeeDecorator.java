package decorator.withDecorator;

public abstract class CoffeeDecorator implements ICoffee{

    protected ICoffee coffee;

    public CoffeeDecorator(ICoffee coffee){
        this.coffee=coffee;
    }

    public String getDescription(){
        return coffee.getDescription();
    }

    public double getCost(){
        return coffee.getCost();
    }

    
}
