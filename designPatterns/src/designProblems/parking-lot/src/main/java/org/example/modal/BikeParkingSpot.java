package org.example.modal;

public class BikeParkingSpot extends ParkingSpot {
    public BikeParkingSpot(int spotNumber) {
        super(spotNumber, "Bike");
    }

    @Override
    public String getSpotType() {
        return super.getSpotType();
    }

    @Override
    public boolean canParkVehicle(Vehicle vehicle) {
        return "Bike".equalsIgnoreCase(vehicle.getVehicleType());
    }
}
