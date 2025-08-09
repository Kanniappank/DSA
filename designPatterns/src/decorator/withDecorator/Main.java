package decorator.withDecorator;

public class Main {
    public static void main(String[] args) {
        ICoffee coffee=new SimpleCoffe();
        System.out.println(coffee.getDescription()+" is of "+coffee.getCost());

        coffee=new MilkDecorator(coffee);
        System.out.println(coffee.getDescription()+" is of "+coffee.getCost());
        
        coffee=new SugarDecorator(coffee);
        System.out.println(coffee.getDescription()+" is of "+coffee.getCost());

    }
}
