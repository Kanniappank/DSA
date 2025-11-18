package org.example.modal.payment;

public class CashPayment implements PaymentStratergy {
    @Override
    public void processPayment(double amount) {
        System.out.println("processing cash payment of $" + amount);
    }
}
