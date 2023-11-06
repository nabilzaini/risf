package fr.rsif.salestaxes.utils;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UtilsTest {

    static Stream<Arguments> truncateDoubleToTwoDecimal() {
        return Stream.of(
                Arguments.of(12.49585154, 12.49),
                Arguments.of(14.995976464, 14.99),
                Arguments.of(10, 10),
                Arguments.of(0.505, 0.50)
        );
    }

    @ParameterizedTest
    @MethodSource("truncateDoubleToTwoDecimal")
    void truncateDouble(double numberLong, double numberWithTwoDecimalExpected) {
        //GIVEN && WHEN
        double truncatedNumberActual = Utils.truncateDouble(numberLong);
        //THEN
        assertEquals(numberWithTwoDecimalExpected, truncatedNumberActual);
    }

    static Stream<Arguments> rounded() {
        return Stream.of(
                Arguments.of(12.49585154, 12.50),
                Arguments.of(14.995976464, 15),
                Arguments.of(1.88, 1.9));
    }

    @ParameterizedTest
    @MethodSource("rounded")
    void roundOff(double number, double numberRoundedExpected) {
        //GIVEN && WHEN
        double numberRoundedActual = Utils.round(number);
        //THEN
        assertEquals(numberRoundedExpected, numberRoundedActual);
    }
}