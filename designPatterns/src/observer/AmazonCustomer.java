package observer;

public class AmazonCustomer implements Customer {

    private String customerName;

    public AmazonCustomer(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public void notify(String productName) {
        System.out.println(customerName + ", your product " + productName + " is live now in Amazon");
    }

}
