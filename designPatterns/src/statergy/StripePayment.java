package statergy;

public class StripePayment implements PaymentStatergy{

    @Override
    public void processPayment() {
       System.out.println("Stripe payment taking place");
    }
    
}
