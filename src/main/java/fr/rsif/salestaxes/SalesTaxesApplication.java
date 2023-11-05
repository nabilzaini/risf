package fr.rsif.salestaxes;

import fr.rsif.salestaxes.receipt.Purshase;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SalesTaxesApplication {

    public static void main(String[] args) {
        SpringApplication.run(SalesTaxesApplication.class, args);
    }

    @Bean
    CommandLineRunner run() {
        return args -> {
            //INPUT1
            Purshase purshase1 = new Purshase();

            purshase1.addProductToCatalog("book", 12.49, false, 1);
            purshase1.addProductToCatalog("music CD", 14.99, false, 1);
            purshase1.addProductToCatalog("chocolate bar", 0.85, false, 1);

            purshase1.validPayment();
            purshase1.displayReceipt();


            //INPUT2
            Purshase purshase2 = new Purshase();

            purshase2.addProductToCatalog("box of chocolates", 10, true, 1);
            purshase2.addProductToCatalog("bottle of perfume", 47.50, true, 1);

            purshase2.validPayment();
            purshase2.displayReceipt();


            //INPUT3
            Purshase purshase3 = new Purshase();

            purshase3.addProductToCatalog("bottle of perfume", 27.99, true, 1);
            purshase3.addProductToCatalog("bottle of perfume", 18.99, false, 1);
            purshase3.addProductToCatalog("packet of headache pills", 9.75, false, 1);
            purshase3.addProductToCatalog("box of chocolates", 11.25, true, 1);

            purshase3.validPayment();
            purshase3.displayReceipt();

        };
    }
}
