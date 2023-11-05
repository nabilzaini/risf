package fr.rsif.salestaxes.receipt;

import fr.rsif.salestaxes.product.Product;
import fr.rsif.salestaxes.product.Products;

import static fr.rsif.salestaxes.utils.Utils.truncateDouble;

public class Receipt {
    private Products products;
    private double totalSalesTaxes;
    private double totalAmount;

    public Receipt(Products products, double totalSalesTaxes, double totalAmount) {
        this.products = products;
        this.totalSalesTaxes = truncateDouble(totalSalesTaxes);
        this.totalAmount = truncateDouble(totalAmount);
    }

    @Override
    public String toString() {
        String receipt = "\n------------------------------------------\n";
        for (Product product : products.getProductList()) {
            receipt += product.toString() + "\n";
        }
        return receipt + "Sales Taxes :" + totalSalesTaxes + " Total: " + totalAmount;
    }
}
