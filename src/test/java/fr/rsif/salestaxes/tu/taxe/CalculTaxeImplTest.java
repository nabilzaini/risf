package fr.rsif.salestaxes.tu.taxe;

import fr.rsif.salestaxes.taxe.CalculTaxe;
import fr.rsif.salestaxes.taxe.CalculTaxeImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static fr.rsif.salestaxes.taxe.constante.TaxeValues.EXEMPT_LOCAL_PRODUCT_TAXE;
import static fr.rsif.salestaxes.taxe.constante.TaxeValues.LOCAL_PRODUCT_TAXE;

class CalculTaxeImplTest {
    CalculTaxe calculTaxe = new CalculTaxeImpl();

    static Stream<Arguments> taxes() {
        return Stream.of(
                //Product exempt + local
                Arguments.of(EXEMPT_LOCAL_PRODUCT_TAXE, 12.49, false, 0.0),
                //Product is not exempt + local
                Arguments.of(LOCAL_PRODUCT_TAXE, 14.99, false, 1.5),
                //Product exempt + imported
                Arguments.of(EXEMPT_LOCAL_PRODUCT_TAXE, 10, true, 0.5),
                //Product is not exempt + imported
                Arguments.of(LOCAL_PRODUCT_TAXE, 47.5, true, 7.15)
        );
    }

    @ParameterizedTest
    @MethodSource("taxes")
    void calculTaxe(double taxe, double price, boolean imported, double taxeAppliedExpected) {
        //GIVEN && WHEN
        double taxeAppliedActual = calculTaxe.calculTaxe(taxe, price, imported);
        //THEN
        Assertions.assertEquals(taxeAppliedExpected, taxeAppliedActual);
    }
}