package fr.rsif.salestaxes.tu.receipt;

import fr.rsif.salestaxes.receipt.Receipt;
import fr.rsif.salestaxes.samples.Samples;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ReceiptTest {
    Samples samples = new Samples();

    @Test
    void toStringReceipt() {
        //GIVEN
        Receipt receipt = new Receipt(samples.products(), 1.50, 29.83);
        //WHEN
        String receiptActual = receipt.toString();
        //THEN
        assertThat(receiptActual)
                .contains("Sales Taxes :1.5 Total: 29.83");

    }


}