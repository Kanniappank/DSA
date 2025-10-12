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

    public ParkingSpot parkVehicle(){

    }

    public ParkingSpot findAvailableSpot(VehicleType type) {
        PriorityQueue<ParkingSpot> queue = availableSpots.get(type);
        if (queue.isEmpty() || queue == null) {
            return null;
        }
        return queue.poll();

    }
}
