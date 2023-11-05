package fr.rsif.salestaxes.product.factory;

import fr.rsif.salestaxes.product.BookProduct;
import fr.rsif.salestaxes.product.Product;

public class BookProductFatcory implements ProductFactory {

    @Override
    public Product getInstance(String name, double price, boolean imported, int quantiy) {
        return new BookProduct(name, price, imported, quantiy);
    }
}
