package org.example.modal;

import lombok.Data;
import org.example.modal.reservation.Reservation;

import java.util.List;

@Data

public class User {
    private final int id;
    private final String name;
    private final String email;
    private List<Reservation> reservations;

    public void addReservation(Reservation reservation){
        reservations.add(reservation);
    }

    public void deleteReservation(Reservation reservation){
        reservations.remove(reservation);
    }
}
