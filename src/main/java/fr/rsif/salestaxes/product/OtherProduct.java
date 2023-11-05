package fr.rsif.salestaxes.product;

import fr.rsif.salestaxes.product.factory.OtherProductFactory;
import fr.rsif.salestaxes.product.factory.ProductFactory;
import fr.rsif.salestaxes.taxe.constante.TaxeValues;

public class OtherProduct extends Product {
    public OtherProduct() {
    }

    public OtherProduct(String name, double price, boolean imported, int quantiy) {
        super(name, price, imported, quantiy);
    }

    @Override
    public double defaultTaxe() {
        return TaxeValues.LOCAL_PRODUCT_TAXE;
    }

    @Override
    public ProductFactory getFactory() {
        return new OtherProductFactory();
    }
}
