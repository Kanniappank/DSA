package org.example.modal;

import org.example.interfaces.DurationType;
import org.example.interfaces.ParkingFeeStatergy;

public class PremiumHourlyRateStatergy implements ParkingFeeStatergy {
    @Override
    public double calculateParkingFees(String vehicleType, int duration, DurationType durationType) {
        switch (vehicleType.toLowerCase()) {
            case "car":
                return durationType == DurationType.HOURS ? duration * 15.0 : duration * 15.0 * 24;
            case "bike":
                return durationType == DurationType.HOURS ? duration * 10.0 : duration * 10.0 * 24;
            case "auto":
                return durationType == DurationType.HOURS ? duration * 9.0 : duration * 0.0 * 24;
            default:
                return 0.0;
        }
    }
}
