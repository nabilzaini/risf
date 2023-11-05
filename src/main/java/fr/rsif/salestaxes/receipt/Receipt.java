package fr.rsif.salestaxes.receipt;

import fr.rsif.salestaxes.product.Product;
import fr.rsif.salestaxes.product.Products;
import fr.rsif.salestaxes.utils.Utils;
import org.apache.logging.log4j.util.Strings;

public class Receipt {
    private Products products;
    private double totalSalesTaxes;
    private double totalAmount;

    public Receipt(Products products, double totalSalesTaxes, double totalAmount) {
        this.products = products;
        this.totalSalesTaxes = Utils.truncateDouble(totalSalesTaxes);
        this.totalAmount = Utils.truncateDouble(totalAmount);
    }

    @Override
    public String toString() {
        String receipt = "------------------------------------------\n";
        for (Product product : products.getProductList()) {
            receipt += product.toString() + "\n";
        }
        return receipt + "Sales Taxes :" + totalSalesTaxes + " Total: " + totalAmount;
    }
}
