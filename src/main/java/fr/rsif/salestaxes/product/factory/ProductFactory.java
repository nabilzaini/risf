package fr.rsif.salestaxes.product.factory;

import fr.rsif.salestaxes.product.Product;

public abstract class ProductFactory {
    public abstract Product getInstence(String name, double price, boolean imported, int quantiy);
}
