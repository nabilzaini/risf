package fr.rsif.salestaxes.receipt;

import fr.rsif.salestaxes.product.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ReceiptTest {

    static Stream<Arguments> addInstanceProduct() {
        return Stream.of(Arguments.of("book", 12.49, false, 1, BookProduct.class), Arguments.of("music CD", 14.99, false, 1, OtherProduct.class), Arguments.of("packet of headache pills", 9.75, false, 1, MedicalProduct.class), Arguments.of("chocolate bar", 0.85, false, 1, FoodProduct.class));
    }

    @Test
    void toStringReceipt() {
        //GIVEN
        Receipt receipt = new Receipt(products(), 1.50, 29.83);
        //WHEN
        String receiptActual = receipt.toString();
        //THEN
        assertThat(receiptActual)
                .contains("Sales Taxes :1.5 Total: 29.83");

    }

    private Products products() {
        Catalog catalog = new Catalog();

        catalog.createProduct("book", 12.49, false, 1);
        catalog.createProduct("music CD", 14.99, false, 1);
        catalog.createProduct("chocolate bar", 0.85, false, 1);

        return catalog.getProducts();
    }
}