package org.example.model.products;

import lombok.Data;

@Data
public class GrocriesProduct extends Product {
    private Data expiryDate;
    private boolean isRefrigerated;

    public GrocriesProduct(String name,String id,double price,int quantity){
        super();
        setId(id);
        setName(name);
        setPrice(price);
        setQuantity(quantity);
        setCategory(ProductCategory.GROCERIES);
    }

}
