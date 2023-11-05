package fr.rsif.salestaxes.taxe;

import static fr.rsif.salestaxes.taxe.constante.TaxeValues.IMPPORTED_PRODUCT_TAXE;
import static fr.rsif.salestaxes.utils.Utils.roundOff;

public class CalculTaxeImpl implements CalculTaxe {

    @Override
    public double calculTaxe(double taxe, double price, boolean imported) {
        double totalTaxe = calculLocalTaxe(taxe, price);
        totalTaxe = calculImportedTaxe(price, imported, totalTaxe);
        return roundOff(totalTaxe);
    }

    private double calculLocalTaxe(double taxe, double price) {
        return taxe * price;
    }

    private double calculImportedTaxe(double price, boolean imported, double localTaxe) {
        return imported ? (localTaxe + (price * IMPPORTED_PRODUCT_TAXE)) : localTaxe;
    }
}
