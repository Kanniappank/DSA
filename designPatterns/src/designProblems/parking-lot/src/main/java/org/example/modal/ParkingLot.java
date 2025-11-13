package org.example.modal;

import org.example.interfaces.VehicleType;

import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ParkingLot {
    private Map<String, PriorityQueue<ParkingSpot>> availableSpots;
    private final List<ParkingSpot> allspots;

    public ParkingLot(List<ParkingSpot> spots) {
        this.allspots = spots;

        for (VehicleType vehicletype : VehicleType.values()) {
            availableSpots.put(String.valueOf(vehicletype), new PriorityQueue<>());
        }

        for (ParkingSpot spot : spots) {
            if (!spot.isOccupied()) {
                availableSpots.get(spot.getSpotType()).add(spot);
            }
        }
    }

    public void vacateSpot(ParkingSpot spot,Vehicle vehicle) throws Exception {
        if(spot!=null && spot.isOccupied() && spot.getVehicle().equals(vehicle)){
            spot.vacate();
            System.out.println("Vehicle "+vehicle.getLicencePlate() + " vacated "+spot.getSpotNumber());
        }
        else{
            System.out.println("Invalid operation either the spot is already empty or the vehicle is not matching");
        }


    }

    public ParkingSpot parkVehicle(Vehicle vehicle) throws Exception {
        ParkingSpot spot = findAvailableSpot(VehicleType.valueOf(vehicle.getVehicleType()));
        if (spot != null) {
            spot.parkVehicle(vehicle);
            System.out.println("vehicle parked successfully in the spot " + spot.getSpotNumber());
            return spot;
        }
        System.out.println("No parking spot available for " + vehicle.getVehicleType() + " !");
        return null;
    }

    public ParkingSpot findAvailableSpot(VehicleType type) {
        PriorityQueue<ParkingSpot> queue = availableSpots.get(type);
        if (queue.isEmpty()) {
            return null;
        }
        return queue.poll();

    }
}
