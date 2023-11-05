package fr.rsif.salestaxes.product.factory;

import fr.rsif.salestaxes.product.Product;

public interface ProductFactory {
    Product getInstence(String name, double price, boolean imported, int quantiy);
}
