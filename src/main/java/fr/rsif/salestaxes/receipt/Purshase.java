package fr.rsif.salestaxes.receipt;

public class Purshase {
    private Catalog catalog;
    private Receipt receipt;
    private Bill bill;

    public Purshase() {
        this.catalog = new Catalog();
    }

    public void addProductToCatalog(String name, double price, boolean imported, int quantity) {
        catalog.createProduct(name, price, imported, quantity);
    }

    public void validPayment() {
        bill = new Bill(catalog.getProducts());
        bill.calculPriceWithTaxeAllProducts();
        receipt = new Receipt(catalog.getProducts(), bill.calculTotalSalesTaxes(), bill.calculTotalAmount());
    }

    public void displayReceipt() {
        System.out.println(receipt);
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public Bill getBill() {
        return bill;
    }

    public Receipt getReceipt() {
        return receipt;
    }
}
