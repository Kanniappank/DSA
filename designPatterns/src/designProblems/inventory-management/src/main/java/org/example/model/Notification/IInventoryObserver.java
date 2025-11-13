package org.example.model.Notification;

import org.example.model.products.Product;

public interface IInventoryObserver {
    void update(Product product);
}
