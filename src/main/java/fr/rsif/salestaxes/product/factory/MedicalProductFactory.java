package fr.rsif.salestaxes.product.factory;

import fr.rsif.salestaxes.product.MedicalProduct;
import fr.rsif.salestaxes.product.Product;

public class MedicalProductFactory implements ProductFactory {
    @Override
    public Product getInstence(String name, double price, boolean imported, int quantiy) {
        return new MedicalProduct(name, price, imported, quantiy);
    }
}
