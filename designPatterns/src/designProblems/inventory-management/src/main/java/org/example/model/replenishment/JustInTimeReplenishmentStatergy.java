package org.example.model.replenishment;

import org.example.model.products.Product;

public class JustInTimeReplenishmentStatergy implements ReplenishmentStatergy{
    @Override
    public void replenish(Product product) {
        System.out.println("Appliying the just in time replenishment statergy for product "+product.getName());
    }
}
