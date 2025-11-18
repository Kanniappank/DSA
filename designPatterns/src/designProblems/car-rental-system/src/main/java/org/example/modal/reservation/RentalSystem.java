package org.example.modal.reservation;

import lombok.Getter;
import org.example.modal.User;
import org.example.modal.payment.PaymentProcesser;
import org.example.modal.payment.PaymentStratergy;
import org.example.modal.vehicle.Vehicle;
import org.example.modal.vehicle.VehicleFactory;

import java.util.*;

public class RentalSystem {
    @Getter
    private List<RentalStore> stores;
    private static RentalSystem instance;
    private VehicleFactory vehicleFactory;
    private ReservationManager reservationManager;
    private PaymentProcesser paymentProcesser;
    @Getter
    private Map<Integer, User> users;
    //    private List<SystemObserver> observers;
    private int nextUserId;

    private RentalSystem() {
        this.reservationManager = new ReservationManager();
        this.vehicleFactory = new VehicleFactory();
        this.stores = new ArrayList<>();
        this.users = new HashMap<>();
        this.nextUserId = 1;
    }

    public static synchronized RentalSystem getInstance() {
        if (instance == null) {
            instance = new RentalSystem();
        }
        return instance;
    }

    public void addStore(RentalStore store) {
        stores.add(store);
    }

    public RentalStore getStore(int storeId) {
        for (RentalStore store : stores) {
            if (store.getId() == storeId) {
                return store;
            }
        }
        return null;
    }

    public Reservation createReservation(int userId, String vehicleRegistraionNumber, int pickUpStoreId, int returnStoreId, Date startDate, Date endDate) {
        User user = users.get(userId);
        RentalStore pickUpStore = getStore(pickUpStoreId);
        RentalStore returnStore = getStore(returnStoreId);
        Vehicle vehicle = (pickUpStore != null) ? pickUpStore.getVehicle(vehicleRegistraionNumber) : null;
        if (user != null && pickUpStore != null && returnStore != null && vehicle != null) {
            return reservationManager.createReservation(user, vehicle, pickUpStore, returnStore, startDate, endDate);
        }
        return null;
    }

    public boolean processPayment(int reservationId, PaymentStratergy stratergy) {
        Reservation reservation = reservationManager.getReservation(reservationId);
        if (reservation != null) {
            boolean result = paymentProcesser.processPayment(reservation.getTotalAmount(), stratergy);
            if (result) {
                reservationManager.confirmReservation(reservationId);
                return true;
            }
        }
        return false;
    }

    public void startRental(int reservationId) {
        reservationManager.startRental(reservationId);
    }

    public void completeRental(int reservationId) {
        reservationManager.completeRental(reservationId);
    }

    public void cancleRental(int reservationId) {
        reservationManager.cancleReservation(reservationId);
    }

    public void registerUser(User user){
        int userId = user.getId();
        if(users.containsKey(userId)){
            System.out.println("User already Registered");
            return;
        }
        users.put(userId,user);
    }

}