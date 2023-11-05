package fr.rsif.salestaxes.receipt;

import fr.rsif.salestaxes.product.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CatalogTest {
    Catalog catalog = new Catalog();

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
    void createProduct(String name, double price, boolean imported, int quantity, Class classExpected) {
        //GIVEN & WHEN
        catalog.createProduct(name, price, imported, quantity);
        //THEN
        Products products = catalog.getProducts();
        List<Product> productList = products.getProductList();

        assertTrue(productList.size() > 0);
        assertThat(productList.get(0), instanceOf(classExpected));
    }
}