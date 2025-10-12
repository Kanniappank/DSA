package org.example.modal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.interfaces.ParkingFeeStatergy;
import org.example.interfaces.VehicleType;

@Getter
@AllArgsConstructor
public abstract class Vehicle {
    private String licencePlate;
    private String vehicleType;
    private ParkingFeeStatergy feeStatergy;
}
