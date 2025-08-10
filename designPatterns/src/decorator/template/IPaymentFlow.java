package decorator.template;

public abstract class IPaymentFlow {
    
    public abstract void validateRequest();
    public abstract void calculateFees();
    public abstract void debitAmount();
    public abstract void creditAmount();

    public final void sendMoney(){
        validateRequest();
        calculateFees();
        debitAmount();
        creditAmount();
    }
}
