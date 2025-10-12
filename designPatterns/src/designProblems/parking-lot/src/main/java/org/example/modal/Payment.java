package org.example.modal;

import lombok.AllArgsConstructor;
import org.example.interfaces.IPaymentStatergy;

@AllArgsConstructor
public class Payment {
    double amount;
    IPaymentStatergy paymentStatergy;

    public void processPayment() throws Exception {
        if (amount > 0) {
            paymentStatergy.processPayment(amount);
        } else {
            throw new Exception("Invalid Payment amount");
        }
    }
}
