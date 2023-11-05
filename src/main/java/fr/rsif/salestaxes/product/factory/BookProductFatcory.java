package fr.rsif.salestaxes.product.factory;

import fr.rsif.salestaxes.product.BookProduct;
import fr.rsif.salestaxes.product.Product;

public class BookProductFatcory implements ProductFactory {

    @Override
    public Product getInstence(String name, double price, boolean imported, int quantiy) {
        return new BookProduct(name, price, imported, quantiy);
    }
}
