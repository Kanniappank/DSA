package adapter;

import java.util.*;

public class Demo {

    public static void main(String[] args) {

        CarDealer dealer = new CarDealer();
        List<ICar> cars = dealer.getCars();

        for (ICar car : cars) {
            System.out.println(car.getName() + " -> " + car.getBrand() + " -> " + car.getPrice());
        }
    }

}
