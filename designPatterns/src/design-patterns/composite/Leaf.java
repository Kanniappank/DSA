package composite;

public class Leaf implements IComponent {

    String name;
    int price;

    public Leaf(String name,int price){
        this.name=name;
        this.price=price;
    }

    @Override
    public void showPrice() {
        System.out.println(name + " : " + price);
    }

}
