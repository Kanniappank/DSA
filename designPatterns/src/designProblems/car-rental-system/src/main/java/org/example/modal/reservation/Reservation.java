package org.example.modal.reservation;

import lombok.Data;
import org.example.modal.User;
import org.example.modal.vehicle.Vehicle;
import org.example.modal.vehicle.VehicleStatus;

import java.util.Date;

@Data
public class Reservation {
    private int id;
    private User user;
    private Vehicle vehicle;
    private RentalStore pickupStore;
    private RentalStore returnStore;
    private Date startDate;
    private Date endDate;
    private ReservationStatus reservationStatus;
    private double totalAmount;

    public Reservation(int id, User user, Vehicle vehicle, RentalStore pickupStore, RentalStore returnStore, Date startDate, Date endDate) {
        this.id = id;
        this.user = user;
        this.vehicle = vehicle;
        this.pickupStore = pickupStore;
        this.returnStore = returnStore;
        this.startDate = startDate;
        this.endDate = endDate;
        this.reservationStatus = ReservationStatus.PENDING;


        long diffInMillies = endDate.getTime() - startDate.getTime();
        int days = (int) (diffInMillies / (1000 * 60 * 60 * 24)) + 1;
    }

    public void confirmReservation() {
        if (reservationStatus == ReservationStatus.PENDING) {
            reservationStatus = ReservationStatus.CONFIRMED;
            vehicle.setStatus(VehicleStatus.RESERVED);
        }
    }

    public void startRental(){
        if(reservationStatus==ReservationStatus.CONFIRMED){
            reservationStatus=ReservationStatus.IN_PROGRESS;
            vehicle.setStatus(VehicleStatus.RENTED);
        }
    }

    public void completeReservation(){
        if(reservationStatus == ReservationStatus.CONFIRMED){
            reservationStatus = ReservationStatus.COMPLETED;
            vehicle.setStatus((VehicleStatus.AVAILABLE));
        }
    }

    public void cancelReservation(){
        if(reservationStatus == ReservationStatus.PENDING || reservationStatus == ReservationStatus.CONFIRMED){
            reservationStatus = ReservationStatus.CANCELED;
            vehicle.setStatus(VehicleStatus.AVAILABLE);
        }
    }
}
