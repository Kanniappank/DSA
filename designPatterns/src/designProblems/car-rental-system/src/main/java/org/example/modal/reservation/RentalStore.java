package org.example.modal.reservation;

import lombok.Data;
import org.example.modal.Location;
import org.example.modal.vehicle.Vehicle;
import org.example.modal.vehicle.VehicleStatus;

import java.util.*;
@Data
public class RentalStore {

    private int id;
    private String name;
    private Location location;
    private Map<String, Vehicle> vehicles;

    public RentalStore(int id, String name, Location location) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.vehicles = new HashMap<>();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.put(vehicle.getRegistrationNumber(), vehicle);
    }

    public void removeVehicle(String registraionNumber) {
        vehicles.remove(registraionNumber);
    }

    public List<Vehicle> getAvailableVehicles(Date startTime, Date endTime) {
        List<Vehicle> availableVehicles = new ArrayList<>();
        for (Vehicle vehicle : vehicles.values()) {
            if (vehicle.getStatus() == VehicleStatus.AVAILABLE) {
                availableVehicles.add(vehicle);
            }
        }
        return availableVehicles;
    }

    public boolean isVehicleAvailable(String registrationNumber) {
        Vehicle vehicle = vehicles.get(registrationNumber);
        return vehicle != null && vehicle.getStatus() == VehicleStatus.AVAILABLE;
    }

    public Vehicle getVehicle(String registrationNumber){
        return vehicles.get(registrationNumber);
    }
}
