package fr.rsif.salestaxes.product.factory;

import fr.rsif.salestaxes.product.OtherProduct;
import fr.rsif.salestaxes.product.Product;

public class OtherProductFactory implements ProductFactory {
    @Override
    public Product getInstance(String name, double price, boolean imported, int quantiy) {
        return new OtherProduct(name, price, imported, quantiy);
    }
}
