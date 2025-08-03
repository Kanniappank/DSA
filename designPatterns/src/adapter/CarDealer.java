package adapter;

import java.util.*;

public class CarDealer {
    public List getCars() {

        List<ICar> cars = new ArrayList<>();

        cars.add(new IndianCar("Eco", "Maruti", 500000));
        // cars.add(new ForigenCars("Gost", "Rolls Royce", 10000000));
        // this cannot be done because forigen cars are not of type ICar because we
        // cannot add
        // forigen cars to cars list so we are createing an adaptor for forigen cars

        ForigenCars car = new ForigenCars("Gost", "Rolls Royce", 10000000);
        cars.add(new ForigenCarAdaptor(car));

        return cars;

    }
}
