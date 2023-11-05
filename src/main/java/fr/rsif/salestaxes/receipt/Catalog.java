package fr.rsif.salestaxes.receipt;

import fr.rsif.salestaxes.product.*;

import java.util.HashMap;
import java.util.Map;

public class Catalog {
    private Products products;
    private Map<String, Product> catalogProduct;

    public Catalog() {
        products = new Products();
        catalogProduct = new HashMap<>();
        addProductToCatalog("book", new BookProduct());
        addProductToCatalog("music CD", new OtherProduct());
        addProductToCatalog("chocolate bar", new FoodProduct());
        addProductToCatalog("box of chocolates", new FoodProduct());
        addProductToCatalog("bottle of perfume", new OtherProduct());
        addProductToCatalog("packet of headache pills", new MedicalProduct());
    }

    public void createProduct(String name, double price, boolean imported, int quantity) {
        Product instence = catalogProduct.get(name).getFactory().getInstence(name, price, imported, quantity);
        products.addProduct(instence);
    }

    private void addProductToCatalog(String productName, Product productType) {
        catalogProduct.put(productName, productType);
    }

    public Products getProducts() {
        return products;
    }
}
