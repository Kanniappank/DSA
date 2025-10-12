package org.example.modal;

import org.example.interfaces.DurationType;
import org.example.interfaces.ParkingFeeStatergy;
import org.example.interfaces.VehicleType;
import org.jetbrains.annotations.NotNull;

public class BasicHourlyRateStatergy implements ParkingFeeStatergy {
    @Override
    public double calculateParkingFees(@NotNull String vehicleType, int duration, DurationType durationType) {
        switch (vehicleType.toLowerCase()) {
            case "car":
                return durationType == DurationType.HOURS ? duration * 10.0 : duration * 10.0 * 24;
            case "bike":
                return durationType == DurationType.HOURS ? duration * 5.0 : duration * 5.0 * 24;
            case "auto":
                return durationType == DurationType.HOURS ? duration * 7.0 : duration * 7.0 * 24;
            default:
                return 0.0;
        }
    }
}
