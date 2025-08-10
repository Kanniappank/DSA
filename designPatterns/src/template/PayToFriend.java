package template;

public class PayToFriend extends IPaymentFlow {

    @Override
    public void validateRequest() {
        System.out.println("validating request to pay a friend");
    }

    @Override
    public void calculateFees() {
        System.out.println("calculating fees to the friend account");

    }

    @Override
    public void debitAmount() {
        System.out.println("Amount debited to the friend account");

    }

    @Override
    public void creditAmount() {
        System.out.println("Amount credited to the friend account");
    }

}
