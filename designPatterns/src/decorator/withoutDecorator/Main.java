package decorator.withoutDecorator;


public class Main {
    public static void main(String[] args) {
        ICoffee simpleCoffee  = new SimpleCoffee();
        System.out.println(simpleCoffee.getDescription()+" is of rupees "+simpleCoffee.getCost());

        ICoffee coldCoffee = new ColdCoffee();
        System.out.println(coldCoffee.getDescription()+" is of rupees "+coldCoffee.getCost());

        ICoffee milkCoffee = new MilkCoffee();
        System.out.println(milkCoffee.getDescription()+" is of rupees "+milkCoffee.getCost());

         ICoffee milkSugarCoffee = new MilkSugarCoffee();
        System.out.println(milkSugarCoffee.getDescription()+" is of rupees "+milkSugarCoffee.getCost());

        /* if diffrent types of coffees increases we need create diffrent classe and the number of class will be increasing so 
         * we brought idea of decorator design pattern we buit the additional feature on top of the existing feature
         */

    }
}
