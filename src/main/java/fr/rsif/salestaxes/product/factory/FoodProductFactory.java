package fr.rsif.salestaxes.product.factory;

import fr.rsif.salestaxes.product.FoodProduct;
import fr.rsif.salestaxes.product.Product;

public class FoodProductFactory implements ProductFactory {
    @Override
    public Product getInstance(String name, double price, boolean imported, int quantiy) {
        return new FoodProduct(name, price, imported, quantiy);
    }
}
