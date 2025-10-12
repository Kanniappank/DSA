package org.example.modal;

public class CarParkingSpot extends ParkingSpot{
    public CarParkingSpot(int spotNumber) {
        super(spotNumber, "Car");
    }

    @Override
    public String getSpotType() {
        return super.getSpotType();
    }

    @Override
    public boolean canParkVehicle(Vehicle vehicle) {
        return "Car".equalsIgnoreCase(vehicle.getVehicleType());
    }
}
