package decorator.template;

public class PayToMerchant extends IPaymentFlow {

    @Override
    public void validateRequest() {
        System.out.println("validating merchant payment");
    }

    @Override
    public void calculateFees() {
        System.out.println("calculating fees for the merchant account");
    }

    @Override
    public void debitAmount() {
        System.out.println("amount debited to the merchant account");

    }

    @Override
    public void creditAmount() {
        System.out.println("amount credited to the merchant account");

    }

}
