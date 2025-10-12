package org.example.modal;

import org.example.interfaces.ParkingFeeStatergy;

public class VehicleFactory {
    public static Vehicle VehicleFactory(String vehicleType, String licencePlate, ParkingFeeStatergy feeStatergy) {
        if (vehicleType.equalsIgnoreCase("car")) {
            return new CarVehicle(licencePlate, vehicleType, feeStatergy);
        } else if (vehicleType.equalsIgnoreCase("bike")) {
            return new BikeVehicle(licencePlate, vehicleType, feeStatergy);
        }
        return new OtherVehicleType(licencePlate, vehicleType, feeStatergy);
    }
}
