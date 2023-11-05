package fr.rsif.salestaxes.utils;

public class Utils {

    public static double truncateDouble(double value) {
        return Math.floor(value * 100) / 100;
    }

    public static double roundOff(double value) {
        return Math.round(value * 20) / (double) 20;
    }

}
