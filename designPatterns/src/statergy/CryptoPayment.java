package statergy;

public class CryptoPayment implements PaymentStatergy {
    
    @Override
    public void processPayment() {
        System.out.println("processing Crypto payment");
    }
    
}
