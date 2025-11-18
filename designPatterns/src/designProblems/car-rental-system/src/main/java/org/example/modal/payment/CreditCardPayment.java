package org.example.modal.payment;

public class CreditCardPayment implements PaymentStratergy {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment $" + amount);
    }
}
