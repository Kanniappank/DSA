package observer;

public class observerDemo {
    public static void main(String[] args) {
        ProductLaunchNotifier product = new IphoneLaunchNotifier("I Phone 18");

        Customer user1 = new AmazonCustomer("Bob");
        Customer user2 = new AmazonCustomer("Rachel");
        Customer user3 = new AmazonCustomer("Joye");

        product.subscribe(user1);
        product.subscribe(user2);   
        product.subscribe(user3);

        product.unsubscribe(user3);
        product.notifyCustomer();
    }
}

