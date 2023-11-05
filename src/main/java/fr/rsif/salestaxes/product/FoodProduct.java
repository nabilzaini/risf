package fr.rsif.salestaxes.product;

import fr.rsif.salestaxes.product.factory.FoodProductFactory;
import fr.rsif.salestaxes.product.factory.ProductFactory;
import fr.rsif.salestaxes.taxe.constante.TaxeValues;

public class FoodProduct extends Product {
    public FoodProduct() {
    }

    public FoodProduct(String name, double price, boolean imported, int quantiy) {
        super(name, price, imported, quantiy);
    }

    @Override
    public double defaultTaxe() {
        return TaxeValues.EXEMPT_LOCAL_PRODUCT_TAXE;
    }

    @Override
    public ProductFactory getFactory() {
        return new FoodProductFactory();
    }
}
