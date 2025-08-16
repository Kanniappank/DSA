package observer;

public interface ProductLaunchNotifier {
    void subscribe(Customer customer);
    void unsubscribe(Customer customer);
    void notifyCustomer();
}
