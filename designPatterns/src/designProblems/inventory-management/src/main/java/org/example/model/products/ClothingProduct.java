package org.example.model.products;


import lombok.Data;

@Data
public class ClothingProduct extends Product {
    private String size;
    private String color;

    public ClothingProduct(String id, String name, double price, int quantity){
        super();
        setId(id);
        setName(name);
        setPrice(price);
        setQuantity(quantity);
        setCategory(ProductCategory.CLOTHING);
    }
}
