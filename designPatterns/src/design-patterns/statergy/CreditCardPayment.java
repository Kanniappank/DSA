package statergy;

public class CreditCardPayment implements PaymentStatergy{
    
    @Override
    public void processPayment() {
       System.out.println("Processing credit card payment");
    }
    
}
