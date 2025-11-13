package org.example.model.products;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Product {
    private final String id;
    private final String name;
    private final double price;
    private int quantity;
    private int threshold;
    private final ProductCategory category;

    protected Product(Builder<?> builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.price = builder.price;
        this.quantity = builder.quantity;
        this.threshold = builder.threshold;
        this.category = builder.productCategory;
    }

    public void addStock(int quantity) {
        this.quantity += quantity;
    }

    public void removeStock(int quantity) {
        this.quantity -= quantity;
    }

    public static abstract class Builder<T extends Builder<T>> {
        private final String id;
        private final String name;
        private final double price;
        private final ProductCategory productCategory;

        private int quantity;
        private int threshold;

        public Builder(String id, String name, double price, ProductCategory productCategory) {
            this.id = id;
            this.name = name;
            this.price = price;
            this.productCategory = productCategory;
        }

        public T setQuantity(int quantity) {
            this.quantity = quantity;
            return self();
        }

        public T setThreshold(int threshold){
            this.threshold = threshold;
            return self();
        }

        protected abstract T self();

        protected  abstract Product build();
    }
}
