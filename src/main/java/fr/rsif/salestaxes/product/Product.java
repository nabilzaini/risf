package fr.rsif.salestaxes.product;

import fr.rsif.salestaxes.product.factory.ProductFactory;
import fr.rsif.salestaxes.utils.Utils;
import org.apache.logging.log4j.util.Strings;


public abstract class Product {
    protected String name;
    protected double price;
    protected boolean imported;
    protected int quantiy;
    protected double priceWithTaxe;

    protected Product() {
        name = Strings.EMPTY;
        price = 0.0;
        imported = false;
        quantiy = 0;
    }

    protected Product(String name, double price, boolean imported, int quantiy) {
        this.name = name;
        this.price = price;
        this.imported = imported;
        this.quantiy = quantiy;
    }

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public double getPrice() {
        return price * quantiy;
    }

    public Product setPrice(double price) {
        this.price = price;
        return this;
    }

    public boolean isImported() {
        return imported;
    }

    public Product setImported(boolean imported) {
        this.imported = imported;
        return this;
    }

    public int getQuantiy() {
        return quantiy;
    }

    public Product setQuantiy(int quantiy) {
        this.quantiy = quantiy;
        return this;
    }

    public double getPriceWithTaxe() {
        return priceWithTaxe;
    }

    public Product setPriceWithTaxe(double priceWithTaxe) {
        this.priceWithTaxe = Utils.truncateDouble(priceWithTaxe);
        return this;
    }

    private String importedToValueString(boolean imported) {
        return (imported ? "import " : Strings.EMPTY);
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(quantiy)
                .append(" ")
                .append(importedToValueString(imported))
                .append(name)
                .append(":")
                .append(priceWithTaxe)
                .toString();
    }

    public abstract double defaultTaxe();

    public abstract ProductFactory getFactory();
}
