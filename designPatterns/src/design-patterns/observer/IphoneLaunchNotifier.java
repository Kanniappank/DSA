package observer;

import java.util.ArrayList;
import java.util.List;

public class IphoneLaunchNotifier implements ProductLaunchNotifier {

    String productName;
    List<Customer> customers = new ArrayList<>();

    public IphoneLaunchNotifier(String productName) {
        this.productName = productName;
    }

    @Override
    public void subscribe(Customer customer) {
        customers.add(customer);
    }

    @Override
    public void unsubscribe(Customer customer) {
        customers.remove(customer);
    }

    @Override
    public void notifyCustomer() {
        for(Customer customer :customers){
            customer.notify(this.productName);
        }
    }
    
}
