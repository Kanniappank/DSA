package org.example.model.Notification;

import lombok.AllArgsConstructor;
import org.example.model.products.Product;

import java.util.List;

@AllArgsConstructor
public class DashboardAlertSystem implements IInventoryObserver{
    private String alertLevel;
    private List<String> adminUsers;
    @Override
    public void update(Product product) {
        double stockPercentage = ((double) product.getQuantity()/product.getThreshold()) *100;

        if(stockPercentage<25){
            System.out.println("Critical Alert :"+product.getName() +" is critically low with "+product.getQuantity());
            notifyAdmins(product,"CRITICAL");
        }
        else if(stockPercentage<50){
            notifyAdmins(product,"WARNING");

            System.out.println("Warning Alert :"+product.getName() +" is low with "+product.getQuantity());
        }
    }

    public void notifyAdmins(Product product, String alertLevel){
        for(String admin : adminUsers){
            System.out.println("Dashboard notification sent to admin "+ admin +" - "+ alertLevel  +" level for "+product.getName());
        }
    }
}
