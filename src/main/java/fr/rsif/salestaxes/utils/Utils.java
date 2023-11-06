package fr.rsif.salestaxes.utils;

import java.text.DecimalFormat;

public class Utils {

    public static double truncateDouble(double value) {
        return Math.floor(value * 100) / 100;
    }

    public static double round(double taxeValue) {
        double rate = 0.05;
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        double taxeValueRounded = Math.floor(taxeValue / -rate) * -rate;
        String taxeValueWithoutComma = decimalFormat.format(taxeValueRounded).replaceAll(",", ".").trim();
        return Double.parseDouble(taxeValueWithoutComma);
    }
}
