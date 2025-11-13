package org.example.model.replenishment;

import org.example.model.products.Product;

public class BulkOrderReplenishmentStatergy implements ReplenishmentStatergy{
    @Override
    public void replenish(Product product) {
        System.out.println("Appliying bulk order replenishmentStatergy for "+product.getName());
    }
}
