package org.example.modal.vehicle;

import lombok.Data;

@Data
public abstract class Vehicle {

    private String registrationNumber;
    private String make;
    private String model;
    private int year;
    private VehicleType type;
    private VehicleStatus status;
    private double baseRentalPrice;

    public Vehicle(String registrationNumber, String model, VehicleType type, double baseRentalPrice) {
        this.registrationNumber = registrationNumber;
        this.model = model;
        this.type = type;
        this.status = VehicleStatus.AVAILABLE;
        this.baseRentalPrice = baseRentalPrice;


    }

    public abstract double calculateRentalFee(int days);



}
