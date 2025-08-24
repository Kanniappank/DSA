package statergy;

public class PaypalPayment implements PaymentStatergy {
    
    @Override
    public void processPayment() {
        System.out.println("Paypal payment processing taking place");
    }
    
}
