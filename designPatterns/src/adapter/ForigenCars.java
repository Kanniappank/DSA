package adapter;

public class ForigenCars {

    private String carName;
    private String carBrand;
    private Integer carPrice;

    public ForigenCars(String carName, String carBrand, Integer carPrice) {
        this.carName = carName;
        this.carBrand = carBrand;
        this.carPrice = carPrice;
    }

    public Integer getCarPrice() {
        return this.carPrice;
    }

    public String getCarName() {
        return this.carName;
    }

    public String getCarBrand() {
        return this.carBrand;
    }
}
