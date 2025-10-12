package org.example.modal;

import org.example.interfaces.IPaymentStatergy;

public class CashPayment implements IPaymentStatergy {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing cash payment of amount Rs. " + amount);
    }
}
