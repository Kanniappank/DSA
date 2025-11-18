package org.example.modal.payment;

public class PaypalPayment implements PaymentStratergy {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing paypal payment of $" +amount);
    }
}
