package fr.rsif.salestaxes.receipt;

import fr.rsif.salestaxes.product.Product;
import fr.rsif.salestaxes.product.Products;
import fr.rsif.salestaxes.taxe.CalculTaxe;
import fr.rsif.salestaxes.taxe.CalculTaxeImpl;

import java.math.BigDecimal;

import static fr.rsif.salestaxes.utils.Utils.roundOff;

public class Bill {
    private CalculTaxe calculTaxe;
    private Products products;

    public Bill(Products products) {
        this.calculTaxe = new CalculTaxeImpl();
        this.products = products;
    }

    public void calculPriceWithTaxeAllProducts() {
        for (Product product : products.getProductList()) {
            double productTaxe = calculTaxe.calculTaxe(product.defaultTaxe(), product.getPrice(), product.isImported());
            double priceWithTaxe = BigDecimal.valueOf(product.getPrice())
                    .add(BigDecimal.valueOf(productTaxe))
                    .doubleValue();
            product.setPriceWithTaxe(priceWithTaxe);
        }
    }

    public double calculTotalSalesTaxes() {
        double totalSalesTaxes = 0.0;
        for (Product product : products.getProductList()) {
            totalSalesTaxes += product.getPriceWithTaxe() - product.getPrice();
        }
        return roundOff(totalSalesTaxes);
    }

    public double calculTotalAmount() {
        double totalAmount = 0.0;
        for (Product product : products.getProductList()) {
            totalAmount += product.getPriceWithTaxe();
        }
        return totalAmount;
    }
}
