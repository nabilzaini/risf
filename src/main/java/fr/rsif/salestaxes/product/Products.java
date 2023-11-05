package fr.rsif.salestaxes.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Products {
    private List<Product> productList;

    public Products() {
        productList = new ArrayList<>();
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public List<Product> getProductList() {
        return productList;
    }

    public Products setProductList(List<Product> productList) {
        this.productList = productList;
        return this;
    }

    public Optional<Double> getAmountFromProductName(String name) {
        return productList.stream()
                .filter(p -> p.getName().equals(name))
                .map(Product::getPriceWithTaxe)
                .findFirst();
    }
}
