package org.example.modal.payment;

public class PaymentProcesser {
    public boolean processPayment(double amount, PaymentStratergy strategy) {
        strategy.processPayment(amount);
        return true;
    }
}
