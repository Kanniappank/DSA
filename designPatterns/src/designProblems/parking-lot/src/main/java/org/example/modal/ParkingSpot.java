package org.example.modal;

import lombok.Getter;
import lombok.Setter;
import org.example.interfaces.VehicleType;

@Getter
public abstract class ParkingSpot {
    private String spotType;
    private int spotNumber;
    private Vehicle vehicle;
    @Setter
    private boolean isOccupied;

    public ParkingSpot(int spotNumber, String spotType) {
        this.spotType = spotType;
        this.spotNumber = spotNumber;
    }

    public abstract boolean canParkVehicle(Vehicle vehicle);

    public void parkVehicle(Vehicle vehicle) throws Exception {
        if (isOccupied) {
            throw new Exception("spot is occupied you cannot park here");
        }
        if (!canParkVehicle(vehicle)) {
            throw new Exception("this spot is not sutable for " + vehicle.getVehicleType());
        }
        this.vehicle = vehicle;
        this.isOccupied = true;
    }

    public void vacate() throws Exception {
        if (!isOccupied) {
            throw new Exception("spot is already vacant");
        }
        this.vehicle = null;
        this.isOccupied = false;
    }

}
