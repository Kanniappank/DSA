package org.example.modal.vehicle;

public class VehicleFactory {
    public Vehicle createVehicle(VehicleType vehicleType, String registrationNumber,String model,double baseRate){
        switch (vehicleType) {
            case ECONOMY:
                return new EconomyVehicle(registrationNumber,model,vehicleType,baseRate);
            case LUXURY:
                return new LuxuryVehicle(registrationNumber,model,vehicleType,baseRate);
            case SUV:
                return new SUVVehicle(registrationNumber,model,vehicleType,baseRate);
            default:
                throw new IllegalArgumentException("Unsupported vehicle type "+vehicleType);
        }
    }
}
