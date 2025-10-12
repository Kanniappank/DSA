package org.example.modal;

import org.example.interfaces.ParkingFeeStatergy;

public class CarVehicle extends Vehicle{
    public CarVehicle(String licencePlate, String vehicleType, ParkingFeeStatergy feeStatergy) {
        super(licencePlate, vehicleType, feeStatergy);
    }
}
