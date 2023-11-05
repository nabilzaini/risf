package fr.rsif.salestaxes.product.factory;

import fr.rsif.salestaxes.product.Product;

public interface ProductFactory {
    Product getInstance(String name, double price, boolean imported, int quantiy);
}
