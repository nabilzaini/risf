package fr.rsif.salestaxes.product;

import fr.rsif.salestaxes.product.factory.BookProductFatcory;
import fr.rsif.salestaxes.product.factory.ProductFactory;
import fr.rsif.salestaxes.taxe.constante.TaxeValues;

public class BookProduct extends Product {
    public BookProduct() {
    }

    public BookProduct(String name, double price, boolean imported, int quantiy) {
        super(name, price, imported, quantiy);
    }

    @Override
    public double defaultTaxe() {
        return TaxeValues.EXCEMPT_LOCAL_PRODUCT_TAXE;
    }

    @Override
    public ProductFactory getFactory() {
        return new BookProductFatcory();
    }
}
