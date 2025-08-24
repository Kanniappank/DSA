package statergy;

public class PaymentProcessor {

    PaymentStatergy paymentStatergy;

    public PaymentProcessor(PaymentStatergy statergy) {
        this.paymentStatergy = statergy;
    }

    public void executePayment() {
        this.paymentStatergy.processPayment();
    }

    public void setPaymentProcessor(PaymentStatergy statergy) {
        this.paymentStatergy = statergy;
    }

}
