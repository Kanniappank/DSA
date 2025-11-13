package org.example.model.Notification;

import lombok.AllArgsConstructor;
import org.example.model.products.Product;

@AllArgsConstructor
public class SupplierNotification implements IInventoryObserver{
    private String name;
    private String contactEmail;


    @Override
    public void update(Product product) {
        if(product.getQuantity()<product.getThreshold()){
            System.out.println("Notification sent to "+this.name+" for low stock on "+product.getName());
        }

    }

}
