package org.example.model;

import org.example.model.products.*;

public class ProductFactory {
    public Product createProduct(String id, String name, int quantity, double price, ProductCategory category) {
        switch (category) {
            case ELECTRONIC:
                return new ElectronicsProduct(id, name, price, quantity);
            case CLOTHING:
                return new ClothingProduct(id, name, price, quantity);
            case GROCERIES:
                return new GrocriesProduct(id, name, price, quantity);
            default:
                throw new IllegalArgumentException("Unsupported product category " + category);
        }

    }
}
