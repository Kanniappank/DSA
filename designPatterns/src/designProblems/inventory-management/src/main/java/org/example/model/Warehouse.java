package org.example.model;

import org.example.model.products.Product;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Warehouse {

    private String id;
    private String name;
    private String location;
    private Map<String, Product> products;

    public Warehouse(String id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.products = new HashMap<>();
    }

    public void addProduct(Product product, int quantity) {
        String id = product.getId();
        if (!products.isEmpty() && products.containsKey(id)) {
            Product existingProduct = products.get(id);
            existingProduct.addStock(quantity);
        } else {
            product.setQuantity(quantity);
            products.put(id, product);
        }
        System.out.println(quantity + " units of " + product.getName() + " has been added to " + name + " with ID : " + product.getId() + ". New quantity is " + product.getQuantity());
    }

    public boolean removeProduct(String id, int quantity) {
        if (products.containsKey(id)) {
            Product product = products.get(id);
            int currentQuantity = product.getQuantity();
            if (currentQuantity >= quantity) {
                product.removeStock(quantity);
                System.out.println(quantity + " unit of " + product.getName() + " id: " + product.getId() + " has been removed from " + name + ". Remaining quantity is " + product.getQuantity());
                if (currentQuantity == 0) {
                    products.remove(id);
                    System.out.println(product.getName() + " has been removed from the " + name + " because its quantity is zero now");
                }
                return true;
            } else {
                System.out.println("Error: Insufficient inventory. Requested: "
                        + quantity + ", Available: " + currentQuantity);
                return false;
            }
        } else {
            System.out.println("Error product with Id " + id + " not found in " + name);
            return false;
        }

    }

    public int getAvailableQuantity(String id) {
        if (products.containsKey(id)) {
            return products.get(id).getQuantity();
        } else {
            return 0;
        }
    }

    public Product getProductById(String id){
        return products.get(id);
    }

    public Collection<Product> getAllProducts(){
        return products.values();
    }
}
