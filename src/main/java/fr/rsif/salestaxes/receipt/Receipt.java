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
        StringBuilder receipt = new StringBuilder();
        receipt.append("\n------------------------------------------\n");
        for (Product product : products.getProductList()) {
            receipt.append(product.toString() + "\n");
        }
        return receipt + "Sales Taxes :" + totalSalesTaxes + " Total: " + totalAmount;
    }

    public Products getProducts() {
        return products;
    }

    public double getTotalSalesTaxes() {
        return totalSalesTaxes;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}
