package org.example.modal;

import org.example.interfaces.IPaymentStatergy;
import org.example.interfaces.ParkingFeeStatergy;

public class CreditCardPayment implements IPaymentStatergy {
    @Override
    public void processPayment(double amount) {
        System.out.println("processing credit card payment of Rs. "+amount);
    }
}
