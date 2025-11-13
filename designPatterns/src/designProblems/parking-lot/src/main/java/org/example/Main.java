package org.example;

import org.example.modal.BikeParkingSpot;
import org.example.modal.CarParkingSpot;
import org.example.modal.ParkingSpot;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<ParkingSpot> parkingSpots = new ArrayList<>();
        parkingSpots.add(new CarParkingSpot(1));
        parkingSpots.add(new CarParkingSpot(2));
        parkingSpots.add(new BikeParkingSpot(3));
        parkingSpots.add(new BikeParkingSpot(4));

        Pa
    }
}
