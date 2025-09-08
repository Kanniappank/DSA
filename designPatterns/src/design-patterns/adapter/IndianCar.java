package adapter;

public class IndianCar implements ICar {

    String name;
    String brand;
    Integer price;

    public IndianCar(String name, String brand, Integer price) {
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getBrand() {
        return this.brand;
    }

    @Override
    public Integer getPrice() {
        return this.price;
    }

}
