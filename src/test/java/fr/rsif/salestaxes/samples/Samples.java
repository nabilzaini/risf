package fr.rsif.salestaxes.samples;

import fr.rsif.salestaxes.product.Products;
import fr.rsif.salestaxes.receipt.Catalog;

public class Samples {
    public Products products() {
        Catalog catalog = new Catalog();

        catalog.createProduct("book", 12.49, false, 1);
        catalog.createProduct("music CD", 14.99, false, 1);
        catalog.createProduct("chocolate bar", 0.85, false, 1);

        return catalog.getProducts();
    }

}
