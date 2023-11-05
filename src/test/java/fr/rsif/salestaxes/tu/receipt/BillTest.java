package fr.rsif.salestaxes.tu.receipt;

import fr.rsif.salestaxes.product.Products;
import fr.rsif.salestaxes.receipt.Bill;
import fr.rsif.salestaxes.samples.Samples;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Optional;
import java.util.stream.Stream;

class BillTest {
    Samples samples = new Samples();
    Bill bill = new Bill(samples.products());

    static Stream<Arguments> productNameAndAmountExpected() {
        return Stream.of(
                Arguments.of("book", 12.49),
                Arguments.of("music CD", 16.49),
                Arguments.of("chocolate bar", 0.85)
        );
    }

    @ParameterizedTest
    @MethodSource("productNameAndAmountExpected")
    void calculPriceWithTaxeAllProducts(String name, double amount) {
        //GIVEN && WHEN
        bill.calculPriceWithTaxeAllProducts();
        //THEN
        Products productsActual = bill.getProducts();
        Optional<Double> amountActual = productsActual.getAmountFromProductName(name);
        Assertions.assertEquals(amount, amountActual.get());
    }

    @Test
    void calculTotalSalesTaxes() {
        //GIVEN
        double totalSalesTaxesExpected = 1.50;
        bill.calculPriceWithTaxeAllProducts();
        // WHEN
        double totalSalesTaxesActual = bill.calculTotalSalesTaxes();
        //THEN
        Assertions.assertEquals(totalSalesTaxesExpected, totalSalesTaxesActual);
    }

    @Test
    void calculTotalAmount() {
        //GIVEN
        double totalAmountExpected = 29.83;
        bill.calculPriceWithTaxeAllProducts();
        // WHEN
        double totalAmountActual = bill.calculTotalAmount();
        //THEN
        Assertions.assertEquals(totalAmountExpected, totalAmountActual);
    }

}