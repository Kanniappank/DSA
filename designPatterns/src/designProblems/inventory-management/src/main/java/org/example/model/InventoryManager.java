package org.example.model;

import lombok.Setter;
import org.example.model.Notification.IInventoryObserver;
import org.example.model.products.Product;
import org.example.model.replenishment.ReplenishmentStatergy;

import java.util.ArrayList;
import java.util.List;

public class InventoryManager {

    private static InventoryManager instance;
    private List<Warehouse> warehouses;
    private ProductFactory productFactory;
    private List<IInventoryObserver> observers;
    @Setter
    private ReplenishmentStatergy replenishmentStatergy;

    private InventoryManager() {
        warehouses = new ArrayList<>();
        productFactory = new ProductFactory();
    }

    public static synchronized InventoryManager getInstance() {
        if (instance == null) {
            return new InventoryManager();
        }
        return instance;
    }

    public void addWarehouse(Warehouse warehouse) {
        this.warehouses.add(warehouse);
    }

    public void removeWarehouse(Warehouse warehouse) {
        this.warehouses.remove(warehouse);
    }

    public Product getProductById(String id) {
        for (Warehouse warehouse : warehouses) {
            Product product = warehouse.getProductById(id);
            if (product != null) {
                return product;
            }
        }
        return null;
    }

    public void checkAndReplenish(String id) {
        Product product = getProductById(id);
        if (product != null) {
            if (product.getQuantity() < product.getThreshold()) {
//                notifyObserver()
                if (replenishmentStatergy != null) {
                    replenishmentStatergy.replenish(product);
                }
            }
        }
    }

    public void performInventoryCheck() {
        for (Warehouse warehouse : warehouses) {
            for (Product product : warehouse.getAllProducts()) {
                if (product.getQuantity() < product.getThreshold()) {
                    if (replenishmentStatergy != null) {
                        replenishmentStatergy.replenish((product));
                    }
                }
            }
        }
    }

    public void addObservers(IInventoryObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(IInventoryObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(Product product){
        for(IInventoryObserver observer:observers){
            observer.update(product);
        }
    }
}

