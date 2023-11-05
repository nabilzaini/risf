package fr.rsif.salestaxes.taxe;

public interface CalculTaxe {
    double calculTaxe(double taxe, double price, boolean imported);
}
