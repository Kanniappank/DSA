package adapter;

public class ForigenCarAdaptor implements ICar {

    private ForigenCars car =null;

    public ForigenCarAdaptor(ForigenCars car){
        this.car=car;
    }
    @Override
    public String getName() {
     return this.car.getCarName();
    }

    @Override
    public String getBrand() {
        return this.car.getCarBrand();
    }

    @Override
    public Integer getPrice() {
      return this.car.getCarPrice();
    }
    

}
