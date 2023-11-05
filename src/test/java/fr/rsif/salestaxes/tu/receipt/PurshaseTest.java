package fr.rsif.salestaxes.tu.receipt;

import fr.rsif.salestaxes.product.*;
import fr.rsif.salestaxes.receipt.Bill;
import fr.rsif.salestaxes.receipt.Catalog;
import fr.rsif.salestaxes.receipt.Purshase;
import fr.rsif.salestaxes.receipt.Receipt;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PurshaseTest {
    Purshase purshase = new Purshase();

    static Stream<Arguments> addInstanceProduct() {
        return Stream.of(
                Arguments.of("book", 12.49, false, 1, BookProduct.class),
                Arguments.of("music CD", 14.99, false, 1, OtherProduct.class),
                Arguments.of("packet of headache pills", 9.75, false, 1, MedicalProduct.class),
                Arguments.of("chocolate bar", 0.85, false, 1, FoodProduct.class)
        );
    }


    @ParameterizedTest
    @MethodSource("addInstanceProduct")
    void addProductToCatalog(String name, double price, boolean imported, int quantity, Class classExpected) {
        //GIVEN & WHEN
        purshase.addProductToCatalog(name, price, imported, quantity);
        //THEN
        Catalog catalog = purshase.getCatalog();
        Products products = catalog.getProducts();
        List<Product> productList = products.getProductList();

        assertTrue(productList.size() > 0);
        assertThat(productList.get(0), instanceOf(classExpected));
    }

    static Stream<Arguments> productsWithPriceAndTaxe() {
        return Stream.of(
                //Product exempt + local
                Arguments.of("book", 12.49, false, 1, 12.49),
                //Product is not exempt + local
                Arguments.of("music CD", 14.99, false, 1, 16.49),
                //Product  exempt + imported
                Arguments.of("box of chocolates", 10, true, 1, 10.50),
                //Product is not exempt + imported
                Arguments.of("bottle of perfume", 47.50, true, 1, 54.65)
        );
    }

    @ParameterizedTest
    @MethodSource("productsWithPriceAndTaxe")
    void validPayment(String name, double price, boolean imported, int quantity, double amount) {
        //GIVEN
        purshase.addProductToCatalog(name, price, imported, quantity);
        //WHEN
        purshase.validPayment();
        //THEN
        Bill bill = purshase.getBill();
        Products products = bill.getProducts();
        double amountActual = products.getAmountFromProductName(name).get();
        assertEquals(amount, amountActual);

    }


    @Test
    void displayReceipt() {
        //GIVEN
        double totalSalesTaxesExpected = 1.50;
        double totalAmountExpected = 29.83;

        purshase.addProductToCatalog("book", 12.49, false, 1);
        double amountBookExpected = 12.49;
        purshase.addProductToCatalog("music CD", 14.99, false, 1);
        double amountMusicExpected = 16.49;
        purshase.addProductToCatalog("chocolate bar", 0.85, false, 1);
        double amountcocholateExpected = 0.85;

        purshase.validPayment();
        //WHEN
        purshase.displayReceipt();
        //THEN
        Receipt receipt = purshase.getReceipt();

        assertEquals(totalSalesTaxesExpected, receipt.getTotalSalesTaxes());
        assertEquals(totalAmountExpected, receipt.getTotalAmount());
        Products products = purshase.getBill().getProducts();
        double amountBookActual = products.getAmountFromProductName("book").get();
        assertEquals(amountBookExpected, amountBookActual);

        double amountMusicActual = products.getAmountFromProductName("music CD").get();
        assertEquals(amountMusicExpected, amountMusicActual);

        double amountChocolateActual = products.getAmountFromProductName("chocolate bar").get();
        assertEquals(amountcocholateExpected, amountChocolateActual);

    }
}